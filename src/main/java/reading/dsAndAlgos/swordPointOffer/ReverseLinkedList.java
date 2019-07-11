package reading.dsAndAlgos.swordPointOffer;

import reading.dsAndAlgos.util.entity.ListNode;
import reading.dsAndAlgos.util.entity.TestData;

import static reading.dsAndAlgos.util.ConsolePrinter.printNode;

/**
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点
 * created by ran
 */
public class ReverseLinkedList {
    private static <T> ListNode<T> solution(ListNode<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode<T> before = null;
        ListNode<T> after;

        while (head != null) {
            after = head.next;
            head.next = before;
            before = head;
            head = after;
        }
        return before;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = TestData.listNodeInteger();

        ListNode<Integer> reversedListNode = solution(head);

        printNode(reversedListNode);
    }
}
