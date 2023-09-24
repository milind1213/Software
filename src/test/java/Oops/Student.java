package Oops;

public class Student {
    String studentName;
    String studentId;
    String city;


    public Student(){
        System.out.println("Object loading : Non Parameterized  ");
    }

    public Student(String str){
        System.out.println("Object loading : Parameterized  ");
    }

    public Student(String str ,int num){
        System.out.println("Object loading :  Double Parameterized  ");
    }

    public void study(){
        System.out.println(studentName + " Is Studying");
    }
    public void studentDetails(){
        System.out.println("Student Id Is "+studentId);
        System.out.println("Student City is "+city);
    }
}
