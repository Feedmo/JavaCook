package reading.dsAndAlgos.swordPointOffer;

import java.util.Stack;

/**
 * time: O(1) space: O(n)
 * created by ran
 */
public class StackWithGetMin<T extends Comparable<T>> {
    private Stack<T> dataStack;
    private Stack<T> minStack;

    public StackWithGetMin() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public T getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("empty stack");
        }
        return minStack.peek();
    }

    public void push1(T t) {
        dataStack.push(t);
        if (minStack.size() == 0 || minStack.peek().compareTo(t) > 0) {
            minStack.push(t);
        }
    }

    public T pop1() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("empty stack");
        }

        T result = dataStack.pop();
        if (result.compareTo(minStack.pop()) == 0) {
            minStack.pop();
        }
        return result;
    }

    public void push2(T t) {
        if (minStack.isEmpty() || minStack.peek().compareTo(t) > 0) {
            minStack.push(t);
        } else {
            minStack.push(minStack.peek());
        }
        dataStack.push(t);
    }

    public T pop2() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("...");
        }
        minStack.pop();
        return dataStack.pop();
    }

}
