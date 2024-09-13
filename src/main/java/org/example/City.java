package org.example; // Ajusta esto según el nombre de tu paquete

import java.util.ArrayList;
import java.util.List;

public class City {
    // Atributos de la ciudad
    private String name;
    private int diseaseCubes;
    private final int MAX_CUBES = 3; // Límite máximo de cubos de enfermedad
    private List<City> connectedCities;

    // Constructor de la clase City
    public City(String name) {
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
        if (diseaseCubes + cubes > MAX_CUBES) {
            diseaseCubes = MAX_CUBES; // No permite superar el límite
            System.out.println("Advertencia: Se ha alcanzado el número máximo de cubos de enfermedad en " + name + ".");
        } else {
            diseaseCubes += cubes; // Aumentamos el número de cubos de enfermedad
        }
    }

    // Método para quitar cubos de enfermedad de la ciudad
    public void removeDiseaseCubes(int cubes) {
        if (diseaseCubes >= cubes) {
            diseaseCubes -= cubes; // Reducimos el número de cubos si hay suficientes
        } else {
            diseaseCubes = 0; // Si no hay suficientes cubos, dejamos en 0
            System.out.println("Advertencia: No hay suficientes cubos de enfermedad para quitar en " + name + ".");
        }
    }

    // Método para obtener el número de cubos de enfermedad en la ciudad
    public int getDiseaseCubes() {
        return diseaseCubes;
    }

    // Método para conectar esta ciudad a otra ciudad
    public void addConnection(City city) {
        if (city != null && !connectedCities.contains(city) && !city.connectedCities.contains(this)) {
            connectedCities.add(city); // Añadimos la ciudad a la lista de conexiones
            city.addConnection(this);  // Aseguramos la conexión bidireccional
        }
    }

    // Método para mostrar las ciudades conectadas a esta ciudad
    public void showConnections() {
        System.out.print("Ciudad " + name + " está conectada a: ");
        for (City city : connectedCities) {
            System.out.print(city.getName() + " ");
        }
        System.out.println();
    }
}
