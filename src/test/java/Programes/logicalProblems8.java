package Programes;

public class logicalProblems8 {

    public static void main(String[] args) {
        // 66 SWAP NUMBERS
        swap2Numbers(10, 20);

        //  67  VOWEL AND CONSTANT COUNT
        vowelAndConsonant();

        //  68  LARGEST NUMBER AMONG THREE
        largestAmongThree(5, 10, 15);

        //  69   POSITIVE OR NEGATIVE NUMBER
        positiveOrNegative(12);

        // 70 ALPHABET CHECK
        alphabetCheck();

        // 71 SUM OF NATURAL NUMBERS
        sumOfNaturalNumbers(100);

        //  72 FACTORIAL NUMBERS
        factorialNumber(5);

        //  73  FIBONACCI'S SERIES
        fibionacciSeries(8);

        // 74  A TO XZ CHARACTERS
        printCharectors();

        //  75 NUMBER OF DIGIT COUNT
        numberCount(2355);

        //  76 REVERSE NUMBER
        reverseNumber(1234);

        //  77 ARMSTRONG & PALINDROME
        armstrongNumber(153);

        //  78  FACTORS NUMBER
        factorsNumber();

        // 79   PRIME NUMBERS
        primeNumber(31);

        //  80  PRIME NUMBER SPECIFIC INTERVAL
        primeNumberInterval();

        //  81 PALINDROME NUMBER 
        palindromeNumber();

    }

    private static void palindromeNumber() {
        int num = 3453;
        int rev = 0;

        int orgNUm = num;

        while (num != 0) {
            int n = num % 10;
            rev = rev * 10 + n;
            num = num / 10;
        }
        System.out.println("Reversed Number : " + rev);
        if (orgNUm == rev) {
            System.out.println("Number is Palindrome : " + rev);
        } else {
            System.out.println("Number is  Not Palindrome : " + rev);

        }
    }

    private static void primeNumberInterval() {
        int low = 10;
        int high = 50;

        while (low < high) {
            boolean flag = false;
            for (int i = 2; i <= low / 2; i++) {
                if (low % i == 0) {
                    flag = true;
                    break; // Exit the loop early if a factor is found
                }
            }
            if (!flag) {
                System.out.println(low);
            }
            low++; // Move to the next number in the range
        }
    }


    private static void primeNumber(int num) {
        boolean flag = false;

        for (int i = 2; i <= num / 2; i++) {
            if (num % 1 == 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println(num + " Number is Prime ");
        } else {
            System.out.println(num + " Number is Not Prime ");
        }
    }

    private static void factorsNumber() {
        int a = 100;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                System.out.println(i + " ");
            }
        }
    }

    private static void armstrongNumber(int num) {
        int actualNum = num;
        double result = 0;
        while (actualNum != 0) {
            int n = actualNum % 10;
            result = result + Math.pow(n, 3);
            actualNum = actualNum / 10;
        }
        if (result == num) {
            System.out.println("Palindrome Number = " + num);
        } else {
            System.out.println("Not a Palindrome = " + num);
        }
    }


    private static void reverseNumber(int nums) {
        int rev = 0;
        while (nums != 0) {
            int n = nums % 10;
            rev = rev * 10 + n;
            nums = nums / 10;
        }
        System.out.println("Reversed Number = " + rev);
    }


    private static void numberCount(int num) {
        int count = 0;
        while (num != 0) {
            num = num / 10;
            ++count;
        }
        System.out.println("Number of Digit Count = " + count);
    }

    public static void printCharectors() {
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.println("Charector = " + c);
        }
    }


    private static void fibionacciSeries(int num) {
        int a = 0, b = 1;
        int sum = 0;
        for (int i = a; i <= num; i++) {
            sum = a + b;
            a = b;
            b = sum;
            System.out.println("fibionacciSeries  = " + sum);
        }
    }

    private static void factorialNumber(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial Number of " + num + " is  = " + fact);
    }

    private static void sumOfNaturalNumbers(int num) {
        // 1
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum = sum + i;
        }
        System.out.println("Sum Of Natural Number = " + sum);

        // 2
        int sum1 = 0;
        int k = 1;
        while (num >= k) {
            sum1 = sum1 + k;
            k++;
        }
        System.out.println("Sum Of Natural Number = " + sum);
    }

    private static void alphabetCheck() {
        char c = 'B';
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            System.out.println(c + " is an Alphabet ");
        } else {
            System.out.println(c + " Not an Alphabet ");
        }
    }

    private static void positiveOrNegative(int number) {
        if (number < 0.0) {
            System.out.println(number + " is Negative ");
        }
        if (number > 0.0) {
            System.out.println(number + " is Positive ");
        }
    }

    private static void largestAmongThree(int x, int y, int z) {
        if (x > y && x > z) {
            System.out.println(" X is Large = " + x);
        } else if (y > z) {
            System.out.println(" Y is Large = " + y);
        } else {
            System.out.println(" Z is Large = " + z);
        }
    }

    private static void vowelAndConsonant() {
        // a e i  o  u
        char c = 'b';
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            System.out.println("Char is  vowel = " + c);
        } else {
            System.out.println("Char is a Consent = " + c);
        }
    }

    private static void swap2Numbers(int a, int b) {
        System.out.println("Before Swapping " + a + "  And " + b + " ");
        //  1
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("After  Swapping " + a + "  And " + b + " ");
        // 2
        a = a - b;
        b = a + b;
        a = b - a;
        System.out.println("After  Swapping " + a + "  And " + b + " ");
        //


    }

}
