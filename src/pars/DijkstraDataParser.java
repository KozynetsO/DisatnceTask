package pars;

import pars.entities.City;
import pars.entities.Test;

import java.util.*;

public class DijkstraDataParser extends Parser{
    private int numberOfCities;
    private int currentLinePosition;
    private List<String> fileLines;

    public DijkstraDataParser(String fileName){
        currentLinePosition = 0;
        fileLines = getFileLines(fileName);
    }

    @Override
    public List<Test> parse() {
        List<Test> tests = new ArrayList<>();
        int numberOfTests = Integer.parseInt(fileLines.getFirst());
        this.numberOfCities = Integer.parseInt(fileLines.get(1));
        currentLinePosition = 2;

        for (int testNumber = 0; testNumber < numberOfTests; testNumber++) {
            Set<City> cities = parseCitesData();
            Map<Integer, Integer> pathsToFind = parsePathsToFindData(cities);
            tests.add(new Test(cities, pathsToFind));
        }

        return tests;
    }

    private Set<City> parseCitesData(){
        Set<City> cities = new HashSet<>();
        for (int i = 1; i <= numberOfCities; i++)
            cities.add(parseCity(i));
        return cities;
    }

    private City parseCity(int cityId) {
        String cityName = fileLines.get(currentLinePosition++);
        int numberOfNeighbors = Integer.parseInt(fileLines.get(currentLinePosition++));
        Map<Integer, Integer> neighborCost = new HashMap<>();
        for (int i = 0; i < numberOfNeighbors; i++)
        {
            String neighborLine = fileLines.get(currentLinePosition);
            var neighborId = Integer.parseInt(neighborLine.split(" ")[0]);
            var cost = Integer.parseInt(neighborLine.split(" ")[1]);
            neighborCost.put(neighborId, cost);
            currentLinePosition++;
        }
        return  new City(cityId, cityName, neighborCost);
    }

    private Map<Integer, Integer> parsePathsToFindData(Set<City> cities)
    {
        Map<Integer, Integer> pathsToFind = new HashMap<>();
        int numberOfPathsToFind = Integer.parseInt(fileLines.get(currentLinePosition++));
        for (int i = 0; i < numberOfPathsToFind; i++) {
            String path = fileLines.get(currentLinePosition++);
            String startName = path.split(" ")[0];
            String endName = path.split(" ")[1];
            int startId = CityUtils.getCityIdByName(cities, startName);
            int endId = CityUtils.getCityIdByName(cities, endName);
            pathsToFind.put(startId, endId);
        }
        currentLinePosition +=2;
        return pathsToFind;
    }
}
