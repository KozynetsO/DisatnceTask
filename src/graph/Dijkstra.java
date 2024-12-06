package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {
    List<Vertex> verticesProcessingList;

    public Dijkstra(){
        verticesProcessingList = new ArrayList<>();
    }

    public void calculate(Vertex start){
        start.setDistance(0);
        verticesProcessingList.add(start);

        while (!verticesProcessingList.isEmpty()){
            start.setVisited(true);
            var edges = start.getEdges();
            for (Edge edge : edges){
                Vertex end = edge.getNeighbor();
                double weight = edge.getWeight();
                double newDistance = start.getDistance() + weight;
                if(newDistance < end.getDistance())
                    end.setDistance(newDistance);
                verticesProcessingList.add(end);
            }
            verticesProcessingList.removeIf(Vertex::isVisited);

            verticesProcessingList.remove(start);
            if(!verticesProcessingList.isEmpty()) {
                start = Collections.min(verticesProcessingList);
            }
        }
    }
}
