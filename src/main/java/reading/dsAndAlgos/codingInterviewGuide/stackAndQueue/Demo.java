package reading.dsAndAlgos.codingInterviewGuide.stackAndQueue;

import java.util.Stack;

import static reading.dsAndAlgos.util.ConsolePrinter.printStack;

/**
 * created by ran
 */
public class Demo {
    static void remain(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Integer result = stack.pop();
        remain(stack);
        stack.push(result);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        remain(stack);
        printStack(stack);
    }
}
