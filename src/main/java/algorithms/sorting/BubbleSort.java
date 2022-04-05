package algorithms.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] A = {4, 2, 1, 3, 1, 6, 9};

        System.out.println("Original Array : ");
        display(A);
        System.out.println();

        // call
        bubbleSort(A, A.length);

        // display - sorted array
        display(A);
    }

    // Time Complexity :
    // 1. Best-Case = O(n)
    // 2. Average-Case = O(n2)
    // 3. Worst-Case = O(n2)

    // Space Complexity in Worst-Case = O(1)

    private static void bubbleSort(int[] A, int N) {
        for (int i = 1; i <= N - 1; i++) {
            boolean isSwap = false;

            for (int j = 0; j <= N - i - 1; j++) {
                if (A[j] > A[j + 1]) {

                    // swap
                    int temp = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = temp;

                    isSwap = true;
                }
            }

            if (!isSwap)
                break;
        }
    }

    private static void display(int[] A) {
        for (int number : A) {
            System.out.print(number + " ");
        }
    }
}
