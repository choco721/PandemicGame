package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        GestorDeCartas gestorDeCartas = new GestorDeCartas();
        List<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Crear ciudades
        Ciudad newYork = new Ciudad("New York");
        Ciudad losAngeles = new Ciudad("Los Angeles");
        Ciudad chicago = new Ciudad("Chicago");
        Ciudad miami = new Ciudad("Miami");

        // Añadir ciudades al tablero
        tablero.addCiudad(newYork);
        tablero.addCiudad(losAngeles);
        tablero.addCiudad(chicago);
        tablero.addCiudad(miami);

        // Conectar ciudades
        tablero.conectarCiudades("New York", "Los Angeles");
        tablero.conectarCiudades("Chicago", "Miami");

        // Añadir jugadores
        System.out.println("¡Bienvenidos al juego Pandemic Game!");
        for (int i = 0; i < 4; i++) {
            System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el rol del jugador " + (i + 1) + " (Médico, Científico, Maestro, Comandante): ");
            String rol = scanner.nextLine();
            jugadores.add(new Jugador(nombre, rol));
        }

        boolean juegoEnCurso = true;
        int turnoActual = 0;

        while (juegoEnCurso) {
            Jugador jugadorActual = jugadores.get(turnoActual);
            System.out.println("\n--- Turno de " + jugadorActual.getNombre() + " (" + jugadorActual.getRol() + ") ---");
            System.out.println("1. Mostrar estado de las ciudades");
            System.out.println("2. Infectar ciudad");
            System.out.println("3. Curar ciudad");
            System.out.println("4. Mostrar jugadores");
            System.out.println("5. Mostrar conexiones del tablero");
            System.out.println("6. Sacar carta de infección");
            System.out.println("7. Mover jugador");
            System.out.println("8. Salir");

            int opcion = -1;
            while (opcion < 1 || opcion > 8) {
                System.out.print("Seleccione una opción: ");
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    if (opcion < 1 || opcion > 8) {
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    }
                } else {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                    scanner.nextLine();
                }
            }

            switch (opcion) {
                case 1:
                    System.out.println("Estado de las ciudades:");
                    for (Ciudad ciudad : tablero.getCiudades().values()) {
                        System.out.println(ciudad);
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la ciudad para infectar: ");
                    String ciudadInfectar = scanner.nextLine();
                    Ciudad ciudadInfectada = tablero.getCiudad(ciudadInfectar);
                    if (ciudadInfectada != null) {
                        ciudadInfectada.infectar();
                        System.out.println(ciudadInfectada.getNombre() + " se ha infectado.");
                    } else {
                        System.out.println("Ciudad no encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la ciudad para curar: ");
                    String ciudadCurar = scanner.nextLine();
                    Ciudad ciudadCurada = tablero.getCiudad(ciudadCurar);
                    if (ciudadCurada != null) {
                        ciudadCurada.curar();
                        System.out.println(ciudadCurada.getNombre() + " se ha curado.");
                    } else {
                        System.out.println("Ciudad no encontrada.");
                    }
                    break;
                case 4:
                    for (Jugador jugador : jugadores) {
                        System.out.println(jugador);
                    }
                    break;
                case 5:
                    tablero.mostrarConexiones();
                    break;
                case 6: // Sacar carta de infección
                    Carta cartaSacada = gestorDeCartas.sacarCarta();
                    if (cartaSacada != null) {
                        System.out.println("Carta sacada: " + cartaSacada);
                        cartaSacada.aplicarEfecto(gestorDeCartas, tablero, jugadorActual); // Aplica el efecto de la carta
                    } else {
                        System.out.println("No hay más cartas en el mazo.");
                    }
                    break;
                case 7: // Mover jugador
                    System.out.print("Ingrese el nombre de la ciudad a la que desea moverse: ");
                    String nombreCiudadDestino = scanner.nextLine();
                    Ciudad ciudadDestino = tablero.getCiudad(nombreCiudadDestino);
                    if (ciudadDestino != null) {
                        // Verificar si la ciudad destino está conectada con la ciudad actual
                        if (jugadorActual.getCiudadActual() != null &&
                                jugadorActual.getCiudadActual().getConexiones().contains(ciudadDestino)) {
                            jugadorActual.setCiudadActual(ciudadDestino);
                            System.out.println(jugadorActual.getNombre() + " se ha movido a " + ciudadDestino.getNombre());
                        } else if (jugadorActual.getCiudadActual() == null) {
                            jugadorActual.setCiudadActual(ciudadDestino);
                            System.out.println(jugadorActual.getNombre() + " se ha movido a " + ciudadDestino.getNombre());
                        } else {
                            System.out.println("No se puede mover a " + ciudadDestino.getNombre() + ", no está conectada.");
                        }
                    } else {
                        System.out.println("Ciudad no encontrada.");
                    }
                    break;
                case 8: // Salir
                    System.out.println("¡Gracias por jugar!");
                    juegoEnCurso = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            // Comprobar condiciones de fin del juego
            if (tablero.hayBrotes()) {
                System.out.println("¡El juego ha terminado! Los brotes han alcanzado el límite.");
                juegoEnCurso = false;
            }

            if (tablero.todasLasCurasEncontradas()) {
                System.out.println("¡Victoria! Se han encontrado todas las curas.");
                juegoEnCurso = false;
            }

            // Pasar al siguiente turno solo si no se han mostrado estados o conexiones
            if (opcion != 1 && opcion != 5) {
                turnoActual = (turnoActual + 1) % jugadores.size();
            }
        }

        scanner.close();
    }
}
