- title: Android Fragments
- tags: android, activities, lifecycle, fragments

# Objectives

- Practice creating a new Android Studio project.
- Understand what a fragment is and why they are used
- Gain familiarity with the fragment lifecycle.
- Learn how to add several fragments to an activity

# Resources

- [Fragments](https://developer.android.com/guide/components/fragments.html)
- [Activities](https://developer.android.com/guide/components/activities.html)
- [Managing the Activity Lifecycle](https://developer.android.com/training/basics/activity-lifecycle/index.html)

# Lecture

During this lecture, we will work through the steps of building a fragment found here:<br>
[Android Creating A Fragment](https://developer.android.com/training/basics/fragments/index.html).


## Build a Fragment to Display your Profile Page for the Grocery Store Employee handbook
### Build a Profile Page
- Create an Android app with one xml page. Name the xml %firstname_lastname%.xml
- On the xml page add a picture of yourself
- On the xml page add 2 other pictures
- On the xml page add a text view with your name
- On the xml page add a text view with a nick name
- On the xml page add a text view with 4 sentences to be your bio

### Build a Fragment
- Add a fragment and activity to your Profile Page app.
- In the createView function, have the fragment instantiate and return your %firstname_lastname% layout file.
- In the onCreate function, attach onClickListeners to each of your buttons
