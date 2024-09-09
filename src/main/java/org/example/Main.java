package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GestorCartas gestorCartas = new GestorCartas();

        // Robar cartas y mostrar resultados
        String cartaInfeccion = gestorCartas.robarCartaInfeccion();
        System.out.println("Carta de Infección Robada: " + cartaInfeccion);

        String cartaEvento = gestorCartas.robarCartaEvento();
        System.out.println("Carta de Evento Robada: " + cartaEvento);

        // Mostrar estado de las pilas de descarte
        System.out.println("Cartas de infección descartadas: " + gestorCartas.obtenerPilaDescarteInfeccion());
        System.out.println("Cartas de evento descartadas: " + gestorCartas.obtenerPilaDescarteEventos());
    }
}