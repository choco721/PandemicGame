package org.example;

public class CartaEnfermedad extends Carta {
    private String enfermedad;

    public CartaEnfermedad(String enfermedad) {
        super("Enfermedad", enfermedad);
        this.enfermedad = enfermedad;
    }


    public void aplicarEfecto(Tablero tablero, Jugador jugador) {
        // Lógica para infectar una ciudad aleatoria
        Ciudad ciudadAInfectar = tablero.getCiudadAleatoria(); // Método que debes implementar en Tablero
        if (ciudadAInfectar != null) {
            ciudadAInfectar.infectar();
            System.out.println("La ciudad " + ciudadAInfectar.getNombre() + " ha sido infectada por " + enfermedad);
        }
    }
}