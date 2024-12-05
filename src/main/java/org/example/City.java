package org.example;

import java.util.ArrayList;
import java.util.List;

public class City { // Class name capitalized
    // Atributos de la ciudad
    private String name;
    private int diseaseCubes;
    private List<City> connectedCities; // Updated to match class name

    // Constructor de la clase City
    public City(String name) { // Updated constructor to match class name
        this.name = name;
        this.diseaseCubes = 0; // Inicialmente la ciudad no tiene cubos de enfermedad
        this.connectedCities = new ArrayList<>(); // Inicializamos la lista de ciudades conectadas
    }

    // Método para obtener el nombre de la ciudad
    public String getName() {
        return name;
    }

    // Método para agregar cubos de enfermedad a la ciudad
    public void addDiseaseCubes(int cubes) {
        if (cubes > 0) { // Aseguramos que el número de cubos a añadir sea positivo
            diseaseCubes += cubes; // Aumentamos el número de cubos de enfermedad
        }
    }

    // Método para quitar cubos de enfermedad de la ciudad
    public void removeDiseaseCubes(int cubes) {
        if (cubes > 0) { // Aseguramos que el número de cubos a quitar sea positivo
            if (diseaseCubes >= cubes) {
                diseaseCubes -= cubes; // Reducimos el número de cubos si hay suficientes
            } else {
                diseaseCubes = 0; // Si no hay suficientes cubos, dejamos en 0
            }
        }
    }

    // Método para obtener el número de cubos de enfermedad en la ciudad
    public int getDiseaseCubes() {
        return diseaseCubes;
    }

    // Método para conectar esta ciudad a otra ciudad
    public void addConnection(City city) { // Updated parameter type to match class name
        if (city == null || city == this) {
            return; // Evitamos añadir conexiones a null o a sí misma
        }
        if (!connectedCities.contains(city)) {
            connectedCities.add(city); // Añadimos la ciudad a la lista de conexiones
            // Aseguramos la conexión bidireccional
            if (!city.connectedCities.contains(this)) {
                city.addConnection(this);
            }
        }
    }

    // Método para mostrar las ciudades conectadas a esta ciudad
    public void showConnections() {
        System.out.print("Ciudad " + name + " está conectada a: ");
        for (City city : connectedCities) { // Updated type to match class name
            System.out.print(city.getName() + " ");
        }
        System.out.println();
    }
}
