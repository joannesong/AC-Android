- title: NYC Big Apps
- tags: java, android, app

# Objectives
- Work on NYC Big Apps project

# Lecture
Today we will be talking about architecture design, using hardware sensors and continue working on Big Apps.

# Architecture Design 
By now we have been working on NYC Big apps for almost a week. Your team should have
- A clear goal of what you are building
- A clear design of each screen you are building
- A clear list of features that are in progress or need to be built
- A clear list of responsibilities who is responsible for what

Part of managing a project is discussing what the code does, instead of talking about how it does it.
Today I am going to describe the project Josiel and I have been working on, along with a description of the architecture.

# Hardware Sensors
Using most hardware sensors in Android is relatively straight forward. Either you use an register an intent receiver that will
receive broadcasts from the sensor, or you pass a Java object to the Andriod system, and it populates that object with relevant
data.

This is not true for the Camera. In Android, the camera is required to draw an image on the screen before a picture is taken.
This requirement prevents code from taking a picture when the camera is not activated.

We will not be writing camera code, but instead be discussing how we would build in this requirement, just like how Android
engineers had to write code to enforce this rule.
