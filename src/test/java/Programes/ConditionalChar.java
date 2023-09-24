package Programes;

public class ConditionalChar {
    public static void main(String[] args) {
        char ch = 'm', chr = 'g';

        if (ch == chr) {
            System.out.println("ch is equal to chr");
        } else {
            System.out.println("ch is not equal to chr");
        }

        if (Character.isLetter(ch)) {
            System.out.println("ch is a letter");
        } else {
            System.out.println("ch is not a letter");
        }

        if (Character.isDigit(chr)) {
            System.out.println("chr is a digit");
        } else {
            System.out.println("chr is not a digit");
        }

        if (Character.isUpperCase(ch)) {
            System.out.println("ch is uppercase");
        } else {
            System.out.println("ch is not uppercase");
        }

        if (Character.isLowerCase(chr)) {
            System.out.println("chr is lowercase");
        } else {
            System.out.println("chr is not lowercase");
        }

        if (ch >= 'a' && ch <= 'z') {
            System.out.println("ch is a lowercase letter between 'a' and 'z'");
        }

        if (chr >= 'A' && chr <= 'Z') {
            System.out.println("chr is an uppercase letter between 'A' and 'Z'");
        }

        if (Character.isLetterOrDigit(ch)) {
            System.out.println("ch is a letter or digit");
        } else {
            System.out.println("ch is neither a letter nor a digit");
        }

        if (Character.isWhitespace(ch)) {
            System.out.println("ch is a whitespace character");
        } else {
            System.out.println("ch is not a whitespace character");
        }

        if (Character.isLetter(chr) && !Character.isLowerCase(chr)) {
            System.out.println("chr is an uppercase letter");
        } else {
            System.out.println("chr is not an uppercase letter");
        }

        if (chr >= '0' && chr <= '9') {
            System.out.println("chr is a digit between '0' and '9'");
        }

        char nextCharCh = (char) (ch + 1);
        System.out.println("The character after ch is: " + nextCharCh);

        char prevCharChr = (char) (chr - 1);
        System.out.println("The character before chr is: " + prevCharChr);
    }



}

