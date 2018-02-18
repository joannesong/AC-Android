
# Title: Final of the Finals Review

## Objective

- Summarize what we've learned so far
- Prepare for FINAL exam!
- Answer any questions you have

## Any Questions

## Linked List
 A **linked list** is a data structure consisting of a group of nodes which together represent a sequence.

 Simplest form: each element (we will call it a **node**) of a list is comprising of two items - the **data** and a **reference** (aka "link") to the next node.

```java
public class Node {
    Node next;
    Object data;
}
```

- The last node has a reference to `null`.
- The entry point into a linked list is called the **head** of the list.
- If the list is empty then the head is a `null` reference.


This function prints contents of linked list starting from head

```java
public void printList()
{
    Node tnode = head;
    while (tnode != null)
    {
        System.out.print(tnode.data+" ");
        tnode = tnode.next;
    }
}
```
## Sorting

** Properties of Sorting algorithms**
- **In-Place**:
    A sort algorithm is said to be an in-place sort if it requires only a constant amount (i.e. O(1)) of extra space during the sorting process
    *Question*: Is selection sort an in-place sorting algorithm? Why or why not?

- **Stable**:
    A sorting algorithm is stable if the relative order of elements with the same key value is preserved by the algorithm
    *Question*: Is selection sort a stable sorting algorithm? Why or why not?


**Selection Sort**

```java
public void selectionSort(int[] arr) {
    for (int n = arr.length; n > 0; n--) {      // O(n) - loop
        // step 1: find largest element
        int largest = 0;                        // O(1)
        for(int i = 0; i < n; i++) {            // O(n) inside O(n) => 0(n^2)
            if (arr[i] > arr[largest]) {        // O(1)
                largest = i;                    // O(1)
            }
        }
        // step 2: swap the elements
        int tmp = arr[largest];                 // O(1)
        arr[largest] = arr[n-1];                // O(1)
        arr[n-1] = tmp;                         // O(1)
    }
}
```

* Is an iterative approach to sorting
* Both best and worst case is O(n2)
* Has a space complexity of O(1)
* It is unstable (but can be made stable)

## Recursion

**Recursion** is when a method calls itself. You need two things to avoid an infinite loop where the method keeps calling itself forever:
1. A _base case_, which returns a value without any further recursive calls (you can have more than one base case sometimes)
2. A _reduction step_, which changes the input before making the next recursive call, so as to make progress toward the base case

Each time a recursive function calls itself, some space in the program's stack is allocated for that function to store its local
variables while it runs.

A program that has an infinite recursive function
calls (no base) will eventually crash with a StackOverFlow exception, because there is no more space on the stack left for the next function call.

Here is an example of a problem that can be solved iteratively, and an alternative recursive solution.

> `sum(int n)` is a function that returns the sum of the `n` integers

```
public int sum(int n){
  int result = 0;
  for (int i = 0; i < n; i++) {
    result += i;
  }
  return result;
}
```

Now inspect the same function written recursively.

```
public int sum(int n){
    if (n == 0) return 0;
    return n + sum(n-1);
}
```


## HashMaps and Lists
