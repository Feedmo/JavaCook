package reading.dsAndAlgos.swordPointOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
 * created by ran
 */
public class FindPostOrderInBST {
    public static boolean solution(int[] sequence) {
        return sequence != null && sequence.length != 0 && solution(sequence, 0, sequence.length - 1);

    }

    private static boolean solution(int[] sequence, int start, int end) {
        if (start > end) return true;

        int index = start;
        while (index < end && sequence[index] < sequence[end]) {
            index++;
        }

        int right = index;
        while (index < end && sequence[index] > sequence[end]) {
            index++;
        }

        if (index != end) {
            return false;
        }

        index = right;
        return solution(sequence, start, index - 1) && solution(sequence, index, end - 1);
    }

    public static void main(String[] args) {
        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + solution(data));

        //           5
        //          / \
        //         4   7
        //            /
        //           6
        int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + solution(data2));

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + solution(data3));

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + solution(data4));

        int[] data5 = {5};
        System.out.println("true: " + solution(data5));

        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + solution(data6));

        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + solution(data7));
    }
}
