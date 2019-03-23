package reading.dsAndAlgos.swordPointOffer;

import reading.dsAndAlgos.util.entity.BinaryTreeNode;
import reading.dsAndAlgos.util.entity.TestData;

import java.util.LinkedList;
import java.util.Queue;

/**
 * created by ran
 */
public class PrintTreeFromTopToBottom {
    public static <T extends Comparable<T>> void solution(BinaryTreeNode<T> node) {
        if (node == null) return;

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> item = queue.poll();
            System.out.print(item.value + " ");

            if (item.left != null) {
                queue.add(item.left);
            }
            if (item.right != null) {
                queue.add(item.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = TestData.binaryTreeNodeInteger();
        solution(root);
    }
}
