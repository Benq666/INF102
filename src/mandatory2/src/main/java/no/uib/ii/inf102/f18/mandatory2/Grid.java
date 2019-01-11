package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

/**
 * Grid
 * https://uib.kattis.com/problems/grid
 *
 * You are on an n×m grid where each square on the grid has a digit on it. From a given square that has digit k on it,
 * a Move consists of jumping exactly k squares in one of the four cardinal directions. A move cannot go beyond the
 * edges of the grid; it does not wrap. What is the minimum number of moves required to get from the top-left corner to
 * the bottom-right corner?
 *
 * Input
 * Each input will consist of a single test case. Note that your program may be run multiple times on different inputs.
 * The first line of input contains two space-separated integers n and m (1≤n,m≤500), indicating the size of the grid.
 * It is guaranteed that at least one of n and m is greater than 1.
 * The next n lines will each consist of m digits, with no spaces, indicating the n×m grid. Each digit is between 0 and
 * 9, inclusive.
 * The top-left corner of the grid will be the square corresponding to the first character in the first line of
 * the test case. The bottom-right corner of the grid will be the square corresponding to the last character in
 * the last line of the test case.
 *
 * Output
 * Output a single integer on a line by itself representing the minimum number of moves required to get from
 * the top-left corner of the grid to the bottom-right. If it isn’t possible, output -1.
 *
 *
 * @author Andrey Belinskiy
 *
 */
public class Grid {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(), m = io.getInt();
        IDigraph digraph = new MyAdjListDirGraph(n * m);
        Integer[][] grid = new Integer[n][m];
        for (int i = 0; i < n; i++) {
            String line = io.getWord();
            for (int j = 0; j < line.length(); j++)
                grid[i][j] = Character.getNumericValue(line.charAt(j));
        }

        // v = i * m + j
        // row = i / m
        // col = i % m
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    continue;

                // starting vertex
                int v0 = i * m + j;
                int value = grid[i][j];

                // getting potential neighbours
                int v1 = i * m + j + value;
                int v2 = i * m + j - value;
                int v3 = (i + value) * m + j;
                int v4 = (i - value) * m + j;

                // adding neighbours if they are in bounds
                if (j + value < m)
                    digraph.addEdge(v0, v1);
                if (j - value >= 0)
                    digraph.addEdge(v0, v2);
                if (i + value < n)
                    digraph.addEdge(v0, v3);
                if (i - value >= 0)
                    digraph.addEdge(v0, v4);
            }
        }

        BreadthFirstSearch bfs = new BreadthFirstSearch(digraph, 0);

        io.print(bfs.hasPathTo(n * m - 1) ?
                bfs.stepsTo(n * m - 1) + "\n" : -1 + "\n");

        io.flush();
    }
}
/*
Sample Input 1:
2 2
11
11

Sample Output 1:
2

Sample Input 2:
2 2
22
22

Sample Output 2:
-1

Sample Input 3:
5 4
2120
1203
3113
1120
1110

Sample Output 3:
6
 */
