package pars.entities;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
    private final Set<City> cities;
    Map<Integer, Integer> pathsToFind;

    public Test(Set<City> cities, Map<Integer, Integer> pathsToFind) {
        this.cities = cities;
        this.pathsToFind = pathsToFind;
    }

    public Set<City> getCities() {
        return cities;
    }

    public Map<Integer, Integer> getPathsToFind() {
        return pathsToFind;
    }
}
