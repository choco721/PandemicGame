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

    @Override
    public String toString() {
        return tipo + ": " + contenido;
    }

    // Método para aplicar el efecto de la carta
    public void aplicarEfecto(GestorDeCartas gestorDeCartas, Tablero tablero, Jugador jugador) {
        if (tipo.equals("Evento")) {
            // Efectos de cartas de evento (ya descritos anteriormente)
        } else if (tipo.equals("Enfermedad")) {
            Ciudad ciudadActual = jugador.getCiudadActual(); // Asumiendo que el jugador tiene una ciudad actual
            if (ciudadActual != null) {
                ciudadActual.infectar(); // Infecta la ciudad actual del jugador
                System.out.println("Se ha sacado una carta de enfermedad: " + contenido);
                if (ciudadActual.getFichasDeInfeccion() >= 3) {
                    // Si se alcanza el límite de fichas de infección, genera un brote
                    ciudadActual.setFichasDeInfeccion(0); // Reinicia las fichas de infección
                    System.out.println("¡Brote en " + ciudadActual.getNombre() + "!");
                    // Aquí podrías implementar la lógica para afectar ciudades conectadas
                }
            } else {
                System.out.println("El jugador no está en ninguna ciudad.");
            }
        }
    }
}
