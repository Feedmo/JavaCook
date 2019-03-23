package reading.dsAndAlgos.util.entity;

/**
 * created by ran
 */
public class ListNode<T> {
    public T value;
    public ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T value, ListNode<T> next) {
        this.value = value;
        this.next = next;
    }

}
