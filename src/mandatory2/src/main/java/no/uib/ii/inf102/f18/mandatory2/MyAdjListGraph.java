package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

/**
 * @author Andrey Belinskiy
 */
@SuppressWarnings("unchecked")
public class MyAdjListGraph implements IGraph {
    private ISortableList<Integer>[] adjList;
    private int m = 0, n;

    public MyAdjListGraph(int n) {
        adjList = new SortableLinkedList[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new SortableLinkedList<>();
        this.n = n;
    }

    @Override
    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
        m++;
    }

    @Override
    public int n() {
        return n;
    }

    @Override
    public int m() {
        return m;
    }

    @Override
    public boolean areAdj(int u, int v) {
        for (int nbr : adjList[u])
            if (nbr == v)
                return true;
        return false;
    }

    @Override
    public IBag<Integer> adj(int u) {
        return adjList[u];
    }
}
