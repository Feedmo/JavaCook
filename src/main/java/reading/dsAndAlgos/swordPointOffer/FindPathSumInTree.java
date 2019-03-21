package reading.dsAndAlgos.swordPointOffer;

import reading.dsAndAlgos.swordPointOffer.util.entity.BinaryTreeNode;
import reading.dsAndAlgos.swordPointOffer.util.entity.TestData;

/**
 * 查找二叉树中是否存在根结点到叶子节点的节点和为指定数值的路径
 * created by ran
 */
public class FindPathSumInTree {
    private static void solution(BinaryTreeNode<Integer> node, int target) {
        if (node == null || target < node.value) return;

        String path = node.value + "->";
        solution(node, target, 0, path);
    }

    private static void solution(BinaryTreeNode<Integer> node, int target, int sum, String path) {
        if (node == null) return;

        sum += node.value;
        if (sum < target) {
            solution(node.left, target, sum, path + (node.left == null ? "" : node.left.value + "->"));
            solution(node.right, target, sum, path + (node.right == null ? "" : node.right.value + "->"));
        } else if (sum == target) {
            if (node.left == null && node.right == null) {
                System.out.println(path + "null");
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> node = TestData.binaryTreeNodeInteger();
        solution(node, 16);
        solution(node, 12);
    }
}
