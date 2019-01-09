package mandatory1.src.main.java.no.uib.ii.inf102.f18.mandatory1;

public class BinarySearchTree<Key extends Comparable<Key>, Value> implements ISymTable<Key, Value> {
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left, right;
        int size;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.size = 1;
        }
    }

    @Override
    public void put(Key key, Value value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value);

        int compare = key.compareTo(node.key);
        if (compare < 0)
            node.left = insert(node.left, key, value);
        else if (compare > 0)
            node.right = insert(node.right, key, value);
        else
            node.value = value;

        node.size = size(node.left) + size(node.right) + 1;

        return node;
    }

    @Override
    public boolean containsKey(Key key) {
        return get(key) != null;
    }

    @Override
    public Value get(Key key) {
        Node target = root;

        while (target != null) {
            int compare = key.compareTo(target.key);
            if (compare < 0)
                target = target.left;
            else if (compare > 0)
                target = target.right;
            else
                return target.value;
        }
        return null;
    }

    private Node maximum(Node node) {
        if (node == null)
            throw new IllegalArgumentException("Can't find maximum in a non-existing tree!");
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    private Node minimum(Node node) {
        if (node == null)
            throw new IllegalArgumentException("Can't find minimum in a non-existing tree!");
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    private Node deleteMinimum(Node node) {
        if (node == null)
            throw new IllegalArgumentException("Can't delete minimum in a non-existing tree!");
        if (node.left == null)
            return node.right;

        node.left = deleteMinimum(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public void delete(Key key) {
        root = deleteKey(root, key);
    }

    private Node deleteKey(Node node, Key key) {
        if (node == null)
            return null;

        int compare = key.compareTo(node.key);
        if (compare < 0)
            node.left = deleteKey(node.left, key);
        else if (compare > 0)
            node.right = deleteKey(node.right, key);
        else {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;

            Node minRight = minimum(node.right);
            minRight.right = deleteMinimum(node.right);
            minRight.left = node.left;

            node = minRight;
        }

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public Iterable<Key> keys() {
        return keys(minimum(root).key, maximum(root).key);
    }

    private IQueue<Key> keys(Key min, Key max) {
        MyLinkedListQueue<Key> queue = new MyLinkedListQueue<>();
        keys(root, queue, max, min);
        return queue;
    }

    private void keys(Node node, IQueue<Key> queue, Key max, Key min) {
        if (node == null)
            return;

        int compareToMax = max.compareTo(node.key);
        int compareToMin = min.compareTo(node.key);

        if (compareToMin < 0)
            keys(node.left, queue, max, min);

        if (compareToMax >= 0 && compareToMin <= 0)
            queue.enqueue(node.key);

        if (compareToMax > 0)
            keys(node.right, queue, max, min);
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        return node == null ? 0 : node.size;
    }
}
