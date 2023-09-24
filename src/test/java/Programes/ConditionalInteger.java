package Programes;

public class ConditionalInteger {

    public static void main(String[] args) {
        int x = 10, y = 10, z = 20;

        if (x >= y && y <= z) {
            System.out.println(" x is greater than y and y is less than or equal to z ");
        }
        if (x == 10 && z == 20) {
            System.out.println(" x is equal to 10 and z is equal to 20 ");
        }
        if (x == 10 || z == 20) {
            System.out.println("Either x is 10 or z is 20");
        }
        if (x != 25) {
            System.out.println("x is not equal to 25");
        }
        if (!(x > 5)) {
            System.out.println("x is not greater than 5");
        }
        if (x % 2 == 0) {
            System.out.println("x is an even number");
        }
        if (x % 2 != 0) {
            System.out.println("x is an odd number");
        }
        if (x > y && z < 15) {
            System.out.println("x is greater than y and z is less than 15");
        }

        if (x * y== 100) {
            System.out.println("The product of x and y is equal to 100");
        }
        if (z / x == 2) {
            System.out.println("z divided by x equals 2");
        }
        if ((x + y) % 5 == 0) {
            System.out.println("The sum of x and y is divisible by 5");
        }
        if (x > 0 && x < 20 && z > 10 && z < 30) {
            System.out.println("x is in the range (0, 20) and z is in the range (10, 30)");
        }
        if (x * y > z) {
            System.out.println("The product of x and y is greater than z");
        }
        if (Math.abs(x - z) < 5) {
            System.out.println("The absolute difference between x and z is less than 5");
        }
        if (z % 10 == 0) {
            System.out.println("z is divisible by 10");
        }
        if (x > 5 && y > 5 && z > 5) {
            System.out.println("All three numbers are greater than 5");
        }
        if (x * y != z) {
            System.out.println("The product of x and y is not equal to z");
        }
        if (x > 0 || y > 0 || z > 0) {
            System.out.println("At least one of the numbers is greater than 0");
        }

        if (x > y && (z < x || z < y)) {
            System.out.println("x is greater than y, and z is less than x or y");
        } else {
            System.out.println("Conditions not met");
        }
        if (x % y == 0 && x % z == 0) {
            System.out.println("x is divisible by both y and z");
        } else {
            System.out.println("Conditions not met");
        }

        if (x > 0 && y < 0 && z >= 0) {
            System.out.println("x is positive, y is negative, and z is non-negative");
        } else {
            System.out.println("Conditions not met");
        }

        if ((x + y + z) % 2 == 0) {
            System.out.println("The sum of x, y, and z is even");
        } else {
            System.out.println("Conditions not met");
        }

        if (x > y && x > z) {
            System.out.println("x is the maximum of the three numbers");
        }
        if (x % y == 0 && x % z == 0) {
            System.out.println("x is a multiple of both y and z");
        }
        if ((x == y && y == z) || (x == y && x == z) || (y == z && x == z)) {
            System.out.println("At least two out of three numbers are equal");
        }

    }

}
