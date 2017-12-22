# Objective

To learn about `HashMap`:

- What is an _associative_ collection?
- How to add keys and values.
- How to look up keys to get values.
- Review networking

# Resources
[Map]()

# Maps

A _map_ is a very useful collection that can be used to associate one object (the key) with another (the value). The key to the Map must be unique, and it will be used to retrieve the value at a later time. Java Map collections can only hold objects, and the Map interface specifies a strict contract about how to put entries into the Map and what types can be added.

Here are some of the operations you'll do with maps
- Put something in the Map
- Get something out of the Map  
- Get a Set of keys to the Map - for iterating over it.


Because [Map] is an interface, you can't instantiate it directly. Java includes some concrete implementations of the Map interface.

Today, we will learn about the HashMap, but first here are some examples of maps:

- For each planet in the solar system, the number of moons
- For each U.S. state, the state capital
- For registered voters, whether each voted in the last election.
- For each student in Access Code, his/her birthday
- For each AC student id, there is a student being represented

For example, I tell you a state, you tell me its capital.  Or, I tell you a planet, you tell me how many moons it has.  You can think of a map as a table with two columns, like so:

| key = Planet | value = # Moons |
|:--|--:|
| Mercury | 0 |
| Venus | 0 |
| Earth | 1 |
| Mars | 2 |
| Jupiter | 67 |
| Saturn | 62 |
| Uranus | 27 |
| Neptune | 14 |

The left column contains _keys_; the right, _values_.  We say it _maps keys to values_, in this case maps planets to numbers of moons.

To look something up in a map, look down the key column until you find the row that matches.  Once you do, read off the value in the column to its right.  If you don't find the entry you need in the key column, for example if you try to look up Pluto, the lookup fails and there is no value.

Some facts about Maps:

- The keys are all the same type.
- The values are all the same type.
- The keys and values don't have to be the same type (though they may be)
- Any key can appear only one time in the map.
- A value may appear more than once in the map.
-  The map can look things up only in one direction: given the key, return the value.  Because a value can appear more than once, it doesn't work the other way: for example, which planet has zero moons?

# Java's HashMap

There are several ways to make a map in Java. Today, we'll use `java.util.HashMap` ([API docs](http://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html)). It implements the `Map` interface, and You'll have to import it like this, or let IntelliJ do it for you.

Recall that with `ArrayList`, you have to tell Java the type of elements in angle brackets.  With `HashMap`, you have to tell Java the types of both the keys and the values.

```java
Map<String, Integer> numberOfMoons = new HashMap<String, Integer>();
```

The two types are the _key type_ and the _value type_, respectively.  In this case, the key type is `String` and the value type is `Integer`.

We now have an **empty** hash map, like a table with no entries.

| key = Planet | value = # Moons |
|:--|--:|

To look up an entry in a map, use the `get(key)` method.  Its argument is always the key type of the map (the first one in angle brackets).  Its return type is the value type of the map (the second one in angle brackets).

```java
Integer num = numberOfMoons.get("Neptune");
```

Our map is empty; it doesn't contain any keys at all.  So, the value is `null`.  But we can add values with the `put(key, value)` method.

```java
numberOfMoons.put("Mercury", 0);
numberOfMoons.put("Venus", 0);
numberOfMoons.put("Earth", 1);
numberOfMoons.put("Mars", 2);
```

After this, the table would look as follows:

| key = Planet | value = # Moons |
|:--|--:|
| Mercury | 0 |
| Venus | 0 |
| Earth | 1 |
| Mars | 2 |

Since it contains keys and values, we can look up a key to obtain a value.

```java
Integer num = numberOfMoons.get("Earth");
System.out.println(num);
```

But any key other than one we've put in already returns null.

```java
System.out.println(numberOfMoons.get("Neptune"));
System.out.println(numberOfMoons.get("Sun"));
System.out.println(numberOfMoons.get("Texas"));
```




# Exercises
[Maps Exercises](exercises/maps-exercises.md)
