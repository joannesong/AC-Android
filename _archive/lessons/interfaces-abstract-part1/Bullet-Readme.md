# Objects, Interfaces and Abstract Classes

### Review of Mid-day check in & Questions

---

# Objectives

- Practice creating and using objects
- Understand basic Array operations
- Understand inheritance
- Understand the Java Class Hierachy
- Understand Method Overriding

---

# Setup

* Project Name: ObjectsAndInterfaces
* Package name: nyc.c4q
* Add a class `Program` with the `main` method
* Add a static method `print` that serves as shortcut to `System.out.println`

---

# Programming Exercise

* Create a Class MathFunctions with the methods add, substract, divide, mul, average, max, min
* `average` would calculate average value of an array of integers
* `max` returns the big element in the array and `min` the smallest

[In-class exercise]
###### class creation, object instantiation, array operations, critical thinking

---- 

# Programming Exercise

* Add the `default` constructor and another constructor that take an int array as parameter.
* Instead of passing array each time, pass it to the constructor and `save it`. Overload `average`, `min` and `max` to use already given array.

[In-class exercise]
###### multi-constructor, static vs non-static, method overloading

---

# Programming Exercise

* Create a Class ScientificMathFunctions that extends MathFunctions
* Add the function `sumOfSquares` that returns the sum of squares of two numbers

[In-class exercise]
###### inheritance, extends, super, critical thinking

---

## Terminology

- overloading vs overriding
- extends
- implements
- method signature
- instanceof
- super
- public,protected,package-private,private
- implicit vs explicit
- polymorphism
- abstract
- override

---

# Break Time

### Mid-day Checkins

### Tip: Use the *Tips* in Intellij

---

# Inheritance
### subclass and superclass

- Create a Bicycle class with the int fields cadence, gear and speed
- Create a constructor that takes a parameter for each field and sets all three fields
- Create a method `applyBrake(int increment)` that increases the speed by `increment`
- Create a method `speedUp(int decrement)` that reduces the speed by `decrement`

---

Here is the sample code for a possible implementation of a Bicycle class.

```java
public class Bicycle {

    // the Bicycle class has three fields
    public int cadence;
    public int gear;
    public int speed;

    // the Bicycle class has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

}
```

---

- Create a `MountainBike` class that extends Bicycle
- Add an int field `seatHeight`;
- Set seatHeight in the constructor as done above
- Create a setter method for the `seatHeight` field

---

A class declaration for a MountainBike class that is a subclass of Bicycle might look like this:

```java
public class MountainBike extends Bicycle {

    // the MountainBike subclass adds one field
    public int seatHeight;

    // the MountainBike subclass has one constructor
    public MountainBike(int startHeight,
                        int startCadence,
                        int startSpeed,
                        int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }

    // the MountainBike subclass adds one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
}
```

---

### What You Can Do in a Subclass

* The inherited fields and methods can be used just like any other fields (except private ones).
* You can declare new fields in the subclass that are not in the superclass.
* You can write a new method in the subclass that has the same signature as the one in the superclass, thus overriding it. This is tricky for methods and fields with static modifier. 
* You can write a subclass constructor that invokes the constructor of the superclass, either implicitly or by using the keyword super.

---

### The `abstract` Keyword

Defer implementation to subclasses.

Let's modify the `Bicycle` Class to have an abstract method called `getName()`

---

### Should I use the subclass or superclass?

`MountainBike` is descended from `Bicycle` and `Object`. Therefore, a `MountainBike` is a `Bicycle` and is also an `Object`, and it can be used wherever `Bicycle` or `Object` objects are called for.

#### The reverse is not necessarily true: a Bicycle may be a MountainBike, but it isn't necessarily. Similarly, an Object may be a Bicycle or a MountainBike, but it isn't necessarily.

---

### Object as a Superclass

```java
protected Object clone()
      Creates and returns a copy of this object.
public boolean equals(Object obj)
      Indicates whether some other object is "equal to" this one.
protected void finalize() 
      Called by the garbage collector on an object when garbage
      collection determines that there are no more references to the object
public final Class getClass()
      Returns the runtime class of an object.
public int hashCode()
      Returns a hash code value for the object.
public String toString()
      Returns a string representation of the object.
```

---

###

> **Exercise:**  Write a class named Calculator. Give it four methods,
add, subtract, multiply, and divide.

> **Exercise:**  Write an class named ScientificCalculator that extends
Calculator. Give it three methods, sin, cos, tan. 
Overload the ScientificCalculator with a divide method that returns a double.

> **Exercise:**  In two sentences, describe what methods any class that extends
ScientificCalculator would have to implement, and why.

---

# Questions
