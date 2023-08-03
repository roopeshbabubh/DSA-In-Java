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

    public void deleteData(int value) {
        deleteData(root, value);
    }

    private Node deleteData(Node currentNode, int value) {
        if (currentNode == null) return null;
        if (value < currentNode.value) {
            currentNode.left = deleteData(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteData(currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null ) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int rightSubTreeMin = minValueInBST(currentNode.right);
                currentNode.value = rightSubTreeMin;
                currentNode.right = deleteData(currentNode.right, rightSubTreeMin);
            }
        }
        return currentNode;
    }

    private int minValueInBST(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    @Override
    public String toString() {
        return "BinarySearchTree {" +
                "root=" + root +
                '}';
    }
}