package com.company;

import org.jetbrains.annotations.Contract;

import java.util.Scanner;

//making class abstract: a student is too general! There are many types of students, so, we can abstract what it means to be a student and deal
//with individual type of student details in sub-classes.
// We did implement some basic getters in this class as every student will share the general properties of a name, ID, grad status etc.
//however, a student is not a grad student! A grad student is a student however, so, we cant implement methods in this class for grad students as a student is
//too general.
public abstract class Student {

    //making final so they cannot be changed later
    protected final String firstName;
   protected   final String lastName;
    protected final String student_ID;
    protected  double GPA;
    protected final boolean hasGraduated;
    protected final String collegeLevel;

    //constructor
    @Contract(pure = true)
    public Student(String firstName, String lastName, String studentID, String gradLevel, boolean hasGraduated, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.student_ID = studentID;
        this.collegeLevel = gradLevel;
        this.hasGraduated = hasGraduated;
        this.GPA = gpa;
    }

    //getters: all the data will be passed into the constructor of the corresponding object:
    //the superclass will retrieve all that data so that subclasses can have properly working inherited methods

    //client will be menu driven and objects will be created based off what user selects: undergrad or grad

    //good engineering practice: make getters for all superclass private members such that, we ensure safety on the class members BUT can still get to them with a getter

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getStudentID(){
        return this.student_ID;
    }

    public String getGraduated(){
        return this.collegeLevel;
    }

    public boolean hasGraduated(){
        return this.hasGraduated;
    }

    public double getGPA(){
       return this.GPA;
    }


    public String printStudentInfo(){
        //format specifiers and then use the params to be filled into the placeholders
        return String.format("%s:  %s%n%s:  %s%n%s:  %s%n%s:  %s%n%s: %s%n%s:  %s%n", "First name",this.firstName,
                "Last Name",this.lastName,"Student ID",this.student_ID,"Graduate level", this.collegeLevel,"Graduated",this.hasGraduated,"GPA",this.GPA);
    }
}
