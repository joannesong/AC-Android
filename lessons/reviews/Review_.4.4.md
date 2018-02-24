# Coding Party!

### **Intro** 
This will be a review day covering various topics.

* 10-12: Overview of Java : Methods and classes structures- From control to complex structures: ie arrays-to lists and maps.Patterns: singleton and listener.
* 12-1: 
* 1-2: lunch
* 2-3: Android: Manifest, Activities, shared prefs 
* 3-4: Fragments and their transactions
* 4-5: Recycler view / Image performance  
* 5-6: Networking: tasks and retrofit. 

topics: best practices, json modeling, images, maybe fragments overview. Async tasks. 


### Overview: 

The Java languge is composed of `classes`, and `interfaces`. A class has three main components. Below, they are listed from the highest complexity to the lowest. 
* `Classes`: These are files that encapsule a concept such as a car, or a user
```java
class Avengers {

}
```
* `Methods`: These are structures that live inside classes, they define behavioral logic for a class such a steering a car or having a user do jumpingjacks depending on the context.
```java 
class Avengers {
    public void assemble(){ // <-- This is a method
        //This is a comment. Inside this method is where the avengers would assemble.
    }
}
```
* `Fields`: These are attributes for said class such as a paint color, favorite book or and entire outfit. 
```java
class Avengers {
    private List<String> assembledAvengers; // This is a field, because it is a global field(as in, not within a method), it is visible to all methods in this class.
    
    public void assemble(){
        String avengerOne = "spidermeng" // local field, also called a variable, it's only visible to this method because it's declared here.
    }
}
```

***note***: A *declaration* is where we define the `Type` of an opject we're using and we give it a name, in the example above this would be `String avengerOne`. Where as an *assignment* is where we give a variable or field a value following the `=` sign, ie `"spidermeng"`

##### Control structures. 

Control structures are blocks of logic used within methods. such as `"if-else" statements`, different kinds of `loops`, `switch cases` and `try-catch` blocks. These are used to control the output of your program.

##### Inheritance:

Java employs two other different file types within the language, that of interfaces and abstract classes. An `interface` defines shared behavior among classes but no implementation, where as an `abstract class` can define behavior if need be. 

In order to construct complex programs we need to work with different levels of abstraction which is why we have inheritance, in Java, inheritance is the idea of abstracting away concepts to modularize the codebase with the aim of making things easier to read and reason about. To this end we have `Abstract classes` and `interfaces` the idea being that we can connect similar concepts in terms of code. With a class you would `extend` another class, whether it's abstract or not, and with an interface you would `implement` it. You can only extend one class per class. This is called single inheritance.

The reason you would have an abstract class would be to implement something like `dog` which defines some size and behavior reuirements like barking. A class that extends dog would inherit this and implement specific behavior such as a low-pitched bark for a larger dog.

An interface can be more nuances as it is used in varying architecture patterns, the idea being that if you implement an interface in your class you MUST override and implement the methods declared in the interface. This is useful for when you have shared behavior between classes or to implement callbacks(also called the listener pattern).

### Patterns:

In short, Design patterns are proven ways to architect a specific outcome. We'll only touch on two today, but there are many. Do you want an object that keeps it's state througout the lifetime of your application? Make it a `singleon`. Do you need to let one class know when something happens in another, maybe pass in some information? This is a callback, use the `listener` pattern. The onclick listeners in android are a perfect example of this.

###### `Singleton`

The singleton is when you create a single instance of a class in your application, this mean that it'll live and keep its state as long as your application lives. 

It looks like this:

```java
class SingleClass {
    
    private SingleClass instance; // We use an instance of the class to mantain state.

    private SingleClass{
        //private constructor so that other classes can't create an instance of this class.
    }
    
    public static SingleClass getInstance(){
        if(instance == null){
            instance = new SingleClass(); // this will get called only once the first time this method is called
        }
        return instance; // always return the same instance
    }
}
```

This patten is useful in cases where you need only one instance of an object, for example a list that you will be updating throuhgout your codebase. 

###### `Listener`

It's possible to create your own callbacks in java, we use an interface for this. This is called the listener pattern, and it's implemented like so. 

```java
public interface CustomListener {
    void callBackMethod(String call);
}
```

An instance of this interface will be the object we use to receive the notice that the method has been called.

This means that we could use the listener by passing it to the constructor of some object we might need as such:

```java
public class ListeningClass {
    ...
    public void someMethod(){
        CustomClass anonListener = new CustomClass(new CustomListener() {
            @Override
            public void callBackMethod(String call){
                // Do whatever you need to do with the string passed in. 
            }
        });
    }
}
```

It is possible to implement this listener directly in your class as such:

```java
public class ListeningClass implements CustomListener {
    ...
    public void someMethod(){
        CustomClass anonListener = new CustomClass(this);
    }
    
     @Override
     public void callBackMethod(String call) {
         // Do whatever you need to do with the string passed in. 
    }
}
```
By passing `this` as a parameter to the CustomClass we notify it that the method that is overriden in the ListeningClass will be the one which will be triggered when the listener is called.

Below is how we would call this listener in the CustomClass:
```java
public class CustomClass {
    public CustomClass(CustomListener listener){
        listener.callBackMethod("Passing a string to the listener");
    }
}
```

Immediately when this class is constructed we pass in a string that will be passed on to the method implemented in the ListeningClass. That method will be added to the call stack and the logic within will be executed. 

### Break

### Android: Manifest, Activities, shared prefs:

Basic android components. 

* `Manifest` This is the entry point of your application, you define services, permissions and activities here including wich activity gets launched first. Whenever you open up a foreign project this is a great starting point to look to first in order to follow the code.
* `Activities` These are the context hubs that hold refecences to your UI and logic based on their lifecycle.
* `Shared Prefs` With this we can save primitive values onto hardisk to be retrieved even after device reboot. 

### Fragments and their transactions

A fragment is composed of a layout file and a java class that go hand in hand much like an activity. The idea being that you can inflate a fragment as a modular subcomponent of an activity by replacing a layout within the layout of your activity with the fragment itself. We'll go over this in class.

### Recycler view / Image performance

* you can go over previous lessons on how to build an RV the idea here is to talk about how loading bitmaps can be made efficient using libraries like picasso or glide so that we can avoid out of memory errors. 

### Networking: tasks and retrofit.

We really only need you to understand how to make simple get request to consume JSON once this is done you can learn more advance stuff at the need arises. You can look through the [lessons](https://github.com/C4Q/AC-Android/tree/master/lessons) for anything specific.