package reading.dsAndAlgos.swordPointOffer;

import java.security.InvalidParameterException;

/**
 *  求斐波那契（Fibonacci) 数列的第n项
 *  1 2 3 4 5 6 7
 *  1 1 2 3 5 8 13 21 34
 * created by ran
 */
public class Fibonacci {
    private static long solution(int n) {
        if (n < 1) throw new InvalidParameterException();

        if (n == 1 || n == 2) {
            return 1;
        }
        return solution(1, 1, n);
    }

    private static long solution(int a, int b, int n) {
        if (n == 2) {
            return b;
        }
        return solution(b, a + b, n - 1);
    }

}
