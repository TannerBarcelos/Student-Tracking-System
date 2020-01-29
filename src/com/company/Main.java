package com.company;

import java.awt.*;	//for desktop
import java.io.*;		//for files
import java.util.*;		//for everything else in this file

public class Main {

    public static void main(String[] args) throws IOException {	//throw exception immediately to cast the logic in an IO error handling state INCASE we encounter some exceptions

    	//create a linked list to distribute the students in the system: of type student
        LinkedList<Student> linked_list = new LinkedList<>();
        
        //create a scanner object for input
        Scanner input = new Scanner(System.in);
        
        
        //Creating file objects globally so that the student entry portion can access these objects
        
        //file pbject for the file the user wants to EDIT NOT CREATE
        File fileForEdits = null;
        
        //file object for writing
        File file = null;	//defined in the else block for a new file

        
        //new file being writer object: used as a means of storing the file path retrieved from program opening
        String fileName = null;
        
        String fileToOpen = null;
        
        //path of directory where files are stored
        final String abs_path = "/Users/tannerbarcelos/OneDrive/DEV/Java/Projects/Student Database/textOut/";
        
        
        System.out.println("Open existing file or start new tracker? The directory of files is within this applications root...[1 for open, 2 for new]\n");
        int val = input.nextInt();

        
        //TODO: Make a directory for files and go to that path: google up info on how to cd to that directory: i am assuming just make a string of the path that folder resides in
        
        if(val == 1) {
        	input.nextLine();	//reset
        	System.out.println("Please enter the file you wish to open...");
        	fileToOpen = input.nextLine().toLowerCase();
        	
        	//copy the path of the text folder to the file to open via user entry
        	fileToOpen = abs_path + fileToOpen + ".txt";	//concatenate.txt to it for correctness
        	
        	
        	//try to open this file (always try when doing forms of work that may fail (input, file opening, reading, etc.)
        	try {
				FileReader inFile = new FileReader(fileToOpen);
				System.out.println("File successfully opened... Here are its contents\n\n");	//will be ignored if not and jump to catch
				
				//write to file if user wished to
				try {
					
					//check for certified desktop
					if(!Desktop.isDesktopSupported()){
			            System.out.println("Desktop is not supported");
			            //return;
			        }
					
					//create a file object with the fileToOpen string that was created from the user input
					fileForEdits = new File(fileToOpen);

					
					//open the file physically
					Desktop desktop = Desktop.getDesktop();
					if(fileForEdits.exists()) {	//check if it exists
						desktop.open(fileForEdits);	//open it
					}
					
				    } catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
		        
		        System.out.println("\n\nPress enter to continue\n");
		        input.nextLine();
		        
		        //globalize decision to use in the next block
		        int dec;
		        while(true) {
		        	try {
		        		System.out.println("Would you like to edit this file or quit ? [1 to edit, 2 to quit]\n");	//invoke a way that will open the file automated when 2 is entered
				        dec = input.nextInt();
				        if(dec == 1 || dec == 2) {
				        	break;
				        }
		        	}catch(InputMismatchException e) {
		        		System.out.println("Only enter 1 or 2");
		        	}
		        	
		        }
		        
		        if(dec == 2) {
		        	//entered 2 to quit: so quit
	        		System.exit(1);
		        }
		        //else, user wants to edit file so TODO: build out the functionality to edit the file (probably will involve turning the object methods below to be in a function)
		        else {
		        	File appendFile = new File(fileToOpen);
					
					//call write to file
		        	
		        	//TODO: this is overriding the contents that already exist! So, we must find the end of line and write at that point
					writeFile(linked_list,appendFile);
		        	
		        	
		        }

		        
			} catch (FileNotFoundException e) {
				System.out.println(fileToOpen + " not found. Please restart the program\n");
				//e.printStackTrace();
				System.exit(1);
			} 
        	//also catch the possibility of IOException: cannot read
        	catch (IOException e) {
				System.out.println("Error reading data in file. Please restart program\n");
				//e.printStackTrace();
				System.exit(1);
			}
        }
        
        //else, file does not exist, so start a new one and then jump to entering students (ask first if theyd like to do that immediately)
        else {
        	//create the file: if its a duplicate, make a new one
        	while(true) {
        		
        		//input.nextLine();	//reset the scanner for proper inputs
            	System.out.println("What would you like to name this file?");
            	fileName = input.nextLine();
            	
            	//go to the path and create the file with the path strings
            	fileName = abs_path + fileName + ".txt";
            	
            	
        		//open text file
                try {
                	//make a new file object and try to open it: append . txt to it
                	file = new File(fileName);
                	if(file.createNewFile()) {
                		System.out.println(file.getName() + " successfully created. Press enter to continue...\n");
                		//write to file
                		writeFile(linked_list,file);
                		break;
                	}
                }
                //if it cannot be open, display an error: will catch this
                catch(IOException e) {
                	System.out.println(fileName+" already exists. Please try again Or restart program to edit " + fileName);	//loops back around for another round : if the file exists
                	//e.printStackTrace();	
                }
               // break;
            }
        }
        	input.close();//close the scanner
}
    
    //takes in a linked list to add to and a file object that i will be writin to
    public static void writeFile(LinkedList<Student>linked_list, File file) {
    	
    	Scanner input = new Scanner(System.in);
    	input.nextLine();	//wait for user to press enter from the file creation above
        
        System.out.println("Please add students to this file. When done, follow the on-screen prompt to quit\n");
        
        
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

            try {
            	
				FileWriter writer = new FileWriter(file,true);	//create the new file writer, passing the file object in from function parameter and set to 'true' for append mode! (will handle edit case)
				
				BufferedWriter bw = new BufferedWriter(writer);	//create a buffer writer for Java 7+ recommendation AND performance
				
	            
	            //write all nodes to the file
	            for(Student i : linked_list) {
	            	//extract the students info on this element: remember, the printStudentInfo is an abstract method that returns a formatted string on the object that we are working on! This is so easy
	            	String stud = i.printStudentInfo();
	            	//write it
	            	bw.write(stud + "\n\n");
	            }
	            bw.close();
	            System.out.println("Thank you. Goodbye\n");
	            System.exit(1);
			}
            //catch IO errors if it cannot open
            catch (IOException e) {
				System.out.println("Failed to write to file. Restart program\n");
				//e.printStackTrace();	//not interested in printing the error. just catch it and move on
			}
            
          }

        }
    }
}
