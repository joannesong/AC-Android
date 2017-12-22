# Exercises: Interfaces + Abstract Classes

## Q1. Comparing Animals

- Create an `Animal` class that includes a **species name** field and implements the `Comparable` interface. Compare two animals by species name, alphabetically.

- Implement `equals()` and `compareTo()` to compare by species name.

- Test your `compareTo()` method on several `Animal` instances by adding them to an ArrayList and calling `sort()`.

- Create the `Domestic` interface. This interface should include getters and setters for a **given name** field, since pets tend to have their own names.

- Create a class for a domestic animal of your choice, perhaps a `DomesticCat`, that both inherits from `Animal` and implements the `Domestic` interface.

- Implement the `compareTo()` function for your domestic animal so that it compares two such animals by their given name instead of their species name. Implement `equals()` to compare by given name.

- Create a constructor for your `Domestic` animal that takes in both the species name and given name.

- Test your `compareTo()` function by creating an `ArrayList<Animal>` and calling `sort()`.

## Q2. Cards

1. Create an abstract class representing a game, which includes the method `getPieces()`.

2. Create a class that extends your `Game` class, `PlayingCards`.

3. Create a class, `Card`, representing a playing card.

4. In your constructor for `PlayingCards`, generate a 52-deck hand of cards. (Do not write 52 lines of code to do this). Decide an appropriate collection to store these in.

5. Implement `getPieces()` which should return your collection of cards. What should be the type signature for `getPieces()` in the abstract class?

## Q3. Interfaces vs. abstract classes?

- List some key differences between interfaces and abstract classes. Why would we use an abstract class over an interface, or vice versa?

## Resources

- https://github.com/C4Q/AC3.3/tree/master/lessons/interfaces-abstract-part1
- https://github.com/C4Q/AC3.3/tree/master/lessons/interfaces-abstract-part2
- https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
- https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html
