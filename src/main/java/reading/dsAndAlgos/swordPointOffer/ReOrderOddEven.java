package reading.dsAndAlgos.swordPointOffer;

import java.security.InvalidParameterException;

import static reading.dsAndAlgos.util.ConsolePrint.printArray;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * created by ran
 */
public class ReOrderOddEven {
    private static void solution(int[] array) {
        if (array == null || array.length == 0) {
            throw new InvalidParameterException();
        }

        int i = 0, j = array.length - 1;
        while (i < j) {
            while (i < j && array[i] % 2 == 1) {
                i++;
            }
            while (i < j && array[j] % 2 == 0) {
                j--;
            }

            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 7, 6, 9, 1, 4, 7, 2, 0};
        solution(arr);
        printArray(arr);
    }
}
