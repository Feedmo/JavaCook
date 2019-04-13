package reading.dsAndAlgos.codingInterviewGuide.stackAndQueue;

import java.util.Stack;

import static reading.dsAndAlgos.util.ConsolePrinter.printStack;

/**
 * 利用额外的一个栈将目标栈中的元素从顶到底按从大到小排序
 * created by ran
 */
public class SortStackUsingStack {
    private static void solution(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(8);
        stack.push(1);
        stack.push(-5);
        stack.push(6);

        solution(stack);
        printStack(stack);
    }
}
