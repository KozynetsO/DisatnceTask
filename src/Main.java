import graph.Dijkstra;
import graph.Vertex;
import pars.Converter;
import pars.DijkstraDataParser;
import pars.entities.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Test> tests = new DijkstraDataParser("cities").parse();
        for (Test test : tests){
            List<Double> results = calculate(test);
            results.forEach(System.out::println);
            System.out.println("\n");
        }
    }
    public static List<Double> calculate(Test test)
    {
        List<Double> results = new ArrayList<>();
        var pathsToFind = test.getPathsToFind();
        for (Integer key : pathsToFind.keySet()) {
            Set<Vertex> vertices = Converter.convertToVertices(test.getCities());
            Vertex start = vertices.stream()
                .filter(vertex -> vertex.getId() == key)
                .findFirst()
                .orElse(null);
            Vertex end = vertices.stream()
                .filter(vertex -> vertex.getId() == pathsToFind.get(key))
                .findFirst()
                .orElse(null);
            new Dijkstra().calculate(start);
            results.add(end.getDistance());
        }

        return results;
    }
}