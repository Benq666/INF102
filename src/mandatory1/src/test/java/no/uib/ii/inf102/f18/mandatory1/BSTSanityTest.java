package mandatory1.src.test.java.no.uib.ii.inf102.f18.mandatory1;

import mandatory1.src.main.java.no.uib.ii.inf102.f18.mandatory1.BinarySearchTree;
import mandatory1.src.main.java.no.uib.ii.inf102.f18.mandatory1.ISymTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BSTSanityTest {
    private BinarySearchTree<String, String> bst;
    private String[] string = new String[] {"A", "B", "C", "D", "X", "Y", "Z"};
    private String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7"};
    private int i;

    @BeforeEach
    void setup() {
        i = -1;
        bst = new BinarySearchTree<>();
    }

    @Test
    void putTest() {
        System.out.println("BST put test.\n");

        bst.put("B", "2");
        bst.put("A", "1");
        bst.put("D", "4");

        printAndCheckKeys(bst);
        System.out.println("\nShould be:\nA B D\n");

        i = -1;
        bst.put("C", "3");
        bst.put("Y", "6");

        printAndCheckKeys(bst);
        System.out.println("\nShould be:\nA B C D Y\n");

        i = -1;
        bst.put("Z", "7");
        bst.put("X", "5");

        printAndCheckKeys(bst);
        System.out.println("\nShould be:\nA B C D X Y Z");

        System.out.println("\nSuccess!\n-------------\n");
    }

    @Test
    void getTest() {
        System.out.println("BST get test.\n");

        bst.put("Z", "7");
        bst.put("B", "2");
        bst.put("C", "3");
        bst.put("Y", "6");
        bst.put("A", "1");
        bst.put("D", "4");
        bst.put("X", "5");

        System.out.println("Result:");
        for (String str : bst.keys())
            System.out.print(str + " ");
        System.out.println();
        for (String str : bst.keys()) {
            System.out.print(bst.get(str) + " ");
            assertEquals(bst.get(str), values[++i]);
        }
        System.out.println("\nShould be:\nA B C D X Y Z\n1 2 3 4 5 6 7");

        System.out.println("\nSuccess!\n-------------\n");
    }

    private int findIndex(String[] arr, String target) {
        for (int j = 0; j < arr.length; j++)
            if (arr[j].equals(target))
                return j;
        return -1;
    }

    private String findString(String[] arr, int index) {
        for (String str : arr)
            if (str.equals(arr[index]))
                return str;
        return null;
    }

    private void printAndCheckKeys(ISymTable bst) {
        System.out.println("Result:");
        for (Object str : bst.keys()) {
            System.out.print(str + " ");
            assertEquals(str, findString(string, findIndex(string, (String) str)));
        }
    }
}
