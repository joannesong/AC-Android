# OAuth 2.0 and Authentication in Android

**Authentication** is the process of verifying the identity of a user in an application against a server. For example when you type in your username and password on a website, your credentials are authenticated, if correct, you gain access to the service.
**Authorization** is a user granting your application permission to access their data stored on a third party source. The industry standard when connecting to third party APIs is [Oauth 2.0](https://en.wikipedia.org/wiki/OAuth). In this lesson we will discuss the general steps necessary for the Oauth 2.0 flow.

Authentication can be a challenging topic. I still have trouble with it. So don't be discouraged if you don't understand it today, be exposed to it, try to get what you can out of this lesson and come back to it if/when you need to. 

The challenge is that each api is built differently, and although the concepts are generally the same, the implementation can vary by API, so it is important to read through the individual docs.

You can get a high level overview of what Oauth2 is in this [Video](https://www.youtube.com/watch?v=CPbvxxslDTU)

In short, Oauth2 authentication is a protocol that allows your application to safely retrieve information that a user might have in a third party appliaction like instagram without you ever getting access to their credentials, to ensure the safety of your user's information.

OAuth 2.0 Authentication is done through the following steps.
* 1: As a developer you need to register your application in a developer portal hosted by the third party service. You will also need to specify a redirect url (more on that below).  
* 2: You will receive a client secret and an id. These two strings are used by the remote server to verify that your application is registered with them and to keep metrics on how your application is using their service. 
* 3: When you make a request to their API using your credentials, the server will respond with some way to allow the user to give your application permission to access their data. This is usually handled in the form of a webview or a browsable intent, where the user can enter their username and password. You never have access to these values. 
* 4: Once the user authorizes your application, the server will respond with a string called an authorization token appended to the redirect url you specified when you registered your application. 
* 5: The authorization token is then used to request an access token. This token is what you will use to make API calls to the service.

This is a brief overview of what can be a complicated topic. For more detail on a conceptual level you can read [this](https://www.digitalocean.com/community/tutorials/an-introduction-to-oauth-2). 


### Exercise: Authenticate
Because it is a complicated topic, you are not expected to fully implement oauth 2 validation today, you are expected to try and get as far as possible.


Pick an API with Oauth 2.0 authentication protocol from this [list](https://github.com/toddmotto/public-apis), or a personal favorite. Remember that not all APIs are made the same and some might be more easily accessible or well documented than others. 

The key is to read the docs of your API. If they start to make sense that's a good sign.

### Resources: 

There are different architectural approaches to authenticating your app with Oauth2 below are some of them.

* This [tutorial](https://futurestud.io/tutorials/oauth-2-on-android-with-retrofit) uses an Intent to implement OAuth 2 using retrofit for the github API. Easy enough to follow, and the video is great. But I wasn't able to catch the redirect_uri from the intent. You might have better luck. 
* This [tutorial](http://progur.com/2016/10/how-to-use-reddit-oauth2-in-android-apps.html) uses OKHttp to make a request to the reddit api. I didn't fully attempt this one. You are welcome to.
* Another approach was the one I used for my first task at work. I used a webview that caught and saved the redirect URI when received into shared preferences by creating a custom client like [so](https://stackoverflow.com/questions/32871641/android-how-to-retrieve-redirect-url-from-a-webview/42433654).
* Advice: Don't beat yourself up if you can't make this happen, this can take a couple of days to get right. Like I mentioned before it's not a topic you understand in one day so yes, be driven but also be kind to yourself. 
