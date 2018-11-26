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
            Node focusNode = root;
            Node parent;

            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.left;
                    if (focusNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;
                    if (focusNode == null) {
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
        Node focusNode = root;
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.left;
            } else {
                focusNode = focusNode.right;
            }

            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    public Node findMin() {
        if (root == null) {
            System.out.println("Tree is empty!!");
            return null;
        }
        Node focusNode = root;
        while (focusNode.left != null) {
            focusNode = focusNode.left;
        }
        return focusNode;
    }

    public Node findMax() {
        if (root == null) {
            System.out.println("Tree is empty!!");
            return null;
        }
        Node focusNode = root;
        while (focusNode.right != null) {
            focusNode = focusNode.right;
        }
        return focusNode;
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
        tree.preorderTraverseTree(tree.root);
        tree.postorderTraverseTree(tree.root);

        System.out.println(tree.findNode(13));

        System.out.println(tree.root.key);
    }
}
