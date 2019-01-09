package mandatory1.src.main.java.no.uib.ii.inf102.f18.mandatory1;

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
    5 10
    20 15 5 9 11
    valid
    ---------------
    4 3
    0 1 4 5
    invalid
    ---------------
    8 0
    72 -500 32 16 8 7 -200 0
    valid
 */
