package reading.dsAndAlgos.swordPointOffer;

/**
 * created by ran
 */
public class PrintMatrixClockWisely {
    private static void solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int x = 0, y = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        while (x * 2 < row && y * 2 < col) {
            solution(matrix, x, y);
            x++;
            y++;
        }
    }

    private static void solution(int[][] matrix, int x, int y) {
        // 因为x, y会更新，因此需要重新计算row和col
        int row = matrix.length;
        int col = matrix[0].length;

        // 1 剩余宽度至少为1
        for (int i = y; i < col-y ; i++) {
            System.out.print(matrix[x][i] + " ");
        }

        // 2 剩余高度至少为2
        if (row - x - 1 > x) {
            for (int i = x + 1; i < row - x; i++) {
                System.out.print(matrix[i][col-y-1] + " ");
            }
        }

        // 3 剩余宽度、高度至少为2
        if (col - y - 1 > y && row - x - 1 > x) {
            for (int i = col - y - 2; i >= y; i--) {
                System.out.print(matrix[row-x-1][i] + " ");
            }
        }

        // 4 剩余宽度至少为2，高度至少为3
        if (col - y - 1 > y && row - x - 2 > x) {
            for (int i = row - x - 2; i > x; i--) {
                System.out.print(matrix[i][y] + " ");
            }
        }

    }

    public static void main(String[] args) {
        int[][] numbers = {
                {1,  2,  3,  4,  5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };

        solution(numbers);
    }
}
