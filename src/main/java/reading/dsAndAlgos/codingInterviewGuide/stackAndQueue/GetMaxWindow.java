package reading.dsAndAlgos.codingInterviewGuide.stackAndQueue;

import java.util.LinkedList;

/**
 * created by ran
 */
public class GetMaxWindow {
    public static int[] solution(int[] arr, int w) {
        int len;
        if (arr == null || w < 1 || (len = arr.length) < w) {
            return null;
        }

        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[len - w + 1];
        int index = 0;

        for (int i = 0; i < len; i++) {
            while (!qMax.isEmpty() && arr[qMax.peekLast()] < arr[i]) {
                qMax.pollLast();
            }
            qMax.addLast(i);
            if (qMax.peekFirst() == i - w) {
                qMax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qMax.peekFirst()];
            }
        }
        return res;
    }

}
