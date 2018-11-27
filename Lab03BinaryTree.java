import java.util.LinkedList;
import java.util.Queue;
/**
 * TODO Your detailed comments
 */
public class Lab03BinaryTree {

    public class Node {
        int value;
        Node leftChild;
        Node rightChild;

        Node(int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    private Lab03BinaryTree() {
    }

    private Node createBinaryTreeFromList(int[] listNodes) {
        Node root = null;
        for (int nodeI : listNodes) {
            Node node = new Node(nodeI);
            root = addNode(root, node);
        }
        return root;
    }

    private Node addNode(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        } else {
            if (newNode.value <= root.value) {
                root.leftChild = addNode(root.leftChild, newNode);
            } else {
                root.rightChild = addNode(root.rightChild, newNode);
            }
        }
        return root;
    }

    /**
     * TODO Your comment goes to here.
     *
     * @param root
     * @return
     */
    private boolean isComplete(Node root) {
        // TODO Your code goes to here
        return false;
    }

    /**
     * TODO Your comment goes to here.
     *
     * @param root
     * @return
     */
    private boolean isFull(Node root) {
        // TODO Your code goes to here
        return false;
    }

    private void printResult(Node root) {
        boolean isFullBinary = isFull(root);
        boolean isCompleteBinary = isComplete(root);
        if (isCompleteBinary && isFullBinary) {
            System.out.println("This is a complete and full binary tree!");
        } else if (isCompleteBinary) {
            System.out.println("This is a complete binary tree!");
        } else if (isFullBinary) {
            System.out.println("This is a full binary tree!");
        } else {
            System.out.println("This is neither a complete or full tree!");
        }
    }

    public static void main(String[] args) {
        Lab03BinaryTree bt = new Lab03BinaryTree();
        /*
         *              20
         *             /  \
         *           10   30
         *           /
         *          5
         */
        int[] testTree01 = {20, 10, 30, 5};
        Node root01 = bt.createBinaryTreeFromList(testTree01);
        bt.printResult(root01);
        /*
         *              30
         *            /    \
         *          20     40
         *         /  \    /
         *        15  25  35
         */
        int[] testTree02 = {30, 40, 20, 15, 25, 35};
        Node root02 = bt.createBinaryTreeFromList(testTree02);
        bt.printResult(root02);
        /*
         *             30
         *            /  \
         *          20   40
         *              /  \
         *             35  50
         *                /  \
         *               45  60
         *
         */
        int[] testTree03 = {30, 40, 50, 60, 20, 35, 45};
        Node root03 = bt.createBinaryTreeFromList(testTree03);
        bt.printResult(root03);
        /*
         *                    30
         *                  /   \
         *                 20   35
         *                /  \
         *              10    25
         *              /  \
         *             5    15
         *            / \
         *           2   7
         */
        int[] testTree04 = {30, 20, 10, 5, 2, 35, 25, 15, 7};
        Node root04 = bt.createBinaryTreeFromList(testTree04);
        bt.printResult(root04);
        /*
         *                    5
         *                  /   \
         *                 2     8
         */
        int[] testTree05 = {5, 2, 8};
        Node root05 = bt.createBinaryTreeFromList(testTree05);
        bt.printResult(root05);
        /*
         *                     20
         *                   /    \
         *                 10     30
         *                /  \    / \
         *               5   15  25 35
         */
        int[] testTree06 = {20, 10, 30, 5, 15, 25, 35};
        Node root06 = bt.createBinaryTreeFromList(testTree06);
        bt.printResult(root06);
        /*
         *                    20
         *                      \
         *                      40
         *                      /
         *                    30
         */
        int[] testTree07 = {20, 40, 30};
        Node root07 = bt.createBinaryTreeFromList(testTree07);
        bt.printResult(root07);
        /*
         *                    20
         *                  /   \
         *                 10   30
         *                     /
         *                    25
         */
        int[] testTree08 = {20, 10, 30, 25};
        Node root08 = bt.createBinaryTreeFromList(testTree08);
        bt.printResult(root08);
        /*
         * You should expect the following outputs:
         *      This is a complete binary tree!
         *      This is a complete binary tree!
         *      This is a full binary tree!
         *      This is a full binary tree!
         *      This is a complete and full binary tree!
         *      This is a complete and full binary tree!
         *      This is neither a complete or full tree!
         *      This is neither a complete or full tree!
         */
    }
}
