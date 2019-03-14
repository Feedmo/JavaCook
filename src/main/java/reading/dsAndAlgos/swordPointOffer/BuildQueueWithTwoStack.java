package reading.dsAndAlgos.swordPointOffer;

import java.util.Stack;

/**
 * 利用两个栈实现队列的功能
 * created by ran
 */
public class BuildQueueWithTwoStack<T> {
    private Stack<T> store = new Stack<>();
    private Stack<T> take = new Stack<>();

    public void append(T t) {
        store.add(t);
    }

    public T deleteHead() {
        if (!take.isEmpty()) {
            return take.pop();
        }
        if (store.isEmpty()) {
            throw new RuntimeException("empty queue");
        }
        while (!store.isEmpty()) {
            take.push(store.pop());
        }
        return take.pop();
    }
}
