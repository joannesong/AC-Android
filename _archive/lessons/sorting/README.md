- title: Sorting Algorithms
- tags: runtime, algorithms, bubble sort, insertion sort, quick sort merge sort

# Objectives
- Gain exposure to, code from scratch and derive the runtimes of: Bubble Sort, Insertion Sort, Quick Sort and Merge Sort.
- Write pseudocode and JUnit tests to verify sorting algorithm implementations.

# Resources
- [Khan Academy](https://www.khanacademy.org/computing/computer-science/algorithms/insertion-sort/a/insertion-sort)
- [Wikipedia](https://en.wikipedia.org/wiki/Insertion_sort)
- [Swift Algorithm Club](https://github.com/raywenderlich/swift-algorithm-club/tree/master/Insertion%20Sort)
- [CS50 - Bubble Sort](https://study.cs50.net/bubble_sort)
- [Quick Sort](https://interactivepython.org/runestone/static/pythonds/SortSearch/TheQuickSort.html)

# Lecture

## What we know so far

```java
List<Integer> list = new ArrayList<Integer>();

list.add(11);
list.add(2);
list.add(7);
list.add(3);

Collections.sort(list);
```

## But how does it actually work?

There are two main types of sorting algorithms.  

- Algorithms that work in O(n * log(n)) time.

- Algorithms that work in O(n<sup>2</sup>) time

*Remember that in computer science, log(n) = log<sub>2</sub>(n)*

We will begin by reviewing two common O(n<sup>2</sup>) algorithms because they are easier to understand.

|Sorting function|Runtime|
|---|---|
|Insertion Sort| O(n<sup>2</sup>)
|Bubble Sort| O(n<sup>2</sup>)
|Merge Sort| O(nlog(n))
|Quicksort | O(nlog(n))


## Bubble Sort

In video form:

[![Bubble Sort](http://img.youtube.com/vi/nBBMunN4_Fs/0.jpg)](https://www.youtube.com/watch?v=nBBMunN4_Fs "Insertion Sort")

What bubble sort does is look at at each pair of numbers.  If they are ordered correctly, we keep them in the same order.  Otherwise, we swap them.  Then, we go back to the start of the list and repeat. We keep doing this until we can run through the array without making any swaps. This algorithm gets its name from the way values eventually "bubble" up to their proper position in the sorted array.

[Bubble Sort Demo](https://www.youtube.com/watch?v=8Kp-8OGwphY)

> Exercise: Write a pseudocode process for how bubble sort would work.

> Exercise: Implement bubble sort in Java.

> Exercise: What is the worst-case runtime of bubble sort? Can you think of any strategies to make it more efficient?

> Exercise: Run your three test methods against your bubble sort algorithm to confirm that your implementation is correct.


## Insertion Sort

Insertion sort is a fairly intuitive algorithm for sorting a list.

Let's see what it looks like:

[![Insertion Sort](http://img.youtube.com/vi/8oJS1BMKE64/0.jpg)](https://www.youtube.com/watch?v=8oJS1BMKE64 "Insertion Sort")

Looks cool!  What does it do?

In plain English, we keep a sorted list on the left and everything else on the right.  We then iterate through the array, and every time we hit an element, we move it to where it fits in the sorted part on the left.

We could also use a new array.  In that case, we will append every element in turn to a new array, then move it to the correct position.

Here's a step by step process for how that would work:

- Create a new array called `sortedArray`
- Iterate through the input array
- For every element:
  - Append that element to `sortedArray`
  - For every index starting from the last index in `sortedArray`:
     
     - Check to see if the value at that index is greater than the one directly to the left.
     - If it is, swap with it.  Otherwise break out of this loop and look at 

[Insertion Sort Demo](https://www.youtube.com/watch?v=DFG-XuyPYUQ)

> Exercise: Implement insertion sort in Java.

> Exercise: What is the worst-case runtime of insertion sort? Can you think of any strategies to make it more efficient?

> Exercise: Write three test methods for your sorting algorithm and run them to confirm that your implementation is correct.

## Merge Sort

Merge sort is a recursive algorithm for sorting that decomposes the large problem of sorting an array into subproblems that are each a step closer to being solved.

Merge Sort performs better than quick sort if the input array is already partially sorted. It works by dividing the input array in two halves, calls itself recursively for the two halves (until each array contains only one element) and then recursively merges each of the two sorted halves.

Algorithm:
- Find the middle point to divide the array into two halves.
- Call mergeSort for first half.
- Call mergeSort for second half.
- Merge the two halves sorted in step 2 and 3.

[Merge Sort](https://www.youtube.com/watch?v=ZRPoEKHXTJg)

[Merge Sort Demo](https://www.youtube.com/watch?v=EeQ8pwjQxTM)

The following diagram shows the complete merge sort process for an example array {38, 27, 43, 3, 9, 82, 10}. If we take a closer look at the diagram, we can see that the array is recursively divided in two halves till the size becomes 1. Once the size becomes 1, the merge processes comes into action and starts merging arrays back till the complete array is merged.

![Merge sort](https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Merge_sort_algorithm_diagram.svg/300px-Merge_sort_algorithm_diagram.svg.png)

> Exercise: Implement merge sort in Java. If you like, you can use the following method stubs + helper to get started:

```java
public class MergeSort {
    
    public static void main(String[] args) {
        int[] array = {108, 42, 3, 12, 19, 22, 200, 16};

        mergeSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

        System.out.println();
    }

    public static void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            // Find the middle point
            int middleIndex = (leftIndex + rightIndex) / 2;

            // Sort first and second halves
            mergeSort(array, leftIndex, middleIndex);
            mergeSort(array, middleIndex + 1, rightIndex);

            // Merge the sorted halves
            merge(array, leftIndex, middleIndex, rightIndex);
        }
    }

    public static void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        // TODO merge the sorted halves!
    }
}
```

> Exercise: What is the worst-case runtime of merge sort? Can you think of any strategies to make it more efficient?

> Exercise: Run your three test methods against your merge sort algorithm to confirm that your implementation is correct.

> Exercise: Use your merge sort implementation to sort each character by ASCII value in the [full text of Moby Dick](https://faculty.washington.edu/stepp/courses/2004autumn/tcss143/lectures/files/2004-11-08/mobydick.txt).

## BONUS: Quick Sort!

Quick sort is a fast sorting algorithm which is widely applied in practice. On average, it has O(n log n) complexity (or at worst O(n2)), making quick sort suitable for sorting big data sets. 

Algorithm:
- Choose a pivot value. We take the value of the middle element as pivot value, but it can be any value in range of sorted values, even if it doesn't present in the array.
- Partition. Divide the array into two groups: a group of elements that are less than the pivot and a group of elements that are greater than the pivot. Values equal to the pivot can stay in any part of the array. (Notice, that array may be divided in non-equal parts).
- Quick sort both parts. Apply the quick sort algorithm recursively to the left and the right parts.

Quick sort  is  typically  very  fast  in  practice,  but  remember  that  it  has  O(n^2)  worst case  running  time,  so  be  sure  to  consider  another  sorting  algorithm,  such  as  merge  sort,  if  you  need  guaranteed  O(n log n)  running  time.

[Quick Sort](https://www.youtube.com/watch?v=8hEyhs3OV1w)

[Quick Sort Demo](https://www.youtube.com/watch?v=aQiWF4E8flQ)

> Exercise: Write a pseudocode process for how quick sort would work.

> Exercise: Implement quick sort in Java.

> Exercise: What is the runtime of quick sort? Can you think of any strategies to make it more efficient?

> Exercise: Run your three test methods against your quick sort algorithm to confirm that your implementation is correct.

## [Exit Ticket](https://goo.gl/forms/KXgXe2dmiSvBCgzq1)
