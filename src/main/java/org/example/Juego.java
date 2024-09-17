import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Enum para definir los roles de los jugadores
enum Rol {
    MEDICO, CIENTIFICO, MAESTRO, COMANDANTE
}

// Clase Jugador que representa un jugador en el juego
class Jugador {
    private String nombre;
    private Rol rol;

    public Jugador(String nombre, Rol rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public Rol getRol() {
        return rol;
    }

    public String toString() {
        return nombre + " (" + rol + ")";
    }

    public void realizarAccion(Juego juego) {
        switch (rol) {
            case MEDICO:
                realizarAccionMedico(juego);
                break;
            case CIENTIFICO:
                realizarAccionCientifico(juego);
                break;
            case MAESTRO:
                realizarAccionMaestro(juego);
                break;
            case COMANDANTE:
                realizarAccionComandante(juego);
                break;
        }
    }

    private void realizarAccionMedico(Juego juego) {
        System.out.println("El Médico " + nombre + " está curando una ciudad.");
        // Implementar la lógica específica para el Médico aquí
        // Por ejemplo, el Médico puede curar una ciudad infectada más rápidamente
    }

    private void realizarAccionCientifico(Juego juego) {
        System.out.println("El Científico " + nombre + " está investigando una cura.");
        // Implementar la lógica específica para el Científico aquí
        // Por ejemplo, el Científico necesita menos cartas para descubrir una cura
    }

    private void realizarAccionMaestro(Juego juego) {
        System.out.println("El Maestro " + nombre + " está enseñando habilidades.");
        // Implementar la lógica específica para el Maestro aquí
        // Por ejemplo, el Maestro puede compartir conocimientos o habilidades con otros jugadores
    }

    private void realizarAccionComandante(Juego juego) {
        System.out.println("El Comandante " + nombre + " está gestionando recursos.");
        // Implementar la lógica específica para el Comandante aquí
        // Por ejemplo, el Comandante puede mover a otros jugadores o gestionar recursos del juego
    }
}

// Clase principal para gestionar la lista de jugadores y roles
public class Juego {
    private List<Jugador> jugadores;
    private Scanner scanner;

    public Juego() {
        jugadores = new ArrayList<>();
        scanner = new Scanner(System.in);
        inicializarJugadores();
    }

    private void inicializarJugadores() {
        System.out.println("¡Bienvenido al juego Pandemic!");
        for (int i = 1; i <= 4; i++) {
            System.out.print("Ingrese el nombre del jugador " + i + ": ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el rol del jugador " + i + " (Médico, Científico, Maestro, Comandante): ");
            String rolString = scanner.nextLine().toUpperCase();
            Rol rol;
            try {
                rol = Rol.valueOf(rolString);
            } catch (IllegalArgumentException e) {
                System.out.println("Rol inválido. Se asignará el rol por defecto: MEDICO.");
                rol = Rol.MEDICO;
            }
            jugadores.add(new Jugador(nombre, rol));
        }
    }

    private void mostrarJugadores() {
        System.out.println("Jugadores:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }

    private void ejecutarAcciones() {
        for (Jugador jugador : jugadores) {
            jugador.realizarAccion(this);
        }
    }

    public void jugar() {
        while (true) {
            System.out.println("\n--- Menú del Juego ---");
            System.out.println("1. Mostrar jugadores");
            System.out.println("2. Ejecutar acciones de todos los jugadores");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    mostrarJugadores();
                    break;
                case 2:
                    ejecutarAcciones();
                    break;
                case 3:
                    System.out.println("¡Gracias por jugar!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.jugar();
    }
}
