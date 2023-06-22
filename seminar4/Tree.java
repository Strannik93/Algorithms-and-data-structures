package seminar4;

/**
 * левостороннее красно-черное дерево
 * (left-sided red-black tree)
 */
public class Tree<V extends Comparable<V>> {
    private Node root;

    public boolean contains(V value){
        Node node = root;
        while (node != null){
            if (node.value.equals(value)){
                return true;
            }
            if (node.value.compareTo(value) > 0){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return false;
    }

    public boolean add(V value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            if (result) System.out.println("Элемент успешно добавлен: " + value);
            else System.out.println("Элемент уже есть: " + value);
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            System.out.println("Элемент добавлен(было пустое дерево): " + value);
            return true;
        } 
    }
    
    private boolean addNode(Node node, V value) {
        if (node.value.compareTo(value) == 0) {
            return false;
        } else {
            if (node.value.compareTo(value) > 0) {
                if (node.left != null) {
                    boolean result = addNode(node.left, value);
                    node.left = rebalance(node.left);
                    return result;
                } else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            } else {
                if (node.right != null) {
                    boolean result = addNode(node.right, value);
                    node.right = rebalance(node.right);
                    return result;
                } else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean balance;
        do {
            balance = false;
            if (result.right != null && result.right.color == Color.RED &&
                (result.left == null || result.left.color == Color.BLACK)) {
                    balance = true;
                    result = rightSwap(result);
                }
            if (result.left != null && result.left.color == Color.RED &&
                result.left.left != null && result.left.left.color == Color.RED) {
                    balance = true;
                    result = leftSwap(result);
                }
            if (result.left != null && result.left.color == Color.RED &&
                result.right != null && result.right.color == Color.RED) {
                    balance = true;
                    colorSwap(result);
                }
        } while (balance);
        return result;
    }

    private Node rightSwap(Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }

    private Node leftSwap(Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }

    private void colorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    public void print() {
        if (root == null) System.out.println("Дерево пустое");
        else print(root);
    }

    private void print(Node node) {
        Node left = node.left;
        Node right = node.right;
        System.out.print(node + " -> left: ");
        if (left == null) System.out.print("null, right: ");
        else System.out.print(left + ", right: ");
        if (right == null) System.out.println("null");
        else System.out.println(right);
        if (left != null) print(left);
        if (right != null) print(right);
    }

    private class Node{
        private V value;
        private Color color;
        private Node left;
        private Node right;

        @Override
        public String toString() {
            return value + "(" + color + ")";
        }
    }

    private enum Color {
        RED, BLACK
    }
}

    //        *
    // * * *     * * * 