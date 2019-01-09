package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

public final class DirectedEdge implements Comparable<DirectedEdge> {
    public final int from, to;
    public final double weight;
    public boolean isFlight = false;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public DirectedEdge(int from, int to, double weight, boolean flight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
        isFlight = flight;
    }

    @Override
    public int compareTo(DirectedEdge other) {
        return Double.compare(weight, other.weight);
    }

    @Override
    public String toString() {
        return "[ " + from + "->" + to + ", w=" + weight + " ]";
    }
}
