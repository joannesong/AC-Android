- title: Intro to Databases + SQLite
- tags: relational databases, sqlite

# Objectives

- Become familiar with what a relational database is and when to use one.
- Learn to compose and execute some common clause SQL statements (CREATE, INSERT, SELECT, UPDATE, DELETE).
- Gain exposure to SQLite on Android via the Cupboard library.

# Resources

- [Glossary of commonly used SQL commands](https://www.codecademy.com/articles/sql-commands)
- [Datatypes in SQLite](https://www.sqlite.org/datatype3.html)
- [SQL Fiddle](http://sqlfiddle.com/#!5)
- [SQLite in Android](http://www.grokkingandroid.com/sqlite-in-android/)
- [Saving Data in SQL Databases - developer.android.com](https://developer.android.com/training/basics/data-storage/databases.html)
- [Easier SQL with Cupboard](https://guides.codepath.com/android/Easier-SQL-with-Cupboard)

# Lecture

## What is a database?

- **relational database** - a database that organizes information into one or more *tables*.
- **table** - a collection of data organized into *rows* and *columns*. Tables are sometimes referred to as *relations*.
- **column** - a set of data values of a particular type.
- **row** - a single record in a table.
- **schema** - a collection of database objects (tables) associated with one particular database username. This username is called the *schema owner*. You may have one or multiple schemas in a database.

All data stored in a relational database is of a certain **data type**. SQLite, the relational database management system we'll be using, has the following data types:

1. **INTEGER** - a positive or negative whole number.
2. **TEXT** - a text string, stored using the database encoding (UTF-8, UTF-16BE or UTF-16LE). Wrap text strings in single quotes, e.g. `'Hello, world!'`.
3. **REAL** - a decimal value, stored as an 8-byte IEEE floating point number.
4. **BLOB** - a blob of data, stored exactly as it was input.
5. **NULL** - the null value.

SQLite does not have a separate BOOLEAN data type class. Instead, BOOLEAN values are stored as INTEGERS `0` (false) and `1` (true).

SQLite also does not have a type set aside for storing dates and/or times. Instead, dates and times are stored as TEXT, REAL, or INTEGER values:

- **TEXT** as ISO8601 strings ("YYYY-MM-DD HH:MM:SS.SSS").
- **REAL** as Julian day numbers, the number of days since noon in Greenwich on November 24, 4714 B.C. according to the proleptic Gregorian calendar.
- **INTEGER** as Unix Time, the number of seconds since 1970-01-01 00:00:00 UTC.

## Use cases

- Relational databases are ideal for repeating or structured data, e.g. contacts, messages, users, tweets.
- Your data is of a type, complexity or quantity that cannot be stored easily in SharedPreferences, e.g. a list.
- You want to cache data from a REST API locally for faster access or offline viewing, e.g. received emails in your Gmail app are always available offline. This can be great for user experience, but it is important to ensure that cached data does not become stale.

## What is SQL?

SQL (Structured Query Language) is a programming language designed to manipulate and manage data stored in relational databases.

- **SQL statement** - text that the database recognizes as a valid command.
- **clause** - the part of a SQL statement that performs a specific task. By convention, clauses are written in capital letters. Clauses are sometimes referred to as *commands*.
- **parameter** - a list of columns, data types, or values that are passed to a *clause* as an argument.
- **query** -  a statement used to extract data from the database in a readable format according to the user's request. 

The structure of SQL statements vary. The number of lines used doesn't matter - a statement can be written in a single line or split up across multiple lines for readability. Statements always end in a semi-colon `;`.

### `CREATE TABLE` statements

Create a new table in the database. Allows you to specify the name of the table and the name and data type of each column in the table.

```SQL
CREATE TABLE table_name (column_1 datatype, column_2 datatype, column_3 datatype);
```

### `ALTER TABLE` statements

Add column(s) to an existing table in the database.

```SQL
ALTER TABLE table_name ADD column datatype;
```

### `INSERT INTO` statements

Add a new row (record) to a table.

```SQL
INSERT INTO table_name (column_1, column_2, column_3) VALUES (value_1, value_2, value_3);
```

### `SELECT` statements

Fetch data from the database. `*` can be used as a wildcard meaning *all*.

```sql
SELECT column_name FROM table_name;
```

### `UPDATE` statements

Edit rows in a table.

```sql
UPDATE table_name SET some_column = some_value WHERE some_column = some_value;
```

### `DELETE FROM` statements

Remove rows from a table.

```sql
DELETE FROM table_name WHERE some_column = some_value;
```

### Exercises

**1)** Complete Codeacademy's SQL Manipulation exercises (1 - 10) and the Manipulation multiple choice quiz. You'll need to create an account if you haven't already. Do not continue past the quiz for now.

**2)** Go to [sqlfiddle.com](http://sqlfiddle.com/#!5/). Make sure the dropdown at the top-left is selecting "SQLite (WebSQL)".
- In the *Schema Panel* (left side), create a table named `cats`. The table should have the following columns: `id` (INTEGER), `name` (TEXT), `last_fed` (LONG) and `is_hungry` (BOOLEAN).
- Next in the *Schema Panel*, write statements to insert five cats into the cats table: id: 1, name: Furry, last_fed: 0, is_hungry: 1, id: 2, name: Harry, last_fed: 6745684353, is_hungry: 0, id: 3, name: Mike, last_fed: 5890234637, is_hungry: 1, plus two of your choosing. Click "Build Schema" to build your database schema.
- In the *SQL Panel* (right side), compose and run a statement to select all of the cats from the cats table.
- In the *SQL Panel* (right side), compose and run an update statement to feed Furry now. He is no longer hungry. Select all cats from the table to confirm that your update worked.
- Mike got tired of the pampered life and ran away. Compose and run a statement to delete him from the table. Select all cats from the table to confirm that your delete worked.
- Alter the table to add a new column: `color` (TEXT). Update each remaining cat with a fur color.
- Compose and run a statement to select all cats from the table with orange fur.

## What is SQLite?

- **relational database management system (RDBMS)** - a program that lets you create, update, and administer a relational database. 

SQLite is a popular open source, compact RDBMS that uses SQL to access the database. It is able to store an entire database in a single file. One of the biggest advantages this provides is that all of the data can be stored locally without having to connect your database to a server.

SQLite is a popular choice for databases in phones (it is the default embedded database in both iOS and Android) and other electronic gadgets. 

### Exercises

Fork and clone the [Access Cats](https://github.com/ramonaharrison/AccessCats) repo. Refer to the [Cupboard documentation](https://bitbucket.org/littlerobots/cupboard/wiki/withDatabase) or this [guide](https://guides.codepath.com/android/Easier-SQL-with-Cupboard) as you complete the following exercises.

**1)** Read through the sample code provided in the Access Cats project. What looks familiar? What looks new?

**2)** Add a few cats to the database and observe the list. Force kill the app by swiping it from the recents screen. Reopen the app. Are the cats still there?

**3)** With the app open, press the recents button and long press the the cat icon in the Access Cats app label to access the App Info screen. Press "Storage" then "Clear Data" to clear the app data. Reopen the app. Are the cats still there?

**4)** In CatActivity.java, find the `onCatClicked()` method. Add logic to feed the cat by using Cupboard to update the last fed time in the database.

**5)** In CatActivity.java, find the `onCatLongClicked()` method. Add logic to delete the cat by using Cupboard to remove the cat from the database.

**6)** Use Cupboard to add a new column to the cat table named `image_url`. For each cat in your database, find a cat image URL online and display the image next to the cat's name in the list using the [Picasso library](https://github.com/square/picasso). Try to do this without clearing the app data (read up on [migrations](https://guides.codepath.com/android/Easier-SQL-with-Cupboard#migrations))!

**7)** Install [DB Browser for SQLite](http://sqlitebrowser.org/), which will allow you to inspect your app's SQLite data graphically. Use Terminal to pull the database file from your device:

*You'll need to cd into the sdk-tools directory if you haven't added adb to your path*

```
./adb shell run-as <app package name> chmod 666 /data/data/<app package name>/databases/<database file name>
./adb shell cp /data/data/<app package name>/databases/<database file name> /sdcard/
./adb pull /sdcard/<database file name>
```

Once you have the file downloaded, open it in DB Browser. What do you see?

**8) BONUS:** Create a new activity, DogActivity.java (or choose another animal that you like). Duplicate the cat logic to create a new POJO, adapter and table in your database, then display a list of animals in your new activity.

### [Exit Ticket](https://goo.gl/forms/Mimlu5kAA3zjJBpu1)
