package com.company;


import java.util.Scanner;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        //create a linked list to distribute the students in the system: of type student!!!
        LinkedList<Student> linked_list = new LinkedList<>();

        //todo: implement error handling

        while(true) {

            //create a scanner object for input
            Scanner input = new Scanner(System.in);

            //get users first name
            System.out.println("Hello, what is your first name?");
            String firstName = input.nextLine().toLowerCase();

            //get users last name
            System.out.println("What is your last name?");
            String lastName = input.nextLine().toLowerCase();

            //get users student ID
            System.out.println("What is your student ID?");
            String studentID = input.nextLine().toLowerCase();

            //get gpa
            System.out.println("Please enter your gpa [x.xx]");
            double GPA = input.nextDouble();

            //pick up new line to reset scanner to next input : this is important because when going from reading strings to numbers,
            //when a number is read, the scanner stays on that same line, so we must completely reset that scanner to a new line to accomodate
            //for a new string input!
            input.nextLine();

            //get users grad level: undergrad or graduate
            System.out.println("What is your graduate level [undergraduate/graduate]");
            String gradLevel = input.nextLine().toLowerCase();


            //if undergrad, get level. else, ignore and pass grad to object creation
            if (gradLevel.equals("undergraduate")) {

                System.out.println("Please enter your year [freshman, sophomore, junior, senior] in that format..");
                String gradeLevel = input.nextLine().toLowerCase();

                //get if user has graduated
                System.out.println("Have you graduated [true/false]");
                String hasGraduated = input.nextLine().toLowerCase();   //will need to convert to boolean or change data typoes of classes to string
                boolean graduated = hasGraduated.equals("true");    //assign boolean conversion to if user graduated or not (easy one liner)

                UndergradStudent under = new UndergradStudent(firstName, lastName, studentID, gradLevel, graduated, GPA, gradeLevel);
                linked_list.push(under);
                }
            else {

                //get if user has graduated
                System.out.println("Have you graduated [true/false]");
                String hasGraduated = input.nextLine().toLowerCase();   //will need to convert to boolean or change data typoes of classes to string
                boolean graduated = hasGraduated.equals("true");    //assign boolean conversion to if user graduated or not (easy one liner)

                GradStudent grad = new GradStudent(firstName, lastName, studentID, gradLevel, graduated, GPA);
                linked_list.push(grad);
            }
            System.out.println("Continue [y/n]");
            String cont = input.nextLine().toLowerCase();

            //check continuation
            if (cont.equals("n")) {
            	input.close();//close the scanner
                break;
            }
        }

        //call display
        displayListItems(linked_list);
    }


    //display function for the linked list
    public static void displayListItems(LinkedList<Student>stud){
        if(stud.isEmpty()){
            System.out.println("List is empty. Goodbye");
        }else{
            //for-each loop
            for(Student i : stud){
                System.out.println(i.printStudentInfo());
            }
        }
    }





}
//NOTES:

    /*
    TODO:
        1) Implement the error handling for menu dialog
        2) Build out a file handling class. That is, when the program is finished, it will write all the students to a text file. The user is prompted
        up front if they want to open a file (will be saved by date) or start a new one with new students. Whenever the user finishes working with
        students, the file will be re-written to the directory where the files are saved (desktop) and exist. If the file never existed, upon the user
        selectin 'new file' in the menu, a new file will be created and written to from the linked list, whenever the user is finished adding students
        3)Implement the ability to add a student, edit a student and delete a student, add to existing file, start new file, etc. File implementations
        will be done in its own class, but to add/change/delete a student will be an enumerated and then invoke functions locally in main file (no need to put
        these methods in student class, as when the student object is made, we will already know all the students that exist)
     */

