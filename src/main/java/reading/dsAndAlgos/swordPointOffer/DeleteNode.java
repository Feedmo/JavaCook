package reading.dsAndAlgos.swordPointOffer;

import reading.dsAndAlgos.util.entity.ListNode;

/**
 * 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点
 * created by ran
 */
public class DeleteNode {

    private static ListNode<Integer> delete(ListNode<Integer> head, ListNode<Integer> target) {
        if (head == null || target == null) {
            return head;
        }

        if (head == target) {
            head = head.next;
            return head;
        }

        if (target.next == null) {
            ListNode<Integer> tmp = head;
            while (tmp.next != target) {
                tmp = tmp.next;
            }
            tmp.next = null;
        } else {
            target.value = target.next.value;
            target.next = target.next.next;
        }

        return head;
    }
}
