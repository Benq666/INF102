package mandatory0.src.main.java.no.uib.ii.inf102.f18.mandatory0;

/**
 * Fakebool UnionFind
 * https://uib.kattis.com/problems/uib.fakebool
 *
 * The social network Fakebool has had a lot of problems with fake news spread by fake user accounts. You have been
 * hired along with a team of consultants to shut them down.
 * By using a 100% fail-proof machine learning technique, a colleague has developed a daemon which monitors network
 * activity and occasionally identifies pairs of profiles on the network which definitely are managed by the same
 * individual.
 * While this all goes on, the legal department often pops by and demands to know the earliest known account ID of
 * the person managing a specific account; each account is associated with a unique identifier (ID) from 0 to n−1
 * where a smaller number indicate an older account.
 * This all reminds you of a course you once took in algorithms and data structures, and something called Union Find
 * which fits this purpose perfectly! You decide to implement it straight away to be able to serve the legal department
 * efficiently.
 *
 * Input
 * The first line of input consists of two integers, n the number of user accounts at Fakebool, and q the number of
 * queries. Then follows q lines, one for each query.
 * The i’th query begins with a token ti, which is either DAEMON or LEGAL, indicating that the query comes from
 * respectively your colleague’s daemon, or the legal department. If ti is DAEMON, two integers ai and bi follows on
 * the line, indicating that the same individual is managing both account ai and account bi. If ti is LEGAL,
 * one integer ℓi will follow on the line, indicating an account ID for which the legal team demands to know the oldest
 * known account ID managed by the same individual.
 *
 * Constraints
 * 1≤n≤100000
 * 1≤m≤100000
 * ti∈{DAEMON,LEGAL}
 * 0≤ai,bi,ℓi<n
 *
 * Output
 * For each query where ti is LEGAL, output an integer on a separate line indicating the oldest known user ID for
 * the individual managing the account ℓi.
 *
 *
 * @author Andrey Belinskiy
 *
 */
public class FakeBoolUnionFind {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt(), m = io.getInt();
        MyQuickUnionUF uf = new MyQuickUnionUF(n);

        for (int i = 0; i < m; i++) {
            if (io.getWord().equals("DAEMON"))
                uf.union(io.getInt(), io.getInt());
            else {
                io.println(uf.find(io.getInt()));
                io.flush();
            }
        }

        io.close();
    }
}

/*
Sample Input 1:
5 7
LEGAL 1
DAEMON 0 1
LEGAL 1
DAEMON 1 2
DAEMON 4 3
LEGAL 2
LEGAL 3

Sample Output 1:
1
0
0
3
 */
