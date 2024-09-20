package org.example;

public class CartaEnfermedad extends Carta {
    private String enfermedad;

    public CartaEnfermedad(String enfermedad) {
        super("Enfermedad", enfermedad);
        this.enfermedad = enfermedad;
    }

    public void aplicarEfecto(Tablero tablero, Jugador jugador) {
        Ciudad ciudadAInfectar = tablero.getCiudadAleatoria(); //
        if (ciudadAInfectar != null) {
            ciudadAInfectar.infectar();
            System.out.println("La ciudad " + ciudadAInfectar.getNombre() + " ha sido infectada por " + enfermedad);
        }
    }
}