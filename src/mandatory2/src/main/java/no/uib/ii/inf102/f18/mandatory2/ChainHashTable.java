package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

import java.lang.reflect.Array;

@SuppressWarnings("unchecked")
public class ChainHashTable<Key extends Comparable<Key>, Value> implements ISymTable<Key, Value> {
    private Node[] hashTable = (Node []) Array.newInstance(Node.class, 4);
    int size = 0;

    private class Node {
        Node next;
        Key key;
        Value value;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(Key key, Value value) {
        int hash = hashMod(key);
        hashTable[hash] = insertKeyAtNode(key, value, hashTable[hash]);
        if (size > hashTable.length * 8)
            resize(hashTable.length * 2);
    }

    private Node insertKeyAtNode(Key key, Value value, Node node) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (node.key.equals(key)) {
            node.value = value;
            return node;
        }

        node.next = insertKeyAtNode(key, value, node.next);
        return node;
    }

    private int hashMod(Key key) {
        return (key.hashCode() & 0x7fffffff) % hashTable.length;
    }

    @Override
    public Value get(Key key) {
        int hash = hashMod(key);
        return getFromNode(key, hashTable[hash]);
    }

    private Value getFromNode(Key key, Node node) {
        if (node == null) return null;

        if (node.key.equals(key))
            return node.value;

        return getFromNode(key, node.next);
    }

    @Override
    public boolean containsKey(Key key) {
        return get(key) != null;
    }

    @Override
    public void delete(Key key) {
        int hash = hashMod(key);
        hashTable[hash] = deleteFromNode(key, hashTable[hash]);
        if (size < hashTable.length * 2 && hashTable.length > 0)
            resize(hashTable.length / 2);
    }

    private void resize(int newSize) {
        Node[] oldHashTable = hashTable;
        hashTable = (Node[]) Array.newInstance(Node.class, newSize);
        size = 0;

        for (int i = 0; i < oldHashTable.length; i++) {
            while (oldHashTable[i] != null) {
                Node node = oldHashTable[i];
                put(node.key, node.value);
                oldHashTable[i] = node.next;
            }
        }
    }

    private Node deleteFromNode(Key key, Node node) {
        if (node == null) return null;

        if (node.key.equals(key)) {
            size--;
            return node.next;
        }

        node.next = deleteFromNode(key, node.next);
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        MyLinkedListQueue<Key> queue = new MyLinkedListQueue<Key>();
        for (int i = 0; i < hashTable.length; i++) {
            for (Node x = hashTable[i]; x != null; x = x.next)
                queue.enqueue(x.key);
        }

        return queue;
    }
}
