package reading.dsAndAlgos.swordPointOffer.util;

import reading.dsAndAlgos.swordPointOffer.util.entity.BinaryTreeNode;
import reading.dsAndAlgos.swordPointOffer.util.entity.ListNode;

/**
 * created by ran
 */
public class ConsolePrint {
    /**
     * print BinaryTreeNode in-order format
     * @param nodeList {@link BinaryTreeNode}
     */
    public static void printTree(BinaryTreeNode nodeList) {
        if (nodeList == null) return;

        printTree(nodeList.left);
        System.out.print(nodeList.value + " ");
        printTree(nodeList.right);
    }

    /**
     * print ListNode in sequence
     * @param head {@link ListNode}
     */
    public static void printNode(ListNode head) {
        while (head.next != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.print(head.value);
    }

    public static void printArray(int[] array) {
        if (array != null && array.length > 0) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
