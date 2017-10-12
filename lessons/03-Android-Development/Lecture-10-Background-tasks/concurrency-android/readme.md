## Multithreading and Concurrency in Android

### Objective

Students will understand:

* what processes and threads are in general
* how processes and threads work on Android
* the role of the main (aka UI) thread and what to do and NOT do
* the different ways to work with threading on Android


#### Resources
- [Concurrency](http://docs.oracle.com/javase/tutorial/essential/concurrency/)
- [Processes and Threads](https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html)
- [AsyncTask](https://developer.android.com/reference/android/os/AsyncTask.html)
- [Processes and Threads, an Overview](https://www.youtube.com/watch?v=IcIFJ5V3Ibg)
- [Components and the UI Thread](https://www.youtube.com/watch?v=A0PAhoHzlsQ)
- [Android Multithreading Overview](https://www.youtube.com/watch?v=lznss-0gEHU)
- [AsyncTasks](https://www.youtube.com/watch?v=V4q0sTIntsk)


### Do Now (Morning)

Create an application that reads data locally. Copy the JSON Object from the following [Gist](https://gist.github.com/abassawo/975f7d9a9d90e2d9d5683454dd981ffa) (Copy everything excluding "var data = ") into a json file in your Res directory. Your task is to load up the json data into a TextView as-is.

### Lecture

Many of the apps we will build will have to connect to the internet. Here are the first rules:
[The Movie DB API](http://api.themoviedb.org/3/movie/popular?api_key=#)

Java comes equipped with several classes that we can use to connect to the internet such as HttpUrlConnection, URLConnection.

We will get some practice with using OkHttp and AsyncTasks today to get up and running.

Rule 1: Don't block the main thread

Rule 2: Add necessary permissions


### Definitions

**Jank**: Any stuttering, flickering or just plain halting that users see when an app (or site) isn't keeping up with the refresh rate. Jank is the result of frames taking too long for a browser to make, and it negatively impacts your users and how they experience your site or app.

  - Demo - JankyApp

**Asynchronous** - When you execute something asynchronously, you can move on to another task before it finishes.

**Synchronous** - When you execute something synchronously, you wait for it to finish before moving on to another task. (Also referred to as blocking)

**Thread** - A thread of execution in a program. The Java Virtual Machine allows an application to have multiple threads of execution running concurrently.

**Process** - A running program; all the threads in a process have access to shared memory, and each process running has its own memory. The CPU of a machine handles running several processes at once.

**Thread** - represents one path of execution in a process. Threads can run concurrently, which makes them tricky to reason about.

Race Condition - Running more than one thread inside the same application does not by itself cause problems. The problems arise when multiple threads access the same resources. For instance the same memory (variables, arrays, or objects), systems (databases, web services etc.) or files.


#### The Android Main Thread

The UI thread is the main thread, and it in charge of updating the UI. Other threads may interact with the main thread to update the UI or do other things such as run a service or running the onReceive method in a broadcast receiver. Because this thread updates the UI, actions that are performed on it should be quick and discrete.  If the UI thread were to be used to access the internet or download a file, for example, then the user would not be unable to interact with the application until that operation was completed. This is why background threads are used.

Background threads are threads other than the main thread.  They do not make changes to the UI.  While information from a background thread may be used to update the UI, the UI is updated by the UI thread. Anything that could block the UI thread, such as a database access, should go on a background thread.


#### Asynchronous Android Programming

There are a number of ways to facilitate asynchronous Android programming - i.e, Handlers, Threads, Runnables, Intent Services: We will start with learning about the AsyncTask because it abstracts away details of concurrency

- Executes code asynchronously

- Initiates background thread, runs operations, and syncs with main thread

- For short operations (< several seconds) that are used to publish some outcome to main thread

- Not an answer to every multi-threading matter*

An AsyncTask is an object that defines a task to be executed in a background thread. The `doInBackground` method must be implemented, and the code runs in the background. The `onPostExecute` method runs on the UI thread, and can use the result of `doInBackground`, which it takes in as a parameter.

Some methods from AsyncTask run on the UI thread, while some run in a background thread - e.g. `publishProgress` posts an update from the background thread, while `onProgressUpdate` runs on the UI thread using the information from `publishProgress`.


### Exercises (Afternoon)

We will load information from the internet. 

Modify your project to fetch Chuck Norris jokes from the following web resource:

http://api.icndb.com/jokes/random/


### 3rd Party Libraries for Consuming Web

- [OkHttp](http://square.github.io/okhttp/)
- [Retrofit](https://square.github.io/retrofit/)
- [Gson](https://github.com/google/gson)

## Exercise  

Modify your code to fetch data from http://api.icndb.com/jokes/categories. Load your data into a RecyclerView in your fragment.
