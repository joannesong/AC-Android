Title: Android Intents and Services
Tags: intents, services, extra, data, action

## Objectives

- Distinguish between implicit and explicit intents
- Starting components and services using intents
- Use intents to handle navigation within an Android application
- Use intent extras to transfer information from one activity to another.
- Registering intents via intent filters

## Resources

- [Intent](https://developer.android.com/reference/android/content/Intent.html)
- [Common Intents](https://developer.android.com/guide/components/intents-common.html)
- [Getting a result from an activity](https://developer.android.com/training/basics/intents/result.html)
- [Intents Tutorial by Vogella](http://www.vogella.com/tutorials/AndroidIntent/article.html)


## What are intents?

Intents are asynchronous messages which allow application components to request functionality from other Android components. Intents allow you to interact with components from the same applications as well as with components contributed by other applications. For example, an activity can start an external activity for taking a picture.

Intents are objects of the android.content.Intent type. Your code can send them to the Android system defining the components you are targeting. For example, via the startActivity() method you can define that the intent should be used to start an activity.


### Instantiating activities

The simplest way to navigate from activity to another is to call the startActivity() method in the initial activity.

```java
// start the gallary activity
Intent intent = new Intent(this, GalleryActivity.class)
startActivity(intent);
```

![using startIntent to start another activity](images/startIntent-to-perform-action.png)

Activities which are started by other Android activities are called sub-activities. This wording makes it easier to describe which activity is meant.



### Navigating

![Intent Navigation](http://apprize.info/google/programming/programming.files/image068.jpg)



##### Mob-programming Exercise

As a group, we will build a splash screen that is presented when we first launch our app, and which navigates us to our app's main content.




#### Implicit vs. Explicit Intents

When we **specify a class within our application** we want to navigate to, that is an **explicit** intent. We are telling the ActivityManager exactly which activity we want to navigate to.

```java
Intent explicitIntent = new Intent(this, ActivityTwo.class);
```

Implicit Intents do not specify a component; instead, they must include enough information for the system to determine which of the available components is best to run for that intent. 

```java
Intent implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.c4q.nyc"));
```

Using an implicit intent is useful when your app cannot perform the action, but other apps probably can and you'd like the user to pick which app to use. 

## Common Implicit Intents

For example, if you have content you want the user to share with other people, create an intent with the ACTION_SEND action and add extras that specify the content to share. When you call startActivity() with that intent, the user can pick an app through which to share the content.

* Taking a picture with Camera (uses default camera app)

* Sending/Reading an SMS message

*What other examples of implicit intents can we think of?*

## Sending data

To send data from one activity to another, we need to make sure to associate an extra with the intent before calling startActivity() in our origin Activity.

You can add data to an Intent Bundle via the overloaded `putExtra()` methods of the Intent objects. Extras are key/value pairs. The key is always of type String. As value you can use the primitive data types (int, float, …​) plus objects of type String, Bundle, Parcelable and Serializable.
``` java
public Intent putExtra(String key, String value);
```

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
```

## Example: Using the share intent

Lots of Android applications allow you to share some data with other people, e.g., the Facebook, G+, Gmail and Twitter application. You can send data to one of these components using the Share intent. 

```java
// this runs, for example, after a button click
Intent intent = new Intent(Intent.ACTION_SEND);
intent.setType("text/plain");
intent.putExtra(android.content.Intent.EXTRA_TEXT, "Important news to share with friends");
startActivity(intent);
```


## Pairing Exercises - Add lifelines to the Quizzy app

1) CheatMode: Add a CheatActivity that displays the same question and includes a Cheat button allowing the user to preview the right answer. Modify CheatActivity's logic so that it reports back to the original activity whether the user clicked cheat or not.

2) Phone-A-Genius: Add the phone number of a genius to your Android project as String resources. Include a button allowing the user to automatically dial this number. The app should navigate from your app to the phone app with the desired phone number already loaded without any additional entry from the user.


3) Share-with-a-Friend: Implement the share feature, allowing for a user to share the question they're having difficulty with on different mediums (ex: Gmail, facebook, twitter, messages) [See Share Icons](https://storage.googleapis.com/material-icons/external-assets/v4/icons/zip/ic_send_black_24dp.zip)


### More on Intents - Optional but Recommended
Your user now wants to be able to include a selfie in the Activity. Include an imageView that will display the user's selfie and a button for launching the phone's Camera app. How can we retrieve the resulting image from the Camera Activity in our own activity?


[Exit Ticket](#)
