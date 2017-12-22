- title: Android Implementing a Complete App
- tags: android, activities, lifecycle, fragments

# Objectives

- Update the Android Grocery Store with your fragment
- Practice creating a complete Android app from start to finish

# Resources

- [Fragments](https://developer.android.com/guide/components/fragments.html)
- [Activities](https://developer.android.com/guide/components/activities.html)
- [Managing the Activity Lifecycle](https://developer.android.com/training/basics/activity-lifecycle/index.html)

# Lecture

Today we will add our individual fragments to the employee grocery store.
We will then update the views of each store front as a class.

### Add your profile page to the Android Grocery Store
- Update to the most recent Android Grocery Store codebase
- Read the source code in [EmployeeListAdapter](https://github.com/JsjRoboticsClassroom/AndroidGroceryStore/blob/master/app/src/main/java/nyc/c4q/grocerystore/employeeHandbook/EmployeeListAdapter.java). Understand how the
employee description is being used and passed around.
- Read the source code in [EmployeeView](https://github.com/JsjRoboticsClassroom/AndroidGroceryStore/blob/master/app/src/main/java/nyc/c4q/grocerystore/employeeHandbook/EmployeeView.java). Add a function that adds your fragment
to the view specified by R.id.employee_profile. Your function should only run
when your name is passed as the EMPLOYEE_NAME extra.

### Update Store Front View
As a class, we will go through each store front, and make changes to the xml.
We will come up with a design spec for the class, and will apply it each screen.

The design spec will include:

- Sizes for buttons
- Sizes for images
- Font Sizes
- Color Palette
- Text styles

And any other features we want to be consistent among separate teams.
