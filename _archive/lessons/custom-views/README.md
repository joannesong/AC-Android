## Threads and Custom Views

### Objective

* Understand what are processes and threads 
* Understand where code is restricted to run in Android
* Understand how a custom view works, by reading Android Documentation


#### Resources
- [Concurrency](http://docs.oracle.com/javase/tutorial/essential/concurrency/)
- [Processes and Threads](https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html)
- [AsyncTask](https://developer.android.com/reference/android/os/AsyncTask.html)
- [Processes and Threads, an Overview](https://www.youtube.com/watch?v=IcIFJ5V3Ibg)
- [Components and the UI Thread](https://www.youtube.com/watch?v=A0PAhoHzlsQ)
- [Android Multithreading Overview](https://www.youtube.com/watch?v=lznss-0gEHU)
- [AsyncTasks](https://www.youtube.com/watch?v=V4q0sTIntsk)
- [Services](https://developer.android.com/guide/components/services.html)
- [Custom View](https://developer.android.com/training/custom-views/index.html)

# Threading
We have discussed in the past the differences between processes and threads.
- A process is a single program. It must have one or more threads.
- A thread is a history of execution for a single code path. A thread exists within
a processes memory space. Each thread runs independently

All user interface operations happen on the main thread.
All long running operations should happen on a background thread.

When an application starts, code is running on the main thread. Execution only
moves to a background thread by spawning one using new Thread();

This is the same for Android devices and Linux computers.

On Linux and Android, there is another execution model called a service. This is 
used to execute long running tasks that do not need a user interface. For example, 
a music app that continues to play music whether the device screen is on or off 
would be implemented in a service. As would an application that backs up user 
data to a website at a fixed time of day.

Services have their own lifecycle, just like activities and fragments do. Once a service
is started, it will run for forever until it shuts itself down. Hence it is important
to guarantee any services you build shut themselves down at some point, otherwise 
your device will eventually become unresponsive.

A running service can be bound to another application component such as an 
activity. A bound service will shut itself down when no other components are bound
to it. Hence, a programmer can design a service that is only alive when an application
that needs it is running, and shuts itself down otherwise. 

# Custom Views
Today, we will be implementing custom views, in order to get a better understanding
of how the Android system handles the xml you feed it. Custom views are not 
typically built in most Android applications, since most Android jobs require
downloading json and showing something on the screen. However, if you want to
do animations, build video games, or draw a custom shape, custom views are an option.

It is important to understand that the xml we write for Android is an interface to 
actual java code. The LinearLayout class is java code, that takes parameters from
xml such as layout_width and gravity.

Your assignment today is to write a single Bouncing Ball class. This class will 
extend the View class, and should draw a circle that animates both vertically 
and horizontally.

Your ball should have the following OPTIONAL parameters. If the parameter is not 
specified in xml, you should use the default value, given in parenthesis

- radius (10dp) - Radius of the ball
- xSpeed (5dp)  - How fast the center of the ball translates in the X plane
- ySpeed (0dp)  - How fast the center of the ball translates in the Y plane
- color  (#FFF11223) - The color of the ball

Note that the default dimensions are given in density independent pixels. You 
must be sure to translate this to pixels correctly.

All the information needed to build this can be found at [Custom Views](https://developer.android.com/training/custom-views/index.html)

There is a working example here:
 http://jsjrobotics.nyc/classroom/BouncingBall.apk
