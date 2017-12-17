# Title: Background services    
Tags: background jobs, intent services

# Objectives

- Understand how to run jobs in the background to boost application's performance
- Understand how to create a background service
- Understand how to send work to a background service
- Understand how to report progress on work status


# Resources

- [Android background operations](https://developer.android.com/guide/background/index.html#alarms)
- [Intent services](https://developer.android.com/training/run-background-service/index.html)

# Background Operations

In many cases, an app needs to perform some operations while the user is not interacting with it. For example, a photo-album app might need to optimize its storage by compressing its photos; the app would not want to do that while the user is interacting with it, because that might degrade its performance. However, if an app does work while it isn't running in the foreground, there's the danger that it might interfere with the performance of other apps. For this reason, it's important for an app to choose the right way to perform its background work.

The Android platform offers a number of ways for an app to perform work while it's in the background:

#### **Scheduled Jobs**
You define a job, and specify the circumstances when you want that job to run. The system starts the job at the appropriate time, even if your app isn't currently running. The system also batches the jobs intelligently; for example, it does more work when the system is otherwise idle.

*Use case*: If you want to refresh your app's cached data, you might specify that you want your job to run when the device is connected to power (so you don't run down the device battery) and to an unmetered network (so you don't waste the user's data allotment).

Link to [schedule jobs](https://developer.android.com/topic/performance/scheduling.html)


#### **Services**
A Service is an application component that can perform long-running operations in the background, and it does not provide a user interface. Another application component can start a service, and it continues to run in the background even if the user switches to another application. 

There are three different type of services:
1. Foreground: Performs some operation that is noticeable to the user. For example, an audio app would use a foreground service to play an audio track.
2. **Background**: Performs operation that isn't directly noticed by the user. For example, if an app used a service to clean up it's storage, that would usually be a background service. 
3. Bound: A bound service offers a client-server interface that allows components to interact with the service, send requests, receive results, and even do so across processes with interprocess communication (IPC). A bound service runs only as long as another application component is bound to it. Multiple components can bind to the service at once, but when all of them unbind, the service is destroyed.

*Use case*: If you have a music app, you would want to define a service to handle the audio playback. In a case like that, you would use a foreground service. Foreground services do work that is noticeable by the user, and they have to display a status bar icon.

Link to [Services](https://developer.android.com/guide/components/services.html)

#### **Broadcasts**
Your app can register to receive system broadcasts, and perform actions when it receives those broadcasts. You app can also send out broadcasts that are used by other apps. Apps can use their manifests to register for explicit broadcasts, since they are targeted at the app directly (not recommended for implicit broadcasts). Apps can register for implicit broadcasts by calling registerReceiver() at runtime, since that way, they'll only receive the broadcast if they're already running when the broadcast is sent.

*Use case*: If you have an app that plays a music whenever the user recieves an SMS, your app would have to register to recieve new sms broadcasts on the activity to be launched. The android systems fires this activity when new SMS arrives and your song plays.

Link to [Broadcasts](https://developer.android.com/guide/components/broadcasts.html)

#### **Alarms**
Your app can use AlarmManager when you need to start your app up at a specific time. At the specified time, the device wakes up if necessary, and sends an intent to your app to wake it up. However, you should only use this approach when you need your app to do something at a particular time. If you just need to perform an operation at a specified interval, or under particular conditions, you should use a scheduled job.

Link to [Alarms](https://developer.android.com/reference/android/app/AlarmManager.html)

*Use case*: A weather app that downloads the latest weather data at 6:00am in the morning.

## Creating a Background Service

The `IntentService` class provides a straightforward structure for running an operation on a *single* background thread. This allows it to handle *long-running operations* without affecting your user interface's responsiveness. Also, an IntentService isn't affected by most user interface lifecycle events, so *it continues to run in circumstances that would shut down an AsyncTask*.

An IntentService has a few limitations:
* It can't interact directly with your user interface. To put its results in the UI, you have to send them to an Activity.
* Work requests run sequentially. If an operation is running in an IntentService, and you send it another request, the request waits until the first operation is finished.
* An operation running on an IntentService can't be interrupted.

To create an IntentService component for your app:

1. Define a class that extends IntentService, and within it, define a method that overrides onHandleIntent().

```java
public class RSSPullService extends IntentService {
    @Override
    protected void onHandleIntent(Intent workIntent) {
        // Gets data from the incoming Intent
        String dataString = workIntent.getDataString();
        ...
        // Do work here, based on the contents of dataString
        ...
    }
}
```

2. Define the IntentService in the Manifest by adding a <service> element that's a child of the <application> element:

```xml
    <application
        android:icon="@drawable/icon"
        android:label="@string/app_name">
        ...
        <!--
            android:name specifices the class name of the IntentService

            Because android:exported is set to "false",
            the service is only available to this app.
        -->
        <service
            android:name=".RSSPullService"
            android:exported="false"/>
        ...
    <application/>
```

## To Send a Work Request to an IntentService

1. Create a new, explicit Intent for the IntentService called RSSPullService. Then add work data to it.

```java
mServiceIntent = new Intent(getActivity(), RSSPullService.class);
mServiceIntent.setData(Uri.parse(dataUrl));
```

2. Call `startService()`
```java 
// Starts the IntentService
getActivity().startService(mServiceIntent);
```

Once you call startService(), the IntentService does the work defined in its onHandleIntent() method, and then stops itself.

## To Report Status from an IntentService

To send the status of a work request in an IntentService to other components, first create an Intent that contains the status in its extended data. As an option, you can add an action and data URI to this Intent.

Next, send the Intent by calling LocalBroadcastManager.sendBroadcast(). This sends the Intent to any component in your application that has registered to receive it. To get an instance of LocalBroadcastManager, call getInstance().

For example:
```java
public final class Constants {
    ...
    // Defines a custom Intent action
    public static final String BROADCAST_ACTION =
        "com.example.android.threadsample.BROADCAST";
    ...
    // Defines the key for the status "extra" in an Intent
    public static final String EXTENDED_DATA_STATUS =
        "com.example.android.threadsample.STATUS";
    ...
}
public class RSSPullService extends IntentService {
...
    /*
     * Creates a new Intent containing a Uri object
     * BROADCAST_ACTION is a custom Intent action
     */
    Intent localIntent =
            new Intent(Constants.BROADCAST_ACTION)
            // Puts the status into the Intent
            .putExtra(Constants.EXTENDED_DATA_STATUS, status);
    // Broadcasts the Intent to receivers in this app.
    LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
...
}
```

## Receive Status Broadcasts from an IntentService

To receive broadcast Intent objects, use a subclass of `BroadcastReceiver`. In the subclass, implement the `BroadcastReceiver.onReceive()` callback method, which `LocalBroadcastManager` invokes when it receives an Intent. LocalBroadcastManager passes the incoming Intent to `BroadcastReceiver.onReceive()`.

For example:
```java
// Broadcast receiver for receiving status updates from the IntentService
private class DownloadStateReceiver extends BroadcastReceiver
{
    // Prevents instantiation
    private DownloadStateReceiver() {
    }
    // Called when the BroadcastReceiver gets an Intent it's registered to receive
    @Override
    public void onReceive(Context context, Intent intent) {
        /*
         * Handle Intents here.
         */
    }
}
```

Once you've defined the BroadcastReceiver, you can define filters for it that match specific actions, categories, and data. To do this, create an IntentFilter. 

For example:
```java
// Class that displays photos
public class DisplayActivity extends FragmentActivity {
    ...
    public void onCreate(Bundle stateBundle) {
        super.onCreate(stateBundle);
        // 1. Define the filter
        // The filter's action is BROADCAST_ACTION
        IntentFilter statusIntentFilter = new IntentFilter(
                Constants.BROADCAST_ACTION);

        // Adds a data filter for the HTTP scheme
        statusIntentFilter.addDataScheme("http");
        ...

        // 2. Register the BroadcastReceiver and IntentFilter with the system
        // Instantiates a new DownloadStateReceiver
        DownloadStateReceiver mDownloadStateReceiver =
                new DownloadStateReceiver();
        // Registers the DownloadStateReceiver and its intent filters
        LocalBroadcastManager.getInstance(this).registerReceiver(
                mDownloadStateReceiver,
                statusIntentFilter);
        ...
    }
    ...
}
```

# Summary

* There are several ways of performing background operations: scheduled jobs, background services, alarms etc
* Background/Intent services allows an app to perform long-running off-the-ui work on a single background thread.
* We can create and start Intent services basically similarly to Intent activities
* We pass and receive data from services using broadcast receivers.
