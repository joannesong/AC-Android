- title: MVC Interfacing
- tags: mvc, interface, design-patterns


# Objectives

- Understand how to dissect product requirements into code requirements
- Be able to refactor existing code to better leverage MVC pattern.
= Get exposure to other common Android widgets.



# Lecture

MVC Review

- Model object holds the application's data and "business logic" These are typically designed to model the things our app is concerned with (like a user, a product in a store, a photo on a server, or a television show). A true/false question. Model objects have no knowledge of the user interface, they exist solely to hold and manage data.

All of the model objects in your app make up the model layer.


- View objects
See the "It's just a view" section of Pragmatic Programmer

View objects know how to draw themselves on the screen and how to respond to user input like touches. And has a bunch of configurable view classes, and you can also create custom view classes. The views in your application make up the view layer.


- Controller objects tie the view and model objects together. Controllers are designed to respond to various events triggered by view objects and to manage the flow of data to and from model objects and the view layer.
  - The controller may be an Activity or Fragment.

Notice the model and view objects do not talk to each other directly. Instead the controller is a middleman to both layers.

### Why MVC?
It is just one way for us to solve a common problem: we want to separate code into classes to help us design and understand an application: the end goal is to allow us to think of our app in terms of layers rather than individual class. This further advances thing like testing and code reusability, but as a start, we should be thinking how to design that classes that have a single scope of responsibility and that are able to interact with classes in other layers.

Getting in the habit of thinking like this will avoid some beginner pitfalls like Creating God Objects and complicated spaghetti code.

#### How do we do this in practice?

I usually begin with designing interfaces for these components. With interface design, we're always thinking about what operations must this component be able to support?

Don't be too dogmatic in your attempts at Clean Code. It may take a few attempts at refactoring to get the code structure to look exactly as we desire and functioning how we desire.

Morning Exercise
Think back to our fibonacci Android example. How can we refactor this so that we are further leveraging MVC?


Create a prime factoring app.
[Pair programming] Use a prime sieve to factor large numbers.
With a progress bar, display progress as $current_largest_in_sieve/$number_being_factored.
 Try multiplying together two very large primes so you can actually see the progress bar moving
 (these operations take some time!).


Afternoon Exercise - Reference the following repo: https://github.com/abassawo/DemoLauncher.

Build a simple App Launcher Android app that leverages MVC.

[Exit Ticket]()                        
