package org.example;

public class Carta {
    private String tipo;
    private String contenido;

    public Carta(String tipo, String contenido) {
        this.tipo = tipo;
        this.contenido = contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public String getContenido() {
        return contenido;
    }


    public String toString() {
        return tipo + ": " + contenido;
    }


    public void aplicarEfecto(GestorDeCartas gestorDeCartas, Tablero tablero, Jugador jugador) {
        if (tipo.equals("Evento")) {
        } else if (tipo.equals("Enfermedad")) {
            Ciudad ciudadActual = jugador.getCiudadActual();
            if (ciudadActual != null) {
                ciudadActual.infectar();
                System.out.println("Se ha sacado una carta de enfermedad: " + contenido);
                if (ciudadActual.getFichasDeInfeccion() >= 3) {
                    ciudadActual.setFichasDeInfeccion(0);
                    System.out.println("¡Brote en " + ciudadActual.getNombre() + "!");
                }
            } else {
                System.out.println("El jugador no está en ninguna ciudad.");
            }
        }
    }
}
