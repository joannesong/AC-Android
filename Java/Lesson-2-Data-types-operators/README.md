# Lesson 2 Unit 1: Variables and Data types
Tags: java programming

# Objectives

- Describe the eight primitive data types, variable assignment rules and naming conventions.
- Use Java to perform basic arithmetic operations.
- Print output to the console.

# Resources

- [Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
- [List of Java keywords (reserved words)](https://en.wikipedia.org/wiki/List_of_Java_keywords)
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)

# Lecture

### Variables & data types

In programming, **variables** is name of *reserved area* allocated in memory. In other words, it is a name of memory location.

A variable's **data type** determines the values it may contain and the operations that may be performed on it. A **primitive data type** is a name for data types that are provided by the language as a basic building block. There are eight primitive data types in Java:

* **boolean** - represents a truth and has only two possible values, `true` or `false`. A boolean can be inverted with the `!` operator. Booleans can also be created by comparing two variables. 

```java
boolean isCar = true;
boolean areWeThereYet = false;
boolean answer = 7 > 3;
```

* **byte** - a small integer between -128 and 127.

* **short** - a small integer between -32,768 and 32,767.

* **int** - an integer between -2<sup>31</sup> and 2<sup>31</sup>-1. In most cases this is the default type used to represent integer values. 

* **long** - an integer  between -2<sup>63</sup> and 2<sup>63</sup>-1.

```java
byte myAge = 28;
short activeCitiBikesInNyc = 6603;
int yearsSinceDinosaurs = 65000000;
long humansOnEarth = 7400000000;
```

* **float** - a real number, single-precision 32-bit floating point. For our uses, **real numbers** are just numbers that can have decimals in them. For example, 2 is an integer but 2.1 is a real number.

* **double** - a real number, double-precision 64-bit floating point. In most cases this is the default type used to represent decimal values. 

```java
float percentOfPizza = 33.3f;
double pi = 3.14159265359d;
```

* **char** - a single [Unicode](http://unicode.org/charts/) character.

```java
char initial = 'R';
char nine = '9';
char newLine = '\n';
```

In addition to these eight, Java also has special support for character strings which allows them to assigned and used like a primitive data type. Wrapping a character string in double quotes will automatically create a new **String** object.

```java
String example = "This is a string";
```

Two strings can be **concatenated** using the ```+``` operator:

```java
String hello = "Hello, " + "world!";
```

[Exercises: Exploring Data Types](exercises.md#data-types)

### Naming & assigning variables

Java is a **strongly-typed** language, meaning variables are of an explicit type when they are assigned. Use `=` to assign a value to a variable.

```java
String myName = "Ramona";

boolean isSkyBlue = true;

char bang = '!';
```

### Variable naming conventions
Java variables are conventionally named in *lowerCamelCase*: the first letter of each word after the first is capitalized. Variable names should use only ASCII letters and digits.

Good variable names are concise and meaningful. A well-selected name will help to convey your intent to subsequent programmers (including yourself!) who are tasked with reading your code.

```java
// Some good variable names:

String favoriteColor;

byte tacoCount;

boolean isNewUser;


// What about these?

double thisVariableIsEqualToTwentyThreePointFive = 23.5d;

boolean LOL;

String HelloWorld;

int int;
```

See the Google Java Style Guide [section on naming conventions](https://google.github.io/styleguide/javaguide.html#s5-naming) for more detailed guidance here.

### Reserved words
A **reserved word** is a word that already has a defined meaning in Java. Because of this, it can't be used to name a variable, method, class or other identifier.

Some example reserved words: `int`, `for`, `if`, `else`, `this`, `new`, `return`, `void`.

You can find a full list of reserved words [here](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html) or [here](https://en.wikipedia.org/wiki/List_of_Java_keywords).

[Exercises: Assigning Variables](exercises.md#assigning)
    
##### Unit2
### Operators

We can use Java to perform basic arithmetic. The order of operations is just like standard arithmetic: parentheses, exponents, multiplication and division, addition and subtraction (PEMDAS).

```java

// Addition
int result = 4 + 5;

// Subtraction
result = result - 1;

// Multiplication
result = result * 2;

// Division
result = result / 2;

result = result + 8;

// Modulo: "%" divides one operand by another and returns the remainder as its result.
result = result % 7;

// You can also combine the arithmetic operators to create compound assignments:

result += 1;

result -= 1;
```

##### Unit 3

The **Unary** operators require only one operand:

```java
int result = 0;
result++;       // increment result by 1

++result;       // alternative syntax to increment result by 1

result--;       // decrement result by 1

--result;       // alternative syntax to decrement result by 1

```

The **Ternary** operator performs a conditional assignment.
```java
String result = 7 > 5 ? "Bigger" : "Smaller";

int age = 74;
String status = age < 50 ? "Young" : "Old";
```


**Be careful when dividing integers!**  In Java, when you divide an integer by an integer, the answer will be an integer rounded towards zero from the real number value.

```java
// Integer division
int result = 7 / 2; // Evaluates to 3
int result = 3 / 4; // Evaluates to 0

// Double division
double result = 7.0/2.0;
```

## More printing + Strings

String is the most commonly used class in Java. It represents a "character string", or sequence of characters.

The full documentation for the String class is here: [Java Docs: Strings](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html).

Let's complete some more exercises to experiment with Strings and printing:


## Summary


| D Type |       use      |
|:------:|:--------------:|
| int    | integers       |
| double | long decimal   |
| float  | short decimal  |
| String | words          |
| boolean| true or false  |
| char   | single letter  |




| symbol |       use      |
|:------:|:--------------:|
|    +   |    Addition    |
|    -   |   Subtraction  |
|    *   | Multiplication |
|    /   |    Division    |
|    %   |     Modulo     |
|   ++   |    Increment   |
|   --   |    Decrement   |

