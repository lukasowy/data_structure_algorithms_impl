package binarytree;

class Node {
    int key;
    String name;

    Node left;
    Node right;

    public Node(int key, String name) {

        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node [Key = " + key + ", name = " + name + "]";
    }

}

public class BinaryTree {

    private Node root;

    public void addNode(int key, String name) {

        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (key < current.key) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }

    }

    // In order traversal
    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.left);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.right);
        }
    }

    // Preorder Traversal
    public void preorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preorderTraverseTree(focusNode.left);
            preorderTraverseTree(focusNode.right);
        }
    }

    // Postorder Traversal
    public void postorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            postorderTraverseTree(focusNode.left);
            postorderTraverseTree(focusNode.right);
            System.out.println(focusNode);
        }
    }

    public Node findNode(int key) {
        Node current = root;
        while (current.key != key) {
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public Node findMin() {
        if (root == null) {
            System.out.println("Tree is empty!!");
            return null;
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Node findMax() {
        if (root == null) {
            System.out.println("Tree is empty!!");
            return null;
        }
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.addNode(50, "Lukas");
        tree.addNode(25, "Koniolowicz");
        tree.addNode(15, "Minetowiczkin");
        tree.addNode(30, "Maniek");
        tree.addNode(75, "Stefek");
        tree.addNode(85, "Kazik");

        tree.inOrderTraverseTree(tree.root);
        System.out.println();
        tree.preorderTraverseTree(tree.root);
        System.out.println();
        tree.postorderTraverseTree(tree.root);

        System.out.println(tree.findNode(85));
        System.out.println(tree.findMax());
        System.out.println(tree.findMin());
        System.out.println(tree.root.key);
    }
}
