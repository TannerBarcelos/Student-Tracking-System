# Student-Tracking-System

<br>

## Reasoning for the project:
This project was originally developed as a means to learn OOP and Abstraction/Inheritance in Java as my Software Engineering course this semester requires us to learn Java (my background is in C++/Python) however, the further I got into it, the more I started to see the projects potential so I decided to build out a complete console driven application that uses all of Java's OOP functionalities including the super() keyword, abstraction, inheritance and @Overriding methods. 


## Description:

The application starts with asking the user if they have a file to open and edit or a new one they wish to make. Assuming the user knows the applications purpose, they'd answer accordingly, however, the purpose of the application is to allow a user (Target user are school administration offices trying to keep a 'cencus' of their students [i called it a student tracker but a Student Census would be more accurate with further development]). When the user edits a document, the file they chose to open will physcially open up in the default system text-editor to show its contents and then the user would follow along on the console adding new students until they wish to quit. Every entry has try/catch exception handling to keep the program fault-tolerant. 

Now, assuming the user wants to make a new file, they would then enter in a file name for this new file and assuming that file name does not exist, you'd be moved along and allowed to start adding students and keep on doing that till you wanted to quit. Assuming that file exists, an exception for IO would be caught and the program quits and the user would have to restart

This application is a little past its MVP stage, so, after I work on other projects for school these next couple months, I want to come back to clean up any unknown bugs, clean up the code design, etc. However, this application is built to run on MacOS. I will build a function to flag the OS and have it work on Windows as well.

