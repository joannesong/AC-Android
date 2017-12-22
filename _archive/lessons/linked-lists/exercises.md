# Exercises

## Lists

Q1. Implement a linked list data structure with the following interface:
- `void add(int index, Object element)` - inserts `element` at index.
- `void add(Object element)` - appends `element` to the end of the list.
- `Object get(int index)` - returns the item at index without removing it.
- `Object remove(int index)` - removes the item at index and returns it.
- `void set(int index, Object element)` - replaces the item at index in this list with the specified item.
- `int size()` - return the number of items.
- `boolean isEmpty()` - return `true` if no items, otherwise `false`.

Q2. Identify the runtime complexity of each method for your linked list implementation. Does this match with the runtime complexities listed on bigocheatsheet.com?

Q3. Implement a `void delete(Object targetElement)` method that removes all instances of `targetElement` from the
list.

Q4. Add a `Node prev` field to the Node structure and implement a doubly-linked list.

Q5. Write a method `Node reverse(Node list)` that takes a list and returns a copy with the order of the items reversed. The original list should not be modified.

Q6. Write a method `boolean isPalindrome()` that returns `true` if the list is a [palindrome](https://en.wikipedia.org/wiki/Palindrome).

## Stacks & Queues

Q1. Implement a Stack data structure with the following interface:
- `void push(Object element)` - inserts `element` at the top of the stack.
- `Object pop()` - remove item at the top of the stack.
- `int size()` - return the number of items.
- `boolean isEmpty()` - return `true` if no items, otherwise `false`.
- `Object top()` - return item at the top of the stack without removing it.

Q2. Implement a Queue data structure with the following interface:
- `void enqueue(Object element)` - inserts `element` at the rear of the queue.
- `Object dequeue()` - remove item from front of queue.
- `int size()` - return the number of items.
- `boolean isEmpty()` - return `true` if no items, otherwise `false`.
- `Object front()` - return item at the front of the queue without removing it.

Q3. Identify the runtime complexity of each method for your stack and queue implementations. Does this match with the runtime complexities listed on bigocheatsheet.com?
