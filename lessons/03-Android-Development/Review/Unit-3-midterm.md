
Title: Review

## Objective

- Summarize what we've learned so far
- Prepare for first test tomorrow
- Answer any questions you have

## Any Questions


## Android Lifecycle

- Practice creating a new Android Studio project.

- Understand what an activity is and the role that it plays in an Android app.

- Gain familiarity with the activity lifecycle.

- Learn how to log output to the console.

- Learn how to save the state of an activity through an orientation change.


## Views

- Explore Views

- Define the difference between ViewGroups and Widgets

- Identify View Vierarchies

- Utilize a number of different Views/ViewGroups


## Intents 

- Distinguish between implicit and explicit intents

- Starting components and services using intents

- Use intents to handle navigation within an Android application

- Use intent extras to transfer information from one activity to another.

- Registering intents via intent filters


## Summary intents

- Intents are used for navigating between multiple activities

- We own explicit intents while the OS manages implicit ones

- Extras are used to pass and retrieve additional information to intents

## Shared Preferences

Lecture link: https://github.com/C4Q/AC-Android/tree/master/lessons/shared-preferences

- Utilize SharedPreferences and Intent Extras to store, recall, and exchange information

## Recycler View

Lecture link: https://github.com/C4Q/AC-Android/blob/master/lessons/recyclerview/review/README.md

- Fellows will create their own data models

- Fellows will implement LinearLayout-based RecyclerView which will display the model's data

## Recycler View: The N Steps

1. Create a Model Class for the Data you want to Display

2. Insert a dependency into your app's build.gradle file

3. Insert RecyclerView markup in the Activity's layout file 

4. Reference the RecyclerView in your Activity's onCreate()

5. Create an ItemView layout (markup for one item in the recycler view)

6. Create a ViewHolder Class to set these ItemView values dynamically

7. Create an Adapter Class to bind data to each ItemView

8. Create/Setup a data source (like a list of your Model class) in Adapter class

9. Implement onBindViewHolder() and getItemCount() on the Adapter class

10. Inflate your ItemView layout into your ViewHolder by implementing `onCreateViewHolder` in Adapter class

11. Assign data to each view in our ViewHolder by implementing `onBind` in Adapter class

12. In the Main acitivity, create/setup data source (list of objects) to pass to the Adapter

13. Pass the data source into an Adapter instance

14. Create a LinearLayoutManager Instance, to set Orientation

15. Set the Adapter to your RecyclerView (the adapter instance you just created)

17. Confirm that your onCreate() method looks good

18. Run it, to make sure it compiles 🤞 🤞

19. Happy Dance 🕺 💃🏽

20. DO IT ALL OVER AGAIN 🙄

## Recycler View: Practice

## Questions
