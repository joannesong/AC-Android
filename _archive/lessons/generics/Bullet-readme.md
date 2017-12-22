# Generics and Parameterized Types 
#### Tags: generics types and generic methods
 
--- 

# Questions
#### ... from anywhere everywhere?

Watch out for *[In-class exercise]*

---
 
# Objectives 
 
- Review extending abstract classes 
- Master reading types and Generic notation 
- Understand when to use generics 
- Be able to create simple generic functions 
 
--- 
 
# Resources 
 
- [Java Docs](https://docs.oracle.com/javase/tutorial/java/generics/types.html) 
- [Random Code exercises](https://www.cs.utexas.edu/~scottm/cs307/codingSamples.htm) 
 
--- 
 
# What are Generics? 
 
- Generics allow you to write code that works on *any* type. 
- It is *type-blindness* - note: there are several degrees of blindness! 
- Interfaces allowed us to wrap multiple types with similar behavior under an umbrella. 
- Generics are Interfaces on steriod
 
--- 
 
# Quick Refresher on Abstractions 
 
1. The easy `print` function from last time - how do we print more types? 
    - Using function overloads to accomodate each object 
    - Using a very high-level interface (or object) 
    - Add special print for `Food` types 
    - Introduction of vargs 
 
[In-class exercise] 
 
--- 
 
# Without Generics 

- Why did they even create generics in the first place? The All-Encompassing list problem.

``` 
List myIntList = new LinkedList();                  // 1 
myIntList.add(new Integer(0));                      // 2 
Integer x = (Integer) myIntList.iterator().next();  // 3         
``` 
 
- What does this code do? 
- Can I add a `String` to `myIntList`? 
- What are some things wrong with it? 
 
--- 
 
# With Generics 
 
``` 
List<Integer> myIntList = new LinkedList<Integer>(); // 1' 
myIntList.add(new Integer(0)); // 2' 
Integer x = myIntList.iterator().next(); // 3' 
``` 
 
- What does this code do? 
- Can I add a `String` to `myIntList`? 
 
--- 
 
# Generics 
 
- Generics allow us to create a *class* that works for any Object.  
- The syntax: angle brackets and an uppercase letter, e.g. `ArrayList<E>`. 
- `E` is a type parameter and serves as a placeholder for a type to be specified later 
- `?` is the wild-card parameter type: `Collection<?>` ("collection of unknown") 
 
#### Can you think of any examples of generics that you have seen so far? 
 
--- 
 
# The million ways of getting `length` in Java 
 
2. Create a static `len` function to remove the confusion between size(), count(), length() and length 
    - Make it print length of string array and string list 
    - Add print for String: length of string is # of chars in it 
    - For a number, print the number of digits 
    - Overload, interface or something else? 
 
[In-class exercises] 
 
--- 
 
Most times you think you need generics, all you actually need is an interface. 
 
So Why Generics 
------------ 
- Implement generic algorithms. E.g: ??? 
- Better code reusability. E.g: ??? 
 
--- 
 
# Code With Me - A simple list of strings 
 
1. Create a class `StringList` to represent a list of strings (similar to arraylist of integers) 
    - methods add, size, toString, and clear
2. Customize string list above to represent a list of Donuts, call it `DonutsList` 
3. Add a typed constructor with vargs 
 
[In-class exercise] 

---

# Break time / Mid-day checkins
 
--- 
 
# Code With Me - Abstracting over the string type 
 
1. Let's take a closer look at [ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) 
2. Create a `SmartList` that is similar to `StringList` but using type parameters.
    - The only special thing about is just passing values during instantiation 
3. Update the methods in `StringList` to be type-blind 
 
Here is an interface that describes `SmartList` 
``` 
public interface SmartListI <E> { 
    void add(E x); 
    int size(); 
    void clear(); 
    boolean contains(); 
    boolean isEmpty(); 
} 
``` 
 
[In-class exercise] 
 
--- 
 
# Refinements and More Test Cases 
 
1. Create test cases for SmartList in Program 
2. Test it with a `foreach` loop 
3. Print an instance of SmartList and compare to ArrayList 
4. Can we use it with the List interface?
5. Can we re-use the code in ArrayList instead?
 
See [ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) 
 
--- 
 
# Use Cases 
 
Adding common behavior: You do pretty much the same operations regardless of the "thing" at the center of the class. 
 
``` 
static <T> void fromArrayToCollection(T[] a, Collection<T> c) { 
    for (T o : a) { 
        c.add(o); // Correct 
    } 
} 
 
``` 
 
--- 
 
# Exercise

Create a class `Box` that boxes any types and stores the time they were created
 
--- 
 
# Summary 
 
 
 
--- 
 
# Questions