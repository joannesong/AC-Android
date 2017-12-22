- title: Recursion
- tags: java, android, recursion

# Objectives
- Identify recursion as a solution to problems
- Identify when recursion is and is not appropriate

# Lecture
Recursion is defined as repeated execution of an instruction set. The obvious
example of this is a function calling itself. A function that calls itself is
said to recurse, or be recursive. A recursive function can not only call itself
however, or the program would never terminate. In reality, each time a function
is called, some space in RAM is allocated for that function to store its local
variables while it runs. A program that has an infinitely recursive function
called will eventually crash with an Out of Memory exception, because there is
no more RAM left for the next function call.

# Thinking in new ways
There are an infinite number of ways to solve practically any programming 
problem. During todays class, we will revisit exercises that are easily solved
using a recursive algorithm. For example, inspect this piece of code that adds 
all the numbers in a list.

```
public int addUp(List<Integer> numbers){
  int result = 0;
  for (Integer i : numbers) {
    result += i;
  }
  return result;
}
```

Now inspect the same function written recursively.

```
public int recursiveAdd(List<Integer> numbers){
    Integer current = numbers.get(0);
    if (numbers.size() == 1) {
        return current;
    }
    List<Integer> restOfList = numbers.subList(1, numbers.size());
    return current + recursiveAdd(restOfList);
}
```

The ability to identify edge cases, and abstract them from the common case will 
be crucial for rewriting procedural algorithms in a recursive fashion.


Example Recursive Problem
```
/*
     Given a number, write a recursive function that will print
     all valid  arrangements of parenthesis, if the number represents
     the closed pairs of parenthesis. For example

     parenthesis(3) should print

      (())(), ()(())
   */
```
