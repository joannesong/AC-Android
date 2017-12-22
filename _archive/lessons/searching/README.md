- title: Searching Algorithms
- tags: runtime, algorithms, binary search

# Objectives
- Review measuring runtime complexity and Big-O notation.
- Gain exposure to common searching algorithms; their use cases and limitations.
- Implement a binary search algorithm in Java.

# Resources
- [Khan Academy: Asymptotic Notation](https://www.khanacademy.org/computing/computer-science/algorithms/asymptotic-notation/a/asymptotic-notation)
- [Khan Academy: Binary Search](https://www.khanacademy.org/computing/computer-science/algorithms/binary-search/a/binary-search)
- [Binary Search (video)](https://www.youtube.com/watch?v=D5SrAga1pno)

# Lecture

## Review: Measuring Performance

**Big O Notation** is a way of measuring the performance of algorithms in order to compare one against another - specifically by how they respond to the number of items (N) that you give them.
 
There are two primary things that you measure with Big O Notation:

- **Time complexity**: the total count of operations an algorithm will perform given a set of items.
- **Space complexity**: the total memory an algorithm will take up while running given a set of items.

We measure these independently from one another because while an algorithm may perform less operations than another, it may also take up way more memory. Depending on what your requirements are, one may be a better choice than the other.

For a problem of size `n`:
- a constant-time method is `O(1)`
- a linear-time method is `O(n)`
- a quadratic-time method is `O(n^2)`

![common runtime complexity](https://github.com/C4Q/AC-DSA/raw/master/Big_O/images/BigOCheatSheet.png)

## Linear Search

A linear search sequentially moves through a list of items, from first to last, looking for a matching item.

The worst case performance scenario for a linear search is that it needs to loop through the entire list of items -- either because the item is the last one, or because the item isn't found. If you have `n` items in your collection, the worst case scenario to find an item is `n` iterations, meaning the runtime of linear search is `O(n)`.

## Binary Search

Binary search is an efficient algorithm for finding an item from a ***sorted*** list of items. It works by repeatedly dividing in half the portion of the list that could contain the item, until you've narrowed down the possible locations to just one.

One of the most common ways to use binary search is to find an item in an array. A binary search algorithm finds an item in a sorted array in `O(log n)` time.

### Pseudocode for binary search

1. Let `min = 0` and `max = n-1`.
2. If `max < min`, then stop: `target` is not present in array. Return `-1`.
3. Compute `guess` as the average of `max` and `min`, rounded down (so that it is an integer).
4. If `array[guess]` equals `target`, then stop. You found it! Return `guess`.
5. If the guess was too low, that is, `array[guess] < target`, then set `min = guess + 1`.
6. Otherwise, the guess was too high. Set `max = guess - 1`.
7. Go back to step 2.

## [Exercises](exercises.md)

## [Exit Ticket](https://goo.gl/forms/g6SF2m9bhSWKIZam2)
