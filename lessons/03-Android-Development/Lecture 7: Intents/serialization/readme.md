## Background Tasks in Android

### Objective

Students will understand:

* The difference between Android Components
* Background operations


#### Resources
- [App Components](https://developer.android.com/guide/components/index.html)
- [Services](https://developer.android.com/guide/components/services.html)


### Lecture

# Android Components
Android components are all the classes provided by the android framework to build
and android app. We have worked with Intents, Activities and Fragments. There
are several other components that you should know. These are
* Service
* Broadcasts
* Content Provider

Today we will be exploring the Service component.

# Service
A Service is a component that once started, can stay alive forever. They are used
to perform long running operations and do not a have a user interface. A service can
communicate with any other component in your application, such as an activity. By
writing code to interface your activities with a service, a user can control the
operation of a service.

There are several options to start a service. If you are using api 21 or greater,
it is recommended to use the JobScheduler class in android. However since we target
api 16 in class, we will be using Started and bound services.

Services have their own lifecycle. Though it is simpler than the activity lifecycle,
be sure you understand exactly when a service starts and stops.

** Extremely Important **
Services run in the main thread. You should always start a new thread if you
will be doing operations that may cause an ANR.

# Started service
* No user interface
* Started with startService()
* Can run indefinitely
* Must be sure to call stopSelf()
* Runs in main thread

# Bound Service
* No user interface
* Started with bindService()
* Will only run while another component is bound.
* Shuts itself down
* Runs in main thread

# Intent Service
* No user interface
* Started with startService() to execute a single task
* Will continue to run as long as there are tasks to be executed.
* Shuts itself down
* Runs in a new thread created by default implementation

# Foreground Service
* Must have a user notification
* Started with startForeground()
* Can run indefinitely
* Must be sure to call stopSelf() to shut down the service
* Must be sure to call stopForeground() to remove notification but keep service running


# Serialization
Serialization describes the process of turning an object into a flat representation
(typically a stream of bytes) that can be interpreted by another object. This is used
to send data from one place to another.

In Java, serialization can be implemented using Serializable interface.

In Android, serialization can be implemented by using the Parcelable or Serializable
interfaces.

Serialization in Android is typically used to send data to and from other components.
The serialized representation is usually added to the intent with putParcelable or
a bundle with putSerializable. Then the data can be read by the receiver and inflated.

# Assignment

Your task is to build an activity that plays a single song, looping in the background.
- When the activity starts, it should start or connect to a service running in the background.
- The activity must determine whether the service is already playing a song.
- If the service is playing a song already, the activity should show a pause button.
- If the service is not playing a song already, the activity should show a play button.
- If the service is playing, there should be a stop service button. When it is clicked, the service should stop.
- If the service is stopped, there should be a disabled stop service button.
