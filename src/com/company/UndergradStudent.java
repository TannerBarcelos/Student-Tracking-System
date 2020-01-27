package com.company;


public class UndergradStudent extends Student {

    //grade level us unique to undergrads: their grade level may differ
    private String GRADE_LEVEL;
    private String gradLevel;       //local to this class: an undergrad will have a grad level [under/grad]

    //sub-class constructor: must call superclass constructor passing corresponding data up the hierarchy chart
    public UndergradStudent(String firstName, String lastName, String studentID,String gradLevel,boolean hasGraduated,double gpa,String gradeLevel) {
        super(firstName, lastName, studentID, gradLevel,hasGraduated,gpa);
        this.GRADE_LEVEL = gradeLevel;
        this.gradLevel = gradLevel;
    }


    public String getUndergradLevel(){
        return this.GRADE_LEVEL;
    }

    //this supports polymorphism: we are overriding the superclass method to invoke similar functionality but on another object!
    @Override
    public String printStudentInfo(){
            //format specifiers and then use the params to be filled into the placeholders
            return String.format("%s:  %s%n%s:  %s%n%s:  %s%n%s: %s%n%s:  %s%n%s:  %s%n%s:  %s%n", "First name",this.firstName,
                    "Last Name",this.lastName,"Student ID",this.student_ID,"Graduate level",this.gradLevel,"Grade Level", this.GRADE_LEVEL,"Graduated",this.hasGraduated,"GPA",this.GPA);
    }

}
