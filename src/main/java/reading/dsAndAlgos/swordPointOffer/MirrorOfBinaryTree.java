package reading.dsAndAlgos.swordPointOffer;

import reading.dsAndAlgos.swordPointOffer.util.ConsolePrint;
import reading.dsAndAlgos.swordPointOffer.util.entity.BinaryTreeNode;
import reading.dsAndAlgos.swordPointOffer.util.entity.TestData;

/**
 * 二叉树的镜像
 * created by ran
 */
public class MirrorOfBinaryTree {
    private static <T extends Comparable<T>> void mirror(BinaryTreeNode<T> node) {
        if (node == null) return;

        BinaryTreeNode<T> tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        mirror(node.left);
        mirror(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = TestData.binaryTreeNodeInteger();
        mirror(root);
        ConsolePrint.printTree(root);
    }
}
