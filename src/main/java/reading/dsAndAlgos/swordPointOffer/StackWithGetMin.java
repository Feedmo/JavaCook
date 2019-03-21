package reading.dsAndAlgos.swordPointOffer;

import java.util.Stack;

/**
 * created by ran
 */
public class StackWithGetMin<T extends Comparable<T>> {
    private Stack<T> dataStack = new Stack<>();
    private Stack<T> minStack = new Stack<>();

    public T getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("empty stack");
        }
        return minStack.peek();
    }

    public void push(T t) {
        dataStack.push(t);
        if (minStack.size() == 0 || minStack.peek().compareTo(t) > 0) {
            minStack.push(t);
        }
    }

    public T pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("empty stack");
        }

        T result = dataStack.pop();
        if (result.compareTo(minStack.pop()) == 0) {
            minStack.pop();
        }
        return result;
    }
}
