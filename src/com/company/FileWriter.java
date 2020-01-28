package com.company;

import java.io.File;  					// Import the File class
import java.io.IOException;  			// Import the IOException class to handle errors


//this class is completely independent of a student. It is only used for the file handling portion of this project: it can, however use any class from this package, so, for the constructors, when we overload
//for both undergrad or grad students, we can use those objects as a means of overloads

public class FileWriter {
	
	//create a new file to write to
	public void createFile() {
		 try {
		      File myObj = new File("filename.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}

