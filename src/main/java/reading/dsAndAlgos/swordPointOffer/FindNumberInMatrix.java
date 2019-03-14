package reading.dsAndAlgos.swordPointOffer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * created by ran
 */
public class FindNumberInMatrix {

    public boolean find(int[][] matrix, int n) {
        /** 如果 matrix[0].length == 0 判断在前，提示 "matrix.length == 0 is always false when reached"
         * 这里是不是可以仅对 matrix[0].length == 0 做判断就好了呢？
         * */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0, col = cols - 1;

        while (row < rows && col >= 0) {
            int value = matrix[row][col];
            if (n > value) {
                row++;
            } else if (n < value) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}
