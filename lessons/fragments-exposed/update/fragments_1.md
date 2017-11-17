# Android Fragments  

#### Overview
A lot of people usually have trouble understanding what a fragment is and why we use it. In short, A fragment is a modular UI view with it's own lifecycle. What does that mean? Read on to find out. 

Think of an activity as a hub, which contains the state and context of your current view which you attach using `setContentView()` A fragment in itself would generally replace a widget view that you declare in your layout xml (Usually a FrameLayout). The idea being that if at some point you need to change the state of your application you can do so by swapping out your fragment with another. Another use would be to have multiple fragments at different sections of your activity, each doing its own thing as the need arises. 

There are two ways to embed fragments in an activity, statically and dynamically. Developers rarely need to embed fragments statically and it is generally not used. In this class we will focus on building them dynamically. 

Understanding how to build them dynamically will make the static implementation easier to understand. 

#### Resources

I have created a [project](https://github.com/lighterletter/FragmentLesson) for you to see how fragments are built. Take a look through the code and comments and try to make sense of it. In this lesson we will review how the application was built and implement some fragments in class. 

[Android Docs](https://developer.android.com/guide/components/fragments.html)

[Google training](https://developer.android.com/training/basics/fragments/index.html)

[Code Path Tutorial](https://guides.codepath.com/android/creating-and-using-fragments)

![](https://github.com/lighterletter/FragmentLesson/blob/master/sample/fragment_gif_demo.gif)

#### Afternoon Exercise

```
Create a similar project where the click of a button swaps out two fragments.
The design of the application is up to you!
```
Hint: you can use a single button as a switch using a boolean.

Things to try:
* pass information from one fragment to the next!
* Implement a recyclerview in one of your fragments. (or both!)
* Play around with transitions!!
* Easter eggs!
