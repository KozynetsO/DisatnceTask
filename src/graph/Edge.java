package graph;

public class Edge {
    private final double weight;
    private final Vertex neighbor;

    public Edge(double weight, Vertex neighbor){
        this.weight = weight;
        this.neighbor = neighbor;
    }

    public double getWeight() {
        return weight;
    }

    public Vertex getNeighbor() {
        return neighbor;
    }
}
