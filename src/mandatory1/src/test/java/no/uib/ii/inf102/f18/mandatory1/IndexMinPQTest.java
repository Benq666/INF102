package mandatory1.src.test.java.no.uib.ii.inf102.f18.mandatory1;

import static org.junit.jupiter.api.Assertions.*;

import mandatory1.src.main.java.no.uib.ii.inf102.f18.mandatory1.IndexMinPQ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.SplittableRandom;

/**
 * @author Andrey Belinskiy
 */
public class IndexMinPQTest {
    private String[] str = { "A", "horrible", "man", "ate", "my", "bike",
            "and", "then", "looked", "at", "me" };
    private IndexMinPQ<String> pq = new IndexMinPQ<>(str.length);

    @BeforeEach
    void setup() {
        pq = new IndexMinPQ<>(str.length);
    }

    @Test
    void sanityTest() {
        System.out.println("Sanity test.\n");
        assertNull(pq.peekKey());
        assertTrue(pq.isEmpty());

        for (int i = 0; i < str.length; i++)
            pq.add(i, str[i]);

        assertTrue(pq.contains(0));
        assertEquals(pq.getKey(0), str[0]);

        assertTrue(pq.contains(5));
        assertEquals(pq.getKey(5), str[5]);

        assertTrue(pq.contains(10));
        assertEquals(pq.getKey(10), str[10]);

        assertEquals(pq.size(), 11);
        assertEquals(pq.peek(), 0);
        assertEquals(pq.peekKey(), "A");
        assertFalse(pq.isEmpty());

        printPQ(pq);
        System.out.printf("%nSuccess!%n------------%n");
    }

    @RepeatedTest(5)
    void addToIndexTest() {
        System.out.println("Add to index test.\n");

        int n = str.length;
        int[] ind = new int[n];
        for (int i = 0; i < n; i++)
            ind[i] = i;
        shuffle(ind);

        for (int i = 0; i < n; i++) {
            pq.add(ind[i], str[ind[i]]);
            assertTrue(pq.contains(ind[i]));
            assertEquals(pq.getKey(ind[i]), str[ind[i]]);
            System.out.println(ind[i] + " " + str[ind[i]]);
        }
        System.out.println();

        printPQ(pq);
        System.out.printf("%nSuccess!%n------------%n");
    }

    @Test
    void pollTest() {
        System.out.println("Poll test.\n");

        for (int i = 0; i < str.length; i++)
            pq.add(i, str[i]);

        while (!pq.isEmpty()) {
            int counter = pq.size(), i = pq.poll();
            assertFalse(pq.contains(i));
            assertEquals(pq.size(), counter - 1);
            System.out.println(i + " " + str[i]);
        }
        assertTrue(pq.isEmpty());

        System.out.printf("%nSuccess!%n------------%n");
    }

    @Test
    void severalInsertionsTest() {
        System.out.println("Several insertions test.\n");

        for (int i = 0; i < str.length; i++)
            pq.add(i, str[i]);
        printPQ(pq);

        assertEquals(pq.size(), 11);
        assertEquals(pq.peek(), 0);
        assertEquals(pq.peekKey(), "A");

        while (!pq.isEmpty()) {
            int i = pq.poll();
            System.out.println(i + " " + str[i]);
        }
        System.out.println();

        assertTrue(pq.isEmpty());
        assertNull(pq.peekKey());

        for (int i = 0; i < str.length; i++)
            pq.add(i, str[i]);
        printPQ(pq);

        assertEquals(pq.size(), 11);
        assertEquals(pq.peek(), 0);
        assertEquals(pq.peekKey(), "A");

        System.out.printf("%nSuccess!%n------------%n");
    }

    @Test
    void changeKeyTest() {
        System.out.println("Change key test.\n");

        for (int i = 0; i < str.length; i++)
            pq.add(i, str[i]);

        pq.changeKey(0, "z");
        assertEquals(pq.getKey(0), "z");
        assertEquals(pq.peekKey(), "and");
        printPQ(pq);

        pq.changeKey(0, "A");
        assertEquals(pq.peekKey(), "A");
        assertEquals(pq.getKey(0), "A");
        printPQ(pq);

        pq.changeKey(6, "z");
        assertEquals(pq.peekKey(), "A");
        assertEquals(pq.getKey(6), "z");
        printPQ(pq);

        System.out.printf("%nSuccess!%n------------%n");
    }

    @Test
    void deleteTest() {
        System.out.println("Delete test.\n");

        for (int i = 0; i < str.length; i++)
            pq.add(i, str[i]);
        printPQ(pq);

        pq.delete(2);
        assertNull(pq.getKey(2));
        assertEquals(pq.size(), 10);

        pq.delete(10);
        assertNull(pq.getKey(10));
        assertEquals(pq.size(), 9);

        pq.delete(5);
        assertNull(pq.getKey(5));
        assertEquals(pq.size(), 8);

        assertEquals(pq.peekKey(), "A");
        assertFalse(pq.isEmpty());
        printPQ(pq);

        System.out.printf("%nSuccess!%n------------%n");
    }

    private void printPQ(IndexMinPQ pq) {
        for (int i = 0; i < str.length; i++)
            System.out.println(i + " " + pq.getKey(i));
        System.out.println();
    }

    private static void shuffle(int[] arr) {
        SplittableRandom r = new SplittableRandom();
        for (int i = 0; i < arr.length; i++) {
            int j = r.nextInt(arr.length-i) + i;
            swap(i, j, arr);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
