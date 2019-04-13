package reading.dsAndAlgos.algorithms.ch01.part3;

import java.util.Stack;

/**
 *
 * created by ran
 */
public class Exercise9 {
    private static String getCompleteInfixExpression(String input) {
        System.out.println(input);
        Stack<String> stack = new Stack<>();

        String[] items = input.split(" ");

        for (String item : items) {
            if (!item.equals(")")) {
                stack.push(item);
            } else {
                if (stack.isEmpty()) {
                    throw new RuntimeException("stack empty");
                }
                String operand1 = stack.pop();
                String operator = stack.pop();
                String operand2 = stack.pop();
                stack.push("( " + operand2 + " " + operator + " " + operand1 + " )");
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String result = getCompleteInfixExpression("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )");
        System.out.println(result);     // ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
    }
}
