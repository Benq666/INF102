package mandatory0.src.main.java.no.uib.ii.inf102.f18.mandatory0;

/**
 * Fakebool Quick-Find
 * https://uib.kattis.com/problems/uib.fakeboolquickfind
 *
 * The social network Fakebool has had a lot of problems with fake news spread by fake user accounts. You have been
 * hired along with a team of consultants to shut them down.
 * By using a 100% fail-proof machine learning technique, a colleague has managed to identify pairs of profiles on
 * the network which definitely are managed by the same individual. You are interested in quickly determining what is
 * the original user account of the person behind a username. You define the oldest account created by a person to be
 * his original account; each account is associated with a unique identifier (ID) from 0 to n−1 where a smaller number
 * indicate an older account.
 * This all reminds you of a course you once took in algorithms and data structures, and something called Union Find.
 * In particular, there was an implementation you vividly recall named quick-find which answered such questions in
 * constant time! You decide to implement it, and test it with your colleague’s data.
 *
 * Input
 * The first line of input consists of two integers n, the number of user accounts at Fakebool, and m, the size of
 * the data set produced by your colleague. Then follows m lines, the i’th of which containing two integers ai and bi
 * representing two ID’s belonging to the same individual.
 *
 * Constraints
 * 1≤n≤2000
 * 1≤m≤2000
 *
 * Output
 * Output a single line with n space-separated integers p0,p1,…,pn−1, where pi should be the ID of the original user
 * account of the person managing account i. Amazingly, this output is also the exact content of the id array in your
 * quick-find implementation, since you decided that your union operation will always retain the lower number.
 *
 *
 * Solved by Andrey Belinskiy
 *
 */
public class FakeBoolQuickFind {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt(), m = io.getInt();
        MyQuickFindUF uf = new MyQuickFindUF(n);

        for (int i = 0; i < m; i++)
            uf.union(io.getInt(), io.getInt());

        for (int i = 0; i < n; i++)
            sb.append(uf.find(i)).append(" ");

        io.print(sb);
        io.close();
    }
}

/*
Sample Input 1:
6 3
3 1
4 5
0 5

Sample Output 1:
0 1 2 1 0 0
 */
