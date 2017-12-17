# Retrofit - Parsing JSON the Easy Way 

## Objectives
* Fellows will pull data from JSON endpoint using Retrofit
* Fellows will create data models to map to that JSON Data
* Fellows will display that data as an image from a website using Picasso

## Resources
* [Picasso](https://github.com/square/picasso)
* [Retrofit](https://github.com/square/retrofit)
* [JSON and JSON Parsing - The Old School Way](https://github.com/C4Q/AC-Android/tree/master/lessons/json/json_parsing)

# Lecture

We have explored in class previously how to create JSONObjects, and parse JSON into data models that we can use to display that JSON data in some meaningful way. We've even explored how to use AsyncTasks (ugh, sorry...) to reach a JSON Endpoint somewhere on the internet, and make use of that information any way we chose to do so. You might have thought this was the only way to do this in Android, but...

![Retrofit, there is...](http://i.imgur.com/SRyMh.jpg)

much less exhausting, and much more predictable way to do this - using Retrofit.

## What is Retrofit?

It's amazing, is what it is. An open-source library built by Square, it allows you to easily make GET and PUT requests (among other things), by simply using a few boilerplate lines of code, without having to repeat yourself that often. It accounts for most edge cases specific to HTTP requests, and does everything off of the main thread, so you never have to worry about blocking 
