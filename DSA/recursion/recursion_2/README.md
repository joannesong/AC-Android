# Title: Recursion Part 2

Tags: java, dsa, recursion

## Objectives
- Identify recursion as a solution to problems
- Identify when recursion is and is not appropriate

## Lecture
Today we will solve several recursive problems.


**Question 1**: Given a number, write a recursive function that will print all valid  arrangements of parenthesis, if the number represents the closed pairs of parenthesis. For example

```
parenthesis(1) = ()

parenthesis(2) = (()), ()()

parenthesis(3) = ()()(), (()()), ((())), (())(), ()(())

parenthesis(4) = ()()()(), (()()()), ((())()), (()(())), (((())))
```

**Question 2**: Write a recursive function that will count the items in a list

**Question 3**: Write a recursive function that will count the vowels in a string

**Question 4**: Count recursively the total number of "abc" and "aba" substrings that appear in the given string.
```
countAbc("abc") → 1
countAbc("abcxxabc") → 2
countAbc("abaxxaba") → 2
```

**Question 5**: We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
```
triangle(0) → 0
triangle(1) → 1
triangle(2) → 3
```

**Question 6**: Given a number, we need to find sum of its digits using recursion.
```
digitSum(12345) = 15
digitSum(45632) = 20
```        

**Question 7**:Given a string that represents a Roman Numeral, write a recursive function that will printthe decimal representation of the number. For example:
```
roman("i")        = 1
roman("iii")      = 3
roman("iv")       = 4
roman("v")        = 5
roman("vi")       = 6
roman("x")        = 10
roman("l")        = 50
roman("c")        = 100
roman("d")        = 500
roman("lii")      = 52
```
