package Programes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class logicalProblems3 {
    public static void main(String[] args) {
        // 25 Reverse Words
        String str = "I am going";
        String[] strs = str.split("\\s");
        System.out.println(str + " <- Reverse of this -> " + reverseWords(strs));

        // 26  Count of Word Occurrence
        String str1 = "I am learning learning java java programming language";
        String[] strr = str1.split(" ");
        countWordOccurrence(strr);

        // 27 count Characters
        String str2 = "Milind Ghongade from Pune living in Bangalore";
        System.out.println("Number of Characters: " + countCharacter(str2));

        // 28  duplicate Character
        String str3 = "Milind";
        char[] charArray = str3.toCharArray();
        duplicateCharacter(charArray);

        // 29  Extract Characters
        String str4 = "www.milind.com";
        extractChar(str4);

        // 30  Remove Duplicate words
        String str5 = "My Name Name is is Milind Milind";
        String mg[] = str5.split(" ");
        removeDuplicateWords(mg);
        // 31 Fetch Smallest NUmber from Array

        int a[] = {5, 2, 8, 3, 1};
        fetchSecondSmaleestEleement(a);

        // 32 Fetch Coomon ELement  from Array

        int ar1[] = {1, 2, 3, 4, 5, 10};
        int ar2[] = {4, 5, 6, 7, 8, 10};
        fetchCommonElement(ar1, ar2);

        // 33  Reverse Array
        int arr3[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reversesArray(arr3);

        // 34  longest String
        String arr4[] = {"Banana", "Aaple", "Avacado", "Apricost", "Papaya"};
        logestString(arr4);
    }

    static void logestString(String[] arr4) {
        int MaxLength = Arrays.stream(arr4).mapToInt(string -> arr4.length).max().orElse(0);
        System.out.println("Reverse Arrray : " + MaxLength);

    }

    static void reversesArray(int[] arr3) {
        IntStream.range(0, arr3.length / 2).forEach(i -> {
            int temp = arr3[i];
            arr3[i] = arr3[arr3.length - i - 1];
            arr3[arr3.length - i - 1] = temp;
        });

        System.out.println("Reverse Arrray : " + Arrays.toString(arr3));
    }


    static void fetchCommonElement(int[] ar1, int[] ar2) {
        List<Integer> commonELement = Arrays.stream(ar1).filter(number -> Arrays.stream(ar2).anyMatch(ar2Number -> ar2Number == number)).boxed().collect(Collectors.toList());
        System.out.println("CommonELement : " + commonELement);

    }

    private static void fetchSecondSmaleestEleement(int[] a) {
        int SecondSmaleestEleement = Arrays.stream(a).sorted().skip(1).findFirst().orElseThrow(() -> new IllegalArgumentException("Arrays Does Not have Second Smallest NUmber"));
        System.out.println("Second  Smallest Number in Given Array is : " + SecondSmaleestEleement);
    }

    private static void removeDuplicateWords(String[] mg) {
        Set<String> mySet = new LinkedHashSet<>();
        for (String m : mg) {
            mySet.add(m);
        }
        Iterator itr = mySet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next() + " ");
        }
    }

    public static void extractChar(String str) {
        String chars = str.substring(4, 10);
        System.out.println("FirstFour :" + chars);
        String lastChar = str.substring(str.length() - 4, str.length());
        System.out.println("LastChar :" + lastChar);
    }

    private static void duplicateCharacter(char[] charArray) {
        Map<Character, Integer> mapChar = new HashMap<>();
        for (char chars : charArray) {
            if (mapChar.containsKey(chars)) {
                int count = mapChar.get(chars);
                mapChar.put(chars, count + 1);
            } else {
                mapChar.put(chars, 1);
            }
        }
        System.out.println("Count of Character Occurrence:");
        for (Character c : mapChar.keySet()) {
            System.out.println(c + ": " + mapChar.get(c));
        }
    }


    public static int countCharacter(String str2) {
        int count = str2.length() - str2.replaceAll("i", "").length();
        return count;
    }


    private static void countWordOccurrence(String[] str) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])) {
                int count = map.get(str[i]);
                map.put(str[i], count + 1);
            } else {
                map.put(str[i], 1);
            }
        }
        System.out.println("Count of Word Occurrence :");
        for (String x : map.keySet()) {
            System.out.println(x + ": " + map.get(x));
        }
    }

    private static String reverseWords(String[] strs) {
        String rev = " ";
        for (int i = strs.length - 1; i >= 0; i--) {
            rev = rev + strs[i] + " ";
        }
        return rev;
    }
}
