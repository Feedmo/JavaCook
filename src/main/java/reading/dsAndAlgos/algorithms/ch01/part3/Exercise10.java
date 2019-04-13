package reading.dsAndAlgos.algorithms.ch01.part3;

import java.util.Stack;

/**
 *  1+2-3 -> 12+3-
 * created by ran
 */
public class Exercise10 {
    private static String infixToPostfix(String infixExpression) {
        System.out.println(infixExpression);
        Stack<String> stack = new Stack<>();

        String[] items = infixExpression.split(" ");

        for (int i = 0; i < items.length; i++) {
            String operator = items[i];
            if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                if (stack.isEmpty() || i == items.length - 1) {
                    throw new RuntimeException("stack empty");
                }
                String operand1 = stack.pop();
                String operand2 = items[i+1];
                stack.push(operand1 + " " + operand2 + " " + operator + " ");
                i++;
            } else {
                stack.push(operator);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String result = infixToPostfix("1 + 2 - 3");
        System.out.println(result);
    }
}
