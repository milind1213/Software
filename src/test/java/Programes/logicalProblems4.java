package Programes;

import java.util.*;

public class logicalProblems4 {

    public static void main(String[] args) {
        // 35 . ISO GRAM STRING
        String str = "Milnd";
        System.out.println("IsoGram String :" + isIsogram(str));

        String name = "Milnd";
        System.out.println("IsoGram String :" + IsIsogram(name));

        // 36 .  FACTORIAL NUMBER
        System.out.println(factorialNumber());

        // 37.  GET ALL ALPHABETS
        allalphabet();

        //  38 . MULTIPLICATION OF INTEGER
        multiPlication(5, 6);

        // 39 .MULTIPLICATION TABLE
        multiPlicationTable(2, 2);

        // 40 . GENERATE RANDOM NUMBERS
        generateRandomNumber();

        //41 . SPLIT STRINGS
        splitstring();

        // 42 .  REMOVE DUPLICATE WORDS
        removeDuplicateWord();
        // 43. eEXTRACT CHARACTER
        extractChar();

        // 44. COUNT  CHARACTER OCCURENCES
        countCharacterOccurences();

        // 45. COUNT  CHARACTER OCCURENCES
        countCharecter();

        // 46. COUNT  WORD OCCURENCES
        countWordOccurrence();

        // 47 .  REVERSE WORD
        reverseWords();
    }

    public static void reverseWords() {
        String str = "I am going";
        String[] strs = str.split("\\s");
        String rev = " ";

        for (int i = strs.length - 1; i >= 0; i--) {
            rev = rev + strs[i] + " ";
        }

        System.out.println(str + " (Reverse of this) " + rev);
    }

    private static void countWordOccurrence() {
        String str = "I am learning learning java java programming language";
        String[] str1 = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length; i++) {
            if (map.containsKey(str1[i])) {
                int count = map.get(str1[i]);
                map.put(str1[i], count + 1);
            } else {
                map.put(str1[i], 1);
            }
        }
        System.out.println("Count of Word Occurrence :");
        for (String x : map.keySet()) {
            System.out.println(x + ": " + map.get(x));
        }
    }

    public static void countCharecter() {
        String str = "Milind Ghongade from Pune living in Bangalore";
        int count = str.length() - str.replaceAll("i", "").length();
        System.out.println(" Number of Charecters : " + count);
    }

    public static void countCharacterOccurences() {
        String str = "Milind";
        char[] charArray = str.toCharArray();
        Map<Character, Integer> mapChar = new HashMap<>();

        for (char c : charArray) {
            if (mapChar.containsKey(c)) {
                int count = mapChar.get(c);
                mapChar.put(c, count + 1);
            } else {
                mapChar.put(c, 1);
            }
        }
        System.out.println("Count of Character Occurrence:");
        for (Character c : mapChar.keySet()) {
            System.out.println(c + ": " + mapChar.get(c));
        }
    }


    public static void extractChar() {
        String str = "www.milind.com";
        String chars = str.substring(4, 10);
        System.out.println("FirstFour :" + chars);

        String lastChar = str.substring(str.length() - 4, str.length());
        System.out.println("LastChar :" + lastChar);

    }

    private static void removeDuplicateWord() {
        String str = "My Name Name is is Milind Milind";
        String mg[] = str.split(" ");
        Set<String> mySet = new LinkedHashSet<>();
        for (String m : mg) {
            mySet.add(m);
        }
        Iterator itr = mySet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next() + " ");
        }
    }


    private static void splitstring() {
        String s1 = "java string split method by Technolamror";
        String[] words = s1.split("\\s");
        for (String w : words) {
            System.out.println(w);
        }
    }

    private static void generateRandomNumber() {
        int c;
        Random t = new Random();
        // random integers in [0, 100]
        for (c = 1; c <= 10; c++) {
            System.out.println(t.nextInt(1000));
        }
    }

    static void multiPlicationTable(int n1, int n2) {
        int j = 0;
        for (int i = n1; j <= n2; i++) {
            System.out.println("Multiplication table of " + i);
            for (j = 1; j <= 10; j++) {
                System.out.println(i + "*" + j + "=" + (i * j));
            }
        }
    }

    static void multiPlication(int a, int b) {
        int Mul = 0;
        for (int i = 0; i < a; i++) {
            Mul += b;
        }
        System.out.println(Mul);
    }

    static void allalphabet() {
        System.out.println("All Alphabets : ");
        {
            char ch;
            for (ch = 'A'; ch <= 'Z'; ch++)
                System.out.print(ch);
        }
    }


    private static int factorialNumber() {
        int n = 5;
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    private static boolean IsIsogram(String str) {
        boolean isIsogram = true;
        str = str.toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            // if (Character.isLetter(currentChar)) {
            for (int j = i + 1; j < str.length(); j++) {
                char nextChar = str.charAt(j);

                if (currentChar == nextChar) {
                    return false;

                }
            }
        }

        return isIsogram;
    }

    static boolean isIsogram(String str) {
        boolean isogram = true;
        char[] ch = str.toCharArray();
        Set<Character> chSet = new HashSet<>();

        for (Character c : ch) {
            if (chSet.contains(c)) {
                isogram = false;
            } else {
                chSet.add(c);
            }
        }
        return isogram;
    }
}
