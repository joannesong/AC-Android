## Morning challenge :cat:

**1)** Create a new Android Studio project for today's exercises.

**2)** The following code snippet displays a basic notification to the user:

```java
int NOTIFICATION_ID = 555; // Setting a notification ID allows you to update the notification later on.

NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My notification")
                .setContentText("Hello World!");

NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

notificationManager.notify(NOTIFICATION_ID, builder.build());
```

Try displaying a new notification to the user in your MainActivity's `onCreate()`. 

*Hint: You'll need to add a notification_icon drawable resource to use as the notification icon.*

**3)** Create a new activity, `SecondActivity.java`. Add a pending intent to your notification that launches SecondActivity when the user clicks the notification.

*Hint: see ["Notification actions"](https://developer.android.com/guide/topics/ui/notifiers/notifications.html#CreateNotification)*.
