package Programes;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class logicalDateProblems {
    public static void main(String[] args) {
        Date date = new Date();
       /* System.out.println(date);            // printing system date
        String strDate = date.toString();    // Converting to String
        String s [] =  strDate.split(" ");
        System.out.println(s[0]);
        System.out.println(s[1]);
        System.out.println(s[2]);
        System.out.println(s[3]);
        System.out.println(s[4]);*/

        // Printing Date
        SimpleDateFormat sd = new SimpleDateFormat("d");
        String day = sd.format(date);
        System.out.println(day);

        // Printing Month
        SimpleDateFormat s2 = new SimpleDateFormat("MMMM");
        String month = s2.format(date);
        System.out.println(month);

        //to get the year
        SimpleDateFormat s3 = new SimpleDateFormat("yyyy");
        String year = s3.format(date);
        System.out.println(year);

        //to get the time
        SimpleDateFormat s4 = new SimpleDateFormat("hh:mm:ss");
        String time = s4.format(date);
        System.out.println(time);

        //--------- get date in yyyy-mm-dd format---------------
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println("NextDay = "+LocalDate.now().plusDays(1));
        System.out.println("Next Week ="+LocalDate.now().plusWeeks(1));
        System.out.println("Next Month = "+LocalDate.now().plusMonths(1));
        System.out.println("Next Year = "+LocalDate.now().plusYears(1));


















    }
}