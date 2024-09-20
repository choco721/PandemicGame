package org.example;

public class Jugador {
    private String nombre;
    private String rol;
    private Ciudad ciudadActual; // Añadido para almacenar la ciudad actual

    public Jugador(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public Ciudad getCiudadActual() {
        return ciudadActual;
    }

    public void setCiudadActual(Ciudad ciudad) {
        this.ciudadActual = ciudad;
    }

    @Override
    public String toString() {
        return nombre + " (" + rol + ") - Ciudad actual: " + (ciudadActual != null ? ciudadActual.getNombre() : "Ninguna");
    }
}
