- title: Data Structures & Algorithms Final Review
- tags: big-o, arrays, 2d arrays, lists

# Objectives

- Review linked lists, stacks and queues and implement the stack and queue interfaces.
- Review recursion and get hands-on practice solving recursion exercises.

# Resources

- [AC 3.3 Recursion Lesson](../recursion)
- [AC 3.3 Linked Lists Lesson](../linked-lists)
- [AC 3.3 Stacks and Queues Lesson](../stacks-and-queues)
- [AC 3.3 DS+A Review I](../ds-a-review)
- [Big-O Cheat Sheet](http://bigocheatsheet.com/)

# Lecture

The goal of this lesson is to review requested topics for the DS+A Final. The final will take place on Monday, will consist of 12 questions, and will be worth 25% of your final exam grade.

## Recursion

Recursion is a problem solving method where the solution to a problem depends on solutions to smaller instances of the same problem. In Java, we can think of a recursive method as simply a method that calls itself.
 
 Simplest case:
 
 ```java
 private int countIterative(int start, int end) {
     
    for (int i = start; i <= end; i++) {
        start++;
    }
    
    return start;
}
 
 // Now do the same thing, recursively
 private int countRecursive(int start, int end) {
		// Base case, start and end have converged so we're done counting. Return the value that we've reached.
        if(start == end) {
            return start;
        }
		
		// Otherwise, count by one
		start++;
		
		// Now, make the recursive call.
		return countRecursive(start, end);
}
 ```


### Recursion Exercises

1) Write a recursive method `int sum(int n)` that computes and returns the sum of all numbers from 1 to n.

2) Write a recursive method `int findmin(int[] array, int n)` that finds and returns the minimum element in an array, where the array and its size are given as parameters.

3) Write a recursive method `int findSum(int[] array, int size)` that computes and returns the sum of all elements in an array, where the array and its size are given as parameters.

4) Write a recursive method `boolean isPalindrome(String str, int n)` that determines whether an string is a palindrome, where the string and its size are given as parameters.

## Linked Lists

A **linked list** is a data structure consisting of a group of nodes which together represent a sequence.

Simplest form: each element (we will call it a **node**) of a list is comprising of two items - the **data** and a **reference** (aka "link") to the next node. The last node has a reference to `null`. The entry point into a linked list is called the **head** of the list. It should be noted that head is not a separate node, but the reference to the first node. If the list is empty then the head is a `null` reference.

```java
public class Node {
    Node next;
    Object data;
}
```

Unlike an array, a linked list is a dynamic data structure, allocating the needed memory while the program is running. The number of nodes in a list is not fixed and it can grow and shrink on demand. 

One disadvantage of a linked list against an array is that it does not allow direct access to the individual elements. If you want to access a particular item then you have to start at the head and follow the references until you get to that item. Also, they have a tendency to use more memory than an array as the references require extra storage space.

## Traversal

A visit to every node of a data structure is called a **traversal**.

To traverse a singly-linked list, we begin at the first node and follow each next link until we come to the end:

```
// Pseudocode

 current node = first node
 while current node is not null
     (do something with current node's data)
     current node = next node
```


### Linked List Exercises

```java
public class Node {
    Node next;
    Object data;
}
```

1) Given the definition of a `Node` above, implement a linked list data structure with the following interface:

- `void add(int index, Object element)` - inserts `element` at index.
- `Object get(int index)` - returns the data at index without removing its node.
- `Object remove(int index)` - removes the node at index and returns its data.
- `int size()` - return the number of nodes.
- `boolean isEmpty()` - return `true` if no nodes, otherwise `false`.

## Queues

A **queue** is a first in, first out (FIFO) data structure that can be visualized as a waiting line. You add to the back of the line (enqueue), the front of the line is the first item you take off (dequeue).

### Queue Exercises

```java
public class Node {
    Node next;
    Object data;
}
```

1) Given the definition of a `Node` above, implement a queue data structure with the following interface:
- `void enqueue(Object element)` - inserts `element` at the rear of the queue.
- `Object dequeue()` - remove node from front of queue and return its data.
- `int size()` - return the number of nodes.
- `boolean isEmpty()` - return `true` if no nodes, otherwise `false`.
- `Object front()` - return data at the front of the queue without removing its node.

## Stacks

A **stack** is a last in, first out (LIFO) data structure that can be visualized like a stack of papers or pancakes. What you put on top (push) is the first item you take off (pop).

### Stack Exercises

```java
public class Node {
    Node next;
    Object data;
}
```

1) Given the definition of a `Node` above, implement a stack data structure with the following interface:
- `void push(Object element)` - inserts `element` at the top of the stack.
- `Object pop()` - remove node at the top of the stack and return its data.
- `int size()` - return the number of nodes.
- `boolean isEmpty()` - return `true` if no nodes, otherwise `false`.
- `Object top()` - return data at the top of the stack without removing its node.

### More Recursion Exercises

5) Write a recursive method `int gcd(int a, int b)` that finds the greatest common divisor of two numbers. A GCD is the greatest number that divides evenly into the given values (i.e. the GCD of 15 and 20 = 5). You can assume is `a` greater than `b`.
    
6) Complete [isEvenWord](https://dl.dropboxusercontent.com/u/24773027/Screen%20Shot%202015-11-03%20at%2011.40.57%20AM.png).

7) Practice [tracing recursive functions](https://www.cs.umd.edu/class/fall2002/cmsc214/Tutorial/trace-recursion.html).
