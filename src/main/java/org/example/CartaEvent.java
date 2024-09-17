package org.example;

public class CartaEvent extends Carta {
    public CartaEvent(String contenido) {
        super("Evento", contenido);
    }


    public void aplicarEfecto(Tablero tablero, Jugador jugador) {
        // Lógica para un efecto específico de evento
        System.out.println("Se aplica el efecto del evento: " + this.toString());
        // Por ejemplo, curar una ciudad
        Ciudad ciudadACurar = jugador.getCiudadActual(); // Supongamos que el jugador tiene un método para obtener su ciudad actual
        if (ciudadACurar != null) {
            ciudadACurar.curar();
        }
    }
}