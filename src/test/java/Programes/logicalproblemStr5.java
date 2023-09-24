package Programes;

public class logicalproblemStr5 {
    public static void main(String [] args){
        String str1 = "Milind";
        String str2 = "Milind Ghongade";

        if (str1.equals(str2)) { // Check if two strings are equal
            System.out.println("Both strings are equal");
        }

        if (!str1.equals(str2)) { // Check if two strings are not equal
            System.out.println("Both strings are not equal");
        }

        if (str1.length() > 0) { // Check if a string is not empty
            System.out.println("String str1 is not empty");
        }

        if (str2.isEmpty()) { // Check if a string is empty
            System.out.println("String str2 is empty");
        }

        if (str1.contains("substring")) { // Check if a string contains a specific substring
            System.out.println("str1 contains 'substring'");
        }

        if (str2.startsWith("prefix")) { // Check if a string starts with a specific prefix
            System.out.println("str2 starts with 'prefix'");
        }

        if (str1.endsWith("suffix")) { // Check if a string ends with a specific suffix
            System.out.println("str1 ends with 'suffix'");
        }



        if (str1.length() < str2.length()) {
            System.out.println("str1 is shorter than str2"); // Check if str1 is shorter than str2
        } else if (str1.length() > str2.length()) {
            System.out.println("str1 is longer than str2"); // Check if str1 is longer than str2
        } else {
            System.out.println("str1 and str2 have the same length");
        }

        if (str1.contains("Ghongade")) {
            System.out.println("str1 contains 'Ghongade'"); // Check if str1 contains a specific substring
        } else {
            System.out.println("str1 does not contain 'Ghongade'");
        }

        if (str2.startsWith("Milind")) {
            System.out.println("str2 starts with 'Milind'"); // Check if str2 starts with a specific prefix
        } else {
            System.out.println("str2 does not start with 'Milind'");
        }

        if (str2.endsWith("Ghongade")) {
            System.out.println("str2 ends with 'Ghongade'"); // Check if str2 ends with a specific suffix
        } else {
            System.out.println("str2 does not end with 'Ghongade'");
        }

        if (str1.equalsIgnoreCase(str2)) {
            System.out.println("str1 is equal to str2 (case-insensitive)"); // Check if both strings are equal, ignoring case
        }

        if (str1.compareTo(str2) < 0) {
            System.out.println("str1 comes before str2 in lexicographical order"); // Compare strings lexicographically
        } else if (str1.compareTo(str2) > 0) {
            System.out.println("str1 comes after str2 in lexicographical order");
        } else {
            System.out.println("str1 and str2 are lexicographically equal");
        }

        if (str1.trim().equals(str2)) {
            System.out.println("str1 is equal to str2 after trimming"); // Check if both strings are equal after trimming leading and trailing whitespace
        }

        if (str1.contains("Milind") && str2.contains("Ghongade")) {
            System.out.println("str1 contains 'Milind' and str2 contains 'Ghongade'"); // Check if both strings contain specific substrings
        }

        if (str1.indexOf('i') != -1) {
            System.out.println("str1 contains the character 'i'"); // Check if a string contains a specific character
        }

        if (str1.substring(2).equals("lind")) {
            System.out.println("str1's substring starting from index 2 is 'lind'"); // Check if a substring of str1 starting from a specific index matches a value
        }

        if (str1.endsWith("nd") && str2.endsWith("ade ")) {
            System.out.println("str1 ends with 'nd' and str2 ends with 'ade '");
        }

        if (str1.toUpperCase().equals("MILIND")) {
            System.out.println("str1 is all uppercase 'MILIND'");
        }

        if (str2.toLowerCase().contains("ghongade")) {
            System.out.println("str2 contains 'ghongade' in lowercase");
        }

        if (str1.matches("[A-Za-z]+")) {
            System.out.println("str1 contains only letters");
        }

        if (str2.replaceAll(" ", "").equals("MilindGhongade")) {
            System.out.println("str2 with spaces removed is 'MilindGhongade'");
        }

        if (str1.indexOf("li") != -1 && str2.indexOf("Gho") != -1) {
            System.out.println("str1 contains 'li' and str2 contains 'Gho'");
        }
        if (str1.compareToIgnoreCase(str2) == 0) {
            System.out.println("str1 is equal to str2 (case-insensitive comparison)");
        }

        if (str1.contains("Milind") && !str2.contains("John")) {
            System.out.println("str1 contains 'Milind' and str2 does not contain 'John'");
        }

        if (str1.startsWith("M") && str2.endsWith("e ")) {
            System.out.println("str1 starts with 'M' and str2 ends with 'e '");
        }

        if (str1.matches("^[A-Za-z]+$")) {
            System.out.println("str1 contains only alphabetic characters");
        }

        if (str2.indexOf("Ghongade") != -1) {
            System.out.println("str2 contains the substring 'Ghongade'");
        }

        if (str1.replace("i", "y").equals("Mylond")) {
            System.out.println("str1 with 'i' replaced by 'y' is 'Mylond'");
        }

        if (str2.substring(0, 6).equals("Milind")) {
            System.out.println("The first 6 characters of str2 are 'Milind'");
        }

    }
}
