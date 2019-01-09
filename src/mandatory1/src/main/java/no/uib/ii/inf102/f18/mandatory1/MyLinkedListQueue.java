package mandatory1.src.main.java.no.uib.ii.inf102.f18.mandatory1;

import java.util.Iterator;

public class MyLinkedListQueue<E> implements IQueue<E> {
    private Node first, last;
    private int size;

    private class Node {
        private Node next;
        private E payload;

        private Node(E item) {
            payload = item;
            next = null;
        }
    }

    @Override
    public void enqueue(E item) {
        Node lastLast = last;
        last = new Node(item);
        if (empty())
            first = last;
        else
            lastLast.next = last;
        size++;
    }

    @Override
    public E dequeue() {
        E item = first.payload;
        first = first.next;
        size--;
        if (empty())
            last = null;
        return item;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public E peek() {
        return first.payload;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node currNode = first;

            @Override
            public boolean hasNext() {
                return currNode != null;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    E payload = currNode.payload;
                    currNode = currNode.next;
                    return payload;
                }

                return null;
            }
        };
    }
}