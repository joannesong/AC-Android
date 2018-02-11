# Google Firebase, and Learning How to Learn

## Resources
* [Firebase Codelab](https://codelabs.developers.google.com/codelabs/firebase-android/index.html#0)
* [Firebase in a Weekend: Android](https://www.udacity.com/course/firebase-in-a-weekend-by-google-android--ud0352)

# Lecture

Since this is the last actual lesson of new material before the Final, Hackathon, and Capstone, it's worth noting that in the tech industry, we must always be prepared to learn new things. What we learn today, will most likely be obsolete in two-years-time. This is actually a good thing, and it is not something new in other professional career paths. Think of a Doctor, who must regularly attend conferences, and publish papers on their findings. A Lawyer who must frequently earn credits for continuing education to be aware of new legislation, or courtroom decisions. A musician, or athlete, who must learn new techniques and strategies to remain competitive as their bodies continue to age. Such is the same for a practicing Software Developer - especially for a developer who composes software for mobile devices.

Once you graduate from C4Q, unless you enroll in another program or university track, much of your learning will come from either writing new apps with new requirements, or from reading/viewing code online - written by other people. It's your job to continually pursue these resources, emulate them, then try to make them better/cleaner, or at the very least, something that fits your needs ([people in the art world do this all the time](https://www.artsy.net/article/artsy-editorial-copying-peoples-art-boost-creativity)).

We've done this in the past while exploring previous lessons, such as SharedPrefs, Fragments, RecyclerView, and Retrofit. However, C4Q will not be the end of your learning journey, at least it absolutely shouldn't be. Online videos, tutorials, and coding demonstrations will be your new best friends as you try to complete the goals you've set for yourselves during the ideation, composition, and presentation phases of your capstone projects. For Android, a great way to explore this is through Google Codelabs.

## What is a Codelab?

A codelab is a way for you to explore new concepts (provided by Google) by either creating an app by following concrete steps, by downloading a repository and filling in the necessary gaps, or both. We could write a lesson on our final topic, but honestly - Google has done a way better job than we could when it comes to their proprietary software. The the topic for the codelab we will explore to both demonstrate self-directed learning, and introduce a new topic you will most likely utilize during hackathon/capstone, is Firebase.

## What is Firebase?

Firebase is a mobile and web application development platform, owned by Google, which provides mobile and web developers a Backend-as-a-Service (BaaS) - in other words, the opportunity for add customizable, cloud-based, backend services for web apps.

However, although many of its services are free, Firebase will charge a fee based on a number of variables (number of users, bandwidth, database size, advertising, etc). Those that can afford it, may use those services by paying for them. But for our purposes, we can use most if not all for free, when used sparingly, and for demostration purposes (hackathon/capstone).

## What Services does Firebase provide?

**Firebase Analytics:** cost-free app measurement solution that provides insight into app usage and user engagement

**Firebase Cloud Messaging:** formerly known as Google Cloud Messaging (GCM), Firebase Cloud Messaging (FCM) is a cross-platform solution for messages and notifications for Android, iOS, and web applications, which currently can be used at no cost

**Firebase Auth:** a service that can authenticate users using only client-side code. It supports social login providers Facebook, GitHub, Twitter and Google. Additionally, it includes a user management system whereby developers can enable user authentication with email and password login stored with Firebase

**Realtime Database:** a realtime database and backend as a service. The service provides application developers an API that allows application data to be synchronized across clients and stored on Firebase's cloud

**Firebase Storage:** provides secure file uploads and downloads for Firebase apps, regardless of network quality. The developer can use it to store images, audio, video, or other user-generated content. Firebase Storage is backed by Google Cloud Storage

**Firebase Test Lab for Android:** provides cloud-based infrastructure for testing Android apps. With one operation, developers can initiate testing of their apps across a wide variety of devices and device configurations. Test results—including logs, videos, and screenshots—are made available in the project in the Firebase console. Even if a developer hasn't written any test code for their app, Test Lab can exercise the app automatically, looking for crashes

**Firebase Notifications:** a service that enables targeted user notifications for mobile app developers at no cost

**Firebase App Indexing:** gets an app into Google Search. Adding App Indexing promotes both types of app results within Google Search and also provides query autocompletions

**Firebase Invites:** a cross-platform solution for sending personalized email and SMS invitations, on-boarding users, and measuring the impact of invitations

**Firebase Remote Config:** a cloud service that lets developers change the behavior and appearance of their apps without requiring users to download an app update

**Adwords:** Google's online advertising service that integrates with to enable developers to target users using Firebase Analytics

**Admob:** a Google advertizing product that integrates with Firebase

.... And the list goes on-and-on ....

## Pros and Cons

Pros:

* Quicker Prototyping Turnaround
* Lots of Services, many of which are free

Cons:

* Costs money the more users/usage you get out of it, and these prices are always subject to change
* Many of these features can be implemented without Firebase on one's own with a little time and elbow grease, for free, and without  the burden of building a dependency on Google (Android is open-source - Firebase IS NOT)

In other words, it's very likely that as a developer for a company, you may never use Firebase - it is also equally as likely that as an entrepreneur, you may use Firebase to quickly get your start-up off the ground, and gaining market share before everyone else - it really depends on your current needs.

## The Firebase for Android Codelab

For today's lesson, we will, as a group, follow the [Google Codelab found here](https://codelabs.developers.google.com/codelabs/firebase-android/index.html#0).

We'll develop a messenger app that allows for Google Auth, and a number of other features. Along the way, we'll make mistakes, re-read instructions, be prepared to google stuff if the app crashes, and learn new things. Welcome to the wonderful world of self-directed learning!!!
