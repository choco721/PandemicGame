package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorDeCartas {
    private List<Carta> mazoDeCartas;
    private List<Carta> cartasSacadas;

    public GestorDeCartas() {
        mazoDeCartas = new ArrayList<>();
        cartasSacadas = new ArrayList<>();
        inicializarMazo();
        barajarMazo();
    }

    private void inicializarMazo() {
        // Inicializa el mazo con cartas de enfermedades
        mazoDeCartas.add(new CartaEnfermedad("Enfermedad1"));
        mazoDeCartas.add(new CartaEnfermedad("Enfermedad2"));
        mazoDeCartas.add(new CartaEnfermedad("Enfermedad3"));
        mazoDeCartas.add(new CartaEnfermedad("Enfermedad4"));

        // Añadir cartas de eventos
        mazoDeCartas.add(new CartaEvent("Evento1: Cure una ciudad."));
        mazoDeCartas.add(new CartaEvent("Evento2: Infecte una ciudad aleatoria."));
    }

    private void barajarMazo() {
        Collections.shuffle(mazoDeCartas);
    }

    public Carta sacarCarta() {
        if (!mazoDeCartas.isEmpty()) {
            Carta carta = mazoDeCartas.remove(0);
            cartasSacadas.add(carta);
            return carta;
        }
        return null;
    }

    public void mostrarCartasSacadas() {
        System.out.println("Cartas sacadas:");
        for (Carta carta : cartasSacadas) {
            System.out.println(carta);
        }
    }

    public boolean estaVacio() {
        return mazoDeCartas.isEmpty();
    }
}
