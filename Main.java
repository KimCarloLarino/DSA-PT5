import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        System.out.println();
        System.out.println("Note: The root node will always be the first value you will input");
        System.out.println("Followed by the left and right node");
        System.out.println();
        System.out.print("Enter the number of elements to insert: ");
        int n = sc.nextInt();
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter element " + i + ": ");
            int val = sc.nextInt();
            tree.insert(val);
        }

        System.out.println();
        System.out.println();
        System.out.println("[1] In-order Traversal");
        System.out.println("[2] Pre-order Traversal");
        System.out.println("[3] Post-order Traversal");
        System.out.println();
        System.out.print("Select option: ");
        
        int option = sc.nextInt();

        System.out.print("Traversal: ");
        switch (option) {
            case 1:
                tree.inorder();
                break;
            case 2:
                tree.preorder();
                break;
            case 3:
                tree.postorder();
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }
}
