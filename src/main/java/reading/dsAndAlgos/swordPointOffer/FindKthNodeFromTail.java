package reading.dsAndAlgos.swordPointOffer;

import reading.dsAndAlgos.swordPointOffer.util.entity.ListNode;
import reading.dsAndAlgos.swordPointOffer.util.entity.TestData;

/**
 * 查找链表的倒数第K个结点
 * created by ran
 */
public class FindKthNodeFromTail {
    private static ListNode<Integer> solution(ListNode<Integer> head, int k) {
        if (head == null || k < 1) {
            return null;
        }

        ListNode<Integer> p = head, q = head;
        for (int i = 0; i < k - 1; i++) {
            q = q.next;
            if (q == null) return null;
        }

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode<Integer> node1 = TestData.ListNodeInteger();

        ListNode<Integer> result1 = solution(node1, 3);
        ListNode<Integer> result2 = solution(node1, 1);
        ListNode<Integer> result3 = solution(node1, 5);
        System.out.println(result1.value);
        System.out.println(result2.value);
        System.out.println(result3.value);
    }
}
