package reading.dsAndAlgos.swordPointOffer;

import reading.dsAndAlgos.util.entity.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
 * created by ran
 */
public class MergeSortedLinkedList {
    public static ListNode<Integer> solution1(ListNode<Integer> head1, ListNode<Integer> head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode<Integer> root = new ListNode<>();
        ListNode<Integer> ptr = root;

        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                ptr.next = head1;
                head1 = head1.next;
            } else {
                ptr.next = head2;
                head2 = head2.next;
            }
            ptr = ptr.next;
        }

        if (head1 == null) {
            ptr.next = head2;
        }
        if (head2 == null) {
            ptr.next = head1;
        }
        ptr = null;
        return root.next;
    }

    public static ListNode<Integer> solution2(ListNode<Integer> head1, ListNode<Integer> head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode<Integer> tmp = head1;
        if (tmp.value < head2.value) {
            tmp.next = solution2(head1.next, head2);
        } else {
            tmp = head2;
            tmp.next = solution2(head1, head2.next);
        }
        return tmp;
    }
}
