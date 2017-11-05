# RecyclerView Review: By The Recipe

## Objectives
* Fellows will review list concepts learned previously
* Fellows will create their own data models
* Fellows will implement LinearLayout-based RecyclerView which will display the model's data  

## Resources
* []()
* []()
* []()

# Lecture

To quote an applicable movie reference:

**Colette:** I know the Gusteau style cold. In every dish, Chef Gusteau always has something unexpected. I will show you. I memorize all his recipe.

**Linguini:** (writing in notebook) Always do something unexpected.

**Colette:** No. Follow the recipe.

**Linguini:** But you just said that...

**Colette:** (interrupts) No-no-no-no. It was *his* job to be unexpected. It is *our* job to...

**Colette, Linguini:** (together, as Linguini rewrites the advice) ... follow the recipe.

**-- Ratatouille, 2007**

## Practice, then Improvise

As with any skill, it's important to figure out the bare minimum for what is necessary to gain this skill.

The famous 18th century catholic polyglot, Cardinal Giuseppe Mezzofanti, spoke 30-plus languages fluently, and was familiar with upwards of 42 languages. He did this by taking the *Pater Noster* prayer, and painstakingly translated it into every new language he wanted to learn, to break down the individual steps that made each language unique.

Elon Musk, the co-founder of PayPal, and current CEO of both SpaceX and Tesla, referred to this technique as **first principles** - he is quoted as once saying "you boil things down to the most fundamental truths... and then reason up from there."

The same can be said for learning to code, especially views like Android's RecyclerView. We will break down the RecyclerView into simple, atomic, elemental steps - then, as you grow as developers, you'll be able to modify these steps to best fit your needs (make things clickable, move to other Activities, add pictures), and eventually read the source code, to make incredible things. So, let's begin:

### 1. Create a Model Class for the Data you want to Display

To separate concerns effectively, we should create a package called **model** (all lowercase) within our project just for our data models - or what we ant our data to look like for use.

Next, we'll make a basic data class to store inside of our new package - a class for fun movies. It should have:

* Field variables for the title, director, and debut year
* Public Constructor to set the fields
* Getters for each instance field

```java
package nyc.c4q.recyclerviewexample.model;

public class Movie {
    String title;
    String director;
    String year;

    public Movie(String title, String director, String year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }
    public String getTitle() {
        return title;
    }
    public String getDirector() {
        return director;
    }
    public String getYear() {
        return year;
    }
}
```
