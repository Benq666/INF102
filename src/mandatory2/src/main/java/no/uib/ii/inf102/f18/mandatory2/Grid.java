package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

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
-------
5 4
2120
1203
3113
1120
1110

6
-------
2 2
11
11

2
-------
2 2
22
22

-1
-------
*/
