package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

public class DepthFirstPaths {
    private final IGraph graph;
    private int[] parent;
    private boolean[] visited;
    private MyLinkedListStack<Integer> order;

    public DepthFirstPaths(IGraph graph, int root) {
        this.graph = graph;
        visited = new boolean[graph.n()];
        parent = new int[graph.n()];
        for (int j = 0; j < graph.n(); j++)
            parent[j] = -1;

        order = new MyLinkedListStack<Integer>();
        dfs(root);
    }

    private void dfs(int u) {
        visited[u] = true;
        for (int nbr : graph.adj(u))
            if (!visited[nbr]) {
                parent[nbr] = u;
                dfs(nbr);
            }
        order.push(u);
    }

    public boolean hasPathTo(int u) {
        return this.visited[u];
    }

    public Iterable<Integer> pathTo(int u) {
        MyLinkedListStack<Integer> stack = new MyLinkedListStack<Integer>();
        while (u >= 0) {
            stack.push(u);
            u = parent[u];
        }
        return stack;
    }

    public boolean[] getVisited() {
        return visited;
    }

    public MyLinkedListStack<Integer> getOrder() {
        return order;
    }
}
