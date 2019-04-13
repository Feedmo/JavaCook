package reading.dsAndAlgos.codingInterviewGuide.stackAndQueue;

import java.util.Stack;

import static reading.dsAndAlgos.util.ConsolePrinter.printStack;

/**
 * created by ran
 */
public class ReverseStack {
    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();

        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    private static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        reverse(stack);
        printStack(stack);
    }
}
