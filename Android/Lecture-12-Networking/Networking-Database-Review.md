# Title: Networking
Tags: java networking http

## Objectives
* Understand computer communication terms:
  - network
  - encoding
  - protocol
* Create and Manipulate URLs
* Retrieve data via HTTP

## Resources
* [How Does the Internet Work?](https://web.stanford.edu/class/msande91si/www-spr04/readings/week1/InternetWhitepaper.htm)
* [Oracle Networking Tutorials](https://docs.oracle.com/javase/tutorial/networking/index.html)


## URLs and HTTP

Use the `HTTP.stringToUrl(string)` method to convert a string to a `java.net.URL` object.  We've provided you this "factory method" because it's a bit easier to use than the standard constructors for the `URL` class.

See: http://docs.oracle.com/javase/7/docs/api/java/net/URL.html

[Nice slide on the anatomy of urls and http](https://docs.google.com/a/c4q.nyc/presentation/d/12S0rxujSdbRiYtdWjB2wdC4aRHfsuIqidgykSlw0s2g)


## Using third-party libraries

Performing network operations with standard Java API can be cumbersome. You have to open and close a connections, enable caches and ensure to perform the network operation in a background thread.

To simplify these operations several popular Open Source libraries are available. The most popular ones are the following:

* OkHttp for efficient HTTP access

* Retrofit for REST based clients

* Glide for image processing

> Prefer using OkHttp over the usage of HttpURLConnection. It is faster than the standard Java library and has a better API.

> Retrofit would be taught in a different lecture.

## Permission to access the network

To access the Internet your application requires the `android.permission.INTERNET` permission. On modern Android API versions, this permission is automatically granted to your application.

## Check the network availability

The network on an Android device is not always available. To check the network state your application requires the android.permission.ACCESS_NETWORK_STATE permission. You can check the network is currently available via the following code.

```java
public boolean isNetworkAvailable() {
    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = cm.getActiveNetworkInfo();
    // if no network is available networkInfo will be null
    // otherwise check if we are connected
    return networkInfo != null && networkInfo.isConnected();
}
```
This requires the ACCESS_NETWORK_STATE permission.

## Connecting to a Network URL

Here is method that takes a url string and fetches it using Java's HttpURLConnection

```java
private String downloadData(String urlString) throws IOException {
  InputStream is = null;
  try {
    URL url = new URL(urlString);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.connect();

    is = conn.getInputStream();
    BufferedReader r = new BufferedReader(new InputStreamReader(is));
    StringBuilder total = new StringBuilder();
    String line;
    while ((line = r.readLine()) != null) {
      total.append(line);
    }
    return new String(total);
  } finally {
    if (is != null) {
      is.close();
    }
  }
}
```

## Using OkHttp

First add the maven dependency for OkHttp. Then add the method below in MainActivity.java

```java
private void makeRequestWithOkHttp(String url) {
        OkHttpClient client = new OkHttpClient();   // 1
        Request request = new Request.Builder().url(url).build();  // 2

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) { // 3
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String result = response.body().string();  // 4

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // perform some ui work with `result`  // 5
                            TextView tv = (TextView) findViewById(R.id.text_view);
                            tv.setText(result);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
```

The code above does the following:
* Creates an OkHttpClient object.
* Builds an OkHttpClient request with the URL you want to connect to.
* Queues the request call.
* Retrieves the response as a string.
* Converts and passes the results to the main thread.

> **Exercises:**
>
> 1. Write a method that constructs an HTTP URL from the host name, port number, and path.  Include the port number only if it is _not_ 80.
>
>  ```java
>  public static URL makeHttpUrl(String host, int port, String path) {
>    // Write me.
>  }
>  ```
>
> 2. Using overloaded methods, write a similar method that doesn't take a port number, and assumes the port number is 80.
>
> 3. Write a method that **neatly** prints out the parts of a URL, in the correct order.


> **Exercises:**
>
> 1. Write a method that determines whether a character is an uppercase letter.
>
>  ```java
> public static boolean isUppercaseLetter(char c) {
>    // Write me.
> }
> ```
>
> 2. Write a method that determines whether a character is a lowercase letter.
>
> 3. _Rot-13_ is a (very simple) _cryptographic cipher_: a code for transferring text or other information in such a way that the contents are understandable only to intended recipient.  It works by rotating each letter 13 positions forward in the alphabet.
>
>  For example, A becomes N, B becomes O, C becomes P, _etc._  The alphabet wraps around from Z to A, so, for example, X becomes K.  Lower letters work similarly.  All other characters are unchanged.
>
>  Write a method that encodes a string in rot-13.
>
>  ```java
>  public static String rot13Encode(String string) {
>    // Write me.
>  }
>  ```
>
> 4. Write `rot13Decode()`, which decodes the cipher.
>
> 5. Generalize your methods to rotate any number of positions through the alphabet, not just 13.



> **Exercises:**
>
> 1. Write a program that asks for a URL from the user.  Retrieve the document via HTTP and print them out.  If the URL is invalid, print an error message stating that.
>
> 2. Write a program that asks for a URL and retrieves the document.  Guess whether the document is HTML by checking whether it begins with the string `<!doctype html>` (case-insensitive).  Print out whether the document is HTML.
>
>  Test your program on,
>  - http://www.google.com/
>  - http://espn.go.com/
>  - http://canitbesaturdaynow.com/images/fpics/355/04_06_09__-(89).jpg
>  - http://www.gutenberg.org/cache/epub/1251/pg1251.txt
>
> 3. Write a program that asks for a URL and a word.  The program retrieves the document and counts the number of times the word occurs in that document.
>
>  For example, you could use it to retrieve _Alice in Wonderland_ from [Project Gutenberg](http://www.gutenberg.org/) and count how many times the word "Alice" appears.
>
>  ```
>  enter URL: http://www.gutenberg.org/cache/epub/11/pg11.txt
>  enter word: Alice
>  That word occurs 403 times in the document.
>  ```

Project Gutenberg is a web site that provides thousands of free public domain ebooks.  They are available in a variety of formats, including "plain text", which is easy for computers to process.

