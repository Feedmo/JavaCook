package reading.dsAndAlgos.swordPointOffer;

import reading.dsAndAlgos.swordPointOffer.util.entity.ListNode;
import reading.dsAndAlgos.swordPointOffer.util.entity.TestData;

import static reading.dsAndAlgos.swordPointOffer.util.ConsolePrint.printNode;

/**
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点
 * created by ran
 */
public class ReverseLinkedList {
    private static <T> ListNode<T> solution(ListNode<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode<T> ptr = new ListNode<>();
        ptr.next = null;

        ListNode<T> next;
        while (head != null) {
            next = head.next;
            head.next = ptr.next;
            ptr.next = head;
            head = next;
        }

        return ptr.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = TestData.listNodeInteger();

        ListNode<Integer> reversedListNode = solution(head);

        printNode(reversedListNode);
    }
}
