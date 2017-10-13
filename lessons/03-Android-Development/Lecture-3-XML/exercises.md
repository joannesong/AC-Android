## Exercises

For each of the following exercises, create a new XML resource file in your `res/layout` directory (e.g. `exercise_one.xml`). You can test each layout by changing the `setContentView(R.layout.exercise_one)` line in your `MainActivity.java` file and running the app.

### Q1) 

1) Create new XML resource file `exercise_one.xml`. Add a `LinearLayout` as the root element, with orientation set to vertical.

2) Add three `TextViews` as child views to the `LinearLayout`. Give them ids. For all three, set `layout_width` and `layout_height` to `wrap_content` and set the text to `TextView One`, `TextView Two` and `TextView Three` respectively. Set the background color to `#ff0000`, `#ffff00` and `#0000ff` respectively. Run the app and observe the layout.

3) Add 40dp padding to each of the `TextViews`. Run the app and observe the layout.

4) Add 40dp margin to each of the `TextViews`. Run the app and observe the layout.

5) Change the layout gravity on the top `TextView` to top. Change the layout gravity on the middle `TextView` to center. Change the layout gravity on the bottom `TextView` to bottom. Run the app and observe the layout.

6) Remove the layout gravity attributes from the `TextViews`. Change the gravity on the `LinearLayout` to bottom. Run the app and observe the layout.

### Q2) 

1) Create new XML resource file `exercise_two.xml`. Add a `LinearLayout` as the root element, with orientation set to horizontal.

2) Add three `Buttons` as child views to the `LinearLayout`. Give them ids. For all three, set `layout_width` to 0dp and `layout_height` to `match_parent`. For all three, set the `layout_weight` to 1. Set the text to `Button One`, `Button Two` and `Button Three` respectively. Set the background colors to [different colors of you choice](http://www.w3schools.com/colors/colors_picker.asp). Run the app and observe the layout.

3) In your activity's Java file, use `findViewById()` to get a reference to each of the buttons. Set click listeners on each of the buttons that display a Toast with the button's text.

### Q3) 

1) Create new XML resource file `exercise_three.xml`. Add a `RelativeLayout` as the root element.

2) Inside of the `RelativeLayout`, add child views to build a layout with the same structure as the calculator screen below. You can use a `TextView` for the result display and a `Button` for each of the calculator buttons. Don't worry about adding the "three dots" menu icon or perfecting the colors or fonts -- just focus on positioning and sizing the child views.

<img src="calculator.png">
