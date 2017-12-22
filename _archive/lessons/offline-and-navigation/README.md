## Navigation in Android

### Objective

Students will understand:

* The different navigation options used in Android


### Resources
- [Navigation Tutorials](https://developer.android.com/training/implementing-navigation/index.html)
- [Navigation Drawer](https://developer.android.com/training/implementing-navigation/nav-drawer.html)
- [Tab View](https://developer.android.com/training/implementing-navigation/lateral.html)
- [Bottom Navigation View](https://developer.android.com/reference/android/support/design/widget/BottomNavigationView.html)
- [Managing Network Usage](https://developer.android.com/training/basics/network-ops/managing.html)

### Lecture
In Android there are several design patterns for navigating through an app. These patterns are 
described and demonstrated in the links above. We will briefly discuss the differences between the navigation 
options and how to implement them.

#### Offline
It is important to understand the environment your applications will run in. Mobile handsets do not always
have network connectivity. We will discuss patterns to handle Connectivity changes, along with the [Android
api's](https://developer.android.com/training/basics/network-ops/managing.html) that detect these changes.

### Assignment

Continuing from https://github.com/C4Q/AC3.3/tree/master/lessons/serialization<br>
Your task is to build an activity that plays a single song, looping in the background.<br>
- When the activity starts, it should start or connect to a service running in the background.
- The activity must determine whether the service is already playing a song.
- If the service is playing a song already, the activity should show a pause button.
- If the service is not playing a song already, the activity should show a play button.
- If the service is playing, there should be a stop service button. When it is clicked, the service should stop.
- If the service is stopped, there should be a disabled stop service button.


