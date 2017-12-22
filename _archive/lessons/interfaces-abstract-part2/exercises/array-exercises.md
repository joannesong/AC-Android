# Exercises: Arrays + ArrayLists

## Q1. 
Write a method that takes a String as a parameter and uses a while loop to store each letter in a `char[]`. The method should return the array.

```
GRACE HOPPER -> 

['G', 'R', 'A', 'C', 'E', ' ','H', 'O', 'P', 'P', 'E', 'R'];
```

## Q2. 

Given the an array of integers (example below), write:

```
int[] numbers = new int[]{ 2, 4, 4, 10, 10, 401, 101 };
```

a. A method that returns the index of the largest value in the array. 

b. A method that returns the difference between the largest and smallest value in the array. 

## Q3.

Given the following code for a String[] weekDays, use a for-loop and a switch statement to populate the array with the appropriate String values from "Sunday" to "Monday".
```
String[] weekDays = new String[7];
```
## Q4.

Debug the following method, which should swap the int[]'s values at the two given indices.

```
/*
* The following method call should swap the 1st element and 3rd * element of the array:
*
* int[] array = [10, 2, 3, 4, 5];
* swap(array, 0, 2);
*   -> returns [3, 2, 10, 4, 5]
*/
public void swap(int[] arr, int index1, int index2) {

    int temp = arr[index2];

    arr[index2] = arr[index1];

    arr[index1] = index2;

}
```

## Q5. 

Write a method that takes a sorted `int[]` and returns the most commonly-occurring value in the array. If there are multiple values tied as the most commonly-occurring, it should return the one that is greatest.

```
[0, 4, 9, 10, 10, 10, 10, 25, 25, 100] ->

10

[1, 2, 2, 4, 4, 5] ->

4
```

## Q6.

Given an array of strings and an integer, write a method that returns an ArrayList where all the strings of the given length are omitted.

```
wordsWithoutList({"a", "bb", "b", "ccc"}, 1) → {"bb", "ccc"}
wordsWithoutList({"a", "bb", "b", "ccc"}, 3) → {"a", "bb", "b"}
wordsWithoutList({"a", "bb", "b", "ccc"}, 4) → {"a", "bb", "b", "ccc"}
```

## Q7.

Say that a "clump" in an ArrayList is a series of 2 or more adjacent elements of the same value. Write a method that returns the number of clumps in the given ArrayList.

```
countClumps({1, 2, 2, 3, 4, 4}) → 2
countClumps({1, 1, 2, 1, 1}) → 2
countClumps({1, 1, 1, 1, 1}) → 1
```

## Q8.

Write a method that takes a String sentence, breaks it up into an ArrayList of Strings (one word per ArrayList element), and prints out the words in alphabetical order.

## Resources

- https://github.com/C4Q/AC3.3/tree/master/lessons/arrays-arraylists
- [Video - ArrayList: Arrays the easy way](https://www.udemy.com/java-tutorial/#/lecture/161106)
- [Java API: ArrayList](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html)
