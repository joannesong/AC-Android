# In class exercises

### Q1) Activity Lifecycle Callbacks

1) Create a new Android Studio project:

* Use the **Application name** `Activity Lifecycle`
- Use the **Company domain** `yourname.c4q.nyc`
- Set the **Project location** to your `~/Desktop/accesscode` directory.
- On the next screen, select **Phone and Tablet** and set the **Minimum SDK** at API 19.
- On the next screen, select **Empty Activity** to initialize your project with an empty activity. Continue to the next screen and name it `MainActivity` and keep **Generate Layout File** checked.
- Click **Finish** to create your project.

2) In your `MainActivity`, override each of the following methods: 
- `protected void onCreate(Bundle savedInstanceState)`
- `protected void onStart()`
- `protected void onResume()`
- `protected void onPause()`
- `protected void onStop()`
- `protected void onRestart()`
- `protected void onDestroy()`

3) In each of the overridden methods, insert an logging statement with the method name (i.e. in the `onCreate()` method you would insert `Log.d("MainActivity", "onCreate");`).

4) Plug in your device and start the app for the first time by pressing the **Run** button in Android Studio. watch the log output in the `Devices | logcat` view - note down the order in which the lifecycle methods are executed when the app starts.

5) Exit the app by pressing the back button to exit the app - note down the order in which the lifecycle methods are executed.

6) Start the app by pressing the app's icon in the Launcher - note down the order in which the lifecycle methods are executed.

7) Exit the app by pressing the home button on your device - note down the order in which the lifecycle methods are executed.

8) Start the app again by accessing it from the Recent Apps screen - note down the order in which the lifecycle methods are executed.

9) Exit the app by pressing the home button on your device.  It should go through the same lifecycle events as in step 5.

10) Start the app again using any method, from the Launcher or from the Recent Apps screen.

11) Rotate the device - note down the order in which the lifecycle methods are executed.

### Q2) Saving and Restoring State


1) Open the `activity_main.xml` file.

2) Add the following attribute to the `<TextView>` element:

```
android:id="@+id/my_textview"
 ```

3) Add an `EditText` view in `activity_main.xml`. In `activity_main.xml`, add the following code underneath the `<TextView>` element:

 ```
 <EditText
    android:id="@+id/my_edittext"
    android:layout_width="match_parent"
    android:layout_height="40dp"
    android:layout_below="@id/my_textview"/>
```

4) Run the app.

5) Type in some text into the `EditText` field.

6) Rotate the screen.

7) After the activity destroys and recreates itself, notice that the `EditText` still contains the same text as it had before it was rotated. This happens because the activity automatically saves and restores state on any views that have an `id` attribute in the backing XML layout file for that activity.

8) Create a instance variable in `MainActivity` to hold a reference to the `TextView`:
- Open `MainActivity.java`
- Under the class declaration, add the following line: `private TextView myTextView;`
- At the end of the `onCreate(Bundle savedInstanceState)` method, add the following lines:
``` 
myTextView = (TextView) findViewById(R.id.my_textview);
SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
String timeString = format.format(new Date());
myTextView.setText(timeString);
``` 

9) Run the app.

10) Type some text into the `EditText`.

11) Take note of the time that is displayed on the screen.

12) Rotate the screen.

13) Notice that after rotation, the text in the `EditText` view is the same but the time in the `TextView` is different.

14) In order to save and restore state on data that was generated dynamically, you must do the following: 

- Override the `onSaveInstanceState(Bundle outState)` method
- Save the state of any variables you want to preserve into the `outState`.
- Restore state from the bundle in the `onCreate(Bundle savedInstanceState)` method.

Modify the code in `MainActivity` so that it saves the time into the activity's bundle and restores it in `onCreate(Bundle savedInstanceState)` if `savedInstanceState != null`.
