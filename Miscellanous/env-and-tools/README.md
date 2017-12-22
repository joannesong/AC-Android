# Environment and Tools

## Objectives
* Install IntelliJ
* Install Android Studio
* Run Java programs on repl.it
* Set up Github account
* The Command Line
* Set up StackOverflow Account
* Set up Slack Account
* Set up Canvas Account
* The App Design Process
* Intro to Pair Programming

## Resources
* [Java coding in browser](https://repl.it/languages/java)
* [Android Studio IDE](https://developer.android.com/studio/install.html)
* [Udacity Android Class](https://www.udacity.com/course/developing-android-apps--ud853)
* [Google Android Tutorials](https://developer.android.com/training/basics/firstapp/index.html)
* [Android Source Code](https://source.android.com/)
* [Github](https://www.github.com)
* [Git Manual](https://git-scm.com/docs/user-manual.html)
* [Git Install](Git.md)
* [StackOverflow](https://stackoverflow.com/)
* [Slack](https://slack.com/downloads)
* [IntelliJ Install](IntelliJ.md)

## Lecture

## IDE Setup
* Install [IntelliJ IDEA](IntelliJ.md)
* Install [Android Studio IDE](https://developer.android.com/studio/install.html)

Navigate to repl.it and run your first Java program. By convention, the first
program outputs Hello World! on the screen.

```java
class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
```

Programming languages are very nuanced. All characters in the program are
passed through a compiler, converted into machine code, and then executed by
the computer. To add human readable text, we can add comments to the code.

```java
class Main { // Define the class name
    public static void main(String[] args) { // The start of all Java programs
        System.out.println("hello world"); // Writes hello world to System.out
    }
}
```

It is always a good idea to add comments to code that is unclear. And in the
beginning of your programming career, all code will look this way. However, as
you master a language, you should strive to write fewer comments by writing code
that is simple to read. Remember programs only have to be written once, but read
many times.

## Set up Github account
Git is a version control program. It runs locally on your machine and tracks
changes in files across time. Github is a website used for sharing code. It
saves your Git repositories online, and can display changes in your files across
time.

## The Command Line
Today most operating systems have a graphical user interface, abbreviated as
GUI. A GUI is the windows, buttons, and interaction that can be done with a
mouse. There are many interactions that can be done on a GUI, but there are far
more that can be accomplished in a command line terminal. Terminals preceded
GUIs for human-computer interaction, and are a powerful tool for the programmer.
It is prudent to learn how to replace most of your interaction with a computer
by using the command line.

## Set up StackOverflow Account
StackOverflow is an online forum for programming questions. It is likely that
any problem you encounter has an answer on this site. However you must never
copy and paste code from an unknown source without first understanding how it
is implemented. If you do so, it could easily introduce a new error in your
code.

## Setup Slack Account
Slack is our less-formal, more immediate messaging/chat app. It should be used for quick short term communication and is not preferred for anything you would want to save long term.

1. To sign up for slack go to this [link](https://join.slack.com/t/c4qbridge-androidnw/shared_invite/MjI1MDQyOTI0ODcxLTE1MDIyMjYxODktNTg4NWIwYTQwMg). 
2. You will be prompted to enter your email address. Enter it and hit the green button.
3. Check your email for the confirmation and click "Confirm Email".
4. Enter your name and choose a user name.
5. Create a password.
6. You should be brought to the web app, ready to go!
7. Optionally download and install desktop client from http://slack.com
8. Optionally install the mobile client.


## Setup Canvas Account

[Canvas](https://canvas.instructure.com/) is our key organizational tool. You'll find a schedule of lessons and assignments in it.

You should have received an email already from Canvas asking you to register before you can participate in the class.

If you haven't already please create a new account and make sure you set your Time Zone to "Eastern Time". You can then accept the invitation.

## The App Design Process
Building an app, whether its for a mobile phone or website, typically follows a
process.

1. Conception
2. Design User Interaction
3. Design Interface
4. Architect and Implement
5. Test
6. Deploy

Whenever you are programming, you should also follow a process. Everyone
develops their own pattern of thinking about code, and what is most comfortable
to them. But when code, you should try to understand how the author framed the
problem. When writing code, be sure to follow a similar process.

1. Understand the problem
2. List the inputs
3. List the outputs
4. List the dependencies
5. Architect several solutions
6. Choose one solution to implement
7. Test
8. Deploy

## Intro to Pair Programming
Pair programming is a term for two people working together on a single computer.
Although one person is typing, both are actively solving the problem at hand.
There should be a dialog between the participants, and both programmers should
have a complete understanding of the architecture, algorithms, and state in
the product. Pair programming produces less errors, helps to spread
knowledge of the code base and teaches you how others think about code along
with the tools they utilize.
