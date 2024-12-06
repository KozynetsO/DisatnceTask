package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
    private int id;
    private final String name;
    private final List<Edge> edges;
    private double distance;
    private boolean isVisited;

    public Vertex(int id, String name){
        this.name = name;
        edges = new ArrayList<>();
        distance = Double.MAX_VALUE;
        isVisited = false;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addEdge(Edge edge){
        edges.add(edge);
    }

    public String getName() {
        return name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(this.getDistance(), o.getDistance());
    }
}
