package reading.dsAndAlgos.swordPointOffer;

import java.security.InvalidParameterException;

/**
 * 寻找旋转数组的最小数字
 * created by ran
 */
public class FindTheMinValueInRotatedArray {
    private static int min(int[] array) {
        if (array == null || array.length == 0) {
            throw new InvalidParameterException();
        }

        int lo = 0;
        int hi = array.length - 1;
        int mid;

        if (array[lo] < array[hi]) {
            return array[lo];
        }

        while (lo < hi) {
            if (hi - lo == 1) {
                return array[hi];
            }
            // note mid不会导致 lo>hi 的情况出现
            mid = lo + (hi - lo) / 2;

            /**
             * 比如 {1, 0, 1, 1, 1} 的情况，由于二分查找是从mid位置开始判断的
             * 那么0会被忽略，因此此时应该以顺序的方式查找
             */
            if (array[lo] == array[mid] && array[mid] == array[hi]) {
                return searchInOrder(array);
            }

            if (array[mid] >= array[lo]) {
                lo = mid;
            } else if (array[mid] <= array[hi]) {
                hi = mid;
            }
        }
        return array[hi];
    }

    private static int searchInOrder(int[] array) {
        int min = 0;
        int len = array.length;

        for (int i = 1; i < len; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return array[min];
    }

    public static void main(String[] args) {
        int[] array1 = {3, 4, 5, 1, 2};
        System.out.print(min(array1) + " ");

        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.print(min(array2) + " ");

        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.print(min(array3) + " ");

        int[] array4 = {1, 0, 1, 1, 1};
        System.out.print(min(array4) + " ");

        int[] array5 = {1, 2, 3, 4, 5};
        System.out.print(min(array5) + " ");

        int[] array6 = {2};
        System.out.print(min(array6) + " ");

        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.print(min(array7));
    }
}
