package reading.dsAndAlgos.swordPointOffer;

import java.util.Stack;

/**
 * 第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序
 * created by ran
 */
public class StackPopOrder {
    public static boolean solution(int[] push, int[] pop) {
        int len;
        if (push == null || pop == null || (len = push.length) == 0 || len != pop.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0, popIndex = 0;

        while (popIndex < len) {
            while (pushIndex < len && (stack.isEmpty() || stack.peek() != pop[popIndex])) {
                stack.push(push[pushIndex++]);
            }
            if (stack.peek() == pop[popIndex]) {
                stack.pop();
                popIndex++;
            } else {
                // now (pushIndex == len) but (stack.peek() != pop[popIndex])
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{4, 5, 3, 2, 1};
        boolean result1 = solution(a, b);
        boolean result2 = solution(a, new int[]{4, 5, 3, 1, 2});
        System.out.println(result1 + " " + result2);
    }
}
