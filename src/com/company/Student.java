package com.company;

//making class abstract: a student is too general! the printStudentInfo() is a pure virtual function, and too general for all sorts of students,
//so in that case we must make the class abstract. see geeks4geeks for more info
public abstract class Student {

    //making final so they cannot be changed later
    protected final String firstName;
   protected   final String lastName;
    protected final String student_ID;
    protected  double GPA;
    protected final boolean hasGraduated;
    protected final String collegeLevel;

    //consturctor
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
