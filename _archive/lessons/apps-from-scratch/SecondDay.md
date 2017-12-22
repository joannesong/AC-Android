- title: Building an App from Scratch
- tags: java, android, app

# Objectives
- Exposure to a realistic interview assignment

# Note
The server for this lesson is located at https://github.com/JsjRoboticsClassroom/Nov14thSever

# Lecture
Today you will be building an Android app, that must communicate with a JSON
server, and display content on the screen depending on the response from the
server. This is your first exposure to an interview assignment, which many
companies make potential hires complete. It is expected that by the end of this
program, all graduates will be able to complete this task in about 3 hours.
Students who can not do so risk not graduating, as this is the bare minimum
requirements of any Android job. For this first time, you will have access to
the instruction team and 6 hours (2 class periods) to complete the assignment.


# Assignment
Write an Android app that connects to your instructors machine (Ask for the ip
address).

The app should have two Activites, one named HomeScreen, and one named
DetailScreen.

The HomeScreen activity should have 1 fragment. This fragment will have a text
view and a recycler view. The content should be populated from {instructor_website}/homescreen
- The display object will hold the text and text color to display. The text color
will be one of colorPalette objects returned.
- The colorPalette list will hold the colors to be displayed in the recycler view
- Clicking on an option in the recycler view will navigate to the DetailScreen
activity.

The DetailScreen activity should have 1 fragment. This fragment will have a TextView with the background color, set to the color that was selected on the Homescreen.
The text in the TextView should be populated from {instructor_website}/{color_name}.


## Part 1 - Parsing HomeScreen JSON offline
Here are 2 example respones from {instructor_website}/homescreen

```
{
	"display": {
		"text": "Boy this is easy",
		"color": "Wheat"
	},
	"colorPalette": [{
		"name": "Crimson",
		"value": "DC143C"
	}, {
		"name": "SpringGreen",
		"value": "00FF7F"
	}, {
		"name": "Wheat",
		"value": "F5DEB3"
	}]
}
```

```
{
	"display": {
		"text": "Who writes this stuff??",
		"color": "DarkSalmon"
	},
	"colorPalette": [{
		"name": "Wheat",
		"value": "F5DEB3"
	}, {
		"name": "DarkSalmon",
		"value": "E9967A"
	}]
}
```

Notice how the response includes a display object, and a colorPalete list. The colorPalette list will change with each call. The color name and text for your HomeScreen TextView is specified in the display object. The hex value for the color will always be in the colorPalette list.

Your HomeScreen RecyclerView should contain all the colors specified in the colorPalette response. Note the size of the list changes each time.

To complete Part 1 you should have

- A HomeScreen Activity
- A HomeScreen Fragment
- A TextView and RecyclerView displayed
- A json object made from the sample response
- Running your app should display the correct screen


## Part 2 - Displaying the DetailScreen
Now build the click listeners to navigate from the HomeScreen Activity to the DetailScreen Activity. Each view in your RecyclerView should be clickable. Each view needs to send the color that it displays to the DetailScreen Activity.

To complete Part 2 you should have

- A DetailScreen Activity
- A DetailScreen Fragment
- A DetailScreen TextView displayed 
- Clicking on a view in the HomeScreen RecyclerView should launch the DetailScreen Activity with the TextView background color set.

## Part 3 - Parsing DetailScreen JSON Offline
Here is an example response from {instructor_computer}/wheat 
```
{"value":"hay and straw"} 
```
Here is an example response from {instructor_computer}/crimson 
```
{"value":"cranberries and plums"}
```
When your DetailScreen Activity is displayed, it will need to download json from {instructor_computer}/{color_name} and display the text received. With these responses, you can test your DetailScreen Activity by selecting the wheat and crimson colors on the HomeScreen.

To complete Part 3 you should have

- A json object that represents wheat response
- A json object that represents crimson response
- The text view should display the correct text depending on which color was selected.

## Part 4 - Downloading JSON with Retrofit
Finally, setup Retrofit in your app, to download the json strings from the instructor machine. Use these strings to feed the previous parts of the app.


