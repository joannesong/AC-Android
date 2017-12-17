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

We can see that this JSON is a single object, consisting of two key/value pairs - the key "status" has a value of "success", and the key "message" has a value of what looks like a weblink to an image. Both values are written as Strings - this is important to remember as we move foward.

### Step 4: Create your Data Model

In your app's package folder, make another package called "model", and create a class inside the 'model' directory to represent that JSON Object. Let's call it "RandoPuppy.java":

```java
package nyc.c4q.dogjson.model;

public class RandoPuppy {
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
```

It should have two String member variables that match the key names **EXACTLY AS THEY ARE WRITTEN** in the JSON, as well as Getter methods. Now that we have our model, let's parse some JSON through it.

### Step 5: Create a Retrofit instance, using the Builder Pattern

The Builder Pattern is a way to assign values to member vaiables/fields within a class using method chaining during instantiation - sort of like a constructor. However, it is arguably better - sort of the way you use beginTransaction() and commit() with a fragment.

**YOU DO NOT NEED TO KNOW HOW THIS WORKS RIGHT NOW.**

However, that's what's happening in the following code:

```java
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
```

Let's break it down line-by-line:
* ```Retrofit retrofit = new Retrofit.Builder()``` - this starts the builder process
* ```.baseUrl("https://dog.ceo/")``` - this is our "Base URL", or the gateway to our JSON endpoint. Our full endpoint link is: https://dog.ceo/api/breeds/image/random - so essentially everything up to our first forward slash is our base url
* ```.addConverterFactory(GsonConverterFactory.create())``` - this takes care of our JSON serialization/deserialization for us! Thanks, Google! If you want to take a deeper dive into Gson, you can read more about it [here](https://futurestud.io/tutorials/retrofit-2-adding-customizing-the-gson-converter)
* ```.build();``` - this ends the transaction, and returns to us a complete Retrofit instance!

### Step 6: Create a service:

Let's create a package called "backend" within the app's package, and create an interface called ```PuppyService.java```:

```java
package nyc.c4q.dogjson.backend;

import nyc.c4q.dogjson.model.RandoPuppy;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PuppyService {
    @GET("api/breeds/image/random")
    Call<RandoPuppy> getPuppy();
}
```

This will give us the opportunity to call on a method called ```getPuppy()``` - which will make an HTTP GET request for our JSON. As you can see, the rest of our JSON endpoint link is contained in our GET request. Let's go back to our MainActivity, and call the service:

```java
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // creating the service so we can use it to make requests:
        puppyService = retrofit.create(PuppyService.class);
```

