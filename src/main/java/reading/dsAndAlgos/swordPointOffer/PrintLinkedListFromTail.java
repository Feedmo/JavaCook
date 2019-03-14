package reading.dsAndAlgos.swordPointOffer;

import reading.dsAndAlgos.swordPointOffer.util.entity.ListNode;

import java.util.Stack;

/**
 * created by ran
 */
public class PrintLinkedListFromTail {

    public static void solution_1(ListNode<String> listNodeList) {
        Stack<ListNode> stack = new Stack<>();

        ListNode<String> root = listNodeList;
        while (root != null) {
            stack.push(root);
            root = root.next;
        }

        while (!stack.isEmpty()) {
            if (stack.size() != 1) {
                System.out.println(stack.pop().value + "->");
            } else {
                System.out.println(stack.pop().value);
            }
        }
    }

    private static void solution_2(ListNode<String> listNodeList) {
        if (listNodeList == null) return;

        solution_2(listNodeList.next);
        if (listNodeList.next == null) {
            System.out.println(listNodeList.value);
        } else {
            System.out.println("->" + listNodeList.value);
        }
    }
}
