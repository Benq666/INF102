package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

/**
 * An interface for a Directed Graph object
 */
public interface IDigraph extends IGraph {

    /**
     * Add an edge from vertex u to vertex v in the graph
     * @param u a vertex
     * @param v a vertex
     */
    void addEdge(int u, int v);

    /**
     * Number of vertices in the graph
     * @return the number of vertices
     */
    int n();

    /**
     * Number of edges in the graph
     * @return the number of edges
     */
    int m();

    /**
     * Return an iterator over the neighbours of a vertex
     * @param u a vertex
     * @return iterator over u's neighbours
     */
    IBag<Integer> adj(int u);

    /**
     * Return the reverse of the current graph (a new IDigraph object)
     *
     * @return the reverse of the graph
     */
    IDigraph reverse();
}
