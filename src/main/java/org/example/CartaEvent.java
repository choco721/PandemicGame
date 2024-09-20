package org.example;

public class CartaEvent extends Carta {
    public CartaEvent(String contenido) {
        super("Evento", contenido);
    }


    public void aplicarEfecto(Tablero tablero, Jugador jugador) {
        System.out.println("Se aplica el efecto del evento: " + this.toString());

        Ciudad ciudadACurar = jugador.getCiudadActual();
        if (ciudadACurar != null) {
            ciudadACurar.curar();
        }
    }
}