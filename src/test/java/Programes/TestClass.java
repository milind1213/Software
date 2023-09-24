package Programes;

import org.testng.annotations.Test;

public class TestClass {
    @Test(priority = 1)
    public void positiveOrNegative() {

        int number = -1;

        if (number < 0.0) {
            System.out.println(number + " is Negative ");
        }
        if (number > 0.0) {
            System.out.println(number + " is Positive ");
        }
    }

    @Test(priority = 2)
    public void alphabetCheck() {
        char c = 'B';
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            System.out.println(c + " is an Alphabet ");
        } else {
            System.out.println(c + " Not an Alphabet ");
        }
    }

    @Test(priority = 3)
    public void sumOfNaturalNumbers() {
        int num = 100;
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum = sum + i;
        }

        System.out.println("Sum Of Natural Number = " + sum);
        // WIth While Loop
        int n = 100;
        int sums = 0;
        int k = 1;
        while (k <= n) {
            sums = sums + k;
            k++;
        }
        System.out.println("Sum Of Natural Number = " + sums);
    }

    @Test(priority = 4)
    public void factorial() {
        int num = 5;
        int fact = 1;

        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial Number of " + num + " is  = " + fact);
    }

    @Test(priority = 5)

    public void mutiplicationTable() {
        int num = 2;
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }

    @Test(priority = 6)
    public void fibionacciNumber() {
        int num = 8, index1 = 0, index2 = 1, sum = 0;

        for (int i = 0; i <= num; i++) {
            sum = index1 + index2;
            index1 = index2;
            index2 = sum;

            System.out.println("fibionacciSeries  = " + sum);

        }
    }

    @Test(priority = 7)
    public void allCharectoers() {
        char c;
        for (c = 'a'; c <= 'z'; c++) {
            System.out.println("Charector = " + c);
        }
    }

    @Test(priority = 8)
    public void numberCount() {
        int num = 22352;
        int count = 0;

        while (num != 0) {
            num = num / 10;
            ++count;
        }
        System.out.println("Number of Digit Count = " + count);
    }

    @Test
    public void reverseNumber() {
        int nums = 4321;
        int rev = 0;

        while (nums != 0) {
            int n = nums % 10;
            rev = rev * 10 + n;
            nums=nums/10;
        }
        System.out.println("Reversed Number = "+ rev);
    }

    


}



