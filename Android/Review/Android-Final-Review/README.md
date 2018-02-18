
# Title: Final of the Finals Review

## Objective

- Summarize what we've learned so far
- Prepare for FINAL exam!
- Answer any questions you have

## Any Questions

## All Topics List

You should try and review everything on this list (at least):
- XML layouts
- Manifest file
- Resources (drawables, layouts, values)
- Context
- Activities & their lifecycle
- Fragments & their lifecycle
- Using fragment manager, communicating with fragment host
- Intents bundles
- SharedPreferences
- Views (TextView, EditText, Button, ImageView, etc)
- Validating input in TextViews
- LayoutInflator
- RecyclerViews
- Menus & navigation
- Multithreading
- Networking API calls
- JSON data
- Local databases
- Background services
- Notifications (with pending intents)

## Polled/Filtered Topics List

Topics on the somewhat-difficult side:
- Local databases
- Background services
- Notifications
- Pending intents
- Job scheduler
- SharedPreferences
- Background services
- Multithreading


## Unit 5 Final Solutions App

Reference Implementation: https://github.com/C4Q/AC_Android_Unit_5_MidUnit_Assessment/tree/solution

Topics include:
- Make calls to a specified API to retrieve data
    * Your choice of tools: OkHttp, Retrofit, Volley, etc.
    * Networking must be done in a background thread
- Recieve and parse JSON data into Java objects
    * Your choice of tools: JSONObject, GSON, etc.
- Display objects in a RecyclerView
- Including an ImageView (API data will include image URLs)
    * Get image from URL and display it using Picasso or similar library
- Show a details screen with more info when an item is selected from RecyclerView
    * Option of separate Activities, or using Fragments (one for list, one for detail)
- BONUS topics (optional, non-required features):
    * Implement a local database to store data from API
    * Can use SQLite or other types of databases
    * When Activity/Fragment is created, app should look in database first, and make network call only if database is empty
- Menus (options menu), click handling
- Orientation
- Check network state
- DSA review

## Unit 4 Final Solutions App

- (Reference implementation) https://github.com/C4Q/AC-AndroidTest-U4Final
- (Peer reference) https://github.com/STaverasAC/AC-AndroidTest-U4Final
- (Peer reference) https://github.com/LuminaryDoom/AC-AndroidTest-U4Final
- (Peer reference) https://github.com/joannesong/AC-AndroidTest-U4Final

Topics include:
|Topic|Resource|
|:-|:-:|
|Menus|[link](https://github.com/C4Q/AC-Android/tree/v2/Android/Lecture-9-Menus-and-Navigation)|
|Fragments|[link](https://github.com/C4Q/AC-Android/tree/master/lessons/android-fragments2/Fragments_Continued)|
|HashMaps and ArrayLists|[link](https://github.com/C4Q/AC-Android/blob/master/lessons/arrays-arraylists/arrays-ArrayLists-HashMaps/README.md)|
|RecyclerView|[link](https://github.com/C4Q/AC-Android/blob/master/lessons/recyclerview/review/README.md)|
|JSON and JSON Parsing|[link](https://github.com/C4Q/AC-Android/tree/master/lessons/json/json_parsing)|
|Networking| [link](https://github.com/C4Q/AC-Android/tree/v2/Android/Lecture-12-Networking)|
|Async Tasks| [link](https://github.com/C4Q/AC-Android/tree/v2/Android/Lecture-10-Async-tasks)
|RetroFit|[link](https://github.com/C4Q/AC-Android/blob/master/lessons/json/json_and_retrofit/README.md)|
|Sorting|[link](https://github.com/C4Q/AC-Android/tree/v2/DSA/sorting)|

## Other Apps Examples:

Apps and their links:
* [Network And Database sample](https://github.com/C4Q/AC-Android-App-NetworkDatabase)
* [Notes app](https://github.com/C4Q/notesapp/tree/dev)
* [Menus app](https://github.com/C4Q/AC-Android-Menu-App.git)


## Intents

- Distinguish between implicit and explicit intents
- Starting components and services using intents
- Use intents to handle navigation within an Android application
- Use intent extras to transfer information from one activity to another.
- Registering intents via intent filters


**Summary intents**

- Intents are used for navigating between multiple activities
- We own explicit intents while the OS manages implicit ones
- Extras are used to pass and retrieve additional information to intents

## Shared Preferences

Lecture link: https://github.com/C4Q/AC-Android/tree/master/lessons/shared-preferences


Code sample for setting value in shared preference (copy-worthy):
```java
//... imports here
public class MainActivity extends AppCompatActivity {
  private static final String SHARED_PREFS_KEY = "sharedPrefsKey";
  private SharedPreferences sp;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //... app initialization code
    sp = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
    SharedPreferences.Editor editor = sp.edit();
    editor.putString("username", "John Doe");
    editor.commit();
  }
  //... more android code
}
```


## Recycler View

1. Create a Model Class for the Data you want to Display

2. Insert RecyclerView markup in the MainActivity's layout file

3. Create an ItemView layout (markup for one item in the recycler view)

4. Create a ViewHolder Class to set these ItemView values dynamically

5. Create an Adapter Class to bind data to each ItemView

6. Implement onBindViewHolder() and getItemCount() on the Adapter class

7. Inflate the RecyclerView in your Activity's onCreate()

8. Create/Setup a data source and pass to Adapter class

9. Pass the data source into an Adapter instance

10. Create a LinearLayoutManager Instance, to set Orientation

11. Set the Adapter to your RecyclerView (the adapter instance you just created)


## Local Databases

1. Create class that extends the SQLiteOpenHelper (copy-worthy)
```java
public class FellowsDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "fellows.db";
    private static final String TABLE_NAME = "fellows";
    private static final int SCHEMA_VERSION = 1;

    public FellowsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "last_name TEXT, first_name TEXT, company TEXT);");
    }

    public void addFellow(String first_name, String last_name) {
      //...
    }
}
```

2. Initialize it in an Activity (copy-worthy):
```java
protected void createDb() {
  FellowsDatabaseHelper db = new FellowsDatabaseHelper(context);
  for(Map.Entry<String, String> entry: res.entrySet()) {
      db.addFellow(entry.getKey(), entry.getValue());
  }
}
```

For example with inserting items and reading from database, see also: https://github.com/C4Q/AC-Android-App-NetworkDatabase/blob/master/app/src/main/java/nyc/c4q/networkingdatabase/MainActivity.java

## Networking

1. Sample code for fetching data at url using OkHttp (very copy-worthy)
```java
protected void makeRequestWithOkHttp(String url) {
  Request request = new Request.Builder()
          .url(url)
          .build();

  new OkHttpClient().newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(Request request, IOException e) {
          // UI code that responds to failed request
      }

      @Override
      public void onResponse(Response response) throws IOException {
          String data = response.body().string();
          // UI code that uses data here.
      }
  });
}
```

2. Java HttpConnection example (copy-worthy with some leg work - asyncTask):
```java
private static String downloadData(String urlString) throws IOException {
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


## Json Data parsing

Sample json data parsing (very copy-worthy):
```java
public void doJsonWork(String jsonString) {
  // create json object from string data
  JSONObject jObj = new JSONObject(jsonString); // jsonString may look like `{ "hello": "world"}`
  // print all keys and values
  for (Iterator<String> it = jObj.keys(); it.hasNext(); ) {
      String s = it.next();
      try {
          System.out.println("key: " + s + ", value: " + jObj.get(s).toString());
      } catch (JSONException e) {
          e.printStackTrace();
      }
  }

}
```

Copied and modified from [colorJson](https://github.com/STaverasAC/AC-AndroidTest-U4Final/blob/master/app/src/main/java/nyc/c4q/androidtest_unit4final/MainActivity.java)

## Notifications

Sample code for displaying notifications in an app (copy-worthy)
```java
private static final int NOTIFICATION_ID = 555;
private static final String NOTIFICATION_CHANNEL = "C4Q Notifications";
// call this method from onCreate or anywhere to display notifications
public void showNotification(){
  NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My notification")
                .setContentText("Hello World!");

  NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
  notificationManager.notify(NOTIFICATION_ID, builder.build());
}
```

To open an activity using Pending intent (extreme copy-worthy when combined with above).
```java
public void showNotification(){
  //... created builder
  int requestID = (int) System.currentTimeMillis(); // Unique requestID to differentiate between various notification with same notification ID
  int flags = PendingIntent.FLAG_CANCEL_CURRENT; // Cancel old intent and create new one
  PendingIntent pendingIntent = PendingIntent.getActivity(this, requestID, intent, flags);
  builder.=.setContentIntent(pendingIntent)

  //... notificationManager
}
```

## Job Scheduler

1. Create a service for the work to be done (certified copy-worthy)
```java
public class ToastJobService extends JobService {

    private static final String TAG = ToastJobService.class.getSimpleName();

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            Toast.makeText(ToastJobService.this, "Running TOAST Service Class", Toast.LENGTH_SHORT).show();
            jobFinished((JobParameters) message.obj, true); // Used to queue up the task to run again at another point.
            // If this method is not called the job runs only once and it's killed by the os after some time.
            return true; // True if no further handling is needed.
        }
    });

    /**
     * Called by the system to begin execution of your job.
     */
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        handler.sendMessage(Message.obtain(handler, MyJobScheduler.TOAST_JOB_ID, jobParameters));
        // True if your service needs to process the work (on a separate thread).
        // False if there's no more work to be done for this job.
        return true;
    }

    /**
     * // Only called if start job returns true, called by the system if your job is cancelled before being finished,
     * Or if the conditions necessary to run the job are no longer being met.
     * <p>
     * Use for safety checks and cleanup.
     */
    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        handler.removeMessages(MyJobScheduler.TOAST_JOB_ID);
        // True to indicate to the JobManager whether you'd like to reschedule this job based on the retry criteria provided at job creation-time.
        // False to drop the job.
        // Regardless of the value returned, your job stops executing.
        return true;
    }
}
```

2. To schedule the service to run using job scheduler (certified copy-worthy)
```java
public void beginToastScheduler(){
  //The scheduler is given to you by the system using getSystemService.
  JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
  //Next, you need a JobInfo.Builder object which is where you denote a job id and the class which contains your job as well as any conditions you want to apply.
  JobInfo.Builder toastJob = new JobInfo
          .Builder(TOAST_JOB_ID, new ComponentName(applicationContext, ToastJobService.class))
          .setMinimumLatency(1000); //Specify that this job should be delayed by the provided amount of time.
  jobScheduler.schedule(toastJob.build()); //schedule your job, the scheduler can chain jobs together.
}
```
