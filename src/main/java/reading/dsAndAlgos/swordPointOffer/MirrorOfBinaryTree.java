package reading.dsAndAlgos.swordPointOffer;

import reading.dsAndAlgos.util.ConsolePrinter;
import reading.dsAndAlgos.util.entity.BinaryTreeNode;
import reading.dsAndAlgos.util.entity.TestData;

/**
 * 二叉树的镜像
 * created by ran
 */
public class MirrorOfBinaryTree {
    private static <T extends Comparable<T>> void mirror(BinaryTreeNode<T> node) {
        if (node == null) return;

        // each recursion only exchange the sub-child(not children)
        BinaryTreeNode<T> tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        mirror(node.left);
        mirror(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = TestData.binaryTreeNodeInteger();
        mirror(root);
        ConsolePrinter.printTreePreOrder(root);
    }
}
