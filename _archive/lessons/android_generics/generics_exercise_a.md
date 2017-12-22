Mastermind Exercise:

Overview of Steps:

Create Models - Create models that encapsulate the logic from the game Mastermind. Requirement: Use generics to allow for Locks that can support different types of inputs: numerical, alphabet, chars, etc.

Create UI - Create a UI that allows you to play a one-way [Mastermind](https://en.wikipedia.org/wiki/Mastermind_(board_game) game against a computer opponent.


This is a perfect opportunity to use Model-View-Presenter (MVP) architecture. You should create a Presenter class that receives user input from the digit buttons. Once enough digits have been collected, the Presenter should use its internal models to submit a guess and calculate a Result. The Presenter calls back to the View. Also, feel free to write unit tests that verify that the correct hint string is returned for the correct input.

Previous Guesses - Add a list of previous guesses to the UI to make it easier to remember what you’ve already guessed.

Independent Study:
Support multiple players and networking.
