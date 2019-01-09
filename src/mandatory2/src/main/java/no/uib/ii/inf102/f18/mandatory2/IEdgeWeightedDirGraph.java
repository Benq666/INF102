package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

public interface IEdgeWeightedDirGraph {
    /**
     * Add an edge between vertex u and vertex v in the graph.
     * @param e the edge
     */
    void addEdge(DirectedEdge e);

    /**
     * Number of vertices in this graph
     * @return the number of vertices
     */
    int n();

    /**
     * Number of edges in this graph?
     * @return the number of edges
     */
    int m();

    /**
     * Return an iterator over the neighbours of a vertex
     * @param u a vertex
     * @return iterator over u's neighbours
     */
    IBag<DirectedEdge> adj(int u);

    /**
     * Return an iterator over the edges of the graph
     * @return iterator over all edges of the graph
     */
    IBag<DirectedEdge> edges();

    void switchToRoadsOnly();

    void switchToRoadsFlights();
}
