- title: Generics
- tags: generics, parameterized types

# Objectives

- Inspect, analyze, and understand how the Android framework leverages generics to support code reuse.
- Write code that uses generic types to increase flexibility and reusability.

# Resources

- [Generics Lecture](/generics)
- [Java Generics Trail](http://docs.oracle.com/javase/tutorial/java/generics/index.html)

# Lecture

Today, we'll explore generics as they are applied in the Android framework. Visit [generics](/generics) for a refresher from previous units.

TLDR - Why generics?

Generics allow for code reuse, and makes uses of Java's compile-time type safety.

## Vocabulary

Generics : A feature in Java's type system allowing for “a type or method to operate on objects of various types while providing compile-time type safety.”

A prime example of this is The Java collections framework  

You are leveraging generics every time you declare a collection with a specified type.

EX:

```List<Foo> fooList; ```

```Set<Integer> primeNumbers;```

Where else have we seen generics in the past?



  ```
  public class IconicAdapter extends RecyclerView.Adapter<RowHolder> {


  @Override
  public RowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return(new RowHolder(getLayoutInflater() .inflate(R.layout.row, parent, false)));
  }

  @Override
  public void onBindViewHolder(RowHolder holder, int position) {  
    holder.bindModel(items[position]);
  }

  @Override
  public int getItemCount() {
    return(items.length);
  }

 }
 ```


[Generics Exercise](generics_exercise_a.md)

[Exit Ticket](https://docs.google.com/a/c4q.nyc/forms/d/1GKtumVacEZZjqbKCirDKOAYSASNrlH0aW5NXHi6r58M/edit)
