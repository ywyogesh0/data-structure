package algorithms.sorting;

public class HeapSort {

    public static void main(String[] args) {
        int[] A = {4, 2, 1, 3, 1, 9, 6};

        System.out.println("Original Array : ");
        display(A);
        System.out.println();

        // call
        heapSort(A, A.length);

        // display - sorted array
        display(A);
    }

    // Time Complexity :
    // 1. Best-Case = O(n * log2n)
    // 2. Worst-Case = O(n * log2n)
    // 3. Average-Case = O(n * log2n)

    // Space Complexity in Worst-Case = O(1)

    private static void heapSort(int[] A, int N) {
        // 1. build_max_heap
        buildMaxHeap(A, N); // time-complexity = O(n)

        for (int i = N - 1; i > 0; i--) {
            // 2. swap root with last element
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            // 3. max_heapify subtree - if swapping violates the max_heapify property assumption
            doMaxHeapify(A, 0, i); // time-complexity = O(log2n)
        }
    }

    private static void buildMaxHeap(int[] A, int N) {
        for (int i = N / 2 - 1; i >= 0; i--) {
            doMaxHeapify(A, i, N);
        }
    }

    private static void doMaxHeapify(int[] A, int rootIndex, int N) {
        int finalRootIndex = rootIndex;
        int leftIndex = 2 * rootIndex + 1;
        int rightIndex = 2 * rootIndex + 2;

        if (leftIndex < N && A[finalRootIndex] < A[leftIndex]) {
            finalRootIndex = leftIndex;
        }

        if (rightIndex < N && A[finalRootIndex] < A[rightIndex]) {
            finalRootIndex = rightIndex;
        }

        if (finalRootIndex != rootIndex) {
            int temp = A[rootIndex];
            A[rootIndex] = A[finalRootIndex];
            A[finalRootIndex] = temp;

            // max_heapify subtree - if swapping violates the max_heapify property assumption
            doMaxHeapify(A, finalRootIndex, N);
        }
    }

    private static void display(int[] A) {
        for (int number : A) {
            System.out.print(number + " ");
        }
    }
}
