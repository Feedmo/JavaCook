package reading.dsAndAlgos.swordPointOffer;

/**
 * created by ran
 */
public class NumberOfOneInBinaryFormat {
    public static int solution(int n) {
        return solution_iter(n, 0);
    }

    private static int solution_rec(int n, int result) {
        if (n == 0) return result;

        if (n % 2 == 1) result++;
        n >>= 1;

        return solution_rec(n, result);
    }

    private static int solution_iter(int n, int result) {
        while (n != 0) {
            if (n % 2 == 1) result++;
            n >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution_rec(15, 0));
        System.out.println(solution_iter(15, 0));
    }
}
