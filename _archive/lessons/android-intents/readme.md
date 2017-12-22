- title: Android Intents
- tags: intents, extra, data, action

# Objectives

- Distinguish between implicit and explicit intents
- Use intents to handle navigation within an Android application
- Use intent extras to transfer information from one activity to another.

# Resources

- [Intent](https://developer.android.com/reference/android/content/Intent.html)
- [Common Intents](https://developer.android.com/guide/components/intents-common.html)
- [Getting a result from an activity](https://developer.android.com/training/basics/intents/result.html)

# Lecture

### Instantiating activities

The simplest way to navigate from activity to another is to call the startActivity() method in the initial activity.

```java
public void startActivity(Intent intent);
```
The Intent class refers to an object that can be used to navigate between activities. At a minimum, it will specify which activity we want to navigate to or some specific action.

```java
Intent intent = new Intent(MainActivity.this, FingerPrintActivity.class)
```

### What is an Intent?

The intent, like a lot of what we see in Java, is just an object. It's an object that a component can use to communicate with the OS. So far, the only we components we're familiar with are activities, but there are also services, broadcast receivers, and content providers.

The intent class provides different constructors depending on what you intend to do.

*Take a few minutes to research some of the other constructors that can be used to create an Intent instance.*

When an activity calls startActivity, the call is sent to the OS, which lunches the ActivityManager trigging the ActivityManager to create the Activity instance and call its onCreate method.

NB: Before ActivityManager actually starts the desired activity, it checks the manifest to ensure that the specified class has been declared in AndroidManifest.xml. If it hasn't been declared, we end up with an [ActivityNotFoundException](https://developer.android.com/reference/android/content/ActivityNotFoundException.html).

TLDR - Declare all your activities in your manifest

### Navigating

![Intent Navigation](http://apprize.info/google/programming/programming.files/image068.jpg)



##### Mob-programming Exercise

As a group, we will build a splash screen that is presented when we first launch our app, and which navigates us to our app's main content.




#### What is your Intent? Implicit vs. Explicit

When we specify a Class within our application we want to navigate to, that is a very explicit intent. We are telling the OS and the ActivityManager exactly which activity we want to navigate to.
There are two primary forms of intents you will use.

- Explicit Intents have specified a component (via setComponent(ComponentName) or setClass(Context, Class)), which provides the exact class to be run. Often these will not include any other information, simply being a way for an application to launch various internal activities it has as the user interacts with the application.

- Implicit Intents have not specified a component; instead, they must include enough information for the system to determine which of the available components is best to run for that intent.

Using an implicit intent is useful when your app cannot perform the action, but other apps probably can and you'd like the user to pick which app to use.

For example, if you have content you want the user to share with other people, create an intent with the ACTION_SEND action and add extras that specify the content to share. When you call startActivity() with that intent, the user can pick an app through which to share the content.

*What other examples of implicit intents can we think of?*

#### Sending data

![Extra1](http://apprize.info/google/programming/programming.files/image070.jpg)

To send data from one activity to another, we need to make sure to associate an extra with the intent before calling startActivity() in our origin Activity.

Extras are just arbitrary data that a calling activity can include with its intent. The OS will forward the intent to the recipient activity, which can access the extras and retrieve the data.

An extra is structured as a key-value pair, and by now we are experts on key-value pairs.


``` java
public Intent putExtra(String name, boolean value);
```

Why do you think the method returns an Intent object


![Extra2](http://apprize.info/google/programming/programming.files/image071.jpg)

To receive data back from a child activity, you will want to call startActivityForResult() instead of startActivity.


It's method definition looks like

```java
public void startActivityForResult(Intent intent, int requestCode);
```

The first parameter is still an intent, while the second parameter is the request code used to identify the action that was requested. The request code is just a user-defined integer that is sent to the child activity and then received back by the parent.

Your activity receives the result as a separate Intent object in your activity's onActivityResult() callback method. The onActivityResult method signature looks like

``` java
void onActivityResult(int requestCode, int resultCode, Intent data);
```

## Pairing Exercises - Add lifelines to the Quizzy app

1) CheatMode: Add a CheatActivity that displays the same question and includes a Cheat button allowing the user to preview the right answer. Modify CheatActivity's logic so that it reports back to the original activity whether the user clicked cheat or not.

2) Phone-A-Genius: Add the phone number of a genius to your Android project as String resources. Include a button allowing the user to automatically dial this number. The app should navigate from your app to the phone app with the desired phone number already loaded without any additional entry from the user.


3) Share-with-a-Friend: Implement the share feature, allowing for a user to share the question they're having difficulty with on different mediums (ex: Gmail, facebook, twitter, messages) [See Share Icons](https://storage.googleapis.com/material-icons/external-assets/v4/icons/zip/ic_send_black_24dp.zip)


### More on Intents - Optional but Recommended
Your user now wants to be able to include a selfie in the Activity. Include an imageView that will display the user's selfie and a button for launching the phone's Camera app. How can we retrieve the resulting image from the Camera Activity in our own activity?


[Exit Ticket](#)
