import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);

        return root;
    }

    int maxDepth(Node node) {
        if (node == null)
            return 0;
        else {
            int leftDepth = maxDepth(node.left);
            int rightDepth = maxDepth(node.right);

            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}

public class lab5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the numbers to insert separated by commas: ");
        String input = scanner.nextLine();
        String[] numbers = input.split(",");

        BinaryTree tree = new BinaryTree();

        for (String num : numbers) {
            int value = Integer.parseInt(num.trim());
            tree.insert(value);
        }

        int levels = tree.maxDepth(tree.root);
        System.out.println("The resulting binary tree has " + levels + " levels.");
    }
}
