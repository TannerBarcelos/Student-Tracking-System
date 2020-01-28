package com.company;

import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

    	//create a linked list to distribute the students in the system: of type student
        LinkedList<Student> linked_list = new LinkedList<>();
        
        //create a scanner object for input
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("Open existing file or start new tracker? [1 for open, 2 for new]\n");
        int val = input.nextInt();

        
        if(val == 1) {
        	input.nextLine();	//reset
        	System.out.println("Please enter the file you wish to open...");
        	String fileToOpen = input.nextLine().toLowerCase();
        	fileToOpen = fileToOpen + ".txt";	//append .txt to it for correctness
        	
        	//try to open this file
        	try {
				FileReader inFile = new FileReader(fileToOpen);
				System.out.println(fileToOpen + " successfully opened... Here are its contents\n\n");	//will be ignored if not and jump to catch
				
				// Always wrap FileReader in BufferedReader.
		        BufferedReader bufferedReader = new BufferedReader(inFile);
		        
		        String line = null;
		        
		        //read the contents and display them in console
		        while((line = bufferedReader.readLine()) != null) {
		        	System.out.println(line);
		        }
		        
		        System.out.println("Press enter to continue\n");
		        
		      //close the buffer
	        bufferedReader.close();
		        
			} catch (FileNotFoundException e) {
				System.out.println(fileToOpen + ".txt " + "not found. Please double check the file exists or make a new file by restarting the program");
				e.printStackTrace();
			} 
        	//for the while loop: needs its own catch
        	catch (IOException e) {
				System.out.println("Error reading data in file\n");
				e.printStackTrace();
			}
        	
        	
        }
        
        //else, file does not exist, so start a new one
        else {
        	input.nextLine();	//reset the scanner for proper inputs
        	System.out.println("What would you like to name this file?");
        	String fileName = input.nextLine();
        	
        	
        	while(true) {
        		//open text file
                try {
                	//make a new file object and try to open it: append . txt to it
                	File file = new File(fileName+".txt");
                	if(file.createNewFile()) {
                		System.out.println(file.getName() + " successfully created. Press enter to continue...\n");
                	}
                	break;
                }
                //if it cannot be open, display an error
                catch(IOException e) {
                	System.out.println(fileName+".txt already exists. Please try again Or restart program to edit " + fileName + ".txt\nn");	//loops back around for another round : if the file exists
                	e.printStackTrace();	
                }
            }
        	}
        	
        	
        
        
        input.nextLine();	//wait for user to press enter from the file creation above
        
        
        
        
        //variables initialized outside the scope of the while,try's so they are global and can be used within nested try/catch scopes or in the loop. This ensures object is made correctly
        String firstName = "";
        String lastName = "";
        String gradLevel = "";
        String studentID = "";
        String cont = "";
        double GPA = 0.00;
        
        

        while(true) {

            //get users first name: do not accept strings that are empty or less than 1 character
        	while(true) {
        		System.out.println("What is your first name?");
                firstName = input.nextLine().toLowerCase();
                if(firstName.length() < 2 || firstName.isEmpty()) {
                	System.out.println("First name must be two or more characters AND not empty\n");
                	//input.nextLine();	//reset scanner
                }else {
                	//input was valid: break
                	break;
                }
        	}
        	
        	//get users last name: do not accept strings that are empty or less than 2 characters
        	while(true) {
                System.out.println("What is your last name?");
                lastName = input.nextLine().toLowerCase();
                if(lastName.length() < 2 || lastName.isEmpty()) {
                	System.out.println("Last name must be two or more characters AND not empty\n");
                }else {
                	break;
                }
        		
        	}

            //get users student ID : make sure it is 6 characters (no more, no less, and the first two characters are alphabetical)
        	while(true) {
        		System.out.println("What is your student ID?");
                studentID = input.nextLine().toLowerCase();
                
                //convert to array to check first two characters are alphabetical
                String [] charOf = studentID.split("");
                
                //TODO: There is a bug here where if the length is correct, it ommits the check for chars at [0] and [1]
                
                if((studentID.length() < 6 || studentID.length() > 6)) {
                	System.out.println("Student ID MUST be 6 characters long\n");
                }
                
                //check first two characters are alphabetical using regex: regex parameter is a string array of chars a-z (see geeksforgeeks)
                if(!(charOf[0].matches("[a-z]") || charOf[1].matches("[a-z]"))) {
                	System.out.println("First two charaters of student ID must be alphabetical\n");
                }	
                else {
                	break;
                }
        	}
            
           
            //for nice flow, loop until the user enters in the correct format
            while(true)
            	try {
            		//get gpa
            		System.out.println("Please enter your gpa [x.xx]");
            		GPA = input.nextDouble();  
            		break;	//if input was correct format
            	}
            	//if the input is not a double, catch and return
            	catch(InputMismatchException e) {
            		System.out.println("Please only enter a numerical value in the form of x.xx");
            		input.nextLine();	//reset the scanner to avoid infinite loop
            	}
            

            //pick up new line to reset scanner to next input: different type inputs will not reset scanner to new line, so this i sa msut
            input.nextLine();
            
            //check if user entered in only two choices: undergrad or grad
            while(true) {

                //get users grad level: undergrad or graduate
                System.out.println("What is your graduate level [undergraduate/graduate]");
                gradLevel = input.nextLine().toLowerCase();
                
                if(gradLevel.equals("undergraduate") || gradLevel.equals("graduate")) {
                	break;
                }else {
                	System.out.println("Only Undergraduate or Graduate level allowed\n");
                }
            }
            

            //if undergrad, get level. else, ignore and pass grad to object creation
            if (gradLevel.equals("undergraduate")) {

                System.out.println("Please enter your year [freshman, sophomore, junior, senior] in that format..");
                String gradeLevel = input.nextLine().toLowerCase();

                //get if user has graduated
                System.out.println("Have you graduated [true/false]");
                String hasGraduated = input.nextLine().toLowerCase();   //will need to convert to boolean or change data typoes of classes to string
                boolean graduated = hasGraduated.equals("true");    	//assign boolean conversion to if user graduated or not (easy one liner)

                UndergradStudent under = new UndergradStudent(firstName, lastName, studentID, gradLevel, graduated, GPA, gradeLevel);
                linked_list.push(under);
                }
            
            if (gradLevel.contentEquals("graduate")){
                //get if user has graduated
                System.out.println("Have you graduated [true/false]");
                String hasGraduated = input.nextLine().toLowerCase();   //will need to convert to boolean or change data types of classes to string
                boolean graduated = hasGraduated.equals("true");    //assign boolean conversion to if user graduated or not (easy one liner)

                GradStudent grad = new GradStudent(firstName, lastName, studentID, gradLevel, graduated, GPA);
                linked_list.push(grad);
            }
            


            while(true) {
            	System.out.println("Continue [y/n]");
            	cont = input.nextLine().toLowerCase();

                if(!(cont.equals("y") || cont.equals("n"))) {
                	System.out.println("Please only enter y to continue or n to quit\n");
                }else {
                	break;
                }
                
            }
            
          //check continuation for main student entry loop
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
