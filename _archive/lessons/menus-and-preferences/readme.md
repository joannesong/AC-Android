- title: Menus and Preferences
- tags: menus, preferences,

# Objectives

- Use Shared Preferences to save and restore preferences
- Inflate menu resources and utilizePreferenceActivity

Answer the following
* What are Preferences?  
* SharedPreferences vs PreferenceActivity  
* Creating the Preferences Activity.  
* Creating Preferences in the XML.  
* Types of Preferences.  
* Reading Preferences.  

# Resources

- [Shared Preferences](https://developer.android.com/reference/android/content/SharedPreferences.html)
- [Saving key value sets](https://developer.android.com/reference/android/content/SharedPreferences.html)

# Lecture
Android has several ways to store data for long-term use by your
activity. Today we will practice using SharedPreferences and simple files. Android allows activities and applications to keep preferences, in the form of key/value pairs (like a Map).

The primary purpose is for you to store user-specified configuration details, such as the last feed the user looked at in your feed reader, or what sort order to use by default on a list. You can store in
the preferences whatever you like, so long as it is keyed by a String and has a primitive value (boolean, String, etc.)

If you have a relatively small collection of key-values that you'd like to save, SharedPreferences API's may be appropriate for some simple data persistence about your user. A SharedPreferences object points to a file containing key-value pairs and provides simple methods to read and write them. Each SharedPreferences file is managed by the framework and can be private or shared.

#### Do Now
- Create an Android App that displays some Lorem Ipsum.
- Add a menu subdirectory to your Resources folder, and create a main.xml file to contain your main menu.
include controls for increase and decreasing the text size, and for changing text background. We will use SharedPreferences to save these user-defined settings.


## Accessing SharedPreferences instance
To get access to the preferences, you have three APIs to choose from:
• getPreferences() from within your Activity, to access activity-specific
preferences
• getSharedPreferences() from within your Activity (or other application
Context), to access application-level preferences
• getDefaultSharedPreferences(), on PreferenceManager, to get the shared preferences that work with Android’s overall preference
framework

The first two take a security mode parameter. Generally go with
MODE_PRIVATE, so no other applications can access the file. The
getSharedPreferences() method also takes a name of a set of preferences;

The getDefaultSharedPreferences() method
takes the Context for the preferences (e.g., your Activity).


## Saving data to Shared Preferences

TO save data to the shared preferences, we must call .edit() on the preferences object to access its editor. We can then use the editor to write key, value pairs.

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor editor = prefs.edit();
    editor.putBoolean("IS_LOGGED_IN", true);
    editor.apply();
}
```

## Retrieving data from Shared Preferences.

All of those methods return an instance of SharedPreferences, which offers a series
of getters to access named preferences, returning a suitably-typed result (e.g.,
getBoolean() to return a boolean preference). The getters also take a default value,
which is returned if there is no preference set under the specified key.


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    boolean isPremium = prefs.getBoolean("IS_LOGGED_IN", false);
}

#### Research
* Preference Activity (https://developer.android.com/reference/android/preference/PreferenceActivity.html)
* Intents  
* Custom Preferences  
    - Default values  
    - Saving and restoring preferences  

####
Expand the PreferenceActivity to have the following features:  
* Use headers for a “Fonts” drawer  
* Fonts should allow the user to set the size and color of font  
* Change all of this to use Custom Preferences  

#### Exit ticket
Please fill out the exit ticket [here](https://docs.google.com/a/c4q.nyc/forms/d/1TaqobsWRTkoweKf89K6nm4WkBGtqYY1UQEQQWdDA_cs/edit?usp=drive_web).
