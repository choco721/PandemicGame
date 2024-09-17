package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorCartas {
    private List<String> mazoInfeccion;
    private List<String> mazoEventos;
    private List<String> pilaDescarteInfeccion;
    private List<String> pilaDescarteEventos;

    public GestorCartas() {
        mazoInfeccion = new ArrayList<>();
        mazoEventos = new ArrayList<>();
        pilaDescarteInfeccion = new ArrayList<>();
        pilaDescarteEventos = new ArrayList<>();
        inicializarMazos();
        barajarMazos();
    }

    private void inicializarMazos() {
        // Añadir cartas al mazo de infección
        mazoInfeccion.add("Infección Ciudad 1");
        mazoInfeccion.add("Infección Ciudad 2");
        mazoInfeccion.add("Infección Ciudad 3");
        // Añadir más cartas según sea necesario

        // Añadir cartas al mazo de eventos
        mazoEventos.add("Evento 1: Reacción rápida");
        mazoEventos.add("Evento 2: Movimiento rápido");
        mazoEventos.add("Evento 3: Curación inmediata");
        // Añadir más cartas de eventos según sea necesario
    }

    private void barajarMazos() {
        Collections.shuffle(mazoInfeccion);
        Collections.shuffle(mazoEventos);
    }

    public String robarCartaInfeccion() {
        if (!mazoInfeccion.isEmpty()) {
            String carta = mazoInfeccion.remove(0);
            pilaDescarteInfeccion.add(carta); // Agregar a la pila de descarte
            return carta;
        } else {
            return "No hay más cartas de infección.";
        }
    }

    public String robarCartaEvento() {
        if (!mazoEventos.isEmpty()) {
            String carta = mazoEventos.remove(0);
            pilaDescarteEventos.add(carta); // Agregar a la pila de descarte
            return carta;
        } else {
            return "No hay más cartas de eventos.";
        }
    }

    public void restablecerMazoInfeccion() {
        mazoInfeccion.addAll(pilaDescarteInfeccion);
        pilaDescarteInfeccion.clear();
        barajarMazos();
    }

    public void restablecerMazoEventos() {
        mazoEventos.addAll(pilaDescarteEventos);
        pilaDescarteEventos.clear();
        barajarMazos();
    }

    public List<String> obtenerPilaDescarteInfeccion() {
        return pilaDescarteInfeccion;
    }

    public List<String> obtenerPilaDescarteEventos() {
        return pilaDescarteEventos;
    }
}
