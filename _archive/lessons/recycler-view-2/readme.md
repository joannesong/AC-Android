- title: Recycler Views in Practice
- tags: json, fragments, recycler view, adapter, view holder

# Objectives
- Practice using RecyclerViews to display varying sources of data.
- Build an app that parses a JSON object of movies into a list of POJO's, and displays this collection or list in a recycler view.

# Resources
- [JSONObject](https://developer.android.com/reference/org/json/JSONObject.html)
- [Pojo](http://www.martinfowler.com/bliki/POJO.html)
- [Json 2 Pojo](http://www.jsonschema2pojo.org/)
- [Creating Lists](https://developer.android.com/training/material/lists-cards.html)

# Lecture

As Android developers, we might find ourselves needing to build an app that fetches data from some source, parses that data into substantial Java objects that we can then display on the screen to a user.


RecyclerView is a Java object that displays a list of child View objects, one for each item in your list of items. The child views can be as simple or as complex as we define them.

| [Rainbow](https://github.com/abassawo/RainbowRecycler)  | [TvShows](#)  |
|---|---|
|  ![RainbowRecycler](http://i.imgur.com/mPiExwX.png?3) |  ![Gmail](https://github.com/pedrovgs/EffectiveAndroidUI/blob/master/art/screenshot2.png?raw=true) |    


Both examples work similarly in that they take data from source and parse it so that it can be displayed in an Android app. For rainbows, the dataset is simply an array of colors within the project's Res directory. For the more complex Tv Shows app, the data source may be a collection of a plain old java object (Pojo) like [The TvShow Class](https://github.com/pedrovgs/EffectiveAndroidUI/blob/master/app/src/main/java/com/github/pedrovgs/effectiveandroidui/domain/tvshow/TvShow.java)

We will modify the RainbowRecycler codebase together t give its recycler view more functionality, and will use JSON to transfer information about more complex data objects...like Movies;


![Recycler View](https://developer.android.com/training/material/images/RecyclerView.png)

Part of the difficulty of learning about recycler views is that there are a number of different objects that interact with the recycler view class to get it up and running displaying some data.


### What's a RecyclerView and why do we need it?

The recycler view provides an efficient way of displaying large amounts of data by reusing or recycler views.

A layout manager positions item views inside a RecyclerView and determines when to reuse item views that are no longer visible to the user. To reuse (or recycle) a view, a layout manager may ask the adapter to replace the contents of the view with a different element from the dataset. Recycling views in this manner improves performance by avoiding the creation of unnecessary views or performing expensive findViewById() lookups.

The RecyclerView's sole responsibility is to recycle views and display them on the screen. It does this with the help of two other classes: An Adapter subclass and a ViewHolder subclass. The LayoutManager object that is associated with the RecyclerView will determine if the recyclerView displays its children in a linear manner or grid-like fashion.

TLDR - Standard way to represent a list of items in an Android app. Works by coordinating with other objects (LayoutManager, Adapter, and ViewHolder) to recycle views in an efficient manner.

### ViewHolder - Why do I need to hold on to a view?

Like the name implies, it holds on to a View.

Example of a ViewHolder subclass
```java
public class MemeRow extends RecyclerView.ViewHolder{
    public ImageView memeThumbNail;
    public TextView memeTitle;

    public MemeRow(View view){
      super(view);
      memeThumbNail = (ImageView) view.findViewById(R.id.thumbnail);
      memeTitle = (TextView) view.findViewById(R.id.meme_title_field);
    }
}
```

This ViewHolder subclass that we have defined will be helpful in populating our recycler view because our recycler view will request that instances of these object be created. If I were creating a recycler view of memes, each ViewHolder object that is as a result created would maintain a reference to my view of a meme row.




### Adapters
The RecyclerView will actually request for the adapter to

- provide the source of data
- create the necessary ViewHolder objects for each item in the dataset
- bind the ViewHolder object to the data at any given position.




### Using the RecyclerView

You will need to import the RecyclerView class from a specific Google support library befoe you can use it. You can add a dependency to your project by navigating to File --> Project Structure---> Dependencies or by modifying your app-level build.gradle file.

- After importing, we need to add the recyclerview to your activity or fragment layout in xml, and wire it up in Java code by instantiating, setting a layout manager to it, and providing an adapter.

  - The  layout manager is responsible for telling the recycler view how it will display its list elements
- The adapter is responsible for providing the dataset to your recycler view object.



### Data checklist - Hooking up our POJO

We will start by creating a movies.json file that we will copy directly into our Resources directory.
Here's a [javascript file](https://gist.github.com/abassawo/975f7d9a9d90e2d9d5683454dd981ffa) that includes an object of Movies called data:


- Let's look at our expected JSON response, and figure out what our mirroring Java class would look like.

- Setters and getters?

- toString()?

[Exit Ticket](#)

