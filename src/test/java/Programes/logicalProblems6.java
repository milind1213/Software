package Programes;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class logicalProblems6 {
    public static void main(String[] args) {
        // 48.  PRINT ARRAY
        int arr[] = {4, 3, 2, 1, 8, 6, 7};
        System.out.println("Actual Array : " + Arrays.toString(arr));

        //  49 REVERSE INT [] ARRAY
        int ar[] = {4, 3, 2, 1, 5, 6, 7};
        reverseArray(ar);

        // 50  REVERSE INT [] ARRAY
        int arr1[] = {7, 6, 5, 4, 3, 2, 1};
        int start = 0;
        int end = 6;
        reverseArrays(arr1, start, end);

        // 51 HALF REVERSE ARRAY
        int arr2[] = {40, 30, 20, 10, 50, 60, 70};
        int startIndex = 0;
        int endIndex = 3;
        halfReverseArrays(arr2, startIndex, endIndex);

        //  52 MIDDLE REVERSE ARRAY
        int arr3[] = {10, 20, 50, 40, 30, 60, 70};
        int startMidIndex = 2;
        int endMidIndex = 4;
        midReverseArrays(arr3, startMidIndex, endMidIndex);

        // 53 SORTING ARRAY WITH SORT METHOD
        int arr4[] = {4, 3, 2, 9, 5, 6, 7, 1};
        Arrays.sort(arr4);
        System.out.println("Sorting Array Using Sort Method: " + Arrays.toString(arr4));

        // 54. SORTING WITH BUBBLE SORT ALGORITHM
        int arr5[] = {4, 3, 2, 9, 5, 6, 7, 1};
        sortArrayByloop(arr5);

        // 55.  SWAPPING AN ELEMENT IN [] ARRAY
        int aa[] = {1, 2, 3, 4, 5, 6, 7, 9};
        int ele1 = 7, ele2 = 3;
        int in1 = -1, in2 = -1;
        swapingElementArray(aa,ele1,ele2,in1,in2);

        //  56 MANIPULATING STRING ARRAY
        String input[] = {"Sunday","Monday","Tuestday","Wednesday","Thursday","Friday","Saturday"};
        manipulateArray(input);

        //  57  FACTORIAL NUMBER
        factorialNumbers(5);

        // 58 SUM ARRAY []
        int a[] = {2, 4, 5, 6, 6, 7, 8, 9};
        sumArray(a);
        // 59 COMPARE ARRAY 
        int a1[] = {2, 4, 6, 7, 8, 9};
        int b1[] = {3, 4, 5, 7, 2, 9};
        comparreArray(a1,b1);

        // 60 MULTIPLICATION
        multiplication();

    }

    private static void multiplication() {
        int a = 3;
        int b = 3;
        int m = 0;

        for (int i = 0; i < a; i++) {
            m += b;
        }
        System.out.println("Multiplication : " + m);
    }


    private static void comparreArray(int[] a, int[] b) {
        List<Integer> al = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                al.add(a[i]);
            }
        }
        Object arr[] = al.toArray();
        for (Object ar : arr) {
            System.out.println(ar);
        }
        System.out.println("Printing Common Values : " + Arrays.toString(arr));
    }

    private static void sumArray(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        System.out.println("Sum Of Arrays : " + sum);
    }


    private static void factorialNumbers(int n) {
      int  fact = 1;
        for(int i=1;i<=n;i++){
          fact = fact*i;
        }
        System.out.println("The Factorial of "+ n +" is = "+fact);
    }

    private static void manipulateArray(String[] input) {
        String[] output = new String[input.length];
        for(int i=0;i<input.length;i++){
            output[i]=input[i].substring(0,3);
        }
        System.out.println(Arrays.toString(output));
        for(String day:output) {
            System.out.println(day);
        }
    }

    private static void swapingElementArray(int[] aa, int ele1, int ele2, int in1, int in2) {
        for (int i = 0; i < aa.length; i++) {
            if (aa[i] == ele1) {
                in1 = i;
            } else if (aa[i] == ele2) {
                in2 = i;
            }
            if (in1 != -1 && in2 != -1) {
                break; // Both elements found, no need to continue searching
            }
        }
        if (in1 != -1 && in2 != -1) {
            int temp = aa[in1];
            aa[in1] = aa[in2];
            aa[in2] = temp;
        }
        System.out.println("Array Swapping (3 & 7) : " + Arrays.toString(aa));
    }


    private static void sortArrayByloop(int[] arr5) {
        for (int i = 0; i < arr5.length - 1; i++) {
            for (int j = 1; j < arr5.length - i - 1; j++) {
                if (arr5[j] > arr5[j + 1]) {
                    int tem = arr5[j];
                    arr5[j] = arr5[j + 1];
                    arr5[j + 1] = tem;
                }
            }
        }
        System.out.println("Sorting Array With Bubble Sort Algorithm  : " + Arrays.toString(arr5));
    }

    private static void midReverseArrays(int[] arr3, int startMidIndex, int endMidIndex) {
        int rev;
        for (int i = startMidIndex, j = endMidIndex; i < j; i++, j--) {
            rev = arr3[i];
            arr3[i] = arr3[j];
            arr3[j] = rev;
        }
        System.out.println("Mid Reverse [] Array = " + Arrays.toString(arr3));
    }

    private static void halfReverseArrays(int[] arr2, int startIndex, int endIndex) {
        int rev;
        for (int i = startIndex, j = endIndex; i < j; i++, j--) {
            rev = arr2[i];
            arr2[i] = arr2[j];
            arr2[j] = rev;
        }
        System.out.println("Half Reverse [] Array = " + Arrays.toString(arr2));
    }

    private static void reverseArrays(int[] arr1, int start, int end) {
        int rev, a, b;
        for (a = start, b = end; a < b; a++, b--) {
            rev = arr1[a];
            arr1[a] = arr1[b];
            arr1[b] = rev;
        }
        System.out.println("Reverse []  Array :" + Arrays.toString(arr1));
    }


    @Test
    static void Multidimentinal() {

        int arr[][] = {{60, 80, 90}, {10, 34, 22}, {22, 45, 99}};
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
        for (int[] ar : arr) {
            System.out.println(Arrays.toString(ar));
        }
    }


    private static void reverseArray(int[] ar) {
     int rev =0;
        for (int i = ar.length - 1; i >= 0; i--) {
            System.out.print(ar[i] + " ");
        }
    }


}
