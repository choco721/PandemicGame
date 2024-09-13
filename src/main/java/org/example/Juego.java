package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase Ciudad que representa una ciudad en el juego
class ciudad {
    private String nombre;
    private boolean infectada;

    public ciudad(String nombre) {
        this.nombre = nombre;
        this.infectada = false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isInfectada() {
        return infectada;
    }

    public void infectar() {
        this.infectada = true;
    }

    public void curar() {
        this.infectada = false;
    }

    @Override
    public String toString() {
        return nombre + (infectada ? " (Infectada)" : " (Sana)");
    }
}

// Clase Jugador que representa un jugador en el juego
class Jugadorr {
    private String nombre;
    private String rol;

    public Jugadorr(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    @Override
    public String toString() {
        return nombre + " (" + rol + ")";
    }
}

// Clase principal del juego que gestiona el estado del juego y los jugadores
public class Juego {
    private List<ciudad> ciudades;
    private List<Jugadorr> jugadores;
    private Scanner scanner;
    private int turnoActual;

    public Juego() {
        ciudades = new ArrayList<>();
        jugadores = new ArrayList<>();
        scanner = new Scanner(System.in);
        turnoActual = 0;
        inicializarCiudades();
        inicializarJugadores();
    }

    private void inicializarCiudades() {
        // Inicializar algunas ciudades
        ciudades.add(new ciudad("New York"));
        ciudades.add(new ciudad("Los Angeles"));
        ciudades.add(new ciudad("Chicago"));
        ciudades.add(new ciudad("Miami"));
    }

    private void inicializarJugadores() {
        System.out.println("¡Bienvenido al juego Pandemic!");
        for (int i = 1; i <= 4; i++) {
            System.out.print("Ingrese el nombre del jugador " + i + ": ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el rol del jugador " + i + " (por ejemplo, Médico, Científico, etc.): ");
            String rol = scanner.nextLine();
            jugadores.add(new Jugadorr(nombre, rol));
        }
    }

    public void mostrarEstado() {
        System.out.println("Estado de las ciudades:");
        for (org.example.ciudad ciudad : ciudades) {
            System.out.println(ciudad);
        }
    }

    public void infectarCiudad(String nombreCiudad) {
        for (org.example.ciudad ciudad : ciudades) {
            if (ciudad.getNombre().equalsIgnoreCase(nombreCiudad)) {
                ciudad.infectar();
                System.out.println("Ciudad infectada: " + ciudad);
                return;
            }
        }
        System.out.println("Ciudad no encontrada.");
    }

    public void curarCiudad(String nombreCiudad) {
        for (org.example.ciudad ciudad : ciudades) {
            if (ciudad.getNombre().equalsIgnoreCase(nombreCiudad)) {
                ciudad.curar();
                System.out.println("Ciudad curada: " + ciudad);
                return;
            }
        }
        System.out.println("Ciudad no encontrada.");
    }

    private void mostrarJugadores() {
        System.out.println("Jugadores:");
        for (Jugadorr jugador : jugadores) {
            System.out.println(jugador);
        }
    }

    public void jugar() {
        while (true) {
            Jugadorr jugadorActual = jugadores.get(turnoActual);
            System.out.println("\n--- Turno de " + jugadorActual.getNombre() + " (" + jugadorActual.getRol() + ") ---");
            System.out.println("1. Mostrar estado de las ciudades");
            System.out.println("2. Infectar ciudad");
            System.out.println("3. Curar ciudad");
            System.out.println("4. Mostrar jugadores");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    mostrarEstado();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la ciudad para infectar: ");
                    String ciudadInfectar = scanner.nextLine();
                    infectarCiudad(ciudadInfectar);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la ciudad para curar: ");
                    String ciudadCurar = scanner.nextLine();
                    curarCiudad(ciudadCurar);
                    break;
                case 4:
                    mostrarJugadores();
                    break;
                case 5:
                    System.out.println("¡Gracias por jugar!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }

            // Pasar al siguiente turno
            turnoActual = (turnoActual + 1) % jugadores.size();
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.jugar();
    }
}
