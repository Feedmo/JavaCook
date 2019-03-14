package reading.dsAndAlgos.swordPointOffer.util.entity;

/**
 * created by ran
 */
public class TestData {
    public static ListNode<Integer> ListNodeInteger() {
        ListNode<Integer> node1 = new ListNode<>();
        node1.value = 1;
        ListNode<Integer> node2 = new ListNode<>();
        node2.value = 2;
        ListNode<Integer> node3 = new ListNode<>();
        node3.value = 3;
        ListNode<Integer> node4 = new ListNode<>();
        node4.value = 4;
        ListNode<Integer> node5 = new ListNode<>();
        node5.value = 5;

        // 1 2 4 3 5
        node1.next = node2;
        node2.next = node4;
        node3.next = node5;
        node4.next = node3;

        System.out.println("Node value in order: 1 2 4 3 5, compare it with console output.");
        return node1;
    }
}
