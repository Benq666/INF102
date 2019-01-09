package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

// currently passes only 22 out of 25 test cases
public class Bumped {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(), m = io.getInt(), f = io.getInt();
        int s = io.getInt(), t = io.getInt();
        MyAdjListEdgeWD graph = new MyAdjListEdgeWD(n);

        for (int i = 0; i < m; i++) {
            int from = io.getInt(), to = io.getInt();
            double weight = io.getDouble();

            graph.addEdge(new DirectedEdge(from, to, weight));
            graph.addEdge(new DirectedEdge(to, from, weight));
        }

        graph.switchToRoadsFlights();

        for (int i = 0; i < f; i++)
            graph.addEdgeFlight(new DirectedEdge(io.getInt(), io.getInt(), 0.0, true));

        DijkstraShortestPaths paths = new DijkstraShortestPaths(graph, s);

        io.print((long) paths.distTo(t) + "\n");
        io.flush();
    }
}

/*
8 11 3 0 5
0 1 10
0 2 10
1 2 10
2 6 40
6 7 10
5 6 10
3 5 15
3 6 40
3 4 20
1 4 20
1 3 30
4 7
7 5
4 6

40
------------
7 6 6 0 6
0 1 7
2 3 5
3 4 10
4 5 5
5 6 5
1 6 20
0 2
0 3
0 4
3 6
4 6
1 6

10
 */
