package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

/**
 * @author Andrey Belinskiy
 */
@SuppressWarnings("unchecked")
public class MyAdjListEdgeWD implements IEdgeWeightedDirGraph {
    private ISortableList<DirectedEdge>[] graph, graphRoadsFlights, graphRoads;
    private ISortableList<DirectedEdge> edgeList = new SortableLinkedList<DirectedEdge>();

    public MyAdjListEdgeWD(int n) {
        graphRoadsFlights = new SortableLinkedList[n];
        graphRoads = new SortableLinkedList[n];
        for (int i = 0; i < n; i++) {
            graphRoadsFlights[i] = new SortableLinkedList<>();
            graphRoads[i] = new SortableLinkedList<>();
        }

        graph = graphRoads;
    }

    @Override
    public void addEdge(DirectedEdge e) {
        graphRoadsFlights[e.from].add(e);
        graphRoads[e.from].add(e);
        edgeList.add(e);
    }

    public void addEdgeFlight(DirectedEdge e) {
        graphRoadsFlights[e.from].add(e);
        edgeList.add(e);
    }

    @Override
    public int n() {
        return graph.length;
    }

    @Override
    public int m() {
        return 0;
    }

    @Override
    public IBag<DirectedEdge> adj(int u) {
        return graph[u];
    }

    @Override
    public IBag<DirectedEdge> edges() {
        return edgeList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n(); i++) {
            sb.append(i).append(":");
            for (DirectedEdge e : graph[i])
                sb.append(e.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void switchToRoadsFlights() {
        graph = graphRoadsFlights;
    }

    public void switchToRoadsOnly() {
        graph = graphRoads;
    }
}
