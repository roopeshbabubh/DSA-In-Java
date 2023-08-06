import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public ArrayList<Integer> bsfTraversal() {
        Node currentNode = root;
        Queue<Node> que = new LinkedList<>();
        ArrayList<Integer> arrList = new ArrayList<>();

        que.add(currentNode);

        while (que.size() > 0) {
            currentNode = que.remove();
            arrList.add(currentNode.value);
            if (currentNode.left != null) {
                que.add(currentNode.left);
            }
            if (currentNode.right != null) {
                que.add(currentNode.right);
            }
        }
        return arrList;
    }

    public ArrayList<Integer> dfsPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> dfsPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> dfsInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return results;
    }
}