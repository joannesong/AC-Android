# Exercises: Classes


## Q1. Cool Cats

- Create 3 cats named `Garfield`, `Pink Panther`, and `Catwoman`.
- Assign each of them a favorite food (Garfield's favorite food should be `Lasagna`).
- Assign each of them an age.
- Write a method called `isOlder` that takes 2 Cats as parameters and returns whether or not the first Cat is older than the second.

```
ex: // if Garfield is 9 years old and Catwoman is 10 years old
    isOlder(garfield, catwoman) returns false
```

- Write a method called `makeBestFriends` that takes 2 Cats as parameters and sets both of their favorite foods to the same thing.

*Hint: this method does not return anything!*

- Write a method called `makeKitten` that takes 2 Cats as parameters and returns a new Cat with a name that is the combination of the 2 parent Cats' names. The age of the new Cat should be `0`.

```
ex: makeKitten(garfield, catwoman) returns a Cat named "GarfieldCatwoman" with age 0
```

- Write a method called `adoption` that takes 1 Cat and 1 Person as a parameters and sets the Cat's owner to be the Person.

```
ex: Person jon = new Person('Jon');
    adoption(garfield, jon); // Jon is now Garfield's owner!
```

*Hint: this method does not return anything!*

- If the Cat's name is `Catwoman`, don't set the owner, but instead print: "Catwoman will never be anyone's pet!"

- Write a method called `isFree` that checks whether or not a Cat has an owner.

```
ex: isFree(garfield) returns false
```

- Write a method called `isSibling` that checks whether or not 2 Cats have the same owner.

## Q2. Bank Account

##### Create two classes: BankAccount and Patron
- A `BankAccount` has a balance.
- A `Patron` has a name, an account, and his/her “pocket”.

##### Create a program that creates objects of these types and defines some interactions. For now, our constraints will be:
- A `Patron` can only interact with one `BankAccount` ( 1 <=> 1 ).
- A `BankAccount` can interact with many `Patron` ( 1 <=> many ).
- We will deal with dollars only, no cents.

##### Some suggested “interactions”:
- A `BankAccount` should provide methods that allow withdrawals and deposits.
- A `Patron` can get from and put money in the `BankAccount`.
- Both should be able to show their current balance.

##### Extra credit:
- Make it so a `Patron` can interact with multiple accounts.
- Prevent the possibility of a `Patron` performing an over-withdrawal.
- Prevent the possibility of depositing more than the `Patron` currently has in their pocket.


## Q3. Voting System

Create Java classes to represent each of the following: 

- `ElectionManager`: conducts an election, controls start of voting, displays election results.
- `Election`: contains information about the election, maintains a list of contenders
- `Contender`: represents details about a contender. What is the contender's name? How many votes has he received?

Write a program to simulate an election. Create a class called `VotingSimulator`. In the `main()` method, you are required to do the following:

- Create an `Election` object, and give the `Election` a name.
- Create a few `Contender` objects. Add these to the `Election` object. Make sure that the contender names are distinct!
- Create an `ElectionManager` object. Ask it to manage the `Election` object created above.
- Ask the `ElectionManager` to `initiatePolling()``
- While polling, users should be able to 'vote' for their preferred `Contender`. 
- When polling is finished, ask the `ElectionManager` to `displayResults()`

## Resources

* [Video - Classes and Objects](https://www.udemy.com/java-tutorial/#/lecture/137826)
* [Unit 0 - Classes pt. I](https://github.com/accesscode-2-1/unit-0/blob/master/lessons/week-2/2015-03-17_classes-part-1.md)
* [Unit 0 - Classes pt. II](https://github.com/accesscode-2-1/unit-0/blob/master/lessons/week-2/2015-03-19_classes-part-2.md)
* [Unit 0 - Classes pt. III](https://github.com/accesscode-2-1/unit-0/blob/master/lessons/week-2/2015-03-21_classes-part-3.md)
* [Java Tutorial - Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html)
* [Java Tutorial - Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/objects.html)
