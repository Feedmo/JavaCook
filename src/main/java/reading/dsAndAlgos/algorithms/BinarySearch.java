package reading.dsAndAlgos.algorithms;

import reading.dsAndAlgos.algorithms.utils.StdOut;
import reading.dsAndAlgos.util.ConsolePrinter;

import java.util.Arrays;

/**
 * created by ran
 */
public class BinarySearch {
    public static int rank_iteration(int key, int a[]) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    static int rank_recursion(int[] a, int key) {
        return rank_recursion(a, 0, a.length, key, 0);
    }

    static int rank_recursion(int[] a, int lo, int hi, int k, int depth) {
        if (lo > hi) return -1;

        int mid = (lo + hi) / 2;

        for (int i = 0; i < depth; i++) {
            StdOut.print(" ");
        }
        System.out.println(lo + " " + hi);

        if (a[mid] < k) lo = mid + 1;
        else if (a[mid] > k) hi = mid - 1;
        else return mid;

        return rank_recursion(a, lo, hi, k, depth + 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 8, 1, 2, 5, 8, 2, 9};
        Arrays.sort(a);
        ConsolePrinter.printArray(a);

        int result = rank_recursion(a, 10);
        System.out.println(result);
    }
}
