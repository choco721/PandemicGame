package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Jugadores {

    public static void main(String[] args) {
        // Crear ciudades
        Ciudad buenosAires = new Ciudad("Buenos Aires");
        Ciudad elCairo = new Ciudad("El Cairo");
        Ciudad miami = new Ciudad("Miami");
        Ciudad sanFrancisco = new Ciudad("San Francisco");
        Ciudad paris = new Ciudad("París");
        Ciudad saoPaulo = new Ciudad("São Paulo");
        Ciudad madrid = new Ciudad("Madrid");

        // Inicializar cubos de enfermedad
        buenosAires.agregarCubos(0, 3);
        elCairo.agregarCubos(1, 2);
        miami.agregarCubos(2, 1);
        sanFrancisco.agregarCubos(3, 1);

        // Crear jugadores
        List<Player> jugadores = new ArrayList<>();
        jugadores.add(new Jugador1("Jugador 1", buenosAires));
        jugadores.add(new Jugador2("Jugador 2", elCairo));
        jugadores.add(new Jugador3("Jugador 3", miami));
        jugadores.add(new Jugador4("Jugador 4", sanFrancisco));

        // Simulación de turnos
        Scanner scanner = new Scanner(System.in);
        boolean juegoEnCurso = true;
        int turno = 0;

        while (juegoEnCurso) {
            Player jugadorActual = jugadores.get(turno % jugadores.size());

            // Mostrar estado del jugador actual
            System.out.println(jugadorActual);

            // Mostrar opciones de acción
            System.out.println(jugadorActual.getNombre() + ", ¿qué acción deseas realizar? (mover/tratar/accion): ");
            String accion = scanner.nextLine().toLowerCase();

            // Realizar acción
            jugadorActual.realizarAccion(accion);

            // Verificar condiciones de victoria/derrota
            juegoEnCurso = verificarEstadoDelJuego();

            // Pasar al siguiente turno
            turno++;
        }

        scanner.close();
    }

    private static boolean verificarEstadoDelJuego() {
        // Implementar la lógica para verificar condiciones de victoria/derrota
        // Ejemplo simple de condición de victoria
        boolean juegoGana = true;
        for (Ciudad ciudad : Ciudad.getCiudades()) {
            if (ciudad.getCubosDeEnfermedad()[0] > 0 ||
                    ciudad.getCubosDeEnfermedad()[1] > 0 ||
                    ciudad.getCubosDeEnfermedad()[2] > 0 ||
                    ciudad.getCubosDeEnfermedad()[3] > 0) {
                juegoGana = false;
                break;
            }
        }
        if (juegoGana) {
            System.out.println("¡Felicidades! ¡Han ganado el juego!");
        } else {
            System.out.println("El juego continúa.");
        }
        return !juegoGana; // Continúa el juego si no ha ganado
    }

    // Clase Ciudad
    public static class Ciudad {
        private static List<Ciudad> ciudades = new ArrayList<>();
        private String nombre;
        private boolean tieneCura;
        private int[] cubosDeEnfermedad;

        public Ciudad(String nombre) {
            this.nombre = nombre;
            this.tieneCura = false;
            this.cubosDeEnfermedad = new int[4];
            ciudades.add(this);
        }

        public void agregarCubos(int tipo, int cantidad) {
            if (tipo >= 0 && tipo < cubosDeEnfermedad.length) {
                cubosDeEnfermedad[tipo] += cantidad;
            } else {
                System.out.println("Tipo de enfermedad inválido.");
            }
        }

        public void removerCubos(int tipo, int cantidad) {
            if (tipo >= 0 && tipo < cubosDeEnfermedad.length) {
                if (cubosDeEnfermedad[tipo] >= cantidad) {
                    cubosDeEnfermedad[tipo] -= cantidad;
                } else {
                    System.out.println("No hay suficientes cubos para remover.");
                }
            } else {
                System.out.println("Tipo de enfermedad inválido.");
            }
        }

        public boolean tieneCura() {
            return tieneCura;
        }

        public void establecerCura(boolean tieneCura) {
            this.tieneCura = tieneCura;
        }

        public String getNombre() {
            return nombre;
        }

        public int[] getCubosDeEnfermedad() {
            return cubosDeEnfermedad;
        }

        public static List<Ciudad> getCiudades() {
            return ciudades;
        }

        @Override
        public String toString() {
            return "Ciudad: " + nombre + ", Cubos de enfermedad: " + java.util.Arrays.toString(cubosDeEnfermedad) + ", Tiene cura: " + tieneCura;
        }
    }

    // Clase abstracta Player
    public abstract static class Player {
        private String nombre;
        private Ciudad ciudadActual;

        public Player(String nombre, Ciudad ciudadInicial) {
            this.nombre = nombre;
            this.ciudadActual = ciudadInicial;
        }

        public void moverse(Ciudad nuevaCiudad) {
            if (ciudadActual != null && esCiudadAdyacente(nuevaCiudad)) {
                this.ciudadActual = nuevaCiudad;
            } else {
                System.out.println("No se puede mover a la ciudad seleccionada.");
            }
        }

        protected abstract boolean esCiudadAdyacente(Ciudad ciudad);

        public void tratarEnfermedad(int tipo) {
            if (ciudadActual != null && ciudadActual.getCubosDeEnfermedad()[tipo] > 0) {
                ciudadActual.removerCubos(tipo, 1);
            } else {
                System.out.println("No hay suficientes cubos de enfermedad para tratar.");
            }
        }

        public String getNombre() {
            return nombre;
        }

        public Ciudad getCiudadActual() {
            return ciudadActual;
        }

        public abstract void accionEspecial();

        public void realizarAccion(String accion) {
            Scanner scanner = new Scanner(System.in);
            switch (accion) {
                case "mover":
                    System.out.println("¿A qué ciudad deseas moverte?");
                    String ciudadDestino = scanner.nextLine();
                    Ciudad nuevaCiudad = Ciudad.getCiudades().stream()
                            .filter(ciudad -> ciudad.getNombre().equalsIgnoreCase(ciudadDestino))
                            .findFirst()
                            .orElse(null);
                    if (nuevaCiudad != null) {
                        moverse(nuevaCiudad);
                    } else {
                        System.out.println("Ciudad no válida.");
                    }
                    break;
                case "tratar":
                    System.out.println("¿Qué tipo de enfermedad deseas tratar? (0-3)");
                    int tipoEnfermedad = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    tratarEnfermedad(tipoEnfermedad);
                    break;
                case "accion":
                    accionEspecial();
                    break;
                default:
                    System.out.println("Acción no válida.");
            }
        }

        @Override
        public String toString() {
            return "Jugador: " + nombre + ", Ciudad Actual: " + ciudadActual.getNombre();
        }
    }

    // Clases Jugador específicos
    public static class Jugador1 extends Player {
        public Jugador1(String nombre, Ciudad ciudadInicial) {
            super(nombre, ciudadInicial);
        }

        @Override
        protected boolean esCiudadAdyacente(Ciudad ciudad) {
            // Implementar la lógica para verificar si la ciudad es adyacente para Jugador 1
            return true; // Ejemplo, debe ser reemplazado con la lógica real
        }

        @Override
        public void accionEspecial() {
            System.out.println("Jugador 1 usa su acción especial.");
            // Implementar acción especial para Jugador 1
        }
    }

    public static class Jugador2 extends Player {
        public Jugador2(String nombre, Ciudad ciudadInicial) {
            super(nombre, ciudadInicial);
        }

        @Override
        protected boolean esCiudadAdyacente(Ciudad ciudad) {
            // Implementar la lógica para verificar si la ciudad es adyacente para Jugador 2
            return true; // Ejemplo, debe ser reemplazado con la lógica real
        }

        @Override
        public void accionEspecial() {
            System.out.println("Jugador 2 usa su acción especial.");
            // Implementar acción especial para Jugador 2
        }
    }

    public static class Jugador3 extends Player {
        public Jugador3(String nombre, Ciudad ciudadInicial) {
            super(nombre, ciudadInicial);
        }

        @Override
        protected boolean esCiudadAdyacente(Ciudad ciudad) {
            // Implementar la lógica para verificar si la ciudad es adyacente para Jugador 3
            return true; // Ejemplo, debe ser reemplazado con la lógica real
        }

        @Override
        public void accionEspecial() {
            System.out.println("Jugador 3 usa su acción especial.");
            // Implementar acción especial para Jugador 3
        }
    }

    public static class Jugador4 extends Player {
        public Jugador4(String nombre, Ciudad ciudadInicial) {
            super(nombre, ciudadInicial);
        }

        @Override
        protected boolean esCiudadAdyacente(Ciudad ciudad) {
            // Implementar la lógica para verificar si la ciudad es adyacente para Jugador 4
            return true; // Ejemplo, debe ser reemplazado con la lógica real
        }

        @Override
        public void accionEspecial() {
            System.out.println("Jugador 4 usa su acción especial.");
            // Implementar acción especial para Jugador 4
        }
    }
}
