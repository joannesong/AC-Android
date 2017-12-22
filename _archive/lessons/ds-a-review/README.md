- title: Data Structures & Algorithms Review
- tags: big-o, arrays, 2d arrays, lists

# Objectives

- Gain hands-on practice in solving linked list, stack, queue, array and recursion exercises.
- Prepare for the DS+A Quest! 

# Resources
- [Two-Dimensional Arrays](https://processing.org/tutorials/2darray/)
- [Khan Academy - Recursion](https://www.khanacademy.org/computing/computer-science/algorithms/recursive-algorithms/a/recursion)
- [AC 3.3 Linked Lists Lesson](../linked-lists)
- [Big-O Cheat Sheet](http://bigocheatsheet.com/)

# Lecture

The goal of this lesson is to practice and prepare for next Saturday's DS+A Quest. Topics of review for the quest include:

- Iterating through a two-dimensional array.
- Using recursion to solve problems.
- Traversing a linked list to count nodes and/or search for a target value.
- Analyzing Big-O runtime complexities.

## Arrays & 2D Arrays

**1)** Write a method that returns a two-dimensional array representing a random grayscale image using the ░, ▒, and ▓ characters. Your method should accept an `int x` and `int y` as parameters that determine the width and height of the image. 

![greyscale image](https://processing.org/tutorials/2darray/imgs/points.jpg)

**2)** Write a method that returns a two-dimensional array that represents an 8×8 grid, using newline characters to separate lines. At each element there is either a space or a “#” character. The characters should form a chess board. Iterating over the entire 2D array and printing each character should show something like this:

```
     # # # #
    # # # #
     # # # #
    # # # #
     # # # #
    # # # #
     # # # #
    # # # #
```

When you have a method that generates this pattern, define a parameter `int size` so that it works for any size (not just 8), outputting a grid of the given width and height.

**3)** Write a method `int[][] addPairs(int[] array, int k)` that receives an array of numbers and returns all the pairs that sum up to a specified value `k`. What is the worst-case runtime complexity of your solution?

```java
pairSums(new int[]{-3, 4, 2, 1, 6, -1}, 3) // returns {{-3, 6}, {4, -1}, {2, 1}}
pairSums(new int[]{0, 2, 4, 6, 8, 10}, 10) // returns {{0, 10}, {2, 8}, {4, 6}}
```

## Recursion

**1)** How would you implement a program that counts from 1 to 10, printing out each number, without using loops?

**2)** Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.

```java
changeXY("codex") → "codey"
changeXY("xxhixx") → "yyhiyy"
changeXY("xhixhix") → "yhiyhiy"
```

**3)** Write a method `String removeDuplicates(String input)` that receives a string and **RECURSIVELY** removes any **CONSECUTIVE** duplicates.

```java
removeDuplicates("access"); // returns "aces"
removeDuplicates("code"); // returns "code"
removeDuplicates("awwhhhh yeahhhhhhhh"); // returns "awh yeah"
```

**4)** Complete [isEvenWord()](https://dl.dropboxusercontent.com/u/24773027/Screen%20Shot%202015-11-03%20at%2011.40.57%20AM.png).

**5)** Why use recursion at all when you could use loops instead? Check [this Stack Overflow thread](https://stackoverflow.com/questions/3021/what-is-recursion-and-when-should-i-use-it) for an interesting conversation on the topic.

**6)** Where are some places where you see recursion in the real world, or where do you see the possibility of using recursion to help you solve some problem in your daily life?

## Linked Lists, Stacks and Queues

**1)** Summarize the differences and similarities between a:

- Linked List
- Stack
- Queue

**2)** Write a method `listLength(Node list)` that receives the head of a singly linked list and returns the number of nodes in the linked list. What is the worst-case runtime complexity of your algorithm?

```java
Node next;
Object data;

public Node(Object data) { 
	this.value = data;
	this.next = null ;
} 

Node list = new Node("Apple");
list.next = new Node("Orange") 
list.next.next = new Node("Banana");
list.next.next.next = new Node("Carrot");
list.next.next.next.next = new Node("Beet");
 
listLength(list); // returns 5 
``` 

**3)** Write a method called `searchLinkedList(Node head, Object target)` that receives the head of a linked list and target search value, and returns `true` if the target is in the list, or `false` if the target is not in the list. What is the worst-case runtime complexity of your algorithm?

```java
searchLinkedList(list, "Apple"); // returns true
searchLinkedList(list, "Pear"); // returns false
```

**4)** Can you traverse a singly-linked list backwards? What about a circular singly-linked list?

**5)**  Write a `moveToTop` function that takes in a queue and a value, and moves that value to the top of the queue.

## Big-O

**1)** Is it always better to choose an algorithm that runs in `O(n)` over one that runs in `O(n²)`? Why or why not?

**2)** Why do you think that we analyze algorithms from a theoretical standpoint using Big-O notation, instead of just counting runtime in seconds or the like?

**3)** In what ways does this adherence to Big-O (disregarding constants and lower order terms) hinder our ability to speak about algorithms in the real world?

**4)** How might we use runtime complexity analysis to our benefit as programmers before we even write any code?

**5)** Which of the following is **NOT** equivalent to a time complexity of 0(n)?
- O(2n)
- O(n^2)
- O(n/2)
- O(n + m) where m < n

## Tries (advanced)

If you're feeling comfortable with the above DS + A review material, move ahead to the [Trie project](tries.md).

## [Exit Ticket](https://goo.gl/forms/lcp6RDbuOALHLIha2)
