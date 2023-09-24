package Programes;

public class CodingString {
    public static void main(String [] args ){
        subStringoFstring();
        comapreString();
    }

    private static void comapreString() {
            String s1 = "hello";
            String s2 = "hell";

            System.out.println("Comparing String : ");
            System.out.println(s1.compareTo(s2));

    }


    static void subStringoFstring(){

        String string, sub;
        int i, c, length;

        string = "I am Milind Ghongade";
        length = string.length();
        System.out.println("Substrings of "+string+" are :-");

        for( c = 0 ; c < length ; c++ )
        {
            for( i = 1 ; i <= length - c ; i++ )
            {
                sub = string.substring(c, c+i);
                System.out.println(sub);
            }
        }
    }
}

