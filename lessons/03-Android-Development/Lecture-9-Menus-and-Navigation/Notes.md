
Notes App
=========

Project url: github.com/c4q/notesapp

[Add image of UI here]

Github:
- fork off of the *dev* branch
- create pull requests to merge your changes
- be sure your branch is update to upstream/dev before creating pull request
```
git clone url-of-your-fork
git checkout dev # to checkout dev branch
git checkout your-branch # to checkout your branch from dev
```

NotesList activity should (intents, menus, activities):
- displays a list of note items. Each note item has a title and first line of content
- clicking on a note item opens it in detail view
- long pressing on a note item shows option to archive, edit or delete it
- It contains an "Add Note" button for adding new note

NoteDetail activity should (intents, menus, activities):
- allow user to enter a note with a title and a body. 
- It should have a button in the toolbar for "Save"ing a note
- On save, user is directed back to the NotesList and new note is added to the list.

NotesManager (threads, xml and serialization):
- A java class that maintains the list of notes
- When app starts, it reads notes from an xml file
- When user adds new notes, it adds the notes to an internal collection
- When app exits, it writes all notes back to an xml file
- maintains an archive list too

Resources and SharedPreferences (resources, intents, shared preferences)
- create all the strings that would be used by the app
- create launcher icon and other drawable resource to be used by the app
- create a Settings activity with option to auto-delete old notes
