package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

import java.util.Iterator;

/**
 * @author Andrey Belinskiy
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class SortableLinkedList<E extends Comparable<E>> implements ISortableList<E> {
    private Node head, tail;
    private int size;

    private class Node {
        private Node next, prev;
        private E payload;
        private int payload2;

        private Node(E item) {
            payload = item;
            payload2 = -1;
            next = prev = null;
        }
    }

    @Override
    public void add(E element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            head = tail = newNode;
            size++;
        }
        else
            addToEdge(newNode, "tail");
    }


    public void add(E element, int element2) {
        Node newNode = new Node(element);
        newNode.payload2 = element2;

        if (isEmpty()) {
            head = tail = newNode;
            size++;
        }
        else
            addToEdge(newNode, "tail");
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        Node newNode = new Node(element);

        if (index == 0)
            if (isEmpty())
                add(element);
            else
                addToEdge(newNode, "head");

        else if (index == size - 1)
            add(element);

        else {
            //go to the position before the index position
            Node beforeTarget = head;
            for (int i = 0; i < index - 1; i++)
                beforeTarget = beforeTarget.next;

            //place the new element at the index position
            //after that link the old elements to the new element
            Node target = beforeTarget.next;
            linkNodes(beforeTarget, newNode, target);
        }
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        Node target = head;

        for (int i = 0; i < index; i++)
            target = target.next;

        return target.payload;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E payload;

        if (index == 0)
            if (head == null)
                return null;
            else
                return removeEdge("head");

        else if (index == size - 1)
            return removeEdge("tail");

        else {
            Node beforeTarget = head;

            //find the node before the index
            for (int i = 0; i < index - 1; i++)
                beforeTarget = beforeTarget.next;

            payload = beforeTarget.next.payload;

            //unlink the target node from the list
            beforeTarget.next = beforeTarget.next.next;
            beforeTarget.next.prev = beforeTarget;
            size--;

            return payload;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort() {
        head = sort(head);
    }

    //sort the list by dividing by half with every recursive call
    private Node sort(Node newHead) {

        //the list is either empty or has only one element
        if (newHead == null || newHead.next == null)
            return newHead;

        Node leftPart, rightPart;

        Node middleNode = findMiddle(newHead);
        Node nextToMiddleNode = middleNode.next;

        //divide the list into two parts
        middleNode.next = null;

        //apply the same technique to two new parts recursively
        leftPart = sort(newHead);
        rightPart = sort(nextToMiddleNode);

        //finally compare the pairs and merge them together
        return compareAndMerge(leftPart, rightPart);
    }

    private Node compareAndMerge(Node first, Node second) {
        //the pair consists of only one node
        if (first == null)
            return second;
        if (second == null)
            return first;

        Node nodeToPick;

        //first, compare two nodes and pick the smallest from the pair,
        //then recursively compare and link the next pair of nodes
        if (compareNodes(first, second) <= 0) {
            nodeToPick = first;
            nodeToPick.next = compareAndMerge(first.next, second);
        }
        else {
            nodeToPick = second;
            nodeToPick.next = compareAndMerge(first, second.next);
        }

        //return the head of the sorted list
        return nodeToPick;
    }

    //slow+fast pointer method is faster than simple counting
    //the fast pointer moves 2x farther than the slow pointer
    //when the fast pointer hits null, the slow pointer will be the middle
    private Node findMiddle(Node target) {
        Node slowPointer, fastPointer;
        slowPointer = fastPointer = target;

        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            if(fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
        }

        //I'll leave the original counting method for reference
        /*int middle = countNodes(target) / 2;

        for (int i = 0; i < middle; i++)
            target = target.next;

        return target;*/

        return slowPointer;
    }

    //count the amount of linked nodes starting from the target node
    /*private int countNodes(Node target) {
        int counter = 0;

        while (target.next != null) {
            counter++;
            target = target.next;
        }

        return counter;
    }*/

    @Override
    public E[] toArray(E[] a) {
        checkSize(a);

        if (head == null) {
            for (int i = 0; i < a.length; i++)
                a[i] = null;
            return a;
        }

        Node currNode = head;
        for (int i = 0; i < size; i++) {
            a[i] = currNode.payload;
            currNode = currNode.next;
        }

        if (a.length > size)
            for (int i = size; i < a.length; i++)
                a[i] = null;

        return a;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node currNode = head;

            @Override
            public E next() {
                if (hasNext()) {
                    E payload = currNode.payload;
                    currNode = currNode.next;
                    return payload;
                }
                return null;
            }

            @Override
            public boolean hasNext() {
                return currNode != null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        };
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printList() {
        for (E elem : this)
            System.out.print(elem + " ");
        System.out.println();
    }

    private void linkNodes(Node first, Node second, Node third) {
        first.next = second;
        second.prev = first;

        second.next = third;
        third.prev = second;

        size++;
    }

    private void addToEdge(Node newNode, String edge) {
        if (edge.equalsIgnoreCase("head")) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }
        else if (edge.equalsIgnoreCase("tail")) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    private E removeEdge(String edge) {
        E payload;

        if (edge.equalsIgnoreCase("head")) {
            payload = head.payload;
            head = head.next;
            head.prev = null;
            size--;
            return payload;
        }

        else if (edge.equalsIgnoreCase("tail")) {
            payload = tail.payload;
            tail = tail.prev;
            tail.next = null;
            size--;
            return payload;
        }

        return null;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw (new IndexOutOfBoundsException(
                    "The index " + index + " is outside of bounds of the list"));
    }

    private void checkSize(E[] a) {
        if (a.length < size)
            throw new IndexOutOfBoundsException(
                    "Error! The size of the provided array ("
                            + a.length + ") is less than the size of the list ("
                            + size + ")");
    }

    //payload2 comparison is used to solve the TrollBook
    private int compareNodes(Node first, Node second) {
        if (first.payload2 == -1 || second.payload2 == -1)
            return first.payload.compareTo(second.payload);
        else
            return first.payload2 - second.payload2;
    }

    /*
    A different method can be used to solve the TrollBook, without
    having to allocate additional payload. But it will require parsing
    Integer from the payload with every comparison which is slow.
    Because we don't have strict space limitations, storing the Integer
    position value in each Node by allocating the second payload is much
    faster for solving the TrollBook.
     */
}
