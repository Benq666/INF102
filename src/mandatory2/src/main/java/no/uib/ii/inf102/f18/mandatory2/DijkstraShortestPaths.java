package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

@SuppressWarnings("unchecked")
public class DijkstraShortestPaths {
    private final IEdgeWeightedDirGraph graph;
    private final double[] distTo;
    private int[] parent;

    public DijkstraShortestPaths(IEdgeWeightedDirGraph graph, int root) {
        this.graph = graph;
        distTo = new double[graph.n()];
        parent = new int[graph.n()];
        for (int i = 0; i < graph.n(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
            parent[i] = -1;
        }

        dijkstra(root);
    }

    private void dijkstra(int root) {
        distTo[root] = 0;

        boolean[] reached = new boolean[graph.n()];
        IIndexPQ pq = new IndexMinPQ(graph.n());
        for (int i = 0; i < graph.n(); i++)
            pq.add(i, distTo[i]);

        while (!pq.isEmpty()) {
            int u = pq.poll();
            reached[u] = true;
            for (DirectedEdge e : graph.adj(u)) {
                if (e.isFlight)
                    graph.switchToRoadsOnly();
                if (!reached[e.to] && distTo[e.from] + e.weight < distTo[e.to]) {
                    parent[e.to] = e.from;
                    distTo[e.to] = distTo[e.from] + e.weight;
                    pq.changeKey(e.to, distTo[e.to]);
                }
            }
        }
    }

    public double distTo(int u) {
        return distTo[u];
    }
}
