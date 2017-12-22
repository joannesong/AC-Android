- title: Hash Tables
- tags: hash maps, hash code

# Objectives

- Understand what a hash code function is and what it means for something to be hashable
- Articulate an implementation of a hash table / hash map
- Explain why hash tables can’t be sorted

# Resources
- [CodingBat - Java Map Introduction](http://codingbat.com/doc/java-map-introduction.html)
- [CS50 Study - Hash Tables](https://study.cs50.net/hashtables)
- [Differences between HashMap and Hashtable (Java)](https://stackoverflow.com/questions/40471/differences-between-hashmap-and-hashtable)
- [Java hashCode()](https://en.wikipedia.org/wiki/Java_hashCode())
- [Java Docs - Object.hashCode()](https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html)
- [The 3 things you should know about hashCode()](http://eclipsesource.com/blogs/2012/09/04/the-3-things-you-should-know-about-hashcode/)

# Lecture

## Hash Tables

A **hash table** is a data structure used to implement a collection of **key-value pairs**. 

Each key appears **only once** in the collection and can be used as an index much in 
the way an integer is used to index an array. In fact, this gives a hint as to 
part of a common implementation of hashes.

![hash table](https://study.cs50.net/slideshows/1WyRdHGA7wYMYg078wXpv9qAjrELJBokRFRKGnVbnI7Q/img/0.png)

### A hash table by any other name...

A hash table may also be referred to as:

* **dictionary**
* **associative array** 
* **hash map** (see [Differences between HashMap and Hashtable](https://stackoverflow.com/questions/40471/differences-between-hashmap-and-hashtable) for a Java specific explanation of these two class implementations)

A hash table gets its name from the process by which keys are generated, and where they're stored.
Hashing is the process by which a key is converted to an integer. Hash is used both as a verb and
a noun. I *hash* a key to make a *hash* of it.

## Operations

Each of the common data structure operations with Java's corresponding `HashMap` method implementation:

* access / search - [`get(Object key)`](https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html#get(java.lang.Object), [`containsKey(Object key)`](https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html#get(java.lang.Object)
* insertion - [`put(K key, V value)`](https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html#put(K,%20V)
* deletion - [`remove(Object key)`](https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html#remove(java.lang.Object)

***You can't iterate over a hash table in a meaningful order.*** This is different from arrays which 
have deterministic ordering, i.e. the order you put things in is the order they come out.

#### Exercises

Use the internet to research and answer these exercises.

1. For each of the above operations (access, search, insertion, deletion) what is:
    - The average case time-complexity, and why?
    - The worst case time-complexity, and why?
    
2. How does a hash table convert each **key** to its corresponding integer/index?

## Hash Function

A hash table uses a hash function on the key to compute an index (hash) into
an array of buckets or slots, from which the desired value can be
found.

* Ideally, the hash function will assign each key to a unique bucket
(perfect hash function).

* ...but it is possible that two keys will generate an identical hash
  causing both keys to point to the same bucket!

* So... a hash table should assume that **hash collisions** — different
keys that are assigned by the hash function to the same bucket —
will sometimes occur and must be accommodated in some way

A common pattern is to offload the work of hashing to the given object because it knows best how to 
hash itself. In Java this is formalized by overriding `hashCode()` and `equals()`. Looking into the implementation of hash tables will reveal why any type that is to be used as a **key** in a hash table must be able to be hashed and compared to others of its type.


## The `hashCode()` contract

In Java, every object has a method `hashCode()`. An object’s hash code allows algorithms and data structures to put objects into compartments.

In order to make your class work properly with hash maps and other algorithms that rely on hash codes, all overriding `hashCode()` implementations must stick to a simple contract. The contract is explained in the [Java API's Object.hashCode()](https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html) summary. 

The contract can be roughly summarized with this statement:

- Objects that are **equal** must have the **same hash code** within a running process :white_check_mark:

However, the contract **does not require** that:

- Unequal objects must have different hash codes :x:
- Objects with the same hash code must be equal :x:

Also note that:

*"If two objects are equal according to the `equals(Object)` method, then calling the `hashCode` method on each of the two objects must produce the same integer result."*

Meaning whenever you override the implementation of `equals(Object)`, you **must also override** `hashCode()` taking the same fields into account as its equals method. If you fail to do so, you will end up with broken objects. 

Why? By overriding the equals method, you’re declaring some objects as equal to other objects, but the original `hashCode` method treats all objects as different. You will end up with "equal" objects that have different hash codes. For example, calling `contains(Object)` on a HashMap will return `false`, even if the object has been added.

### Hash function implementation


#### Exercises

1. Write a very basic hash function `hash(String key, int tableSize)` that sums the ASCII values of the `String key` argument's characters. Don’t forget to take into account the `int tableSize` of your hash table!

2. Using your IDE or `grepcode.com`, find the implementation of `java.lang.String.equals(Object)`. Discuss with your pair programming partner what the algorithm does and your reasoning for why. What would the algorithm in the overriding implementation of `hashCode()` need to do in order to adhere to Java's `hashCode()` contract? Find the implementation of `java.lang.String.hashCode()` to confirm if your assumptions are correct.

### Hash collisions and chaining

Because there are generally an infinite number of keys mapping to a finite number of hash codes, two distinct keys can map to the same hash code (we call these keys **synonyms**). We call it a **hash collision** when two different objects in the same process have the same hash code. 

A collision in a hash map is nothing critical, it just means that there is more than one object in a single bucket, so a lookup method has to look again to find the right object. A lot of collisions will degrade the performance of a system, but they won’t lead to incorrect results.

One way of dealing with collisions is **linear probing**. With linear probing, if a key hashes to the same index as a previously stored key, it is assigned the next available slot in the table. Once a collision occurs, you’ve significantly increased chances that another collision will occur in the same area. 

This is called **clustering**, and it’s a serious drawback to linear probing. Worst case insertion, deletion, and lookup times have devolved to O(n), as the next available slot could potentially have been the last slot in the table.

Another way of dealing with collisions is something called **separate chaining** where each colliding (key, value) pair is stored in a linked list located at their mapped index (i.e., collision site), meaning the hash table is actually an array of pointers to linked lists.

When a collision occurs, the key can be inserted in constant time at the head of the appropriate linked list.

The worst case lookup time for a hash table that uses separate chaining (assuming a uniform hash function) is therefore O(n/m), where m is the size of the hash table.

Since m is a constant, O(n/m) is theoretically equivalent to O(n). In the real world, however, O(n/m) is a big improvement over O(n)!

A good hash function will maximize this real world improvement.

### Load Factor

Load factor = **n / k**

where **n = number of entries**

and **k = number of buckets**

When the **load factor** of the hash table is too high, the hash table is
not as effective

* O(1) lookup is no longer guaranteed
* In this case, we’ll need a bigger table, iterate over the previous table,
and insert the (key, value) pairs into the new table, using the new hash function
* This takes time… and should ideally occur as little as possible
* O(n) cost is amortized so that it can be ignored

### Analysis

* In a good hash table, the average cost for each lookup
is independent of the number of elements stored in the
table, i.e. O(1)

* Many hash table designs also allow arbitrary insertions
and deletions of key-value pairs, at (amortized) constant
average cost per operation

### Applications

O(1) lookup! Use it for everything!
* more efficient than search trees or any other table
lookup structure
* database indexing
* caches (browser, DNS, ARP caches)
* sets (HashSet)
* Gmail, DropBox attachments

#### Hash function applications

Hash functions have applications in encryption. Often passwords 
are "one way" encrypted, meaning that given a password string, the same derived value (read: hash)
will reliably be generated from the same input. 

But, importantly, the hashed value cannot be
converted back into the original. This makes it possible to test for inputted password matches
without storing passwords.

#### Exercises

*:moneybag: Hint: they all involve hash tables! :moneybag:* 

Complete exercises marked with :pencil: on a whiteboard (no laptops) first!

1. :pencil: Given a list of integers, i.e. `{1, 1, 1, 1, 2, 2, 3,
	3, 5}`, count how many times a given integer
	occurs, e.g. `{1, 4}, {2, 2}, {3, 2}, {5, 1}`

2. :pencil: Given two strings, check if they’re anagrams or not. Two strings are
anagrams if they are written using the same exact letters, ignoring
space, punctuation and capitalization. Each letter should have the
same count in both strings. For example, ‘eleven plus two’ and
‘twelve plus one’ are meaningful anagrams of each other. We've solved this problem in the past using both loops and arrays... this time of course, your solution should 
incorporate a hash map!

3. :pencil: Find the first non-repeated character in a string.

4. :pencil: Remove a specified character from a string.

5. Find the 5 most common words in this lesson plan.

6. Write the song Old Mac Donald using a hash map and two stacks. The order
in which each animal is introduced doesn't matter.

	```
	Old Mac Donald had a farm 
	E-I-E-I-O
	And on that farm he had a cow
	E-I-E-I-O
	With a moo-moo here and a moo-moo there
	Here a moo, there a moo, everywhere a moo-moo
	Old Mac Donald had a farm 
	E-I-E-I-O

	And on that farm he had a pig
	E-I-E-I-O
	With a oink-oink here and a oink-oink there // yeah, "a oink" is ok
	Here a oink, there a oink, everywhere a oink-oink
	Old Mac Donald had a farm 
	E-I-E-I-O

	duck: quack
	sheep: baa
	```

	https://en.wikipedia.org/wiki/List_of_animal_sounds
    
7. A local herd of elephants is trying to create a hash map to keep track of tigers in the area. Two instances of Tiger are considered equal if they have the same `color` and `stripePattern`. There is an additional property `isHungry` that will be ignored in their definition of equality. Help the elephants fix the following `Tiger` class to adhere to Java's hashCode contract.

```java
public class Tiger {
	private String color;
	private String stripePattern;
	private boolean isHungry;
    
    public Tiger(String color, String stripePattern, boolean isHungry) {
		this.color = color;
		this.stripePattern = stripePattern;
		this.isHungry = isHungry;
	}
    
    // getters and setters...
```

It may help to consider this commonly used formula for overriding `hashCode()`, proposed by Joshua Block in *Effective Java*:

```
public int hashCode(){
   int result = 17;
   // For each field in your definition of equality:
   result = 37 * result + ((this.field1 != null) ? this.field1.hashCode() : 0);
   result = 37 * result + ((this.field2 != null) ? this.field2.hashCode() : 0); 
   // ...
   return result;
}
```

#### More Exercises!
    
7. Complete [Java Map](https://www.hackerrank.com/challenges/phone-book) on HackerRank.

8. Complete [Java Hashset](https://www.hackerrank.com/challenges/java-hashset) on HackerRank.

9. Complete [Java SHA-256](https://www.hackerrank.com/challenges/sha-256) on HackerRank.

10. Use the internet to research different hashing methods and techniques for collision resolution. You can use [Visualgo](https://visualgo.net/hashtable) as a tool for this. Try experimenting with different hashing methods and table sizes to inspect how the buckets are filled.


## [Exit Ticket](https://goo.gl/forms/t55VLaOFUDY4dbx63)
