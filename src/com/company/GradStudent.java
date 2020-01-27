package com.company;


//a grad student is independent of an undergrad! So we have no need to extend from UnderGrad
public class GradStudent extends Student {
    public GradStudent(String firstName, String lastName, String studentID,String gradLevel,boolean hasGraduated,double gpa) {
        super(firstName, lastName, studentID,gradLevel,hasGraduated,gpa);
    }

    /*getters for name, ID, etc. exist in super class. we are only interested in overriding
    printStudentInfo and also some other methods we may want to build out (will decide on fly)
     */

    @Override
    public String printStudentInfo(){
        //format specifiers and then use the params to be filled into the placeholders
        return String.format("%s:  %s%n%s:  %s%n%s:  %s%n%s:  %s%n%s: %s%n%s:  %s%n", "First name",getFirstName(),
                "Last Name",getLastName(),"Student ID",getStudentID(),"Graduate level",getGraduated(),"Graduated",hasGraduated(),"GPA",getGPA());
    }

}
