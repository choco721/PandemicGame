package org.example;

import java.util.HashMap;
import java.util.Map;

public class Tablero {
    private Map<String, Ciudad> ciudades;
    private boolean[] curasEncontradas;
    private int numeroDeBrotes;

    public Tablero() {
        ciudades = new HashMap<>();
        curasEncontradas = new boolean[4]; // Suponemos 4 enfermedades
        numeroDeBrotes = 0;
    }

    public void addCiudad(Ciudad ciudad) {
        ciudades.put(ciudad.getNombre(), ciudad);
    }

    public Ciudad getCiudad(String nombre) {
        return ciudades.get(nombre);
    }

    public void infectarCiudad(Carta carta) {
        String ciudadNombre = carta.getContenido();
        Ciudad ciudad = ciudades.get(ciudadNombre);
        if (ciudad != null) {
            ciudad.infectar();
            System.out.println("La ciudad " + ciudadNombre + " se ha infectado.");
        } else {
            System.out.println("Ciudad no encontrada: " + ciudadNombre);
        }
    }


    public void conectarCiudades(String nombreCiudad1, String nombreCiudad2) {
        Ciudad ciudad1 = ciudades.get(nombreCiudad1);
        Ciudad ciudad2 = ciudades.get(nombreCiudad2);

        if (ciudad1 != null && ciudad2 != null) {
            ciudad1.addConnection(ciudad2);
            ciudad2.addConnection(ciudad1); // Conexión bidireccional
        } else {
            System.out.println("Advertencia: Una o ambas ciudades no existen en el tablero.");
        }
    }

    public void mostrarConexiones() {
        for (Ciudad ciudad : ciudades.values()) {
            ciudad.showConnections();
        }
    }

    public void encontrarCura(int indiceEnfermedad) {
        if (indiceEnfermedad >= 0 && indiceEnfermedad < curasEncontradas.length) {
            int indiceEnfermadad = 0;
            curasEncontradas[indiceEnfermadad] = true;
            System.out.println("Cura encontrada para la enfermedad " + indiceEnfermedad);
        }
    }

    public boolean todasLasCurasEncontradas() {
        for (boolean cura : curasEncontradas) {
            if (!cura) return false;
        }
        return true;
    }

    public boolean hayBrotes() {
        return numeroDeBrotes >= 8; // Suponemos que el límite de brotes es 8
    }

    public void aumentarBrotes() {
        numeroDeBrotes++;
    }

    public boolean hayFichasDeInfeccion() {
        // Suponemos que siempre hay suficientes fichas para este ejemplo
        return true;
    }

    public boolean ciudadTieneFichasDeInfeccion(String nombreCiudad) {
        Ciudad ciudad = ciudades.get(nombreCiudad);
        if (ciudad != null) {
            return ciudad.getFichasDeInfeccion() < 3; // Suponiendo que se requiere una ficha de infección
        }
        return false;
    }

    public Map<String, Ciudad> getCiudades() {
        return ciudades;
    }

    public Ciudad getCiudadAleatoria() {
        {


        }
        return null;
    }
}