- title: Navigating with Android Fragments
- tags: android, activities, lifecycle, fragments

# Objectives

- Practice creating a new Android Studio project.
- Understand what a fragment is and why they are used
- Gain familiarity with the fragment lifecycle.
- Learn how to add several fragments to an activity

# Resources

- [Fragments](https://developer.android.com/guide/components/fragments.html)
- [Communicating w/ Fragment](https://developer.android.com/training/basics/fragments/communicating.html)

# Lecture
Pre-work for today's class is to find 4 images of your favorite memes to use for fragments in an Android app.

So far, we already know that fragments represent behavior or a portion of UI in an app.

During this lecture, we will use our knowledge of fragments to build an app that showcases our favorite memes. Our app will use a single activity to host a number of fragments and manage the navigation of these fragments.


## Fragments Exposed

- Fragments can communicate with the activity

Although a Fragment is implemented as an object that's independent from an Activity and can be used inside multiple activities, a given instance of a fragment is directly tied to the activity that contains it.

Specifically, the fragment can access the Activity instance with getActivity() and easily perform tasks such as find a view in the activity layout:

Likewise, your activity can call methods in the fragment by acquiring a reference to the Fragment from FragmentManager, using findFragmentById() or findFragmentByTag(). For example:

```java
ExampleFragment fragment = (ExampleFragment) getFragmentManager().findFragmentById(R.id.example_fragment);
```

- While communication between a fragment and its bound activity is fairly straightforward, a fragment cannot communicate directly with another fragment.

"Often you will want one Fragment to communicate with another, for example to change the content based on a user event. All Fragment-to-Fragment communication is done through the associated Activity. Two Fragments should never communicate directly."

tldr - MemeFragment1 cannot communicate directly with MemeFragment2 without first communicating with its attached activity.



# In-Class Exercise

### Build a Fragment to represent a chooser page
Create an xml layout equipped with buttons for each meme that your app will display. Feel free to use this app as a reference: [Memester](https://github.com/abassawo/Memester)


### Design a fragment for each meme
- Create an xml layout for each meme. Name the xml %fragment_memename%.xml
- On the xml page add an imageview with your desired meme
- On the xml page add a textview with the name of the meme

### Build your Fragments
- Add your fragments to your project as individual Java classes


### Hook up your Chooser fragments
- In your chooser page, Override onViewCreated(), and attach onClickListeners to each of your buttons.

- Clicking meme1 should signal to MainActivity to host the fragment for Meme1



### Independent Research and Discussion 

Fragment Arguments - Every fragment instance can have a Bundle object attached to it. A bundle contains key-value pairs that work like intent extras of an Activity. How can we use this to simplify the architecture of our meme fragments?
