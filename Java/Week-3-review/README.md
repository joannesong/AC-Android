- title: Week 3 review
- tags: java hashmaps sets stacks queues

# Objectives
* Review HashMaps
* Review Sets
* Review Stacks
* Review Queues

# Resources
[HashMap Api](https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html)
[Set Api](http://docs.oracle.com/javase/7/docs/api/java/util/Set.html)
[Stack Api](http://docs.oracle.com/javase/7/docs/api/java/util/Stack.html)
[Queue Api](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html)

# Lecture

This lecture will consist of answering api questions regarding the above data
structures, and building programs that utilize two or more of these objects.

## HashMap Questions
> **Question 1**
What is the difference between a HashMap and HashTable?

> **Question 2**
When creating a HashMap and specifying the type using a Map variable, how many
types must you provide?

> **Question 3**
What function returns a list of the HashMap keys? What function returns a list
of the values?

> **Question 4**
When would you use a HashMap?

## Set Questions
> **Question 5**
How many elements in a Set can be null?

> **Question 6**
What is the parent class of Set?

> **Question 7**
What interfaces extend Set?

> **Question 8**
What is the difference between a Set and a List?

## Stack Questions
> **Question 9**
How many interfaces does Stack implement?

> **Question 10**
Draw a picture of a stack after the following code is executed
```java
Stack<Integer> stack = new Stack<>();
stack.push(5);
stack.push(8);
stack.peek();
stack.pop();
stack.push(4);
```
> **Question 11**
What is the difference between a Stack and a Set?

## Queue Questions
> **Question 12**
If I wanted to remove an element from a queue, but not throw an exception if the
queue is empty, what function would I use?
> **Question 13**
If I wanted to get the value of the head of a queue, and throw an exception if
there is no value, what function would I use?

> **Question 14**
What are the interfaces that extend the Queue interface?

## Data Structure programs
> **Question 1**
Using a HashMap, write a function that accepts a char, and returns the name of
a fruit that starts with that letter.

> **Question 2**
Using a HashMap and a Queue, build a function that simulates a donut shop. The
HashMap will use the types of donuts as keys, and will use Queues to hold the
number of donuts available.

Initialize the donut shop hashmap with the following values:
```java
Chocolate -> {Sprinkles, Chips, Swirl}
Cinnamon -> {}
Blueberry -> {Swirl, Frosting }
```
Then write a function that, using a while loop, constantly reads a String from
input. If the string matches a key of the hashmap, print the next donut from
that queue and remove it. If the queue is empty print "No more left";

> **Question 3**
After having built a donut shop, we want to expand into a donut empire. Using a
stack, create a data structure that holds 3 donut shop hashmaps. When a user
requests a donut, each donut shop must now be checked to see if that donut is
available.
