public class BinarySearchTree {

    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "Node {" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        Node(int value) {
            this.value = value;
        }
    }

    BinarySearchTree() {

    }

    public void addData(int value) {
        Node newNode = new Node(value);
        if (root == null) root = newNode;
        Node temp = root;
        if (temp.value == newNode.value) return;
        while (true) {
            if (temp.value > newNode.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (temp.value == value) return true;
            if (value < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "BinarySearchTree {" +
                "root=" + root +
                '}';
    }
}
