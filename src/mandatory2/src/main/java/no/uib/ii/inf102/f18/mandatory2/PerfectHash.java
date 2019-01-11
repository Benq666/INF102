package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

/**
 * Perfect String Hash
 * https://uib.kattis.com/problems/uib.perfecthash
 *
 * In computer science, a hash function is a function which maps data of arbitrary size (called keys) into data of
 * fixed size called hashes; typically integers within a certain range, say {0,1,2,…M−1} for some constant M. It is
 * highly desirable that different keys yields different hashes, but since there are usually more possible keys than
 * available hashes, collisions are inevitable.
 * When our set of possible keys is bounded, however, we can create what is known as a perfect hash function. Given
 * a finite set of keys S, a perfect hash function maps distinct elements in S to a set of non-negative integers less
 * than M, with no collisions. In mathematical terms, it is an injective function h:S→{0,1,2,…M−1}, for some constant M.
 *
 * We are aiming to implement a perfect hash function for a set of strings, such that you can choose the constant M as
 * small as possible. As as starting point, consider the hash function for strings below (which, with the except of
 * the modulo operation, is stolen from the built-in hashcode function for strings in the Java language):
 *
 *     public int hash(String s) {
 *         int hash = 0;
 *         for (int i = 0; i < s.length(); i++) {
 *             hash = (31 * hash + s.charAt(i)) % M;
 *         }
 *         return hash;
 *     }
 *
 * Your task is to find a value for the constant a (possibly different from 31) and a value for M such that h is
 * a perfect hash function for the set of strings S, and M is as small as possible.
 *
 * Explanation of sample
 * For example, consider the set S={"Hi","ha"}. The smallest M we can hope for is 2, since |S|=2. Sadly, the two
 * strings ‘Hi’ and ‘ha’ will yield the same hash for M=2 regardless of our value of a. For M=3, however, we can pick
 * a=2, which maps the two strings to different values (even if a=31 does not).
 *
 * Input
 * The first line of input contains an integer n (2≤n≤80), the size of the set S. Then the elements of S follows on
 * the next n lines, each consisting of a unique string. No string has more than 32 characters, and all strings are
 * made entirely of alphabetic ASCII characters (that is, 65 <= s.charAt(i) <= 90 || 97 <= s.charAt(i) <= 122 for every
 * s∈S and 0≤i<s.length()). You may assume that for all input files, M≤500.
 *
 * Output
 * Output a single line containing two space-separated non-negative integers a and M, such that M is as small as
 * possible and there are no collisions using a as the constant of h. If multiple choices of a are possible, output
 * your favourite among those less than 2^31.
 *
 *
 * Solved by Andrey Belinskiy
 *
 */
public class PerfectHash {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(), uHash = 0, a = 0, m;
        String[] words = new String[n];
        for (int i = 0; i < n; i++)
            words[i] = io.getWord();

        for (m = n; m <= 500; m++) {
            for (a = 2; a <= 340; a++) {
                boolean[] hashes = new boolean[m];
                for (uHash = 0; uHash < n; uHash++) {
                    int currHash = hash(words[uHash], a, m);
                    if (!hashes[currHash])
                        hashes[currHash] = true;
                    else break;
                }
                if (uHash == n) break;
            }
            if (uHash == n) break;
        }

        io.print(a + " " + m);
        io.close();
    }

    public static int hash(String s, int a, int m) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++)
            hash = (a * hash + s.charAt(i)) % m;
        return hash;
    }
}

/*
Sample Input 1:
2
Hi
ha

Sample Output 1:
2 3
*/
