# Job Scheduler

The Job Scheduler is a component provided by the android framework that allows you to schedule work when certain conditions are met by the system, even if your application is not in the foreground or killed by the OS. For example, say you want to schedule a job that updates a local database from a server when your device is plugged in and has wifi connection. The [JobScheduler](https://developer.android.com/reference/android/app/job/JobScheduler.html) allows you to do that. 

The Job scheduler is composed of two components, the scheduler that is responsible for building the conditions to begin your job and the job itself which will contain the logic necessary for the work. 

### Scheduler
The scheduler itself you would call from an Activity or from a Util class. It is provided by the system itself, what you pass in to schedule is a job builder which contains the desired OS conditions for a successful completion of your job. 

It looks like so:
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

There are various settings that you can apply such as network conditions `.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)` (WIFI)

Check out the `JobInfo.Builder` [Doc](https://developer.android.com/reference/android/app/job/JobInfo.Builder.html) for more info. 

### Your Job
The Job you specify must extend the `JobService` class, like the `IntentService`, the JobService extends the `Service` class and must be declared in your manifest. It's an interface that allows you to perform work outside of your application, that being said, it runs in the main thread which means that you need to create a background thread if you need to. For example with an async task.

There are two methods that you need to override to make your job work. 
* `onStartJob(JobParameters params)`: Returns true if your service needs to process the work (on a separate thread). False if there's no more work to be done for this job.
* `boolean onStopJob(JobParameters params)` Called by the system when a job ends:  Return true to indicate to the JobManager that you'd like to reschedule this job based on the retry criteria provided at job creation-time. False to drop the job. Regardless of the value returned, your job stops executing.

There is a third method to keep in mind: that is `jobFinished (JobParameters params, boolean needsReschedule)`.
You MUST call this method at some point if you are processing work on another thread when you finish your job, otherwise the system will kill your job because this is never called. 

Don't be put off by the size of the following sample, it's only two methods and a handler, the bulk of the snippet are comments.

From the sample project: A simple Job using a handler to toast a message:

```java
/**
 * A Job that toasts the screen whenever it runs.
 */

public class ToastJobService extends JobService {

    private static final String TAG = ToastJobService.class.getSimpleName();

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            Toast.makeText(ToastJobService.this, "Running TOAST Service Class", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "handleMessage: ~~~~~~running test job~~~~~~~");
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
        Log.d(TAG, "onStartJob: on start called");
        handler.sendMessage(Message.obtain(handler, MyJobScheduler.TOAST_JOB_ID, jobParameters));
        return true;
        // True if your service needs to process the work (on a separate thread).
        // False if there's no more work to be done for this job.
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
        Log.d(TAG, "onStopJob: ~~~~~~job terminated~~~~~~~");
        return true;
        // True to indicate to the JobManager whether you'd like to reschedule this job based on the retry criteria provided at job creation-time.
        // False to drop the job.
        // Regardless of the value returned, your job stops executing.
    }
}
```

### Conclusion: 

We have no control when these jobs are executed, all we can really control is the conditions that should be met when they do. So keep that in mind. The Job Scheduler was created to facilitate long running background tasks and to conserve device resources. As far a background executions go, it is thought of as the current best practice.

### Resources:

Lesson was influenced from: 
* [link 1](https://medium.com/google-developers/scheduling-jobs-like-a-pro-with-jobscheduler-286ef8510129)
* [link 2](https://code.tutsplus.com/tutorials/using-the-jobscheduler-api-on-android-lollipop--cms-23562)


### Exercise

Take a look at the following [Project](https://github.com/lighterletter/JobScheduler). In it I have implemented a toast job for you to checkout. I have also created an `AsyncJob` and a `RetrofitJob` class for you to implement. Use one of the APIs you have been using to simply log the response thorugh the Job. Everything your need is in the project, for guidance use the links provided in Resources and the documentation. Remember to import into Android Studio from the `Jobs` folder.