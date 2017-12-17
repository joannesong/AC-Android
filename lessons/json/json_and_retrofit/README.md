# Retrofit - Parsing JSON the Easy Way 

## Objectives
* Fellows will pull data from JSON endpoint using Retrofit
* Fellows will create data models to map to that JSON Data
* Fellows will display that data as an image from a website using Picasso

## Resources
* [Dog API](https://dog.ceo/dog-api/) 
* [Picasso](https://github.com/square/picasso)
* [Retrofit](https://github.com/square/retrofit)
* [JSON and JSON Parsing - The Old School Way](https://github.com/C4Q/AC-Android/tree/master/lessons/json/json_parsing)

# Lecture

We have explored in class previously how to create JSONObjects, and parse JSON into data models that we can use to display that JSON data in some meaningful way. We've even explored how to use AsyncTasks (ugh, sorry...) to reach a JSON Endpoint somewhere on the internet, and make use of that information any way we chose to do so. You might have thought this was the only way to do this in Android, but...

![Retrofit, there is...](http://i.imgur.com/SRyMh.jpg)

much less exhausting, and much more predictable way to do this - using Retrofit.

## What is Retrofit?

It's amazing, is what it is. An open-source library built by Square, it allows you to easily make GET and PUT requests (among other things), by simply using a few boilerplate lines of code, without having to repeat yourself that often. It accounts for most edge cases specific to HTTP requests, and does everything off of the main thread, so you never have to worry about blocking the rest of your UI.

## Retrofit, by the Recipe

First, we'll break down the most important steps to a basic Retrofit call, as per the **first principles** technique, then we'll expand on these steps by making an app that displays random puppy images.

### Step 1: Add Internet Permissions

First, you'll need to add this permission to your ```AndroidManifest.xml``` file:

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          package="nyc.c4q.dogjson">
  
    <!--This will allow you to connect to the internet-->
    <uses-permission android:name="android.permission.INTERNET"/>

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>

                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
    </application>

</manifest>
```

### Step 2: Add Gradle Dependencies

Add these dependencies to your app's build.gradle file:

```groovy
compile 'com.squareup.retrofit2:retrofit:2.3.0'
compile 'com.squareup.retrofit2:converter-gson:2.3.0'
```

**Remember:** if you're using Android 3.0, swap out ```compile``` with ```implementation```.

### Step 3: Find your desired JSON Endpoint

In this example, we'll use the JSON provided by [Dog.ceo](https://dog.ceo/api/breeds/image/random), which looks something like this:

```json
{"status":"success","message":"https:\/\/dog.ceo\/api\/img\/poodle-toy\/n02113624_2224.jpg"}
```

We can see that this JSON is a single object, consisting of two key/value pairs - the key "status" has a value of "success', and the key "message" has a value of what looks like a weblink to an image. Both values are written as Strings - this is important to remember as we move foward.

###
