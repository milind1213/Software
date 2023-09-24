package Programes;

public class StarPatterns {
    public static void main(String [] args ){
        starPattern1(4);
        starPattern2(4);
        starPattern3(4);
        starPattern4(4);
        starPattern5(5);
        diamondPattern(5);
        diamondPattern6(5);

    }
    static void starPattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void starPattern2(int n) {
        System.out.println("=========================== ");

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void starPattern3(int n) {
        System.out.println("=========================== ");
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void starPattern4(int n) {
        System.out.println("=========================== ");
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void starPattern5(int n) {
        System.out.println("=========================== ");
        for (int row = 0; row < 2 * n; row++) {
            int totalColInRow = row > n ? 2 * n - row : row;
            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }

    static void diamondPattern(int n) {
        System.out.println("=========================== ");
        for (int row = 0; row < 2 * n; row++) {
            int totalColInRow = row > n ? 2 * n - row : row;
            int noOfSpaces = n - totalColInRow;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }
            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void diamondPattern6(int n) {
        System.out.println("=========================== ");
        for (int row = 0; row <= n; row++) {
            for (int space = 0; space < n - row; space++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

}
