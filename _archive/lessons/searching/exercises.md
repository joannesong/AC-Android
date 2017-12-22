# Exercises

### 1) Complete [the guessing game exercise](https://www.khanacademy.org/computing/computer-science/algorithms/intro-to-algorithms/a/a-guessing-game).

### 2) Complete the `binarySearch` method so that it implements binary search. Remember that binary search can be summarized with the following pseudocode:
1. Let `min = 0` and `max = n-1`.
2. If `max < min`, then stop: `target` is not present in array. Return `-1`.
3. Compute `guess` as the average of `max` and `min`, rounded down (so that it is an integer).
4. If `array[guess]` equals `target`, then stop. You found it! Return `guess`.
5. If the guess was too low, that is, `array[guess] < target`, then set `min = guess + 1`.
6. Otherwise, the guess was too high. Set `max = guess - 1`.
7. Go back to step 2.

```java
/* 
 * Returns either the index of the location in the array,
 * or -1 if the array did not contain the targetValue 
 */
public static int binarySearch(int[] array, target) {
    
    

    return -1;
};
```

### 3) Create a new Android Studio project. Implement your own "guess-the-number" game using your binary search algorithm: 
- A player thinks of a number between 1 and 10000. Your program guesses a number and displays it in a TextView. 
- The player responds by pressing one of two buttons to indicate whether their number is higher or lower. 
- Your program makes a new guess and so on until it guesses the right number. 
- Then extend your program so that the player can pick any positive number, not just ones up to 10000.

### 4) **BONUS** There are two approaches that your binary search algorithm might take: *iterative or recursive*. Determine which approach the algorithm that you wrote is taking. If your algorithm is iterative, try to rewrite it using the recursive approach; if it is recursive, rewrite it using the iterative approach.

### 5) Read up on [the solution](http://datagenetics.com/blog/july22012/index.html) to the [two egg problem](morning-challenge.md).
