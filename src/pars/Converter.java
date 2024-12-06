package pars;

import graph.Edge;
import graph.Vertex;
import pars.entities.City;

import java.util.Set;
import java.util.stream.Collectors;

public class Converter {
    public static Set<Vertex> convertToVertices(Set<City> cities)
    {
        Set<Vertex> vertices = cities.stream()
                .map(city -> new Vertex(city.getId(), city.getName()))
                .collect(Collectors.toSet());

        for (City city : cities)
        {
            int cityId = city.getId();
            Vertex currentVertex = vertices.stream()
                    .filter(vertex -> vertex.getId() == cityId)
                    .findFirst()
                    .orElse(null);
            for (Integer key : city.getNeighborCost().keySet()) {
                int neighborId = key;
                int cost = city.getNeighborCost().get(key);

                Vertex neighborVertex = vertices.stream()
                        .filter(vertex -> vertex.getId() == neighborId)
                        .findFirst().get();

                currentVertex.addEdge(new Edge(cost, neighborVertex));
            }
        }

        return vertices;
    }
}
