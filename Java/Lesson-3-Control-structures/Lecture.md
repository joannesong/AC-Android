# Control Flow
## If..Else and Conditionals
##### Java Programming, DSA

---

## Objectives

- Understand conditional expressions
- Write an "if" statement
- Write an "if... else" statement
- Write a "while" loop
- Write a "for" loop
- Write a "switch" statement
- Use break and continue keywords

---

## Resources

* [Main Resources Page](https://github.com/C4Q/AC-Android/tree/organization#java)
* [Java Docs on Control Flow](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)
* [Video: If Statements](https://www.youtube.com/watch?v=jjx5mJOcLqM)
* [Video: Switch Statements](https://www.youtube.com/watch?v=oLpUfseieuE)
* [Video: Ternary Operators](https://www.youtube.com/watch?v=igc_jsQIoxY)

---

## Warm up exercise

```
public int average(int a, int b, int c) {
    int average = 0; // update this code to return the average of a,b,c
    return average;
}
```

* How can we make `average` more precise?

---

## Boolean Expressions

* Two boolean types `true` and `false`
* Boolean expression is code that evaluates to `true` or `false`

```java
boolean thisEvaluatesToTrue = 5 > 2;
System.out.println(thisEvaluatesToTrue);
boolean or = true || false;
// System.out.println(or);
boolean and = true && false;
// System.out.println(and);
```
---

## Boolean Operators

Operators that yield a `boolean` result. They ask `true`, `false` questions.

|Operator|Meaning|
|:-:|:--|
|```==```|Equals|
|```!=```|Not Equals|
|```>```|Greater than|
|```<```|Less than|
|```>=```|Greater than or equal to|
|```<=```|Less than or equal to|
|```&&```|Conditional And|
|```||```|Conditional Or|


---

## The Truth Table

All the possible combinations of `p` and `q` using the OR 
operator

|   p  |   q  | p \|\| q |
|:----:|:----:|:------:|
| true | true |  true  |
| true | false|  true  |
| false| true |  true  |
| false| false|  false |

The AND operator

|   p  |   q  | p && q |
|:----:|:----:|:------:|
| true | true |  true  |
| true | false|  false |
| false| true |  false |
| false| false|  false |

* A note on short-circuting

---

### Operator Exercise

* Given `p = true`, what is the result of `!p`
* Given `p = true` and `q = false`, what is the result of `p == !q`
* Given `p = true` and `q = false`, what is the result of `(p && q) || (!q)`

---

## Break

---

## Ternary Operators

* Simplified `if else` statement.
* Ideal for single statement, non-void statements

```
int carMileage = 500;
int minCarAge = carMileage > 300000 ? 15 : 5
```

---

## Questions?

[CodingBat](http://codingbat.com/prob/p159531)

---

## Unit 2: While and For Loops

While Loop
```
initializer;
while (condition) {
    execute_some_commands();
}
```

For Loop
```
for (initializer; condition; increment/interval) {
    execute_some_commmands();
}
```

---

# Warm Up

```
boolean isThirsty = true;
int cup = 1;
while (isThirsty) {
    System.out.println("drinking water");
    ++cup;
    if(cup == 3) {
        isThirsty = false;
    }
}

```

* Convert this to `for` loop.
* Create an infinite `while` loop.
* Create an infinite `for` loop.


---

## For Loops

Learn by doing...

* Printing all numbers within a range
* Printing all multiples of 5 till 50
* Printing all prime numbers till 100

---


## Switch Statement

* Very similar to If...else if...else chain
* `default` case is the equivalent of `else`

```
switch(expression){    
case value1:    
 //code to be executed;    
 break;  //optional  
case value2:    
 //code to be executed;    
 break;  //optional  
......    
    
default:     
 code to be executed if all cases are not matched;    
}
```

---

## Switch Example

```
public class SwitchExample {  
    public static void main(String[] args) {  
        int number=20;  
        switch(number){  
        case 10: System.out.println("10");break;  
        case 20: System.out.println("20");break;  
        case 30: System.out.println("30");break;  
        default:System.out.println("Not in 10, 20 or 30");  
        }  
    }  
}  
```

---

## Exercises

* Solve the cigar problem using switch statement [CodingBat](http://codingbat.com/prob/p159531)
* Can all `if` statements be written as `switch` statements? When do you use which?
* Can all `while` statements be written as `for` statements?
* Can we infinitely nest loops? How about if and switch?
* Write an infinite while and for loop. What could be a possible use case?

---

## More programming using loops and control structures

* Calculate the sum of all even numbers between 0 and 50
* Print the first 10 fibonacci numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
* [CodingBat](http://codingbat.com/prob/p159531)

---

## In-class exercises and mid-day check in

---

# Unit 3: Do-while, For-each, continue keyword
[InstaFeedback](https://goo.gl/forms/eU2n0BrkMdooQ2kx1)

* 

---

## Do while

The Java do-while loop is executed at least once because condition is checked after loop body.

```
public class DoWhileExample {  
    public static void main(String[] args) {  
        int i=1;  
        do{  
            System.out.println(i);  
        i   ++;  
        } while(i<=10);  // note the semi-colon after while.
    }  
} 
```

---

## For each 

* Simplified, yet robust way for iterating over arrays and collections
* No initialization, condition and incrementer

```
public class Main {
   public static void main(String[] args) {
      int[] numbers = { 1,2,3,4};
      for(int i: numbers) {
          System.out.print(i);
      }
   }
}
```
Prints "1234"

---

## Continue keyword

* Skips the current iteration on any loop - for, while, do-while, for-each 

```
public class Main {
   public static void main(String[] args) {
      int[] numbers = { 1,2,3,4};
      for(int i: numbers) {
          if(i == 2) {
              continue;
          }
          System.out.println(i);
      }
   }
}
```
Prints "134"

---

## Exercise

* Write a Java program to input week number(1-7) and print day of week name using switch case. *

Example Input week number(1-7): 2
Output: Tuesday

---

## Exercise

Write a Java program to create menu driven calculator that performs basic arithmetic operations (add, subtract, multiply and divide) using switch case and functions. The calculator should input two numbers and an operator from user. It should perform operation according to the operator entered and must take input in given format.

public static double calc(String operator, int a, int b) {
    // code here
}

// calc('+', 3, 5): 8
// calc('*', 3, 5): 15

---

## HackerRank

[Hacker Rank Java Problems](https://www.hackerrank.com/domains/java/java-introduction)
* If...Else
* Data types and convertions
* Loops

---
