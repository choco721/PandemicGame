package org.example;

import java.util.HashMap;
import java.util.Map;

public class Board {
    // Mapa de ciudades en el tablero, la clave es el nombre de la ciudad
    private Map<String, City> cities;

    // Constructor de la clase Board
    public Board() {
        cities = new HashMap<>(); // Inicializamos el mapa de ciudades
    }

    // Método para agregar una ciudad al tablero
    public void addCity(City city) {
        cities.put(city.getName(), city); // Añadimos la ciudad al mapa usando su nombre como clave
    }

    // Método para obtener una ciudad del tablero por su nombre
    public City getCity(String name) {
        return cities.get(name); // Retorna la ciudad correspondiente al nombre
    }

    // Método para conectar dos ciudades en el tablero
    public void connectCities(String cityName1, String cityName2) {
        City city1 = cities.get(cityName1);
        City city2 = cities.get(cityName2);

        if (city1 != null && city2 != null) {
            city1.addConnection(city2); // Conecta las dos ciudades
        }
    }

    // Método para mostrar las conexiones en el tablero
    public void showBoardConnections() {
        for (City city : cities.values()) {
            city.showConnections(); // Muestra las conexiones de cada ciudad
        }
    }
}
