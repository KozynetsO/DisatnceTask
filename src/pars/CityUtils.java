package pars;

import pars.entities.City;

import java.util.Set;

public class CityUtils {
    public static int getCityIdByName(Set<City> cities, String name)
    {
        return cities.stream()
                .filter(city -> city.getName().equals(name))
                .findFirst().get().getId();
    }
}
