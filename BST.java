public class BST {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    // Constructor
    BST() {
        root = null;
    }

    // Insert function
    void insert(int x) {
        if (root == null) {
            root = new Node(x);
            return;
        }

        Node curr = root, p = null;

        while (curr != null) {
            p = curr;

            if (x < curr.data)
                curr = curr.left;
            else
                curr = curr.right;
        }

        if (x < p.data)
            p.left = new Node(x);
        else
            p.right = new Node(x);
    }

    // Inorder traversal
    void inorder() {
        fun(root);
    }

    void fun(Node r) {
        if (r == null) return;

        fun(r.left);
        System.out.print(r.data + " ");
        fun(r.right);
    }

    // Main method
    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(35);

        tree.inorder();
    }
}