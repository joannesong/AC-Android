# Android's RecyclerView

#### Overview
 The [ReyclerView](https://developer.android.com/training/material/lists-cards.html) is android's answer to dynamic scrolling lists. A long time ago Android developers used framework called a [ListView](https://developer.android.com/guide/topics/ui/layout/listview.html) for scrolling through items, the listview although powerful was clunky and performed rather poorly when it came to handling many items. It was fine if you were to have a small set of items, but even then there was complexity in setting it up. Since then, developers have moved on to the RecyclerView, and because it recycles created items simply rebinding information as needed it performs much better.
 
 Side note: a [ScrollView](https://developer.android.com/reference/android/widget/ScrollView.html) will allow you to scroll through items as well but it is not dynamic which means that you have to add each and every view manually.

#### Resrouces

You can read more about the recyclerview [here](https://guides.codepath.com/android/using-the-recyclerview)

You can watch a high-level overview of the reasonsing behind it [here](https://www.youtube.com/watch?v=-VPM6ICgCk8)

For reference, I have created a sample app with a barebones implementation of a recycler view [here](https://github.com/lighterletter/RecyclerView_Lesson). 

![](https://github.com/lighterletter/RecyclerView_Lesson/blob/master/sample/recyclerview_sample.gif)
#### Afternoon Exercise

Cleate a sample application that uses the recyclerview much like the sample app, remember that a lot of your programming skill will come not only from understanding concepts but also from implementing them. 

Things to try:
* Make your list scroll horizontally
* flesh out your view holders. (add images!)
* add buttons to your view holder and make something cool happen when a button is clicked!

#### Bonus!!!

* Add an OPTIONS MENU button which adds a new item to the RecyclerView
* Add a button to the ViewHolder that opens a new activity and displays the information from the item 
* Add a button to the ViewHolder to share some text from the item via an implicit intent. 
