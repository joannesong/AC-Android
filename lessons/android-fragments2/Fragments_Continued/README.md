# Fragments: Views with their own Lifecyles

## Objectives

* Fellows will learn what fragments are
* Fellows will explore the Fragment Lifecycle
* Fellows will instantiate Fragments
* Fellows will utilize Fagment managers
* Fellows will use Fragment Transactions to add bundles and commit Fragments
* Fellows will add Fragments to a BackStack
* Fellows will add and replace Fragments within Frame Layouts

# Lecture

As we've seen with Activities, the only way to include different layouts for an activity, is to use the <include> tag in your layout xml, or to use an intent to switch between activities. However....

## The Fragment Lifecycle

The Fragment Lifecycle is similar to that of the Activity Lifecycle, in that it goes through various stages throughout its lifecycle, and can shift between these states depending on the actions of either the user, or the device itself.

|Fragment Lifecycle Callback Method|Description|
|:-----------:|:-----------------|
|onAttach()|This method will be called first, even before onCreate(), letting us know that your fragment has been attached to an activity. You are passed the Activity that will host your fragment|
|onCreateView()| The system calls this callback when it’s time for the fragment to draw its UI for the first time. To draw a UI for the fragment, a View component must be returned from this method which is the root of the fragment’s layout. We can return null if the fragment does not provide a UI|
|onViewCreated()| This will be called after onCreateView(). This is particularly useful when inheriting the onCreateView() implementation but we need to configure the resulting views, such as with a ListFragment and when to set up an adapter|
|onActivityCreated()| This will be called after onCreate() and onCreateView(), to indicate that the activity’s onCreate() has completed. If there is something that’s needed to be initialised in the fragment that depends upon the activity’s onCreate() having completed its work then onActivityCreated() can be used for that initialisation work|
|onStart()|The onStart() method is called once the fragment gets visible|
|onPause()|The system calls this method as the first indication that the user is leaving the fragment. This is usually where you should commit any changes that should be persisted beyond the current user session|
|onStop()|Fragment going to be stopped by calling onStop()|
|onDestroyView()|It’s called before onDestroy(). This is the counterpart to onCreateView() where we set up the UI. If there are things that are needed to be cleaned up specific to the UI, then that logic can be put up in onDestroyView()|
|onDestroy()|onDestroy() called to do final clean up of the fragment’s state but Not guaranteed to be called by the Android platform|
|onDetach()|It’s called after onDestroy(), to notify that the fragment has been disassociated from its hosting activity|
