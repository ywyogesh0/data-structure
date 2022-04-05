package algorithms.searching;

public class LinearSearch {

    public static void main(String[] args) {
        int[] A = {4, 2, 1, 3, 1, 6, 9};

        System.out.println("Array : ");
        display(A);
        printNewLine(2);

        // Calling LinearSearch
        linearSearch(A, 6);
        printNewLine(1);

        linearSearch(A, 2);
        printNewLine(1);

        linearSearch(A, 5);
        printNewLine(1);

        linearSearch(A, 1);
        printNewLine(1);

        linearSearch(A, 8);
        printNewLine(1);
    }

    private static boolean isElementExists(int[] A, int X) {
        for (int num : A) {
            if (num == X)
                return true;
        }

        return false;
    }

    // Time-Complexity in Worst-Case = O(n)

    private static void linearSearch(int[] A, int X) {
        System.out.println("Search Element = " + X);

        if (isElementExists(A, X))
            System.out.println("Success : " + X + " is present...");
        else
            System.out.println("Failure : " + X + " is not present...");
    }

    private static void display(int[] A) {
        for (int number : A) {
            System.out.print(number + " ");
        }
    }

    private static void printNewLine(int count) {
        while (count > 0) {
            System.out.println();
            count--;
        }
    }
}
