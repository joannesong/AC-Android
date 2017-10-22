# Views in Android

## Objectives

- Explore Views
- Define the difference between ViewGroups and Widgets
- Identify View Vierarchies
- Utilize a number of different Views/ViewGroups

## Resources

- [Toasts](https://developer.android.com/guide/topics/ui/notifiers/toasts.html)
- [Layouts](https://developer.android.com/guide/topics/ui/declaring-layout.html)
- [Linear Layout](https://developer.android.com/guide/topics/ui/layout/linear.html)
- [Relative Layout](https://developer.android.com/guide/topics/ui/layout/relative.html)
- [Android API: TextView](https://developer.android.com/reference/android/widget/TextView.html)
- [Android API: EditText](https://developer.android.com/reference/android/widget/EditText.html)
- [Android API: Button](https://developer.android.com/reference/android/widget/Button.html)

## Warmup - Making Toast :bread:

A ```Toast``` is a popup that provides simple feedback to the user. It only fills the amount of space required for the message and does not remove the current activity from the foreground or block interaction. A ```Toast``` will automatically disappear after a short timeout, defined by the duration argument (e.g. `Toast.LENGTH_SHORT` or `Toast.LENGTH_LONG`).

```java
// Make a toast that says "Hello toast!"
Context context = getApplicationContext();
CharSequence text = "Hello toast!";
int duration = Toast.LENGTH_SHORT;

Toast toast = Toast.makeText(context, text, duration);
toast.show();

// ... Or as a single line:
Toast.makeText(getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT).show();
```

Start your morning with ```Toast```! Make 10 different toast messages, and switch between short and long durations. What happens if you put integers rather than strings in your toasts? Will they still work?

# Lecture

According to the Android Docs:

- "All user interface elements in an Android app are built using ```View``` and ```ViewGroup``` objects. A ```View``` is an object that draws something on the screen that the user can interact with. A ```ViewGroup``` is an object that holds other ```View``` (and ```ViewGroup```) objects in order to define the layout of the interface."

- "Android provides a collection of both ```View``` and ```ViewGroup``` subclasses that offer you common input controls (such as buttons and text fields) and various layout models (such as a linear or relative layout)."

[Android Source Documentation](https://developer.android.com/guide/topics/ui/overview.html)

Essentially, ```View``` objects are anything which can be either seen or touched by the user. ```ViewGroups``` are also views, but their jobs are much more tailored to organizing view objects on the screen.

## Defining Views Programatically

There are multiple ways to place views on a screen. One way is by using pure java code in your activities:

```java
package nyc.c4q.surewhynot;

import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                1.0f);

        LinearLayout ll = new LinearLayout(getApplicationContext());
        ll.setLayoutParams(param);
        ll.setOrientation(LinearLayout.VERTICAL);
        
        setContentView(ll);

        TextView tv1 = new TextView(getApplicationContext());
        tv1.setLayoutParams(param);
        tv1.setText("Hello");
        tv1.setGravity(Gravity.CENTER);

        TextView tv2 = new TextView(getApplicationContext());
        tv2.setLayoutParams(param);
        tv2.setText("Goodbye");
        tv2.setGravity(Gravity.CENTER);

        ll.addView(tv1);
        ll.addView(tv2);
    }
}
```

Old-school Java GUI (Graphical User Interface) Framework developers like AWT and Swing use (used? from the 90's, but today? Still?), pure java code to instantiate and layout view objects on the screen. 

However, although this way is possible, it might not be ideal. Doing it this way means errors will appear at runtime, which could have been checked for at compile time. There is another way to place these object on the screen in Android - with XML (eXtensible Markup Language).

## XML Layouts

A **layout** defines the visual structure for a user interface. There are two ways to create Android layouts:

- As an XML resource file. Android provides a straightforward XML vocabulary that corresponds to the View classes and subclasses, such as those for widgets and layouts.
- In Java, by instantiating layout elements at runtime. Your application can create View and ViewGroup objects (and manipulate their properties) programmatically.

While you can use either of these methods to create layouts, there are some advantages to declaring your UI in XML:

- It enables you to better separate the presentation of your application from the code that controls its behavior. 
- You can modify or adapt layouts without having to modify your source code. For example, you can create XML layouts for different screen orientations, different device screen sizes, and different languages. 
- Declaring the layout in XML makes it easier to visualize the structure of your UI, so it's easier to debug problems.

Each XML layout file may only contain one root element. Once you've defined the root element, you can add more layout objects or widgets as child elements within.

When you compile your application, each XML layout file is compiled into a View resource, which is saved in a file called ```R.java```, and may be accessed in your activity. For an activity, you can load the layout resource by calling setContentView() and passing it the reference to your layout resource in the form of: R.layout.layout_file_name. For example:

```java
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.main_layout);
}
```

In our Java-only version above, we had to instantiate a ```LinearLayout``` object first, using many lines of code, then finally use that layout object as a parameter in our ```setContentView()``` method:

```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                1.0f);

        LinearLayout ll = new LinearLayout(getApplicationContext());
        ll.setLayoutParams(param);
        ll.setOrientation(LinearLayout.VERTICAL);
        
        setContentView(ll);
        
        ... 
        
        }
        
        ...
        
```

However, Android Studio helps us create an XML file, and will auto-generate a layout resource file automatically, with all of the necessary parameters for the view:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:app="http://schemas.android.com/apk/res-auto"
              xmlns:tools="http://schemas.android.com/tools"
              android:orientation="vertical"
              android:id="@+id/sure_linearlayout"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              tools:context="nyc.c4q.surewhynot.MainActivity">

</LinearLayout>
```

The only code we had to actually add was the ```android:orientation="vertical"``` line above. This helps to set the orientation of the views placed within this ViewGroup to be stacked on top of each other, rather than next to each other. If we wanted them stacked next to each other from left-to-right, we could have written ```android:orientation="horizontal"``` instead.

For more information on the various different layouts in Android, please check out these links from the Android Docs below:

[API Guides: LinearLayout](https://developer.android.com/guide/topics/ui/layout/linear.html)

[API Guides: RelativeLayout](https://developer.android.com/guide/topics/ui/layout/relative.html)

[API Guides: FrameLayout](https://developer.android.com/reference/android/widget/FrameLayout.html)

[API Guides: ConstraintLayout](https://developer.android.com/reference/android/support/constraint/ConstraintLayout.html)

## Input Controls, and Child View Items

Android has a number of views, or widgets, out-of-the-box - that you can use to display information from the screen, and use information entered by the user:

- *TextView* - for displaying text on the screen
- *ImageView* - for displaying images on the screen
- *Button* - for accepting button clicks from the user
- *ImageButton* - for accepting button clicks from the user, but with a fun picture in the background
- *EditText* - for accepting textual input from the user (using a keyboard)

These are all considered "Child Views", since they all need a "Parent" layout to host them, in order to be seen by the user effectively.

For a full list of all of the basic Input Controls in Android, click on the link below:

[API Guides: Input Controls](https://developer.android.com/guide/topics/ui/controls.html)

## Creating ID's

An efficient way to access views in a layout resource file is by creating unique id's for each of your views in your XML layout files:

```xml
android:id="@+id/some_name_for_your_view"
```

If we wanted to update our code to replace the Java with XML for our views, we could do something like this:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:app="http://schemas.android.com/apk/res-auto"
              xmlns:tools="http://schemas.android.com/tools"
              android:id="@+id/sure_linearlayout"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:orientation="vertical"
              tools:context="nyc.c4q.surewhynot.MainActivity">

    <TextView
        android:id="@+id/first_textview"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:gravity="center"
        android:text="Hello"/>

    <TextView
        android:id="@+id/second_textview"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:gravity="center"
        android:text="Goodbye"/>

</LinearLayout>
```

Now, if we wanted to interact with these TextViews in our Activity at runtime, we could to this:

```java
package nyc.c4q.surewhynot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView tv1 = (TextView) findViewById(R.id.first_textview);
        TextView tv2 = (TextView) findViewById(R.id.second_textview);
        
        tv1.setText("Hola");
        tv2.setText("Adios");

    }
}
```
