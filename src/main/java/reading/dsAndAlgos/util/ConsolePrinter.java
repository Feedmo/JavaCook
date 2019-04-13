package reading.dsAndAlgos.util;

import reading.dsAndAlgos.util.entity.BinaryTreeNode;
import reading.dsAndAlgos.util.entity.ListNode;

import java.util.Stack;

/**
 * created by ran
 */
public class ConsolePrinter {
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

    public static <T> void printArray(T[] array) {
        if (array != null && array.length > 0) {
            for (T i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
