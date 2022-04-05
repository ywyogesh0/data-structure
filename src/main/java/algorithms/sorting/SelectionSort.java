package algorithms.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] A = {4, 2, 1, 3, 1, 6, 9};

        System.out.println("Original Array : ");
        display(A);
        System.out.println();

        // call
        selectionSort(A, A.length);

        // display - sorted array
        display(A);
    }

    // Time Complexity :
    // 1. Best-Case = O(n2)
    // 2. Average-Case = O(n2)
    // 3. Worst-Case = O(n2)

    // Space Complexity in Worst-Case = O(1)

    private static void selectionSort(int[] A, int N) {
        for (int i = 0; i <= N - 2; i++) {
            int minIndex = i;

            for (int j = i + 1; j <= N - 1; j++) {
                if (A[j] < A[minIndex])
                    minIndex = j;
            }

            // swap
            int temp = A[minIndex];
            A[minIndex] = A[i];
            A[i] = temp;
        }
    }

    private static void display(int[] A) {
        for (int number : A) {
            System.out.print(number + " ");
        }
    }
}
