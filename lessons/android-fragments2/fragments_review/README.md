# Fragments Review

## Objectives
* Fellows will review instantiating fragments
* Fellows will review swapping out fragments
* Fellows will review adding to the fragment BackStack
* Fellows will integrate animations into their fragments

# Lecture

Fragments are resusable components of UI, which have their own lifecycle events. We've seen the creation of fragments in their host activities before:

```java
package nyc.c4q.fragmentsarefun;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = new MainFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_framelayout, mainFragment);
        fragmentTransaction.commit();

    }
}
```

With an activity_main.xml file like so:

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="nyc.c4q.fragmentsarefun.MainActivity">

    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/fragment_container_framelayout"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"/>

</android.support.constraint.ConstraintLayout>
```

And a fragment class of our own design like so:

```java
package nyc.c4q.fragmentsarefun;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {

View rootView;
    public MainFragment() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button button = (Button) rootView.findViewById(R.id.next_fragment_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NextFragment nextFragment = new NextFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("main", null);
                nextFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container_framelayout, nextFragment);
                fragmentTransaction.addToBackStack("next");
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }
}
```

And a fragment_next.xml file like below:

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
             xmlns:tools="http://schemas.android.com/tools"
             android:layout_width="match_parent"
             android:layout_height="match_parent"
              android:orientation="vertical"
             tools:context="nyc.c4q.fragmentsarefun.NextFragment">
  
    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="This Is A Brand New Fragment!"
        android:textSize="80sp"/>

</LinearLayout>
```

From this code, we can see a number of basic patterns:

* We must first create a Fragment class of our own with its corresponding xml layout, then instantiate it
* We'll need a FragmentManager object to take care of a number of things under the hood, like where, when, and how to add/replace the fragments
* We'll need a FragmentTransaction object to separate concerns when adding tasks to our transaction, like ```beginTransaction```, ```replace()```, ```addToBackStack()```, ```commit()```, etc.

Intermediate patterns include:

* Creating a MainFragment, and NOT adding it to the BackStack
* Adding subsequent fragments to a BackStack
* Creating Bundle objects to pass values to the next fragment, very much like intent extras between activities
* Using ```setArguments()``` on our Fragment
* Making sure to call ```getActivity()``` before calling ```getSupportFragmentManager()``` when inside a fragment
* Using a ```rootView``` variable to store the fragment for later use after inflation
