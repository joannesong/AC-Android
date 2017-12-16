# Networking before the age of retrofit. 

#### Overview:

Before android developers had awesome libraries like retrofit for networking, we used background threads like async tasks to make a network request. Although rarely used, you might encounter legacy code written where async tasks are used to make a network request, and we parse the json string returned to create our objects. Knowing how that is done can be usefull. 

This lesson will give you a quick overview of how that is done.

A sample project can be found [here](https://github.com/lighterletter/NetworkingLesson).

#### Making a network request with an async task: (No libraries)

Some interviews will ask you to make a network call without libraries in android. This is how you do it: 
```
public class NetworkTask extends AsyncTask<String, Void, Integer> {
        @Override
        protected Integer doInBackground(String... strings) {
            InputStream inputStream = null;
            HttpsURLConnection urlConnection = null;
            Integer result = 0;

            try {

                URL url = new URL(strings[0]);
                urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                int statusCode = urlConnection.getResponseCode();

                if (statusCode == 200) {

                    Log.v("okay", statusCode + "");
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                    String response = convertInputStreamToString(inputStream);
                    
                        //Success! response contains your json!
                        
                    result = 1; // Data!
                } else {
                    result = 0; //"No data :(";
                }
            } catch (Exception e) {
                Log.d("doInBackground", e.getLocalizedMessage());
            }
            return result; //defaults to no data
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            if (integer == 1) {
                //Awesome! You can update the UI from here
            } else {
                Log.e("issuePostExecute", "Failed to fetch data!");
            }
        }

        private String convertInputStreamToString(InputStream inputStream) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String result = "";
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            inputStream.close();
            return result;
        }
    }
```

* convertInputStreamToString() simply takes in the input of your response and turns it into a string.
* A status code of 200 means everything went OK! 
* you can only update your UI elements from OnPostExecute() which is why I'm passing an number here. You can pass a boolean or anything else depending on how you structure your Async task.
* Async tasks were meant for small and quick network requests. 


#### Making a network call with retrofit: libary

Retrofit makes this super simple and it's the de-facto/industry standard to make network calls on android.
First: Import your gradle dependencies (may need to update in the future)
```
//retrofit
    compile 'com.squareup.retrofit2:retrofit:2.3.0'
    compile 'com.squareup.retrofit2:converter-gson:2.3.0' // gson helps with json parsing
```

To implement this we make an interface and add our endpoint to it like so:
```
public interface GitHubService {
    @GET("repos/rails/rails/issues")
    Call<List<Issue>> getIssues();
}
```

Notice that the link does not contain the base url. That is added when we build our Retrofit instance.

The service above would contain all the methods necessary to make our calls, in this example, appending the string: ("repos/rails/rails/issues") to the base url on our retrofit instance, would get us all the Issues. We must look at the JSON call to understand that the object that we are getting is an array which is why we need a `list` of `Issue` type shown below. The Call itself lets retrofit know the type of object we're expecting from the response. 

The fields in your Model Object should match those in your json response like so.

```
public class Issue {
    private String title;
    private String name;
    private String body;
    private String comments_url;
    private User user;
}
```
My user class just has a String `login` for the username as per githubs api schema.
(Your class would of course have getters and setters. )

This is how we would build our retrofit instance:

```
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
```

With your instance you would then create a service by instantiating your interface:

```
GitHubService service = retrofit.create(GitHubService.class);
```

Finally we make our call by creating our call back. Like this we have access to our response and our object:
```
        Call<List<Issue>> issues = service.getIssues();
        issues.enqueue(new Callback<List<Issue>>() {
            @Override
            public void onResponse(Call<List<Issue>> call, Response<List<Issue>> response) {
                Log.d(TAG, "onResponse: " + response.body().size());
            }

            @Override
            public void onFailure(Call<List<Issue>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.toString());
            }
        });

```

If you understand this you should be on your way to adapt to different network calls! 



