package pars.entities;

import graph.Edge;
import graph.Vertex;

import java.util.Dictionary;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class City {
    private final int id;
    private final String name;
    private Map<Integer, Integer> neighborCost;

    public City(int id, String name, Map<Integer, Integer> neighborCost) {
        this.name = name;
        this.neighborCost = neighborCost;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Integer> getNeighborCost() {
        return neighborCost;
    }
}
