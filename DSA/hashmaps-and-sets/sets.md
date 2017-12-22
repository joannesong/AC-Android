# Objectives

To learn about `Set`:
- What is a `Set`, i.e. how it differs from say `List`.
- How to add and remove values.
- How to use `keySet`.

# Resources

- [documentation](http://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html)

# Sets

> *Definition:* A *set* is a collection structure that by definition contains unique elements — that is, no duplicates. Whereas a List can contain the same object hundreds of times, a Set can only contain a given instance once. A Java Set collection can only hold objects, and it defines a strict contract about how it behaves.

Common Set Operations:

- Put something in the Set.
- Get something out of the Set
- Ask the Set for its size

What's an example of a set? An alphabet is a set:

```
a b c d e f g ...
```

Or here is some Hiragana:

```
あ い う え お
```

# Set vs List

How is a set different from a list?

| | List | Set |
|---|---|---|
| Unique | No | Yes |
| Ordered | Yes | Depends |
| Indexable | Yes | No |

HashMap's `keyset()` function returns a collection of unique keys in the Map.

On occasion, you might find yourself with a reference to a Map, and you want to walk over its entire set of contents. In this case, you need a Set of the keys to the Map:

```Java
Set<String> keys = mapOfIntegers.keySet();
for (String key : keys) {
  Integer  value = mapOfIntegers.get(key);
  System.out.println(key + " has a value of " + value);
}
```

The distinguishing features of the Set interface is that it guarantees uniqueness among its elements, but doesn't care about the order of the elements.

- Every set guarantees uniqueness of its elements. Consider the following code:

```java
Set<Integer> setOfIntegers = new HashSet<Integer>();
setOfIntegers.add(Integer.valueOf(10));
setOfIntegers.add(Integer.valueOf(11));
setOfIntegers.add(Integer.valueOf(10));
for (Integer i : setOfIntegers) {
    System.out.println("Integer value is: " + i);
}
```

After this code is run, we might expect that the Set would have three elements in it, but it only has two because the `Integer` object containing the value 10 is added only once:

# Using a Set implementations

There are a few way ways to make a set in Java. Today, we'll be using 'HashSet'
You import it like this:

```java
import java.util.HashSet;
```

let's start with an empty `HashSet`. Call it `odd`.

```java
Set<Integer> odd = new HashSet<Integer>();
```

#### add

You add objects to a set using `add`:

```java
odd.add(1);
odd.add(3);
odd.add(57);
```

> **Exercise:** Your `odd` set is empty. Add some odd numbers!

#### for each

You can iterate over a set using a `for each` loop:

```java
for (Integer num : odds) {
}
```

> **Exercise:** Create a new `HashSet` called `even` with only even numbers. Use a `for each` loop to add all the numbers in `odd` to `even`.

#### remove

You remove an object by calling `remove`:

```java
odd.remove(3);
```

> **Exercise:** Undo what you just did: remove all the odd numbers from `even`.

#### addAll, removeAll

These are two useful methods. They add every element from one set into another, retaining uniqueness. Here's `addAll`:

```java
// odd = [1,3,5]
// even = [2,4,6]
odd.addAll(even); // [1,2,3,4,6,7]
```

Here's `removeAll`:

```java
// nums1 = [1,3,5]
// nums2 = [1,2,4]
nums1.removeAll(nums2); // [2,4]
```
> **Exercise:** Redo the previous exercises, this time using `addAll` and `removeAll`.

#### contains, size, isEmpty

Sets also have our standard methods: `contains`, `size`, and `isEmpty`.

```java
odd.contains(1); // true
```

#### Cloning a set

An easy way to clone a set is to just pass the set you want to copy into the constructor:


```java
Set<Integer> odd2 = new HashSet<Integer>(odd);
Set<Integer> odd3 = new HashSet<Integer>(odd);
System.out.println(odd2 == odd2);
System.out.println(odd2 == odd3);
System.out.println(odd2.equals(odd3));
```
