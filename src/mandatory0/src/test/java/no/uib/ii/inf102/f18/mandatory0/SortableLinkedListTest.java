package mandatory0.src.test.java.no.uib.ii.inf102.f18.mandatory0;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mandatory0.src.main.java.no.uib.ii.inf102.f18.mandatory0.ISortableList;
import mandatory0.src.main.java.no.uib.ii.inf102.f18.mandatory0.SortableLinkedList;

import java.util.Arrays;

public class SortableLinkedListTest extends TestCase {
    private ISortableList<String> ll;
    private String s1 = "0", s2 = "1", s3 = "2", s4 = "3";

    public SortableLinkedListTest(String testName) {
        super(testName);
        ll = new SortableLinkedList<String>();
    }

    public static Test suite() {
        return new TestSuite(SortableLinkedListTest.class);
    }

    public void testAddGet () {
        System.out.println("Testing add() and get() functions ...");
        System.out.println("Initial linked list:");
        ll.printList();
        System.out.println("Adding \"" + s1 + "\" ...");
        ll.add(s1);
        System.out.println("Results:");
        ll.printList();
        assertEquals (ll.get(0), s1);
        System.out.println("Adding \"" + s2 + "\" ...");
        ll.add(s2);
        System.out.println("Results:");
        ll.printList();
        assertEquals (ll.get(1), s2);
        System.out.println("Adding \"" + s3 + "\" ...");
        ll.add(s3);
        System.out.println("Results:");
        ll.printList();
        assertEquals (ll.get(2), s3);
        System.out.println("Adding \"" + s4 + "\" ...");
        ll.add(s4);
        System.out.println("Results:");
        ll.printList();
        assertEquals (ll.get(3), s4);
        assertEquals (ll.size(), 4);
        System.out.println("Success!");
        System.out.println("---");
    }

    public void testAddToIndex () {
        System.out.println("Testing add() to index function ...");
        ll.add(s1);
        ll.add(s2);
        ll.add(s3);
        ll.add(s4);
        System.out.println("Initial linked list:");
        ll.printList();

        System.out.println("Adding \"newHead\" to index 0 ...");
        ll.add(0, "newHead");
        assertEquals(ll.get(0), "newHead");
        assertEquals(ll.get(1), "0");
        assertEquals(ll.get(ll.size() - 1), "3");
        assertEquals(ll.size(), 5);
        System.out.println("Results:");
        ll.printList();

        System.out.println("Adding \"newNode\" to index 2 ...");
        ll.add(2, "newNode");
        assertEquals(ll.get(0), "newHead");
        assertEquals(ll.get(1), "0");
        assertEquals(ll.get(2), "newNode");
        assertEquals(ll.get(3), "1");
        assertEquals(ll.get(ll.size() - 1), "3");
        assertEquals(ll.size(), 6);
        System.out.println("Results:");
        ll.printList();

        System.out.println("Adding \"newTail\" to index 5 ...");
        ll.add(5, "newTail");
        assertEquals(ll.get(0), "newHead");
        assertEquals(ll.get(1), "0");
        assertEquals(ll.get(2), "newNode");
        assertEquals(ll.get(3), "1");
        assertEquals(ll.get(5), "3");
        assertEquals(ll.get(ll.size() - 1), "newTail");
        assertEquals(ll.size(), 7);
        System.out.println("Results:");
        ll.printList();
        System.out.println("Success!");
        System.out.println("---");
    }

    public void testRemove () {
        System.out.println("Testing remove() function ...");
        ll.add(s1);
        ll.add(s2);
        ll.add(s3);
        ll.add(s4);
        ll.add(0, "newHead");
        ll.add(2, "newNode");
        ll.add(5, "newTail");
        System.out.println("Initial linked list:");
        ll.printList();

        System.out.println("Removing \"" + ll.remove(2) + "\" ...");
        assertEquals(ll.get(1), "0");
        assertEquals(ll.get(2), "1");
        assertEquals(ll.get(ll.size() - 1), "newTail");
        assertEquals(ll.size(), 6);
        System.out.println("Results:");
        ll.printList();

        System.out.println("Removing \"" + ll.remove(5) + "\" ...");
        assertEquals(ll.get(0), "newHead");
        assertEquals(ll.get(3), "2");
        assertEquals(ll.get(ll.size() - 1), "3");
        assertEquals(ll.size(), 5);
        System.out.println("Results:");
        ll.printList();

        System.out.println("Removing \"" + ll.remove(0) + "\" ...");
        assertEquals(ll.get(0), "0");
        assertEquals(ll.get(1), "1");
        assertEquals(ll.get(2), "2");
        assertEquals(ll.get(ll.size() - 1), "3");
        assertEquals(ll.size(), 4);
        System.out.println("Results:");
        ll.printList();
        System.out.println("Success!");
        System.out.println("---");
    }

    public void testToArray () {
        System.out.println("Testing toArray() function ...");
        ll.add(s1);
        ll.add(s2);
        ll.add(s3);
        ll.add(s4);
        String[] strArr = new String[ll.size()];
        System.out.println("Initial linked list:");
        ll.printList();

        System.out.println("Transferring elements from the list to array ...");
        ll.toArray(strArr);
        assertEquals(strArr[0], "0");
        assertEquals(strArr[1], "1");
        assertEquals(strArr[2], "2");
        assertEquals(strArr[3], "3");
        System.out.println("Array of the same size:");
        System.out.println(Arrays.toString(strArr));

        strArr = new String[ll.size() + 2];
        ll.toArray(strArr);
        assertNull(strArr[4]);
        assertNull(strArr[5]);
        System.out.println("Array of larger size:");
        System.out.println(Arrays.toString(strArr));

        System.out.println("Array of smaller size:");
        strArr = new String[ll.size() - 2];
        try {
            ll.toArray(strArr);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Success!");
        }
        System.out.println("---");
    }

    public void testClear() {
        System.out.println("Testing clear() function ...");
        ll.add(s1);
        ll.add(s2);
        ll.add(s3);
        ll.add(s4);
        System.out.println("Initial linked list:");
        ll.printList();

        System.out.println("Clearing the list ...");
        ll.clear();
        System.out.println("Results:");
        ll.printList();
        assertTrue(ll.isEmpty());
        System.out.println("Success!");
        System.out.println("---");
    }

    public void testSort() {
        System.out.println("Testing sort() function ...");
        ll.add("E");
        ll.add("C");
        ll.add("A");
        ll.add("F");
        ll.add("Z");
        System.out.println("Initial linked list:");
        ll.printList();
        System.out.println("Executing merge sort ...");
        ll.sort();
        assertEquals(ll.get(0), "A");
        assertEquals(ll.get(1), "C");
        assertEquals(ll.get(2), "E");
        assertEquals(ll.get(3), "F");
        assertEquals(ll.get(4), "Z");
        System.out.println("Results:");
        ll.printList();
        System.out.println("Success!");
        System.out.println("---");
    }
}
