package org.example;

public class Ciudad {

        private final String nombre;
        private boolean tieneCura;
        private int[] cubosDeEnfermedad; // Índices para diferentes tipos de enfermedades

        // Constructor
        public Ciudad(String nombre) {
            this.nombre = nombre;
            this.tieneCura = false;
            this.cubosDeEnfermedad = new int[4]; // Suponiendo 4 tipos de enfermedades
        }

        // Métodos para manipular los cubos de enfermedad
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

        public String toString() {
            return "Ciudad: " + nombre + ", Cubos de enfermedad: " + java.util.Arrays.toString(cubosDeEnfermedad) + ", Tiene cura: " + tieneCura;
        }
}


