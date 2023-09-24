package Programes;

import java.util.Arrays;

public class logicalProblems1 {
    public static void main(String[] args) {
        // 1. Search An Element Present in [] Array or  Not
        int arr[] = {1, 2, 3, 4, 5};
        int target = 5;
        boolean result = searchArray(arr, target);
        System.out.println("Is Element Found In Array = " + result);
        // 2  Search An Element Present in [] [] Array or  Not
        int ar[][] = {{79, 30, 50}, {11, 33, 22, 44}, {10, 20, 30, 40}, {100, 200}};
        int tr = 40;
        int[] ans = searchNumber(ar, tr);
        System.out.println(" Element Index : " + Arrays.toString(ans));

        //  3. Search An Index of Element in Array
        int arr1[] = {1, 2, 3, 4, 5, 5, 7, 9};
        int target1 = 3;
        System.out.println(target1 + " Element found at Index = " + searchInRange(arr1, target1, 0, 4));

        //  4. Verify Character present in String or Not
        String name = "Milind";
        System.out.println("Converting String in Char Array :" + Arrays.toString(name.toCharArray()));
        Character targetChar = 'M';
        System.out.println("Is Character Present in String ? : " + searchChar(name, targetChar));

        // 5. Minimum Number from Integer [] Array
        int arr2[] = {11, 22, 33, 4, 55, 66};
        int min = minimumNumber(arr2);
        System.out.println("Minimum Number From Array : " + min);

        // 6 .Maximum Number from Integer [] Array
        int max = maximumNumber(arr2);
        System.out.println("Maximum Number From Array : " + max);

        // 7 .  Max Number from Integer [] [] Array
        int arr3[][] = {{79, 30, 50}, {11, 33, 22, 44}, {10, 20, 30, 40}, {100, 200}};
        int maxNum = searchMaxNumber(arr3);
        System.out.println("Maximum Value [][] Array:" + maxNum);

        // 8 .  Min Number from Integer [] [] Array
        int minNum = searchMinNumber(arr3);
        System.out.println("Minimum Value [][] Array:" + minNum);

        // 9 . count Number of Digits
        int a = 12234;
        System.out.println("Number of Digits = " + digits(a));

        // 10 . Find Even or Odd Number
        int num = 13;
        evenOddNumber(num);

        // 11 . Find Even or Odd Number
        boolean even = isEvenNumber(num);
        System.out.println("Is Number is Even = " + even);

        // 12 . Find Even or Odd Number
        boolean odd = isOddNumber(num);
        System.out.println("Is Number is Odd = " + odd);

        // 13 . find the Number of even Numbers from [] Array
        int nums[] = {12, 3, 2, 6};
        System.out.println("Find Even Number counts : " + findNumbers(nums));

    }

    static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    static boolean isEvenNumber(int num) {
        return num % 2 == 0;
    }

    static boolean isOddNumber(int num) {
        return num % 2 != 0;
    }

    private static void evenOddNumber(int num) {
        if (num % 2 == 0) {
            System.out.println(num + " Number is Even");
        } else {
            System.out.println(num + " Number is Odd");
        }
    }


    static int digits(int num) {
        int counts = 0;
        while (num > 0) {
            counts++;
            num = num / 10;
        }
        return counts;
    }


    static int searchMaxNumber(int arr3[][]) {
        int max = arr3[0][0];
        for (int row = 0; row < arr3.length; row++) {
            for (int col = 0; col < arr3[row].length; col++) { // Iterate through all columns
                if (arr3[row][col] > max) {
                    max = arr3[row][col];
                }
            }
        }
        return max;
    }
    static int searchMinNumber(int arr3[][]) {
        int min = arr3[0][0];
        for (int row = 0; row < arr3.length; row++) {
            for (int col = 0; col < arr3[row].length; col++) { // Iterate through all columns
                if (arr3[row][col] < min) {
                    min = arr3[row][col];
                }
            }
        }
        return min;
    }

   /* private static int searchMaxNumber(int[][] arr3) {
    int maXNum = Integer.MIN_VALUE;
        for (int[] ele : arr3) {
            for (int element : ele) {
                if (element > maXNum) {
                    maXNum = element;
                }
            }
        }
        return maXNum;
    }*/


    static int maximumNumber(int[] arr2) {
        int max = arr2[0];
        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i] > max) {
                max = arr2[i];
            }
        }
        return max;
    }

    static int minimumNumber(int[] arr2) {
        int min = arr2[0];
        for (int i = 1; i < arr2.length; i++) { // Start from index 1
            if (arr2[i] < min) {
                min = arr2[i];
            }
        }
        return min;
    }

    static int[] searchNumber(int ar[][], int tr) {
        for (int row = 0; row < ar.length; row++) {
            for (int col = 1; col < ar[row].length; col++) {
                if (ar[row][col] == tr) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static boolean searchChar(String name, char target) {
        if (name.length() == 0) {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            if (target == name.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    static int searchInRange(int[] arr1, int target1, int start, int end) {
        if (start < 0 || end >= arr1.length || start > end) {
            return -1; // Invalid indices
        }
        for (int i = start; i <= end; i++) {
            if (arr1[i] == target1) {
                return i; // Index of target found
            }
        }
        return -1; // If target is not found in the specified range
    }

    static boolean searchArray(int[] arr, int target) {
        if (arr.length == 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];
            if (ele == target) {
                return true;
            }
        }
        return false;
    }
}
