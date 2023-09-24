package Programes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class logicalProblems7 {
    public static void main(String[] args) {
        // 61 PRINT MIN & MAX NUMBER FROM [] ARRAY
        int a[] = {4, 6, 8, 9, 12, 22};
        maxMinNumber(a);

        // 62 MIN - MAX DIFFERENCE [] ARRAY
        minMaxDifference();
        maxDifference();

        // 63 MAX DIFFERENCE [] [] ARRAY
        maxNumberfromMultidimenetilaArray();

        // 64 MISSING NUMBER FROM [] ARRAY
        int a1[] = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        missingNUmber(a1);

        // 65 DUPLICATE NUMBERS/ELEMENT FROM [] ARRAY
        duplicateElement();
    }

    private static void duplicateElement() {
        int a[] = {1, 4, 6, 8, 5, 3, 2, 1, 4, 5};
        // 1
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    System.out.println("Duplicates Numbers : " + a[i]);
                }
            }
        }
        // 2
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                System.out.println("Using Sort Method Duplicates : " + a[i]);
            }
        }

        // 3
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int n:a){
            if(!map.containsKey(n)){
                map.put(n,1);
            } else {
                map.put(n, map.get(n) + 1);
            }
          }
            for (Integer n :map.keySet()) {
                if(map.get(n)>1)
                    System.out.println("Using HashMap Duplicates :" +n);
            }
        }


    private static void missingNUmber(int[] a) {
        int sum = 0;
        int ExpectedSum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        for (int j = 0; j <= 10; j++) {
            ExpectedSum = ExpectedSum + j;
        }
        System.out.println("Numbers : " + (Arrays.toString(a)));
        System.out.println("Missing Number : " + (ExpectedSum - sum));

    }


    private static void maxNumberfromMultidimenetilaArray() {
        int a[][] = {{6, 8, 9}, {10, 34, 22}, {22, 45, 99}};
        int max = a[0][0];
        int min = a[0][0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                }
                if (a[i][j] < min) {
                    min = a[i][j];
                }
            }
        }
        System.out.println("MaxNumber From [][] Array :" + max);
        System.out.println("MaxNumber From [][] Array :" + min);

    }

    private static void maxDifference() {
        int a[] = {4, 6, 8, 9, 10, 22};
        int maxDiff = 0;  // Initialize maximum difference to 0

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int diff = Math.abs(a[i] - a[j]);  // Calculate the absolute difference between elements
                if (diff > maxDiff) {
                    maxDiff = diff;    // Update maximum difference if needed
                }
            }
        }
        System.out.println("Maximum Difference: " + maxDiff);
    }

    private static void minMaxDifference() {
        int a[] = {4, 6, 8, 9, 10, 22};
        int maxDiff = 0; // Initialize maximum difference to 0
        int minDiff = Integer.MAX_VALUE; // Initialize minimum difference to the maximum possible integer value

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int diff = Math.abs(a[i] - a[j]); // Calculate the absolute difference between elements
                if (diff > maxDiff) {
                    maxDiff = diff; // Update maximum difference if needed
                }
                if (diff < minDiff) {
                    minDiff = diff; // Update minimum difference if needed
                }
            }
        }
        System.out.println("Minimum Difference: " + minDiff);
        System.out.println("Maximum Difference: " + maxDiff);
    }


    private static void maxMinNumber(int[] a) {
       /* int max = Integer.MIN_VALUE; // Initialize max to the smallest possible value
        int min = Integer.MAX_VALUE; // Initialize min to the largest possible value*/
        int max = a[0];
        int min = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        System.out.println("Maximum Number from [] Array: " + max);
        System.out.println("Minimum Number from [] Array: " + min);
    }


}
