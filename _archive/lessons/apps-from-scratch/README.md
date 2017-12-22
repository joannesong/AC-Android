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

