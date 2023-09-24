package Oops;

public class DemoMain {
    public static void main(String [] args){
       Student st = new Student("MG",123);
       st.studentName = "Milind";
       st.studentId = "A111";
       st.city = "Pune";
       st.study();
       st.studentDetails();

    }
}
