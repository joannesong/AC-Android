## Title: Android Layouts
Tags: android, xml, layouts, widgets, toasts

## Objectives

- Learn how activity layouts are built in XML.
- Practice positioning child views in LinearLayout.
- Practice configuring XML attributes for common view widgets.
- Learn how to make a Toast.

## Resources

- [Layouts](https://developer.android.com/guide/topics/ui/declaring-layout.html)
- [Linear Layout](https://developer.android.com/guide/topics/ui/layout/linear.html)
- [Android API: TextView](https://developer.android.com/reference/android/widget/TextView.html)
- [Android API: EditText](https://developer.android.com/reference/android/widget/EditText.html)
- [Android API: Button](https://developer.android.com/reference/android/widget/Button.html)

## XML Layouts

A **layout** defines the visual structure for a user interface. There are two ways to create Android layouts:

1. As an XML resource file. Android provides a straightforward XML vocabulary that corresponds to the View classes and subclasses, such as those for widgets and layouts.
2. In Java, by instantiating layout elements at runtime. Your application can create View and ViewGroup objects (and manipulate their properties) programmatically.

While you can use either of these methods to create layouts, there are some advantages to declaring your UI in XML:
- It enables you to better separate the presentation of your application from the code that controls its behavior. 
- You can modify or adapt layouts without having to modify your source code. For example, you can create XML layouts for different screen orientations, different device screen sizes, and different languages. 
- Declaring the layout in XML makes it easier to visualize the structure of your UI, so it's easier to debug problems.

Each XML layout file may only contain one root element. Once you've defined the root element, you can add more layout objects or widgets as child elements within.

When you compile your application, each XML layout file is compiled into a View resource. For an activity, you can load the layout resource by calling setContentView() and passing it the reference to your layout resource in the form of: R.layout.layout_file_name. For example:

```java
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);
}
```

## Layouts: Views

The basic building block for user interface is a **View** object which is created from the View class and occupies a rectangular area on the screen and is responsible for drawing and event handling.

View is the base class for widgets, which are used to create interactive UI components like buttons, text fields, etc.

The **ViewGroup** is a subclass of **View** and provides invisible container that hold other Views or other ViewGroups and define their layout properties.

More lectures on views coming your way!

In the layout code below, `LinearLayout` is a ViewGroup while `TextView` and `Button` are Views

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:orientation="vertical" >
    <TextView android:id="@+id/text"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="Hello, I am a TextView" />
    <Button android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hello, I am a Button" />
</LinearLayout>
```

## Common Layout Types

- **Linear Layout** 
LinearLayout is a view group that aligns all children in a single direction, vertically or horizontally.

- **Relative Layout** 
RelativeLayout is a view group that displays child views in relative positions.

- **Table Layout** 
TableLayout is a view that groups views into rows and columns.

- **Absolute Layout** 
AbsoluteLayout enables you to specify the exact location of its children.

- **Frame Layout** 
The FrameLayout is a placeholder on screen that you can use to display a single view.

- **List View**
ListView is a view group that displays a list of scrollable items.

- **Grid View**
GridView is a ViewGroup that displays items in a two-dimensional, scrollable grid.

## Intentionally left blank

## Common Layout Types

How many do you remember?
What are some use cases you can think of them?

## Linear Layout

By far the easiest to understand. Just stack all my children one after the other.

Create a linear layout with a TextView, and a Button

## Common Layout Attributes

**android:id** 
This is the ID which uniquely identifies the view.

**android:layout_width** 
This is the width of the layout.

**android:layout_height** 
This is the height of the layout

**android:layout_marginTop**
This is the extra space on the top side of the layout.

**android:layout_marginBottom** 
This is the extra space on the bottom side of the layout.

You can guess **android:layout_marginLeft** and **android:layout_marginRight**

**android:layout_gravity** 
This specifies how child Views are positioned.

**android:layout_weight**  
This specifies how much of the extra space in the layout should be allocated to the View.

**android:layout_x**  
This specifies the x-coordinate of the layout.

**android:layout_y** 
This specifies the y-coordinate of the layout.

**android:layout_width** 
This is the width of the layout.

**android:layout_width** 
This is the width of the layout.

**android:paddingLeft**
This is the left padding filled for the layout.

You can guess **android:paddingRight**, **paddingTop** and **paddingBottom**

## Tweek and Feel

Experiment with these attributes in the notepad app

## Exercises

For each of the following exercises, create a new XML resource file in your `res/layout` directory (e.g. `exercise_one.xml`). You can test each layout by changing the `setContentView(R.layout.exercise_one)` line in your `MainActivity.java` file and running the app.

> **Question 1:**) 

1) Create new XML resource file `exercise_one.xml`. Add a `LinearLayout` as the root element, with orientation set to vertical.

2) Add three `TextViews` as child views to the `LinearLayout`. Give them ids. For all three, set `layout_width` and `layout_height` to `wrap_content` and set the text to `TextView One`, `TextView Two` and `TextView Three` respectively. Set the background color to `#ff0000`, `#ffff00` and `#0000ff` respectively. Run the app and observe the layout.

3) Add 40dp padding to each of the `TextViews`. Run the app and observe the layout.

4) Add 40dp margin to each of the `TextViews`. Run the app and observe the layout.

5) Change the layout gravity on the top `TextView` to top. Change the layout gravity on the middle `TextView` to center. Change the layout gravity on the bottom `TextView` to bottom. Run the app and observe the layout.

6) Remove the layout gravity attributes from the `TextViews`. Change the gravity on the `LinearLayout` to bottom. Run the app and observe the layout.

> **Question 2:**

1) Create new XML resource file `exercise_two.xml`. Add a `LinearLayout` as the root element, with orientation set to horizontal.

2) Add three `Buttons` as child views to the `LinearLayout`. Give them ids. For all three, set `layout_width` to 0dp and `layout_height` to `match_parent`. For all three, set the `layout_weight` to 1. Set the text to `Button One`, `Button Two` and `Button Three` respectively. Set the background colors to [different colors of you choice](http://www.w3schools.com/colors/colors_picker.asp). Run the app and observe the layout.

3) In your activity's Java file, use `findViewById()` to get a reference to each of the buttons. Set click listeners on each of the buttons that display a Toast with the button's text.



