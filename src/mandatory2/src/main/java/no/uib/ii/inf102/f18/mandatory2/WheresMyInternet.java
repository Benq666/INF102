package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

public class WheresMyInternet {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(), m = io.getInt();
        boolean allConnected = true;
        IGraph graph = new MyAdjListGraph(n + 1);
        for (int i = 0; i < m; i++)
            graph.addEdge(io.getInt(), io.getInt());

        DepthFirstPaths search = new DepthFirstPaths(graph, 1);
        boolean[] visited = search.getVisited();

        for (int i = 2; i <= n; i++)
            if (!visited[i]) {
                io.print(i + "\n");
                allConnected = false;
            }

        if (allConnected) io.print("Connected\n");
        io.close();
    }
}
/*
    6 4 1 2 2 3 3 4 5 6

    5
    6
    ---
    2 1 2 1

    Connected
    ---
    4 3 2 3 4 2 3 4

    2
    3
    4
*/
