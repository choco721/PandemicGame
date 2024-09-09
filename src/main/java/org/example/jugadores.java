package org.example;

import java.util.Arrays;
import java.util.List;

class jugadores {
    public static void main(String[] args) {


        abstract class Player {
            private String nombre;
            private String ciudadActual;
            private int[][] cubosDeEnfermedad;

            public Player(String nombre, String ciudadInicial, int[][] cubosDeEnfermedad) {
                this.nombre = nombre;
                this.ciudadActual = ciudadInicial;
                this.cubosDeEnfermedad = cubosDeEnfermedad;
            }

            public void moverse(String nuevaCiudad) {
                if (esCiudadAdyacente(nuevaCiudad)) {
                    this.ciudadActual = nuevaCiudad;
                } else {
                    System.out.println("No se puede mover a la ciudad seleccionada.");
                }
            }

            protected abstract boolean esCiudadAdyacente(String ciudad);

            public void tratarEnfermedad(int tipo) {
                int ciudadIndex = getCiudadIndex(ciudadActual);
                if (ciudadIndex != -1 && cubosDeEnfermedad[ciudadIndex][tipo] > 0) {
                    cubosDeEnfermedad[ciudadIndex][tipo]--;
                } else {
                    System.out.println("No hay suficientes cubos de enfermedad para tratar.");
                }
            }

            private int getCiudadIndex(String ciudad) {
                List<String> ciudades = Arrays.asList("Buenos Aires", "El Cairo", "Miami", "San Francisco", "París", "São Paulo", "Madrid");
                return ciudades.indexOf(ciudad);
            }

            public String getNombre() {
                return nombre;
            }

            public String getCiudadActual() {
                return ciudadActual;
            }

            public abstract void accionEspecial();

            @Override
            public String toString() {
                return "Jugador: " + nombre + ", Ciudad Actual: " + ciudadActual;
            }
        }

        class Jugador1 extends Player {
            public Jugador1(String nombre, String ciudadInicial, int[][] cubosDeEnfermedad) {
                super(nombre, ciudadInicial, cubosDeEnfermedad);
            }

            @Override
            protected boolean esCiudadAdyacente(String ciudad) {
                // Implementar la lógica para verificar si la ciudad es adyacente para Jugador 1
                // Ejemplo simple: todas las ciudades son adyacentes
                return true;
            }

            @Override
            public void accionEspecial() {
                System.out.println("Jugador 1 usa su acción especial.");
                // Implementar acción especial para Jugador 1
            }
        }

        class Jugador2 extends Player {
            public Jugador2(String nombre, String ciudadInicial, int[][] cubosDeEnfermedad) {
                super(nombre, ciudadInicial, cubosDeEnfermedad);
            }

            @Override
            protected boolean esCiudadAdyacente(String ciudad) {
                // Implementar la lógica para verificar si la ciudad es adyacente para Jugador 2
                // Ejemplo simple: todas las ciudades son adyacentes
                return true;
            }

            @Override
            public void accionEspecial() {
                System.out.println("Jugador 2 usa su acción especial.");
                // Implementar acción especial para Jugador 2
            }
        }

        class Jugador3 extends Player {
            public Jugador3(String nombre, String ciudadInicial, int[][] cubosDeEnfermedad) {
                super(nombre, ciudadInicial, cubosDeEnfermedad);
            }

            @Override
            protected boolean esCiudadAdyacente(String ciudad) {
                // Implementar la lógica para verificar si la ciudad es adyacente para Jugador 3
                // Ejemplo simple: todas las ciudades son adyacentes
                return true;
            }

            @Override
            public void accionEspecial() {
                System.out.println("Jugador 3 usa su acción especial.");
                // Implementar acción especial para Jugador 3
            }
        }

        class Jugador4 extends Player {
            public Jugador4(String nombre, String ciudadInicial, int[][] cubosDeEnfermedad) {
                super(nombre, ciudadInicial, cubosDeEnfermedad);
            }

            @Override
            protected boolean esCiudadAdyacente(String ciudad) {
                // Implementar la lógica para verificar si la ciudad es adyacente para Jugador 4
                // Ejemplo simple: todas las ciudades son adyacentes
                return true;
            }

            @Override
            public void accionEspecial() {
                System.out.println("Jugador 4 usa su acción especial.");
                // Implementar acción especial para Jugador 4
            }
        }
    }
}
