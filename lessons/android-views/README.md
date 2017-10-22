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

# Lecture

According to the Android Docs:

- "All user interface elements in an Android app are built using ```View``` and ```ViewGroup``` objects. A ```View``` is an object that draws something on the screen that the user can interact with. A ```ViewGroup``` is an object that holds other ```View``` (and ```ViewGroup```) objects in order to define the layout of the interface."

- "Android provides a collection of both ```View``` and ```ViewGroup``` subclasses that offer you common input controls (such as buttons and text fields) and various layout models (such as a linear or relative layout)."

[Android Source Documentation](https://developer.android.com/guide/topics/ui/overview.html)

Essentially, ```View``` objects are anything which can be either seen or touched by the user. ```ViewGroups``` are also views, but their jobs are much more tailored to organizing view objects on the screen.
