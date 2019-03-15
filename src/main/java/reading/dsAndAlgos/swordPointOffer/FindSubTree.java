package reading.dsAndAlgos.swordPointOffer;

import reading.dsAndAlgos.swordPointOffer.util.entity.BinaryTreeNode;
import reading.dsAndAlgos.swordPointOffer.util.entity.TestData;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构
 * created by ran
 */
public class FindSubTree {
    private static boolean solution(BinaryTreeNode sup, BinaryTreeNode sub) {
        if (sup == sub || sub == null) {
            return true;
        }
        if (sup == null) {
            return false;
        }

        int cmp = sup.value - sub.value;
        if (cmp < 0) {
            return solution(sup.right, sub);
        } else if (cmp > 0) {
            return solution(sup.left, sub);
        } else {
            return solution(sup.left, sub.left) && solution(sup.right, sub.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode sup = TestData.binaryTreeNodeInteger();
        System.out.println(solution(sup, sup.left));

        BinaryTreeNode node11 = new BinaryTreeNode();
        node11.value = 11;
        System.out.println(solution(sup, node11));
    }
}
