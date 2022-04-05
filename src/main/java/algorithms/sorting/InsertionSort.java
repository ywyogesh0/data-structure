package algorithms.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] A = {4, 2, 1, 3, 1, 6, 9};

        System.out.println("Original Array : ");
        display(A);
        System.out.println();

        // call
        insertionSort(A, A.length);

        // display - sorted array
        display(A);
    }

    // Time Complexity :
    // 1. Best-Case = O(n)
    // 2. Average-Case = O(n2)
    // 3. Worst-Case = O(n2)

    // Space Complexity in Worst-Case = O(1)

    private static void insertionSort(int[] A, int N) {
        for (int i = 1; i <= N - 1; i++) {
            int value = A[i];
            int hole = i;

            while (hole > 0 && A[hole - 1] > value) {
                A[hole] = A[hole - 1];
                hole = hole - 1;
            }

            A[hole] = value;
        }
    }

    private static void display(int[] A) {
        for (int number : A) {
            System.out.print(number + " ");
        }
    }
}
