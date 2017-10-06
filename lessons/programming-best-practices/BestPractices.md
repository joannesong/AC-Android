# Java Mastery

A wise fool once said. "To know language is to know thought, to understand language is to understand patterns. In patterns we'll find choice, and hopefully peace." -Some dude or whatever.

There is `something` really interesting when we begin to see `organized` logic in java. A program that you can easily follow is the hallmark and the work of a professional programer. As a developer, becoming a professional is achieved through convention and best practices which have evolved over time and continue to do so, following these is an important step to becoming an engineer.

In this lesson, we will follow three main themes: 
* 1: We will encounter and aim to understand proper `pacakge` and `Class` format when creating projects.
* 2: We will explore `Class` and `Method` naming, along with proper formatting.
* 3: We end with an overview of error checking and debugging your way thorugh a program. 

In class we will attempt to to build our java-master program using these tools as a group, and hopefully fight ninja bears along the way.

There are serveral granular concepts to grasp when it comes to organized code: These are suggested best practices which evolve over time.

#### 1: Package and Class format.

A java program is composed of one or many text files which follow a set of rules for syntax to execute arithmetic calculations and commands in the computer.

To create a Java program, you need the jdk which includes the jvm, an environment that allows Java programs to compile and excecute on your machine. Your program is composed of multiple `.Java` files which gets compiled to `.class` files which then run through the `java` command in the terminal.

see: https://en.wikipedia.org/wiki/Java_virtual_machine

As developers working with java, it is important to understand these steps, but thanks to IDEs geared towards proffessionals in the field like IntelliJ and Android Studio; When we create a new program, the intital steps for environment set up are taken care of for us, reducing the amount of boilerplate code we must write, which allows us to build our programs faster.

Below, I have a project called Collections with a package which I defined during project creation which contains classes.

<insert folder_structure img>

The classes themselves can be arranged by package depending on their function and it is something we will see in practice during the lesson.

#### 2: Code formatting.

Having clean code is absolutely paramount to being a good programmer. You want to be able to go back and make any necessary changes in the future without breaking things and making sure that anything you write can be understood by another programmer. This is a skill that comes with practice but there are several conventions that you can follow. The image below is a snapshot of what a formatted class in production can look like:


<insert class_convention img>

However this formatting can be time consuming and so it is usually done as a polishing step once basic functionaility is implemented. When prototyping you generally want to build as quickly as possible and so it's not expected to see this formatting all the time, the exception being take-home-projects for interviews and at your workplace. It has been my experience that good docummented code is hardly frowned-upon when evaluating candidates at the workplace. Even for your own private projects, being able to have a consistent style that you can come back to will make development easier for you overtime.

#### 3: Error Handling and defensive programming

When writing programs there are common errors that we'll encounter, fortunately there are tools that can help us problem solve our way to our desired outcome, these come in the way of "log" statements, the IDE debugger and Exception handling.

The first two tools we'll explore in class. Errors you'll most likely see the most are null pointers and index out of bounds exceptions. Which we can overcome through defensive programming.

Sometimes when working with certain objects like the Date class or when working with the file system we'll need to wrap our code in try catch blocks which you can read about in the following link.

https://en.wikiversity.org/wiki/Learning_Java/Error_handling





