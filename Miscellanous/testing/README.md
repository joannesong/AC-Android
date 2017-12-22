- title: Java Testing
- tags: test, unit tests, JUnit

# Objectives
- Understand how programs are verified
- Write a JUnit Test

# Resources
- [Setup JUnit in IntelliJ](https://www.jetbrains.com/help/idea/2016.2/testing.html)
- [Example TDD Article](https://technologyconversations.com/2013/12/20/test-driven-development-tdd-example-walkthrough/)

# Testing
Software engineers have a lot of responsibilities. They must understand the requirements of a program as specified by a non technical supervisor, translate these requirements into logical rules a computer can follow, and verify that they don't break previously working functionality. Testing is one way to verify the operation of a program, and is expected the more level engineer you are.

When software engineers talk about testing, they are typically referring to automated testing. Automated testing is done by writing code to check that a condition exists, then running the test code against the application you want to verify working. Manual testing would describe an individual checking each of the conditions that test code verifies. Automated testing is many times superior than manual testing, since it is reliable, reproducible, and can give immediate feedback to the programmer.

# Types of Tests
There are several types of tests. They describe when the application under test is running and how much information the tester knows about the system.

## Static Testing / Static Analysis
Testing that occurs after compiling the code, but before executing. This form of tests checks for conditions that do not change at runtime. For example in the following code:

```java
View aView;

public void updateDisplay(String textToSet) {
  aView.setText(textToSet);  // Android Studio gives a warning here
}
```

Android Studio will give a warning on the setText line, warning that aView may not have been initialized. These kind of checks do not need a running application or any runtime data to execute.

## White Box Testing
White box testing describes a methodology where the test code knows about the internal workings of the application under test. White box testing verifies not only that an application produces a correct answer, but also that it follows the correct sequence of steps to achieve the answer. For example, say you have the following program:

```java
  public void add(int num1, int num2){
    return num1 + num2 + add(1, 2) - add(1,2);
  }
```

The above add function works correctly, however it unnecessarily calls add twice per run. White box testing would detect this error, whereas black box testing would not.

## Black Box Testing
Black box testing describes testing an application, and only caring about the inputs and outputs. In black box testing, the application under test is treated as a 'black box' and hence the inner workings of it are a mystery. One can only provide inputs to a black box, and inspect the output.

## Unit Testing
Unit tests are tests that exercise a single piece of functionality in an application. The point of a unit test is to verify that a single feature works. They are supposed to be as small as possible, and should exercise as little code in the application as possible.

## Integration Testing
Integration testing are tests that verify individual parts of an application work together. Integration testing is concerned with the communication that occurs between parts of a program.

# Software Development in Production
Testing is an integral part of the software development lifecycle. Today, most business are adopting Continuous Integration, which is a workflow that roughly proceeds as follows:

- Developer writes new code and merges into codebase
- Testing server detects codebase change and runs tests
- Testing server detects passing / failing of tests and notifies developers.
- If code base passes all tests, a new application is built for distribution. 

# Writing tests
Today we will be writing Java code and running tests against them. We will follow a development methodology known as TDD or Test Driven Development to design an application and write tests against it verifying functionality.


https://github.com/JsjRoboticsClassroom/JUnitExample
