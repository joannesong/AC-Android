# Intro to Databases, SQLite, and SQLiteOpenHelper

## Objectives

- Fellows will become familiar with what a relational database is and when to use one
- Fellows will learn to compose and execute some common clause SQL statements (CREATE, INSERT, SELECT, UPDATE, DELETE)
- Fellows will gain exposure to SQLite on Android via the SQLiteOpenHelper Class

## Resources

- [Glossary of commonly used SQL commands](https://www.codecademy.com/articles/sql-commands)
- [Datatypes in SQLite](https://www.sqlite.org/datatype3.html)
- [SQL Fiddle](http://sqlfiddle.com/#!5)
- [SQLite in Android](http://www.grokkingandroid.com/sqlite-in-android/)
- [Saving Data in SQL Databases - developer.android.com](https://developer.android.com/training/basics/data-storage/databases.html)
- [Easier SQL with Cupboard](https://guides.codepath.com/android/Easier-SQL-with-Cupboard)

## Vocabulary
|Term|Definition|
|:-:|:-|
|**Relational Database**|a database that organizes information into one or more *tables*|
|**Table**|a collection of data organized into *rows* and *columns*. Tables are sometimes referred to as *relations*
|**Column**|a named category for a set of data values of a particular type; in SQL they are referred to as *fields*
|**Row**|a single entry in a table; in SQL they are referred to as *records*
|**Schema**|a collection of database objects (tables) associated with one particular database username. This username is called the *schema owner*. You may have one or multiple schemas in a database|
|**SQL statement**|text that the database recognizes as a valid command|
|**clause**|the part of a SQL statement that performs a specific task. By convention, clauses are written in capital letters. Clauses are sometimes referred to as *commands*|
|**parameter**|a list of columns, data types, or values that are passed to a *clause* as an argument|
|**query**|a statement used to extract data from the database in a readable format according to the user's request|

# Lecture

## What is a database?

A database is simply a collection of information, that is organized so that it can be easily accessed, managed and updated by a user. By this definition, Shared Preferences data can be thought of as a database:

* Creating/Accessing the "Database":

```java
private static final String SHARED_PREFS_KEY = "sharedPrefsTesting";

SharedPreferences sharedPrefs = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
```

* Putting/Updating entries from the "Database":

```java
SharedPreferences.Editor editor = sharedPrefs.edit();
editor.putString("username", username.getText().toString());
editor.putString("password", password.getText().toString());
editor.commit();
```

* Getting specific values from the "Database":

```java
String usernameValue = sharedPrefs.getString("username", null);
String passwordValue = sharedPrefs.getString("password", null);
```

However, `SharedPreferences` are limited since they can only hold key/value pairs. Also, the types of values that can be stored in `SharedPreferences` are limited as well to primitives, Strings, and Sets.

A more effective database can be thought of as a collection of **associated** information, beyond a single key/value pair. An example of this can be visualized as a table (like a spreadsheet), with **columns** for value categories, and **rows** for individual entries. Let's say we wanted to track the users of a blogging site. We can put them in something like the table below:

|entry_order|username|password|
|:-:|:-|:-|
|1|dogperson123|ComplicatedPassword123!|
|2|catperson456|ComplicatedPassword456!|
|3|hamsterperson789|ComplicatedPassword789!|

To extend this metaphor, you might be asking "Which one is the key?" Well, let's say we wanted to find out the password for a certain user - dogperson123 - visually, we could look at the table, under the column `username`, go down until we see the user we wanted (dogperson123), then look to the right or left of that row, until we hit the column `password`, where we'd find the password associated with that particular user. In this sense, technically speaking, any value could be a key. This is both a good and a bad thing. Good, because it means you can search for associated data using multiple keys, but bad, since it means there's no real way to tell one entry from the other, especially if a username is identical:

|entry_order|username|password|
|:-:|:-|:-|
|1|dogperson123|ComplicatedPassword123!|
|2|catperson456|ComplicatedPassword456!|
|3|hamsterperson789|ComplicatedPassword789!|
|4|catperson456|SomeOtherPassword!|

We need to make one key unique - so that if we do find dupicate data, we can at least tell the difference between the two. If we make sure that the entry order number can **never be changed**, then at least we'd know for sure that we have mutiple entries for the same user - and we can either remove the duplicate entry, or change the username for them entirely. We can look at the `entry_order` as the **primary key** to associate with all the other data in our rows, making each row a unique entry.

If you wanted to, you could even create a table tracking the multiple blog posts each username might author - you could create a "relationship" between these two tables, so that whenever a user makes a post, you create a relationship between the user data, and the blog post data.

On a very high level, this is essentially how Relational SQL-based databases work.

## What is a Relational Database?

A **Relational Database** is a database that organizes information into one or more tables. SQLite is the relational database management system we'll be using when working on Android projects.

All data stored in a relational database is of a certain **data type**. SQLite has the following data types:

|Type|Definition|
|:-:|:-|
|**INTEGER**|a positive or negative whole number|
|**TEXT**|a text string, stored using the database encoding (UTF-8, UTF-16BE or UTF-16LE). Wrap text strings in single quotes, e.g. **'Hello, world!'**|
|**REAL**|a decimal value, stored as an 8-byte IEEE floating point number|
|**BLOB**|a blob of data, stored exactly as it was input|
|**NULL**|the null value|

**IMPORTANT:** 

* SQLite does not have a separate BOOLEAN data type class. Instead, BOOLEAN values are stored as INTEGERS `0` (false) and `1` (true).

* SQLite also does not have a type set aside for storing dates and/or times. Instead, dates and times are stored as TEXT, REAL, or INTEGER values:

- **TEXT** as [ISO8601 strings](https://en.wikipedia.org/wiki/ISO_8601) ("YYYY-MM-DD HH:MM:SS.SSS")
- **REAL** as [Julian day](https://en.wikipedia.org/wiki/Julian_day) numbers, the number of days since noon in Greenwich on November 24, 4714 B.C. according to the [proleptic Gregorian calendar](https://en.wikipedia.org/wiki/Proleptic_Gregorian_calendar)
- **INTEGER** as Unix Time, the number of seconds since 1970-01-01 00:00:00 UTC

A user can insert the current data and current time by using function like `DATE()` and `TIME()` - this is especially useful for timestamping your data. 

## Why use Relational Databases in Android Application?

Relational databases are ideal for repeating or structured data (e.g. contacts, messages, users, tweets). You might want to use a Relational Database if:

- The data you wish to store is of a type, complexity or quantity that cannot be stored easily in SharedPreferences (e.g. a list)
- You want to cache data from a REST API locally for faster access or offline viewing - for example: received emails in your Gmail app are always available offline. This can be great for user experience, but it is important to ensure that cached data does not become stale

## What is SQL?

SQL (Structured Query Language) is a programming language designed to manipulate and manage data stored in relational databases.

|Term|Definition|
|:-:|:-|
|**SQL statement**|text that the database recognizes as a valid command|
|**clause**|the part of a SQL statement that performs a specific task. By convention, clauses are written in capital letters. Clauses are sometimes referred to as *commands*|
|**parameter**|a list of columns, data types, or values that are passed to a *clause* as an argument|
|**query**|a statement used to extract data from the database in a readable format according to the user's request|
|**field**|comparable to a **column**, a named category for a set of data values of a particular type|
|**record**|comparable to a **row**, or a single entry in a table|

The structure of SQL statements vary. The number of lines used doesn't matter - a statement can be written in a single line or split up across multiple lines for readability. However, statements always end in a semi-colon `;` - much like in other languages.

These statements constitute what are referred to as [CRUD](https://en.wikipedia.org/wiki/Create,_read,_update_and_delete) operations, or the four basic functions of persistent storage:

* Create
* Read
* Update
* Delete

### `DROP TABLE` statements

The `DROP TABLE` statement is used to drop an existing table in a database:

```SQL
DROP TABLE table_name;
```

**IMPORTANT**: ***Be careful before dropping a table*** - deleting a table will result in loss of complete information stored in the table!

### `CREATE TABLE` statements

Create a new table in the database. Allows you to specify the name of the table and the name and data type of each field (column) in the table:

```SQL
CREATE TABLE table_name (column_1 datatype, column_2 datatype, column_3 datatype);
```

### `ALTER TABLE` statements

Add fields (columns) to an existing table in the database:

```SQL
ALTER TABLE table_name ADD column datatype;
```

### `INSERT INTO` statements

Add a new record (row of data) to a table:

```SQL
INSERT INTO table_name (column_1, column_2, column_3) VALUES (value_1, value_2, value_3);
```

### `SELECT` statements

When you compose `SELECT` statments, you are making **queries** - or accessing the database to get data specific to certain search requirements.

The character `*` can be used as a wildcard meaning *all*. This will return all of the records in a database table, including all of its fields/ field values:

```SQL
SELECT * FROM table_name;
```

You can fetch partial data just for a certain field from the database:

```SQL
SELECT column_name FROM table_name;
```

You can fetch partial data for a number of fields from the database:

```SQL
SELECT column_name01, column_name02 FROM table_name;
```

You can fetch all records that have fields containing certain values from the database:

```SQL
SELECT * FROM table_name WHERE column_name = some_value;
```

You can fetch all records, and order them based on the values of specific fields from the database:

```SQL
SELECT * FROM table_name ORDER BY column_name;
```

You can fetch all records, and order them based on the values of specific fields from the database, in reverse order:

```SQL
SELECT * FROM table_name ORDER BY column_name DESC;
```

You can fetch all records that have fields containing certain values of a certain length from the database:

```SQL
SELECT * FROM table_name WHERE LENGTH(column_name) = 4;
```

Honestly, this is simply scratching the surface as to the many ways a user can query a database table. People have spent entire careers as Database Administrators designing/optomizing useful queries for data analytics on massive tables/databases. If you'd like to know more, you can follow [this link](https://www.sqlite.org/lang_select.html) for more information.

### `UPDATE` statements

Edit records (rows) in a table:

```SQL
UPDATE table_name SET some_column = some_value WHERE some_column = some_value;
```

### `DELETE FROM` statements

Remove records (rows) from a table:

```SQL
DELETE FROM table_name WHERE some_column = some_value;
```

### Adding a `PRIMARY KEY`

Remember in the example we described at the beginning of the lecture - where you could have multiple entries with identical values, adding to inconsistent data? There is a way to add a `PRIMARY KEY` you your table, listing the order in which each record was placed into the table: 

```SQL
CREATE TABLE fellows(_id INTEGER PRIMARY KEY, last_name TEXT, first_name TEXT);
```

Now, you can add that `PRIMARY KEY` every time you insert a new record:

```SQL
INSERT INTO fellows(_id, last_name, first_name) VALUES(1, "Lin", "Lily");
```

However, SQL will make sure that every primary key is unique, so if you add the same primary key when you insert a new record. One way around this is to enter the keyword `NULL` when entering the `PRIMARY KEY` value:

```SQL
INSERT INTO fellows(_id, last_name, first_name) VALUES(NULL, "Smith", "Jordan");
```

However, it still requires you to enter a value. You can still add this `PRIMARY KEY` field, and have the number for each record increase automatically every time a new record is added, without having to use `NULL` every single time:

```SQL
CREATE TABLE fellows(_id INTEGER PRIMARY KEY AUTOINCREMENT, last_name TEXT, first_name TEXT);

INSERT INTO fellows(last_name, first_name) VALUES("Smith", "Jordan");
```

You might notice though that after deleting records, the `PRIMARY KEY` field may appear to be missing record numbers. That's because each primary key is unique, and should never be used again. This is a normal part of table operations.

## What is SQLite?

**SQLite** is a **relational database management system (RDBMS)** - a program that lets you create, update, and administer a relational database.

SQLite is a popular open source, compact RDBMS that uses SQL to access the database. It is able to store an entire database in a single file. One of the biggest advantages this provides is that all of the data can be stored locally without having to connect your database to a server.

SQLite is a popular choice for databases in phones (it is the default embedded database in both iOS and Android) and other electronic gadgets.

## How can we use SQLite to create, update, and administer a relational database in Android Applications?

// TODO: update lesson to use SqliteOpenHelper, then introduce Cupboard/Room as future alternatives, because SqliteOpenHelper....

### Exercises

**1)** Complete Codeacademy's SQL Manipulation exercises (1 - 10) and the Manipulation multiple choice quiz. You'll need to create an account if you haven't already. Do not continue past the quiz for now.

**2)** Go to [Online SQL interpreter (SQL.js)](http://kripken.github.io/sql.js/GUI/). For this example only, make sure to clear the contents of the input box, and add the following code: `DROP TABLE cats;`
- In the *Schema Panel* (left side), create a table named `cats`. The table should have the following columns: `id` (INTEGER), `name` (TEXT), `last_fed` (LONG) and `is_hungry` (BOOLEAN).
- Directky below the create statement, write statements to insert five cats into the cats table: id: 1, name: Furry, last_fed: 0, is_hungry: 1, id: 2, name: Harry, last_fed: 6745684353, is_hungry: 0, id: 3, name: Mike, last_fed: 5890234637, is_hungry: 1, plus two of your choosing. Next, compose and run a statement to select all of the cats from the cats table. Click "Execute" to run the code.
- Compose and run an update statement to feed Furry now. He is no longer hungry. Select all cats from the table to confirm that your update worked.
- Mike got tired of the pampered life and ran away. Compose and run a statement to delete him from the table. Select all cats from the table to confirm that your delete worked.
- Alter the table to add a new column: `color` (TEXT). Update each remaining cat with a fur color.
- Compose and run a statement to select all cats from the table with orange fur.

### Exercises

> Fork and clone the [Access Cats](https://github.com/ramonaharrison/AccessCats) repo. Refer to the [Cupboard documentation](https://bitbucket.org/littlerobots/cupboard/wiki/withDatabase) or this [guide](https://guides.codepath.com/android/Easier-SQL-with-Cupboard) as you complete the following exercises.

> **1)** Read through the sample code provided in the Access Cats project. What looks familiar? What looks new?

> **2)** Add a few cats to the database and observe the list. Force kill the app by swiping it from the recents screen. Reopen the app. Are the cats still there?

> **3)** With the app open, press the recents button and long press the the cat icon in the Access Cats app label to access the App Info screen. Press "Storage" then "Clear Data" to clear the app data. Reopen the app. Are the cats still there?

> **4)** In CatActivity.java, find the `onCatClicked()` method. Add logic to feed the cat by using Cupboard to update the last fed time in the database.

> **5)** In CatActivity.java, find the `onCatLongClicked()` method. Add logic to delete the cat by using Cupboard to remove the cat from the database.

> **6)** Use Cupboard to add a new column to the cat table named `image_url`. For each cat in your database, find a cat image URL online and display the image next to the cat's name in the list using the [Picasso library](https://github.com/square/picasso). Try to do this without clearing the app data (read up on [migrations](https://guides.codepath.com/android/Easier-SQL-with-Cupboard#migrations))!

> **7)** Install [DB Browser for SQLite](http://sqlitebrowser.org/), which will allow you to inspect your app's SQLite data graphically. Use Terminal to pull the database file from your device:

> *You'll need to cd into the sdk-tools directory if you haven't added adb to your path*

> ```
> ./adb shell run-as <app package name> chmod 666 /data/data/<app package name>/databases/<database file name>
> ./adb shell cp /data/data/<app package name>/databases/<database file name> /sdcard/
> ./adb pull /sdcard/<database file name>
> ```

> Once you have the file downloaded, open it in DB Browser. What do you see?

> **8) BONUS:** Create a new activity, DogActivity.java (or choose another animal that you like). Duplicate the cat logic to create a new POJO, adapter and table in your database, then display a list of animals in your new activity.

