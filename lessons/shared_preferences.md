# Using SharedPreferences on android

#### Objective

Students will learn how to store and retrieve primitive values on their devices using shared preferences. 

#### Pre-work

[Read all you can about persisiting storage on andorid](https://developer.android.com/guide/topics/data/data-storage.html#pref)

We will only use shared preferences in this class but it is worth it to look further into other solutions provided by the framework.

#### Afternoon Exercise

As a class, we will create a "StarWars Alliance" app that stores the settings for a "Theme" set by the user after initial start-up.

Your application should contain two activities, the "Home" screen will be the user's "profile" which will contain:

1: A background color 
2: A welcome message 
3: An icon chosen by the user

On initial start up, these will contain default values.

At the bottom of the home screen you will have a "settings" button which will take you to another activity that will allow you to change these values and store them using shared preferences so that the next time the user opens up their app. Their settings will have been saved.

Specification:
* The user can choose one of three colors for the activity's background. One must be a default used for the first time that the user opens up the app. (I will use yellow, blue, red)
* A Welcome message for the user. On the settings screen this message can be edited by the user.
* A default icon which can be changed by the user in the settings screen. (hint - you can simply map ints to images instead of storing the entire image in shared prefs.) 

Images: 
* [R2 icon ](https://cdn0.iconfinder.com/data/icons/star-wars/512/r2d2-128.png)(Default)
* [Rebel icon](http://emojis.slackmojis.com/emojis/images/1450319450/113/rebel.png?1450319450)
* [Empire icon](http://emojis.slackmojis.com/emojis/images/1450319450/114/empire.png?1450319450)