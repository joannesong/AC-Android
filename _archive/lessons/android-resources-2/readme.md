- title: Android Resources 2
- tags: resources, internationalization,

# Objectives

- Practice storing external resources in xml
- Retrieve external resources like strings, arrays, and drawables in Java code

# Resources

- [Spinner Class](https://developer.android.com/guide/topics/ui/controls/spinner.html)
- [ArrayAdapters](https://developer.android.com/reference/android/widget/ArrayAdapter.html)

# Lecture

We can think of the resources directory of an Android app as containing static bits of information outside the java source code. Some examples of things we may store in the res/ directory include externalized strings, drawables, layouts, dimens, and style. With the exception of drawable images, you will be able to edit these resources directly in xml using Android studio.

```xml
<resources>
    <string name="app_name">Android Grocery Store</string>
</resources>
```   
External resources may be generally referenced in Java code by using the R keyword which stands for resource. The following java code for example, programmatically changes an imageview's background.


```java
imageView = (ImageView) findViewById(R.layout.activity_main);
imageView.setImageResource(R.drawable.marshmallow);
```





 NB: In this example, R.drawable.marshmallow is actually an integer type serving as a reference to the marshmallow image and not the image itself.

## Other Resources

We can also use the res/ directory to store information about booleans, color, and layouts for Android menu's. Here is an example of an xml resource that represents boolean values.


## Storing booleans in an xml file.

```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <bool name="screen_small">true</bool>
    <bool name="adjust_view_bounds">true</bool>
</resources>
```

To retrieve the boolean value in Java code, we can do the following:

```java
Resources res = getResources();
boolean screenIsSmall = res.getBoolean(R.bool.screen_small);
```

We can also reference resource properties in other xml files. Here's an xml snippet referencing an external bool resource.

```xml
<ImageView
    android:layout_height="fill_parent"
    android:layout_width="fill_parent"
    android:src="@drawable/logo"
    android:adjustViewBounds="@bool/adjust_view_bounds"/>
```



## Some thoughts on Resources
- External resources are distinct from Java source code because they are in a different format (xml)
- Also distinct because we can have multiple definitions of a resource to be used in different circumstances. (think: internationalization and localization)



## Mob-Programming Activity

- Store the 12 months of the year as strings in your res/values/strings.xml file.

- In activity_main, define a vertical linear layout with buttons for each month. For now, we just want to print a Log statement when the user clicks each button and present a Toast notifying us which button was selected.

We can also use resources to represent String arrays and Integer arrays. This code snippet shows an xml file containing an array of the most recent Android flavors.

```xml
<resources>
    <string-array
        name="android-flavors">
        <item>@string/nougat</item>
        <item>@string/marshmallow</item>
        <item>@string/lollipop</item>
        <item>@string/kitkat</item>
        <item>@string/jellybean</item>
    </string-array>
</resources>
```


- Modify your resource layer to store your months data as a string-array, and retrieve this array in java code.



## Exercise 2

- Using images from the internet, we are going to build a Birthday Card app that allows a user to cycle through different birthday card images.

Start with finding some birthday card images from the internet to add to your drawable directory, and replacing your linear layout of buttons with a spinner view and an imageview. We will visit the spinner soon, but for now let's make this app more dynamic. Clicking the image should change the imageview's content to the next image in your drawable folder.



**  Adapters are a way to provide data to a view and create subviews for each item in the data set. Think about your facebook news feed or a Netflix gallery of movies. They are content that come from a data source and are represented in a consistent way perhaps in a grid or list.

In Android, adapter views are views whose children are determined by an adapter. Examples include ListView, GridView, and Spinner.

We will use the [array adapter](https://developer.android.com/reference/android/widget/ArrayAdapter.html) class to populate our spinner dropdown menu with the necessary content. We will need to

1) instantiate our spinner in Java code
2) Instantiate an ArrayAdapter with the array of months.
3) Call `setAdapter()` on the spinner view to populate its child views
4) Use an OnItemSelectedListener to determine which item was selected.

```java
// Retrieving array of months from xml
String[] months = getResources().getStringArray(R.array.string_array_months);

/*Instantiating a new ArrayAdapter and supplying the following parameters:
1) the current context (MainActivity.this)

2) a layout containing a textview for rendering each subview of the spinner

3) The array of months or data set*/
ArrayAdapter adapter = new ArrayAdapter(this, R.layout.text_layout, months);

// Sets the adapter for the spinner providing the data and look for the spinner widget.
spinner.setAdapter(adapter);
```

### Individual exercises

- Add a button to your MainActivity that navigates the user to another activity with a listview of language choices to get the birthday greeting in.

- The common greetings should be stored in the appropriate res subdirectory.
