In-class Assignment

1) Maps are useful for representing key - value relationship of objects. Implement the following method, which takes as inputs: a starting integer, and ending integer. It returns a map that maps Strings to Integers, where the key is the String representation of the integer and the value is the Integer value.
EX: `createMapOfIntegers(0, 4);` would return a Map with the following Key, Value pairs

| key (String) | value (Integer) |
|:--|--:|
| "0" | 0 |
| "1"| 1 |
| "2" | 2 |
| "3" | 3 |
| "4 | 4 |


```java
public Map<String, Integer> createMapOfIntegers(int start, int end){

}
```

An IP address is a unique numerical label assigned to each computer in a network of computers. Create a Java class that will store a series of ip addresses.

To find your own ip address, you can use a HTTP Get request on the following endpoint url: "https://api.ipify.org?format=json"

You can even [google](https://www.google.com/#q=ip+address) it or use the terminal to find your ip address.
```
curl https://api.ipify.org?format=json
```

2a) Use a HashSet to store your ip address, and ask neighboring programmers for their ip address to add to the set.

2b) Iterate through your set to print every saved ip address.


3a) Use an associative collection to remember the different ip addresses. For your Key, Value pairs, the Key shall be the person's name, and the Value is their ip address.

3b) Iterate through your collection's keyset to print the person's name and their stored ip address.






Please work through these exercises, completing as many as you can in class.  

1. **Finish moons:** Finish the HashMap of number of moons for each planet.

2. **Moons as method:** Convert this to a _method_ that _returns_ this hashmap.  It should look like this:

  ```java
  public static HashMap<String, Integer> getNumberOfMoons() {
      // Write code here!
  }
  ```


3. **Moons overload:** Create an _overload_ for this method that takes a planet name as an argument and returns the specific number of moons.  Be careful how you handle an argument that is not the name of a planet.

  ```java
  public static int getNumberOfMoons(String planet) {
      // Write code here!
  }
  ```

4. **Is a planet:** One nice bonus of having this HashMap is that you can check whether a String is the name of a planet by checking whether that string is a key in the HashMap.  Write a method that does this:

  ```java
  public static boolean isPlanet(String name) {
      // Write code here!
    }
```

Test your method on a few real and fake planet names.

5. **State capitals:** Copy the [Capitals.java file](exercises/Capitals.java) into your project. It includes a method `getCapitals()` that returns a hashmap from state names to capitals.  In the `main()` method, write a program that prompts the user for a state name.  If the user enters a state name, print out,


  ```
  The capital of (state) is (capital).
  ```

  Otherwise, print out,

  ```
  (name) is not a state!
  ```

  Make sure you test your program on correct and incorrect state names.

6. **Map of word lengths:** Write a method that takes an array list of strings as a parameter, and creates and returns a hash map whose keys are the strings from the array and whose values are the lengths of these strings.

  ```java
  public static HashMap<String, Integer> getLengths(ArrayList<String> strings) {
    // Write code here!
  }
  ```

  For example, if you call it with an array containing "hello" and "goodbye", you'll get back a hash map with two keys: "hello" associated with the value 5, and "goodbye" associated with the value 7.

  Test it with code similar to this.

  ```java

  ArrayList<String> words = new ArrayList<String>();
  words.add("banana");
  words.add("pineapple");
  words.add("cantaloupe");

  HashMap<String, Integer> lengths = getLengths(words);
  System.out.println(lengths.get("banana"));      // should print 6
  System.out.println(lengths.get("cantaloupe"));  // should print 10
  System.out.println(lengths.get("broccoli"));    // should print null
  ```


7. **(Bonus) Two lists make a map:**  Another way to represent a mapping is with the key and value columns in the tables

shown above, using one `ArrayList` for the keys and one `ArrayList` for the columns.  

  For example, to represent the number of moons for each planet, the keys will be a `ArrayList<String>` containing Mercury, Venus, Earth, Mars, _etc._ and the values will be a `ArrayList<Integer>` containing 0, 0, 1, 2, _etc._  To look up the value for a key, first find the index of the key in the keys list, and then extract the corresponding index from the values list.

  The lesson project [`ListMap`](exercises/ListMap.java) contains a class named `ListMap`, which sets this up for you.  There are three methods for you to implement: one to put a key and value into the "map", one to look up a key, and one to remove a key and value.  The `main()` method contains tests: once you have implemented the other three methods correctly, all the tests should print "true"!

  Note: While this is a correct way to implement maps in Java, the reason we don't usually do it this way is because it is inefficient once there are many keys and values in the map.
