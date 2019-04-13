package reading.dsAndAlgos.algorithms.ch01.part3;

import java.util.Stack;

/**
 * Reads in a text stream from standard input and uses a stack to determine whether its parentheses are properly balanced.
 * created by ran
 */
public class Exercise4 {
    public static void main(String[] args) {
        String textStreamInput = args[0]; // {()[]}
        System.out.println("Is balanced " + textStreamInput + ": " + isBalanced(textStreamInput));  // true
        System.out.println("Is balanced " + "[()]{}{[()()]()}: " + isBalanced("[()]{}{[()()]()}")); // true
        System.out.println("Is balanced " + "[(}]: " + isBalanced("[()]{}{[()()]()}"));             // false
    }

    private static boolean isBalanced(String input) {
        char[] parentheses = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char parenthesis : parentheses) {
            if (parenthesis == '[' || parenthesis == '(' || parenthesis == '{') {
                stack.push(parenthesis);
            } else {
                // note: fast-fail
                if (stack.isEmpty()) {
                    return false;
                }

                char lastItem = stack.pop();
                if (parenthesis == ']' && lastItem != '[' || parenthesis == ')' && lastItem != '('
                        || parenthesis == '}' && lastItem != '{') {
                    return false;
                }
            }
        }
        return true;
    }
}
