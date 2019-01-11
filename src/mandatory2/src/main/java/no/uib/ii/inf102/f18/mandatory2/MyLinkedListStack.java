package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

import java.util.Iterator;

/**
 * @author Andrey Belinskiy
 */
public class MyLinkedListStack<E> extends IStack<E> {
    private Node head;
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
    public E pop() {
        E item = head.payload;
        head = head.next;
        size--;
        return item;
    }

    @Override
    public void push(E item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public boolean empty() {
        return head == null;
    }

    @Override
    public E peek() {
        return head.payload;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node currNode = MyLinkedListStack.this.head;

            @Override
            public boolean hasNext() {
                return currNode != null;
            }

            @Override
            public E next() {
                E data = currNode.payload;
                currNode = currNode.next;
                return data;
            }
        };
    }
}
