package org.example;

import java.util.HashSet;
import java.util.Set;

public class Ciudad {
    private String nombre;
    private boolean infectada;
    private Set<Ciudad> conexiones;
    private int fichasDeInfeccion;

    public Ciudad(String nombre) {
        this.nombre = nombre;
        this.infectada = false;
        this.conexiones = new HashSet<>();
        this.fichasDeInfeccion = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isInfectada() {
        return infectada;
    }

    public void infectar() {
        fichasDeInfeccion++;
        System.out.println("Se ha agregado una ficha de infección a " + nombre);
        if (fichasDeInfeccion >= 3) {
            infectada = true;
            System.out.println("¡Brote en " + nombre + "!");
            // Aquí puedes agregar lógica para generar brotes en ciudades conectadas
            fichasDeInfeccion = 0; // Reiniciar las fichas tras el brote
        }
    }

    public void curar() {
        this.infectada = false;
        this.fichasDeInfeccion = 0; // Curar también elimina las fichas de infección
        System.out.println("La ciudad " + nombre + " se ha curado.");
    }

    public void addConnection(Ciudad ciudad) {
        conexiones.add(ciudad);
    }

    public void showConnections() {
        System.out.println("Ciudad " + nombre + " está conectada con:");
        for (Ciudad ciudad : conexiones) {
            System.out.println(" - " + ciudad.getNombre());
        }
    }

    public int getFichasDeInfeccion() {
        return fichasDeInfeccion;
    }

    public Set<Ciudad> getConexiones() {
        return conexiones;
    }


    public String toString() {
        return nombre + (infectada ? " (Infectada)" : " (Sana)") + " - Fichas de infección: " + fichasDeInfeccion;
    }

    public void setFichasDeInfeccion(int i) {
    }
}
