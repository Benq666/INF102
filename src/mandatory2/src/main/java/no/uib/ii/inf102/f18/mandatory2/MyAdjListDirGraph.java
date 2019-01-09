package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

@SuppressWarnings("unchecked")
public class MyAdjListDirGraph implements IDigraph {
    private ISortableList<Integer>[] adjList;
    private int m = 0, n;

    public MyAdjListDirGraph(int n) {
        adjList = new SortableLinkedList[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new SortableLinkedList<>();
        this.n = n;
    }

    @Override
    public void addEdge(int u, int v) {
        adjList[u].add(v);
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
        return false;
    }

    @Override
    public IBag<Integer> adj(int u) {
        return adjList[u];
    }

    @Override
    public MyAdjListDirGraph reverse() {
        MyAdjListDirGraph reverse = new MyAdjListDirGraph(n);
        for (int v = 0; v < n; v++)
            for (int w : adj(v))
                reverse.addEdge(w, v);
        return reverse;
    }
}
