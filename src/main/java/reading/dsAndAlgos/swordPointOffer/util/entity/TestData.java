package reading.dsAndAlgos.swordPointOffer.util.entity;

/**
 * created by ran
 */
public class TestData {
    public static ListNode<Integer> listNodeInteger() {
        ListNode<Integer> node1 = new ListNode<>();
        node1.value = 1;
        ListNode<Integer> node2 = new ListNode<>();
        node2.value = 2;
        ListNode<Integer> node3 = new ListNode<>();
        node3.value = 3;
        ListNode<Integer> node4 = new ListNode<>();
        node4.value = 4;
        ListNode<Integer> node5 = new ListNode<>();
        node5.value = 5;

        // 1 2 4 3 5
        node1.next = node2;
        node2.next = node4;
        node3.next = node5;
        node4.next = node3;

        System.out.println("Node value in order: 1 2 4 3 5, compare it with console output.");
        return node1;
    }

    /**
     *                           7
     *                        /   \
     *                      3     9
     *                    /  \   / \
     *                   1   6  8  10
     * @return {@link BinaryTreeNode}
     */
    public static BinaryTreeNode binaryTreeNodeInteger() {
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        BinaryTreeNode node5 = new BinaryTreeNode();
        BinaryTreeNode node6 = new BinaryTreeNode();
        BinaryTreeNode node7 = new BinaryTreeNode();
        node1.value = 7;
        node2.value = 3;
        node3.value = 1;
        node4.value = 6;
        node5.value = 9;
        node6.value = 8;
        node7.value = 10;

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.left = node6;
        node5.right = node7;

        System.out.println("                               7\n" +
                "                             /   \\\n" +
                "                           3     9\n" +
                "                         /  \\   / \\\n" +
                "                        1   6  8  10\n--------------------------");
        return node1;
    }
}
