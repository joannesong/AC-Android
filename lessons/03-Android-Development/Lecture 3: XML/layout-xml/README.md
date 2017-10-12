- title: XML Layouts
- tags: android, xml, layouts, widgets, toasts

# Objectives

- Learn how activity layouts are built in XML.
- Practice positioning child views in both LinearLayout and RelativeLayouts.
- Practice configuring XML attributes for common view widgets.
- Learn how to make a Toast.

# Resources

- [Toasts](https://developer.android.com/guide/topics/ui/notifiers/toasts.html)
- [Layouts](https://developer.android.com/guide/topics/ui/declaring-layout.html)
- [Linear Layout](https://developer.android.com/guide/topics/ui/layout/linear.html)
- [Relative Layout](https://developer.android.com/guide/topics/ui/layout/relative.html)
- [Android API: TextView](https://developer.android.com/reference/android/widget/TextView.html)
- [Android API: EditText](https://developer.android.com/reference/android/widget/EditText.html)
- [Android API: Button](https://developer.android.com/reference/android/widget/Button.html)

# Lecture

## Making Toast :bread:

A Toast is a popup that provides simple feedback to the user. It only fills the amount of space required for the message and does not remove the current activity from the foreground or block interaction. A Toast will automatically disappear after a short timeout, defined by the duration argument (e.g. `Toast.LENGTH_SHORT` or `Toast.LENGTH_LONG`).

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

## [API Guides: LinearLayout](https://developer.android.com/guide/topics/ui/layout/linear.html)

## [API Guides: RelativeLayout](https://developer.android.com/guide/topics/ui/layout/relative.html)

## [Exercises](exercises.md)
