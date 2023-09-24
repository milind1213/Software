package Programes;

import org.testng.annotations.Test;

import java.util.Arrays;

public class logicalProblems2 {
    public static void main(String[] args) {
        // 14. Find Max Number from three
        int a1 = 10, b1 = 20, c1 = 30;
        System.out.println("Maximum Number from " + a1 + " ," + b1 + " ," + c1 + " is = " + maxMinNumfromInt(a1, b1, c1));

        // 15. Fibonacci Series
        System.out.println("Fibonacci Numbers :" + fibo(9));
        // 16. Fibonacci Series
        int n = 8;
        System.out.println("Fibonacci Numbers :" + fibonacciNUmber(n));

        // 17  Number of Occurrence in integer
        int num = 141424;
        int occurNumber = 4;
        System.out.println("Number of Occurrence = " + numberOccurrence(num, occurNumber));

        // 18 Reverse NUmber
        int nums = 13579;
        System.out.println(nums + " Of Reverse = " + reverseNumber(nums));

        // 19 Printing [] [] Array in console
        int a[][] = {{2, 4, 6,}, {3, 6, 9}, {4, 8, 1}};
        printConsole(a);
        // 20  Check if the sum of the digits of x is divisible by 3
        sumOfDigitsDevisible();
        // 21  - Number Divisible number by (3 & 5), 3, 5
        int numb = 100;
        numberDevisible(numb);
        // 22  SWAP Element An  [] Array
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 9};
        int ele1 = 7, ele2 = 2;
        swapElementsArray(arr, ele1, ele2);
        //23 SWAP  []
        int arr1[] = {1, 3, 4, 9, 18};
        System.out.println("Before SWAP  = " + Arrays.toString(arr1));
        swapArry(arr1, 0, 3);
        System.out.println("After SWAP  = " + Arrays.toString(arr1));

        // 24 Maximum Number []
        int arr2[] = {1, 3, 4, 9, 18};
        System.out.println("Maximum Number from Array [] = "+maximumNUmber(arr2));

    }

    private static int maximumNUmber(int[] arr) {
        int maxValue = arr[0];
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }
    static void swapArry(int arr1[], int index1, int index2) {
        int temp = arr1[index1];
        arr1[index1] = arr1[index2];
        arr1[index2] = temp;
    }

    private static void swapElementsArray(int[] arr, int ele1, int ele2) {
        int ind1 = -1, ind2 = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele1) {
                ind1 = i;
            } else if (arr[i] == ele2) {
                ind2 = i;
            }
        }
        if (ind1 != -1 && ind2 != -1) {
            // Swap the elements
            int temp = arr[ind1];
            arr[ind1] = arr[ind2];
            arr[ind2] = temp;
        }
        System.out.println("Array Swapping (" + ele1 + " & " + ele2 + "): " + Arrays.toString(arr));
    }

    private static void numberDevisible(int numb) {
        for (int i = 1; i <= numb; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println(i + " Number Divisible by 3 & 5 ");
            } else if (i % 3 == 0) {
                System.out.println(i + " Number Divisible by 3 ");
            }
            if (i % 5 == 0) {
                System.out.println(i + " Number Divisible by 5 ");
            } else {
                System.out.println(i);
            }
        }

    }


    private static void sumOfDigitsDevisible() {
        int x = 22;
        int sumOfDigits = 0;
        int temp = x;
        while (temp != 0) {
            sumOfDigits += temp % 10;
            temp /= 10;
        }
        if (sumOfDigits % 3 == 0) {
            System.out.println("The sum of the digits of X is Divisible by 3");
        } else {
            System.out.println("Not Divisible by 3");
        }
    }


    private static void printConsole(int a[][]) {
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                System.out.print(a[row][col] + " ");
            }
            System.out.println();
        }
    }

    protected static int reverseNumber(int nums) {
        int rev = 0;
        while (nums != 0) {
            rev = rev * 10;
            rev = rev + nums % 10;
            nums = nums / 10;
        }
        return rev;
    }

    private static int numberOccurrence(int num, int occurNumber) {
        int count = 0;
        int rem;

        while (num > 0) {
            rem = num % 10;
            if (rem == occurNumber) {
                count++;
            }
            num = num / 10;
        }
        return count;
    }

    static int fibo(int n) {
        if (n < 2) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    private static int fibonacciNUmber(int n) {
        int a = 0;
        int b = 1;
        int fibo = 0;
        for (int i = 1; i <= n; i++) {
            fibo = a + b;
            b = a;
            a = fibo;
            // System.out.println(fibo);
        }
          /* while(i<=n){
            fibo=a+b;
            b=a;
            a=fibo;
            i++;
        }*/
        return fibo;
    }

    private static int maxMinNumfromInt(int a1, int b1, int c1) {
        // 1   Using Math Method
        int ma = Math.max(c1, Math.max(a1, b1));
        System.out.println("Max Value :" + ma);
        int mi = Math.min(c1, Math.min(a1, b1));
        System.out.println("Min Value :" + mi);

        // 2  Assigning Value  of  Variable
        int max = a1;
        int min = a1;
        /*if (b1 > max) {
            max = b1;
        }
        if (c1 > max) {
            max = c1;
        }
        return max;*/

        if (b1 < min) {
            min = b1;
        }
        if (c1 < min) {
            min = c1;
        }
        return min;

        // 3 Using  other Variable
       /*int max = 0;
        if (a1 > b1) {
            max = a1;
        } else {
            max = b1;
        }
        if (c1 > a1) {
            max = c1;
        }
        return max;*/
    }


}
