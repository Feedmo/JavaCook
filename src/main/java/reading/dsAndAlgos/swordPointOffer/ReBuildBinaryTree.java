package reading.dsAndAlgos.swordPointOffer;

import reading.dsAndAlgos.util.entity.BinaryTreeNode;

import static reading.dsAndAlgos.util.ConsolePrinter.printTree;

/**
 * note 运行出错了，打算重启再试试
 * 根据前序遍历和中序遍历构建二叉树
 *
 * preOrder: [1] 2 4 7 3 5 6 8
 * inOrder: 4 7 2 [1] 5 3 6 8
 *      left: 4 7 [2]
 *     right: 5 [3] 6 8
 *
 *          1
 *       /   \
 *     2     3
 *   /      / \
 *  4      5  6
 *  \          \
 *  7          8
 *  created by ran
 */
public class ReBuildBinaryTree {

    private static BinaryTreeNode constructor(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0 || preOrder.length != inOrder.length) {
            return null;
        }

        return constructor(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    private static BinaryTreeNode constructor(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie) {
        if (ps > pe) {
            return null;
        }

        int value = preOrder[ps];
        int index = is;
        while (index <= ie && value != inOrder[index]) {
            index++;
        }

        if (index > ie) {
            throw new RuntimeException("Invalid input");
        }

        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;

        node.left = constructor(preOrder, ps + 1, ps + index - is, inOrder, is, index - 1);
        node.right = constructor(preOrder, ps + index - is + 1, pe, inOrder, index + 1, ie);

        return node;
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};

        BinaryTreeNode root = constructor(preOrder, inOrder);
        printTree(root);
    }
}
