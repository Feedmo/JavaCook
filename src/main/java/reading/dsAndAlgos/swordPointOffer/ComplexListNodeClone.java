package reading.dsAndAlgos.swordPointOffer;

/**
 * Node包含指向下一个结点的引用和指向任意结点的引用，复制一个新的此类型的NodeList（包括引用
 * created by ran
 */
public class ComplexListNodeClone {
    static class Node {
        int value;
        Node next;
        Node sibling;

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    public static Node solution(Node head) {
        if (head == null) return null;
        cloneNodes(head);
        createSiblings(head);
        return apartNodes(head);
    }

    private static void cloneNodes(Node node) {
        while (node != null) {
            Node tmp = new Node();
            tmp.value = node.value + 10;
            tmp.next = node.next;
            node.next = tmp;

            node = tmp.next;
        }
    }

    private static void createSiblings(Node node) {
        while (node != null) {
            Node clonedNode = node.next;
            if (node.sibling != null) {
                clonedNode.sibling = node.sibling.next;
            }
            node = clonedNode.next;
        }
    }

    private static Node apartNodes(Node node) {
        Node newNode = node.next;
        Node ptr = newNode;

        while (true) {
            node.next = ptr.next;
            if (node.next == null) break;
            node = node.next;
            ptr.next = node.next;
            ptr = ptr.next;
        }
        return newNode;
    }

    private static void printNode(Node node) {
        while (node.next != null) {
            if (node.sibling != null) {
                System.out.print(node.value + "(" + node.sibling.value + ") -> ");
            } else {
                System.out.print(node.value + " -> ");
            }
            node = node.next;
        }
        System.out.println(node.value);
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.value = 1;
        head.next = new Node();
        head.next.value = 2;
        head.next.next = new Node();
        head.next.next.value = 3;
        head.next.next.next = new Node();
        head.next.next.next.value = 4;
        head.next.next.next.next = new Node();
        head.next.next.next.next.value = 5;

        /**
         * 1->3; 2->5; 4->2
         */
        head.sibling = head.next.next;
        head.next.sibling = head.next.next.next.next;
        head.next.next.next.sibling = head.next;

        printNode(head);
        Node newNode = solution(head);
        printNode(newNode);

    }
}

