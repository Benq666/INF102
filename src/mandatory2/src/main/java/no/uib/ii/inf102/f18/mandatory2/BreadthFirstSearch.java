package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

public class BreadthFirstSearch {
    private final IGraph graph;
    private int[] parent;
    private boolean[] visited;
    private int steps = 0;

    public BreadthFirstSearch(IGraph graph, int root) {
        this.graph = graph;
        visited = new boolean[graph.n()];
        parent = new int[graph.n()];
        for (int j = 0; j < graph.n(); j++)
            parent[j] = -1;

        bfs(root);
    }

    private void bfs(int u) {
        IQueue<Integer> queue = new MyLinkedListQueue<Integer>();
        visited[u] = true;
        queue.enqueue(u);
        while (!queue.empty()) {
            int v = queue.dequeue();
            for (int nbr : graph.adj(v))
                if (!visited[nbr]) {
                    parent[nbr] = v;
                    visited[nbr] = true;
                    queue.enqueue(nbr);
                }
        }
    }

    public boolean hasPathTo(int u) {
        return visited[u];
    }

    public Iterable<Integer> pathTo(int u) {
        steps = 0;
        MyLinkedListStack<Integer> stack = new MyLinkedListStack<Integer>();
        while (u >= 0) {
            stack.push(u);
            u = parent[u];
        }
        steps = stack.size() - 1;
        return stack;
    }

    public int stepsTo(int u) {
        pathTo(u);
        return steps;
    }
}
