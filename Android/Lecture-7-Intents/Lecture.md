<!DOCTYPE html>
<html>
  <head>
    <title>Title</title>
    <meta charset="utf-8">
    <style>
      @import url(https://fonts.googleapis.com/css?family=Yanone+Kaffeesatz);
      @import url(https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic);
      @import url(https://fonts.googleapis.com/css?family=Ubuntu+Mono:400,700,400italic);

      body { font-family: 'Droid Serif'; }
      h1, h2, h3 {
        font-family: 'Yanone Kaffeesatz';
        font-weight: normal;
      }
      .remark-code, .remark-inline-code { font-family: 'Ubuntu Mono'; }
    </style>
  </head>
  <body>
    <textarea id="source">

class: center, middle

## Hello

Title: Android Intents and Services
Tags: intents, services, extra, data, action

--

## Objectives

- Distinguish between implicit and explicit intents
- Starting components and services using intents
- Use intents to handle navigation within an Android application
- Use intent extras to transfer information from one activity to another.
- Registering intents via intent filters

---

## Resources

- [Intent](https://developer.android.com/reference/android/content/Intent.html)
- [Common Intents](https://developer.android.com/guide/components/intents-common.html)
- [Getting a result from an activity](https://developer.android.com/training/basics/intents/result.html)
- [Intents Tutorial by Vogella](http://www.vogella.com/tutorials/AndroidIntent/article.html)

---

## What are intents?

Intents are asynchronous messages which allow application components to request functionality from other Android components. Intents allow you to interact with components from the same applications as well as with components contributed by other applications. For example, an activity can start an external activity for taking a picture.

Intents are objects of the android.content.Intent type. Your code can send them to the Android system defining the components you are targeting. For example, via the startActivity() method you can define that the intent should be used to start an activity.

---

## Instantiating activities

The simplest way to navigate from activity to another is to call the startActivity() method in the initial activity.

```java
// start the gallary activity
Intent intent = new Intent(this, GalleryActivity.class)
startActivity(intent);
```

![using startIntent to start another activity](images/startIntent-to-perform-action.png)

Activities which are started by other Android activities are called sub-activities. This wording makes it easier to describe which activity is meant.


---

## Implicit vs. Explicit Intents

When we **specify a class within our application** we want to navigate to, that is an **explicit** intent. We are telling the ActivityManager exactly which activity we want to navigate to.

```java
Intent explicitIntent = new Intent(this, ActivityTwo.class);
```

Implicit Intents do not specify a component; instead, they must include enough information for the system to determine which of the available components is best to run for that intent.

---

## Implicit Intents

The primary pieces of information in an intent are:

**action** -- The general action to be performed, such as ACTION_VIEW, ACTION_EDIT, ACTION_MAIN, etc.

**data** -- The data to operate on, such as a person record in the contacts database, expressed as a Uri. 

```java
Intent implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.c4q.nyc"));
```

Using an implicit intent is useful when your app cannot perform the action, but other apps probably can and you'd like the user to pick which app to use. 

---

## Common Implicit Intents

For example, if you have content you want the user to share with other people, create an intent with the ACTION_SEND action and add extras that specify the content to share. When you call startActivity() with that intent, the user can pick an app through which to share the content.

* Taking a picture with Camera (uses default camera app)

* Sending/Reading an SMS message

* ACTION_VIEW content://contacts/people/1 -- Display information about the person whose identifier is "1".

* ACTION_DIAL content://contacts/people/1 -- Display the phone dialer with the person filled in.

* ACTION_VIEW tel:123 -- Display the phone dialer with the given number filled in. Note how the VIEW action does what is considered the most reasonable thing for a particular URI.

*What other examples of implicit intents can we think of?*

---

## Sending data

To send data from one activity to another, we need to make sure to associate an extra with the intent before calling startActivity() in our origin Activity.

You can add data to an Intent Bundle via the overloaded `putExtra()` methods of the Intent objects. Extras are key/value pairs. The key is always of type String. As value you can use the primitive data types (int, float, …​) plus objects of type String, Bundle, Parcelable and Serializable.
``` java
public Intent putExtra(String key, String value);
```

---

## Receiving data

The component which receives the intent can use the `getIntent().getExtras()` method call to get the extra data. That is demonstrated in the following code snippet.

```java
Bundle extras = getIntent().getExtras();
if (extras == null) {
    return;
}

// get data via the key
String value1 = extras.getString(Intent.EXTRA_TEXT);
if (value1 != null) {
    // do something with the data
}

// alternatively:
if(getIntent().hasExtra(Intent.EXTRA_TEXT)) {
    // call getExtras().getString() here.
    // do something with the data
}
```

---

## Example: Using the share intent

Lots of Android applications allow you to share some data with other people, e.g., the Facebook, G+, Gmail and Twitter application. You can send data to one of these components using the Share intent. 

```java
// this runs, for example, after a button click
Intent intent = new Intent(Intent.ACTION_SEND);
intent.setType("text/plain");
intent.putExtra(android.content.Intent.EXTRA_TEXT, "Important news to share with friends");
startActivity(intent);
```

---

## Registering Intents

The following code will register an Activity for the Intent which is triggered when someone wants to open a webpage.

```xml
<activity android:name=".BrowserActivitiy"
          android:label="@string/app_name">
  <intent-filter>
     <action android:name="android.intent.action.VIEW" />
     <category android:name="android.intent.category.DEFAULT" />
     <data android:scheme="http"/>
  </intent-filter>
</activity>
```

---

# Registering Intents

The following example registers an activity for the ACTION_SEND intent. It declares itself only relevant for the text/plain mime type.

```xml
<activity
    android:name=".ActivityTest"
    android:label="@string/app_name" >
    <intent-filter>
      <action android:name="android.intent.action.SEND" />
      <category android:name="android.intent.category.DEFAULT" />
      <data android:mimeType="text/plain" />
    </intent-filter>
</activity>
```

Implicit Intents (activities outside your app) must be registered.

If a component does not define an intent filter, it can only be called by explicit intents.

---

## Starting Services


---

## Exercises 

> **Question 1**

The goal of this exercise is to be able to send and recieve data between two intents. Create an app called Adder with two activities, Main and Total. 

The Main activity has two number inputs and a "SUM" button.

When user types in two numbers and presses the SUM button, a new activity Total is launched which displays the sum of the numbers from the previous activity. 


---

> **Question 2**

The goal of this exercise to be able to use implicit intents. Create an app that has a text input and a button "Share".

When user enters text a presses "Share", they should see the share activity that allows them to select app to share the text entered. 

Select SMS app, ensure the text user entered is displayed in SMS texting box.


---



</textarea>
<script src="https://remarkjs.com/downloads/remark-latest.min.js">
</script>
<script>
  var slideshow = remark.create();
</script>
</body>
</html>