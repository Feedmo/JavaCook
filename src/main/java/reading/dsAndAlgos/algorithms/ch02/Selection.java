package reading.dsAndAlgos.algorithms.ch02;

import static reading.dsAndAlgos.algorithms.ch02.SortUtil.exch;
import static reading.dsAndAlgos.algorithms.ch02.SortUtil.less;

public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, min, i);
        }
    }
}
