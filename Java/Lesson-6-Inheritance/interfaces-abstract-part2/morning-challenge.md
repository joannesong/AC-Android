# Morning Challenge :coffee:

1. Create a new IntelliJ project: 

    - Open IntelliJ, click "Create New Project" > "Next" > check to select "Create project from template, Command Line App".
    
    - Name your project `EX_09-04`.
    
    - Set the base project location as `~/Desktop/accesscode/EX_09-04`.
    
    - Set the base package as `nyc.c4q.yourname`. Click 'Finish' to create the project.
    
2. In your project, create a new Java class called `Student`. 

3. Build out your `Student` class to contain `private` fields for a **first name**, **last name**, **ID number** and **favorite food**. Create a getter and setter method for each field.

4. Create a constructor for your class.

5. Write a static method called `checkSameFavoriteFood` which accepts as input two `Student` instances and checks if they have the same favorite food. The method should return a boolean value.

6. When you are finished, create a new repository on GitHub called `EX_09-04` (do not select the option to create the repo with a README). Using terminal, initialize the project folder as a git repository (`git init`), add a `.gitignore` file (see below). Set the remote origin to your new GitHub repository (`git remote add origin <GITHUB URL>`).

7. Add (`git add .`), commit (`git commit -m "Add morning challenge"`) and push (`git push -u origin master`) your work. Submit a link to your new repo using the Morning Challenge Google Form (check Slack!).

.gitignore :

```
.DS_Store
out/
*.class
```
    
