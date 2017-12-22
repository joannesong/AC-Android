# Android Studio and the Structure of an Android Project

#### Objective

Students will become familiar with the project structure of a gradle Android Project
and know how to use basic Android Studio features.

#### Pre-work

[Download Android Studio](https://developer.android.com/studio/index.html)

Read through ["Building your first app"](https://developer.android.com/training/index.html). (We will explore this in class)

#### Afternoon Exercise

Write a program that takes in a number from 0 to 100,
representing a student’s grade, and prints out the letter grade. 

* 100   = A+
* 90-99 = A
* 80-89 = B
* 70-79 = C
* 60-69 = D
* 0-59 = F

#### Lesson

##### What is Android 

[Android](https://en.wikipedia.org/wiki/Android_(operating_system)) is an operating system originally built by [Andy Ruben](https://en.wikipedia.org/wiki/Andy_Rubin) in 2003 and bought by Google in 2005. As android developers, when we build an android application we're constructing a file for the operating system to interpret, which comes as a `.apk` file built by the [framework](https://en.wikipedia.org/wiki/Software_framework) provided by android studio. You can build an application manually but it is a complex task. Android studio was built to cut out all the time it would take to build common settings and structure needed for all applications. 

##### What is Android Studio


Android Studio is based off IntelliJ, but created specifically for Android Development. Although you'll very commonly see Eclipse online when looking for help, Android Studio is the default build system supported by Google. Using this should be very similar to IntelliJ, including similar shortcuts, and the advice you find online for IntelliJ will often be transferable (except for gradle problems - ie. build settings).

> Exercise: Create a new Android Project of any type.

##### Introduction to an Android project
* Gradle Scripts: The build system that allows you to tweak application build settings
* Manifests: This is where the information that the system must have to run the Android Project lives.
* Java: This is where your Java code for the project lives.
* Res: These are the resources files. Here's where static information lives.

##### Exploring Android Studio panels:
* Project (android view vs project view)
* Android console (logcat, memory, cpu)
* Structure

##### SDK Manager

The SDK manager allows you to install other libraries you might need, for example HAXM, Android Wear, or earlier versions of Android.

Over it's lifetime, Android has gone through different iterations as an operating system, these are called flavors. You'll often hear names such as kitkat, Lollipop or Marshmellow when people refer to android versions, these are previous versions analogous to the API version you're working with which have a number associated with it such as API level 21 and so on. The latest one being Android O for Oreo otherwise called API level 26  

The [SDK Manager](https://developer.android.com/studio/intro/update.html) is a tool in android studio that helps us keep up to date with these changes and download newer versions to develop in as they become available. It is also important to mantain backwards compatibility with older versions in case users of your app still have an older device. Generally it is a good practice to develop for API level 19 and above, like this you will be able to reach a large portion of market users. 

##### AVD manager

The [AVD](https://developer.android.com/studio/run/managing-avds.html) is where you can manage virtual devices (Android emulators) and create new ones. This is to make sure that your application looks good on differently sized screens.

> Exercise: Create an Android app that does the same thing as your letter grade program. Include a [text field](http://developer.android.com/reference/android/widget/EditText.html) for user
input and a [button](http://developer.android.com/reference/android/widget/Button.html) to submit. The output should be a [text view](http://developer.android.com/reference/android/widget/TextView.html) of the letter. If you wish, you can try to make the letter different colors based on the grade. For a bonus challenge, add a notification that notifies the user of the grade when the submit button is pressed. The app should look like this:

> ![](http://i.imgur.com/RgszB8z.png).



#### Support materials

* [Android anatomy](https://www.youtube.com/watch?v=Buo7kzHECHk) 
* [Project overview](https://developer.android.com/studio/projects/index.html)
* [Ui Overview](https://developer.android.com/guide/topics/ui/overview.html)
* [TextView](https://developer.android.com/reference/android/widget/TextView.html)
* [EditText](https://developer.android.com/reference/android/widget/EditText.html)
* [Button](https://developer.android.com/guide/topics/ui/controls/button.html)