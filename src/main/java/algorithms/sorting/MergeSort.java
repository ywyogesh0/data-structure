package algorithms.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] A = {4, 2, 1, 3, 1, 6, 9};

        System.out.println("Original Array : ");
        display(A);
        System.out.println();

        // call
        mergeSort(A, A.length);

        // display sorted array
        display(A);
    }

    // Time Complexity :
    // 1. Best-Case = O(n * log2n)
    // 2. Average-Case = O(n * log2n)
    // 3. Worst-Case = O(n * log2n)

    // Space Complexity in Worst-Case :
    // 1. If we don't clear extra memory in each call = O(n * log2n)
    // 2. If we clear extra memory in each call = O(n)

    private static void mergeSort(int[] A, int N) {
        // base condition
        if (N < 2)
            return;

        int mid = N / 2;
        int[] L = new int[mid];
        int[] R = new int[N - mid];

        // left array - assignment
        for (int i = 0; i < mid; i++) {
            L[i] = A[i];
        }

        // right array - assignment
        for (int j = mid; j < N; j++) {
            R[j - mid] = A[j];
        }

        mergeSort(L, L.length);
        mergeSort(R, R.length);
        merge(L, R, A);
    }

    private static void merge(int[] L, int[] R, int[] A) {
        int sizeL = L.length;
        int sizeR = R.length;

        int i = 0; // L - array
        int j = 0; // R - array
        int k = 0; // A - array

        // smallest number comparision
        while (i < sizeL && j < sizeR) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i = i + 1;
            } else {
                A[k] = R[j];
                j = j + 1;
            }

            k = k + 1;
        }

        // leftovers - L array
        while (i < sizeL) {
            A[k] = L[i];
            k = k + 1;
            i = i + 1;
        }

        // leftovers - R array
        while (j < sizeR) {
            A[k] = R[j];
            k = k + 1;
            j = j + 1;
        }
    }

    private static void display(int[] A) {
        for (int number : A) {
            System.out.print(number + " ");
        }
    }
}
