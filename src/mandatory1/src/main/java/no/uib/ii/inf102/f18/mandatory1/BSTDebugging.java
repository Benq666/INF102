package mandatory1.src.main.java.no.uib.ii.inf102.f18.mandatory1;

/**
 * BST Debugging
 * https://uib.kattis.com/problems/uib.bstdebugging
 *
 * Øyvind has recently implemented a binary search tree. However, there seems to be some problems with his
 * implementation – some searches does not behave correctly. To debug his implementation he added a print statement
 * whenever a key is examined in the tree, so he can find where it goes wrong.
 * Now the only problem is identifying which of these sequences of examined keys are invalid in a proper binary search
 * tree. Can you write a program that checks if a sequence of keys examined in a search is valid?
 *
 * Input
 * The first line consists of two integeres, n (1≤n≤100000), the number of keys examined in a given search,
 * and m (−2^31≤m<2^31), the key that is searched for. The next line contains n space-separated keys (all 32-bit
 * signed integers) in the order they are examined by the search.
 *
 * Output
 * Output “valid” if the sequence of keys examined is plausible in a correctly implemented BST, or “invalid” otherwise.
 * There is no guarantee that the search tree is balanced, or that the search key exists in the tree.
 *
 *
 * @author Andrey Belinskiy
 *
 */
public class BSTDebugging {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        boolean valid = true;

        int n = io.getInt(), m = io.getInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = io.getInt();

        for (int i = 0; i < n; i++) {
            if (a[i] < min || a[i] > max) {
                valid = false;
                break;
            }

            if (m < a[i])
                max = a[i] - 1;

            else if (m > a[i])
                min = a[i] + 1;

            else if (m == a[i] && i != n - 1) {
                valid = false;
                break;
            }
        }

        io.println(valid ? "valid" : "invalid");
        io.close();
    }
}

/*
Sample Input 1:
5 10
20 15 5 9 11

Sample Output 1:
valid

Sample Input 2:
4 3
0 1 4 5

Sample Output 2:
invalid

Sample Input 3:
8 0
72 -500 32 16 8 7 -200 0

Sample Output 3:
valid
 */
