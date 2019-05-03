package reading.dsAndAlgos.algorithms.ch02;

import reading.dsAndAlgos.util.ConsolePrinter;

import static reading.dsAndAlgos.algorithms.ch02.SortUtil.less;

public class Insertion {
    private static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable v = a[i];
            int j;
            for (j = i; j > 0 && less(v, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = v;
        }
    }

    public static void main(String[] args) {
        String[] strings = {"s", "c", "e", "a"};
        sort(strings);
        ConsolePrinter.printArray(strings);
    }
}
