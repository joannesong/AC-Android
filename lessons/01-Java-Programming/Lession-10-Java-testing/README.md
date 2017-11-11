
Title: Testing using JUnit

## Objective

* The purpose of software tests
* Testing terminology
* Using JUnit 4
* Mocking

- 

## Resources

[JUnit Homepage](http://www.junit.org/)

[JUnit 5 user guide](http://junit.org/junit5/docs/current/user-guide/)

[Unit Testing Guide by Vogella](http://www.vogella.com/tutorials/JUnit/article.html)


## What are software tests?
A software test is a piece of software, which executes another piece of software. It validates if that code results in the expected state (state testing) or executes the expected sequence of events (behavior testing).

## Why are software tests helpful?
Software unit tests help the developer to verify that the logic of a piece of the program is correct.

Running tests automatically helps to identify software regressions introduced by changes in the source code. Having a high test coverage of your code allows you to continue developing features without having to perform lots of manual tests.

## Testing terminology

#### Code (or application) under test
The code which is tested is typically called the code under test. If you are testing an application, this is called the application under test.

#### Test fixture
A test fixture is a fixed state in code which is tested used as input for a test. Another way to describe this is a test precondition.

For example, a test fixture might be a a fixed string, which is used as input for a method. The test would validate if the method behaves correctly with this input.

#### Unit tests and unit testing
A unit test is a piece of code written by a developer that exercises a specific functionality in the code to be tested and asserts a certain behavior or state.

The percentage of code which is tested by unit tests is typically called **test coverage**.

A unit test targets a small unit of code, e.g., a method or a class. External dependencies should be removed from unit tests, e.g., by replacing the dependency with a test implementation or a (mock) object created by a test framework.

Unit tests are not suitable for testing complex user interface or component interaction. For this, you should develop integration tests.

#### Integration tests
An integration test aims to test the behavior of a component or the integration between a set of components. The term functional test is sometimes used as synonym for integration test. Integration tests check that the whole system works as intended, therefore they are reducing the need for intensive manual tests.

These kinds of tests allow you to translate your user stories into a test suite. The test would resemble an expected user interaction with the application.

#### Performance tests
Performance tests are used to benchmark software components repeatedly. Their purpose is to ensure that the code under test runs fast enough even if it’s under high load.


## Where should the test be located?
Typical, unit tests are created in a separate project or separate source folder to keep the test code separate from the real code. The standard convention from the Maven and Gradle build tools is to use:

src/main/java - for Java classes

**src/test/java** - for test classes

## Which part of the software should be tested?
What should be tested is a highly controversial topic. Some developers believe every statement in your code should be tested.

In any case you should write software tests for the critical and complex parts of your application. If you introduce new features a solid test suite also protects you against regression in existing code.

In general it it safe to ignore trivial code. For example, it is typical useless to write tests for getter and setter methods which simply assign values to fields. Writing tests for these statements is time consuming and pointless, as you would be testing the Java virtual machine. The JVM itself already has test cases for this. If you are developing end user applications you are safe to assume that a field assignment works in Java.

If you start developing tests for an existing code base without any tests, it is good practice to start writing tests for code in which most of the errors happened in the past. This way you can focus on the critical parts of your application.

## Using JUnit
JUnit is a test framework which uses annotations to identify methods that specify a test. JUnit is an open source project hosted at Github.

### How to define a test in JUnit?
A JUnit test is a method contained in a class which is only used for testing. This is called a Test class. To define that a certain method is a test method, annotate it with the @Test annotation.

This method executes the code under test. You use an assert method, provided by JUnit or another assert framework, to check an expected result versus the actual result. These method calls are typically called asserts or assert statements.

You should provide meaningful messages in assert statements. That makes it easier for the user to identify and fix the problem. This is especially true if someone looks at the problem, who did not write the code under test or the test code.

## Example JUnit test
The following code shows a JUnit test using the JUnit 5 version. This test assumes that the MyClass class exists and has a multiply(int, int) method.

```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyTests {

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        MyClass tester = new MyClass(); // MyClass is tested

        // assert statements
        assertEquals(0, tester.multiply(10, 0), "10 x 0 must be 0");
        assertEquals(0, tester.multiply(0, 10), "0 x 10 must be 0");
        assertEquals(0, tester.multiply(0, 0), "0 x 0 must be 0");
    }
}
```

## JUnit naming conventions
There are several potential naming conventions for JUnit tests. A widely-used solution for classes is to use the "Test" suffix at the end of test classes names.

As a general rule, a test name should explain what the test does. If that is done correctly, reading the actual implementation can be avoided.

One possible convention is to use the "should" in the test method name. For example, "ordersShouldBeCreated" or "menuShouldGetActive". This gives a hint what should happen if the test method is executed.

Another approach is to use "Given[ExplainYourInput]When[WhatIsDone]Then[ExpectedResult]" for the display name of the test method.



## Test execution order
JUnit assumes that all test methods can be executed in an arbitrary order. Well-written test code should not assume any order, i.e., tests should not depend on other tests.

As of JUnit 4.11 the default is to use a deterministic, but not predictable, order for the execution of the tests.

## Defining test methods
JUnit uses annotations to mark methods as test methods and to configure them. The following table gives an overview of the most important annotations in JUnit for the 4.x and 5.x versions. All these annotations can be used on methods.

## Common JUnit Annotations

**@Test**: Identifies a method as a test method.

**@Before**: Executed before each test. It is used to prepare the test environment (e.g., read input data, initialize the class).

**@After**: Executed after each test. It is used to cleanup the test environment (e.g., delete temporary data, restore defaults). It can also save memory by cleaning up expensive memory structures.

**@BeforeClass**: Executed once, before the start of all tests. It is used to perform time intensive activities, for example, to connect to a database. Methods marked with this annotation need to be defined as static to work with JUnit.

**@AfterClass**: Executed once, after all tests have been finished. It is used to perform clean-up activities, for example, to disconnect from a database. Methods annotated with this annotation need to be defined as static to work with JUnit.

**@Test (expected = Exception.class)**
Fails if the method does not throw the named exception.

**@Test(timeout=100)**
Fails if the method takes longer than 100 milliseconds.

## Assert statements
JUnit provides static methods to test for certain conditions via the Assert class. These assert statements typically start with assert. They allow you to specify the error message, the expected and the actual result. An assertion method compares the actual value returned by a test to the expected value. It throws an AssertionException if the comparison fails.

The following table gives an overview of these methods. Parameters in [] brackets are optional and of type String.

## Summary


## Exercises
