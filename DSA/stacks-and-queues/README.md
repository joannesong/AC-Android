- title: Stacks and Queues
- tags: java stacks queues

#Objectives
- Understand the purpose of a data structures
- Understand and implement a Queue data structure
- Understand and implement a Stack data structure

#Resources
- [Oracle Queue Tutorial](https://docs.oracle.com/javase/tutorial/collections/interfaces/queue.html)
- [Oracle Dequeue Tutorial](https://docs.oracle.com/javase/tutorial/collections/interfaces/deque.html)
- [Wikipedia Stack Description](https://en.wikipedia.org/wiki/Stack_machine)
- [Stack Api](http://docs.oracle.com/javase/6/docs/api/java/util/Stack.html)

#Lecture

## The purpose of data structures
Data structures are important because they are exact descriptions of code that
computers can understand. When communicating with another programmer, it is
important to be as exact as possible with how your program works. Using data
structures, you can be both more precise and concise in your communication.
Data structures are the equivalent of vocabulary among programmers, and the more
you know, the better you will code.

## Queues
A Queue is a First In First Out (FIFO) data structure. It allows you to add
elements to one end of a list, and remove elements from the opposite end.
Queues can be used to provide a list ordered by the time elements have arrived.
If you wanted to program the line for a deli counter, you would use a queue.

> **Exercise** Write a function that reads six numbers from the command line,
and prints the sum of all six afterwards. Use a queue to store each input as its
received, receiving all six inputs before calculating the output.

> **Exercise** Write a function readTwoInts() that reads two integers from the
command line, and returns the sum. Write a second function runTwoInts() that
reads an integer from the command and calls readTwoInts() that many times. Each
return value from readTwoInts() should be stored in a queue. After all calls to
readTwoInts() complete, print the sum of all numbers in the queue.

## Dequeues (pronounced Decks)
A Dequeue is a double ended queue. You can add and remove elements to both sides
of the list. For example, a line at an emergency room is similar to a dequeue.
As patients arrive, they each are attended to a first in first out order.
However, if a patient arrives who needs urgent care, they are immediately
removed from the back of the line and attended to.

> **Exercise** Write a function palindrome detector that accepts a
Dequeue<Integer> as an input. The Dequeue will always have either zero, or an
even number of elements. This function should remove an element from each end of
the dequeue and compare them. If the dequeue has zero elements, the function
should print "No input". If the elements removed from the ends of the dequeue do
not match, then the function should print "Not a palindrome". Otherwise, the
function should output "Palindrome Found".

## Stack
A Stack is a Last In First Out (LIFO) data structure. It allows you to add
elements to one end of a list, and remove elements from that same end. This is
a form of memory organization that grows in one direction. Many embedded memory
chips implement a stack as the primary interface to storing and receiving data.
Stacks are considered the one of the simplest memory forms that can be used to
build a computer.

> **Exercise** Rewrite the palindrome detector, but instead of accepting a
Dequeue<Integer>, it will accept a Stack<Integer>.
