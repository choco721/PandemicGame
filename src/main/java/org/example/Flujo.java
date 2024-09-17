package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.lang.String;

public class Flujo {
    public static <ciudad> void main(String[] args) {
        //declaramos en un (enum) nuestras variables a trabajar en los proximos script como punto de referencia
        enum CartasJugables {
            CARTAS_DE_CIUDADES,
            CARTAS_DE_ENFERMEDAD,
            CARTAS_DE_EPIDEMIA,
            CARTAS_DE_EVENTO;

            //declaramos las variables tomadas anteriormente
            public static void main(String[] args) {
                String[] values = {
                        "cartas de ciudades",
                        "cartas de enfermedad",
                        "cartas de epidemia",
                        "cartas de evento"
                };

                // mostramos cada valor
                for (String str : values) {
                    System.out.println(str);
                }
            }
        }


//introduccion
        String pandemic_game = " estas son sus reglas.";
        System.out.println("Bienvenidos a Pandemic games," + pandemic_game.toUpperCase());
        String opciones = new String("LAS CARTAS DISPONIBLES SON --> buenos aires - el cairo - tokio - san francisco - paris - sao pablo - moscow ");
        System.out.println(opciones);
        // podremos observar cuantas letras contiene nuestro problema (longitud_pandemicgame)
        int longitud_pandemicgame = pandemic_game.length();
        System.out.println(longitud_pandemicgame);

        //cartas de ciudades (principales roles)

        Scanner cartas_ciudad = new Scanner(System.in);
        System.out.println("que carta desea elegir para ver sus concecuencias: ");
        String ciudad = cartas_ciudad.nextLine();
        switch (ciudad) {
            case "buenos aires":
                System.out.println("su color asociado es el amarillo");
                System.out.println("los eventos son la mayor causa de infecciones en esta ciudad," +
                        "tambien sera bueno para intercambiar cartas e ir a otras ciudades y estrategias");
                break;
            case "el cairo":
                System.out.println("su color asociado es el negro");
                System.out.println("es una de las ciudades con mas brotes y casos de infecciones," +
                        "es esencial el uso de tratamientos curativos ante cualquier infeccion");
                break;

            case "tokio":
                System.out.println("su color asociado es el rojo ");
                System.out.println("a pesar de que hay muchos brotes," +
                        "puede ir como estrategia para centrar las enfermedad y buscar curas por se grandeza de ciudad.");
                break;

            case "san francisco":
                System.out.println("su color asociado es el azul");
                System.out.println("su ubicacion esquinada hace que hayan menos brotes a diferencia de otras ciudades centrales");
                break;

            case "paris":
                System.out.println("su color asociado es el azul");
                System.out.println("es esencial para compartir cartas con otros jugadores para descubrir una cura, aunque es una ciudad con multiples infecciones a cada rato");
                break;

            case "sao pablo":
                System.out.println("su color asociado es el amarillo");
                System.out.println("los jugadores se trasladan alli para tratar enfermedades ");
                break;

            case "moscow":
                System.out.println("su color asociado es el negro");
                System.out.println("los jugadores intervienen alli principalmente para intercambiar cartas y armar planes para crear nuevas curas");
                break;
            default:
                System.out.println("esta carta no esta disponible.");
                break;

        }
        //cual es el tipo de enfermedad que caracteriza a cada ciudad

        System.out.println("Ahora veamos cuáles son los tipos de enfermedades:");
        String enfermedades = "Los tipos de enfermedades/brote son -> la negra - la azul - la amarilla - la roja";
        System.out.println(enfermedades);
        int longitud_enfermedad = enfermedades.length();
        System.out.println(longitud_enfermedad);

        Scanner color_enfermedad = new Scanner(System.in);
        System.out.println("Elija una enfermedad: ");
        String enfermedad = color_enfermedad.nextLine();


        if (enfermedad.equals("la negra")) {
            System.out.println("Esta enfermedad pertenece a las cartas de Medio Oriente/Asia.");
        } else if (enfermedad.equals("la azul")) {
            System.out.println("Esta enfermedad pertenece a las cartas de Europa y América del Norte.");
        } else if (enfermedad.equals("la amarilla")) {
            System.out.println("Esta enfermedad pertenece a las cartas de América del Sur.");
        } else if (enfermedad.equals("la roja")) {
            System.out.println("Esta enfermedad pertenece a las cartas de Asia y Oceanía.");
        } else {
            System.out.println("Tipo de enfermedad no reconocido.");
        }
        System.out.println("P R O C E S O DE E P I D E M I A");
        String descripcionEpidemia = "es especial y sirven para aumentar la dificultad del juego.";
        System.out.println("EL PROCESO DE UNA EPIDEMIA " + descripcionEpidemia);
        int longitud_epidemia = descripcionEpidemia.length();
        System.out.println(longitud_epidemia);

        Scanner cartaEpidemia = new Scanner(System.in);
        System.out.println("Ingrese el tipo de carta de epidemia ('intensificacion' o 'reseñar'):");
        String tipo = cartaEpidemia.nextLine().trim().toLowerCase(); // Convertir a minúsculas para comparación

        switch (tipo) {
            case "intensificacion":
                System.out.println("Esta carta se encarga de brindar apoyo a las ciudades con más brotes.");
                break;
            case "reseñar":
                System.out.println("Esta carta se encarga de gestionar los brotes, como la capacidad máxima de cubos por ciudad, entre otras cosas.");
                break;
            default:
                System.out.println("Esta carta no está disponible.");
                break;
        }
        //carta 4_  carta de evento
        System.out.println("C A R T A D E E V E N T O");
        String carta_evento = "no cuenta no como una accion, pero son escencial para mover al jugador de ciudad en ciudad y asi prevenir brotes.";
        System.out.println("las cartas de evento" + carta_evento);
        System.out.println("represantaremos cada evento con un numero");
        int longitud_evento = carta_evento.length();
        System.out.println(longitud_evento);


        int airlift = 1;
        int resilient_population = 2;
        int government_grant = 3;


        do {
            System.out.println("(airlift) --> movemos cualquier jugador, para que se cambie a otra ciudad sin tener que gastar acciones.");
            airlift++;
        } while (airlift <= 1);


        do {
            System.out.println("(resilient_population) --> se puede descartar de tu baraja una carta de infección. Estado actual: " + resilient_population);
            resilient_population++;
        } while (resilient_population <= 2); // Ajustar para limitar el ciclo


        do {
            System.out.println("(government_grant) --> se puede construir una estación de investigación en cualquier ciudad del tablero, sin necesidad de descartar una carta valiosa. Estado actual: " + government_grant);
            government_grant++;
        } while (government_grant <= 3);

        System.out.println("." + "." + "." + "." + ".." + "." + "." + "." + ".");

        enum TiposDeJugadores {
            MEDICO,
            CIENTIFICO,
            MAESTRO,
            COMANDANTE, TiposDeJugadores;

            public static void main(String[] args) {


                // Obtener todos los valores del enum
                TiposDeJugadores[] jugadores = TiposDeJugadores.values();
                for (TiposDeJugadores tiposDeJugadores : jugadores) {
                    System.out.println(TiposDeJugadores);
                }
            }


        }
        String jugadores_ = "son aquellos que deben cumplir todas las acciones del juego ";
        System.out.println("los jugadores" + jugadores_);

// Clase base para los tipos de jugadors
// Definición del enum para tipos de jugadores
        enum Tipos_Jugadores {
            MEDICO,
            CIENTIFICO,
            MAESTRO,
            COMANDANTE;

            public static void main(String[] args) {
                // Obtener todos los valores del enum
                Tipos_Jugadores[] jugadores = Tipos_Jugadores.values();

                // Imprimir cada tipo de jugador
                for (Tipos_Jugadores tipoDeJugador : jugadores) {
                    System.out.println(tipoDeJugador);
                }

                // Descripción general
                String descripcion = "son aquellos que deben cumplir todas las acciones del juego";
                System.out.println("Los jugadores " + descripcion);
            }
        }

// Clase ciudad donde se encuentra el personaje
        class Ciudad {
            private String nombre;

            public Ciudad(String nombre) {
                this.nombre = nombre;
            }

            public String getNombre() {
                return nombre;
            }
        }


        String jugadorMedico = "tratar con facilidad las enfermedades y de esta manera curar";
        System.out.println("La principal acción del médico es: " + jugadorMedico);


        String jugadorMaestro = "construir salas de investigación en cualquier ciudad";
        System.out.println("La principal acción del maestro es: " + jugadorMaestro);


        String jugadorCientifico = "investigar las enfermedades para desarrollar curas más rápido";
        System.out.println("La principal acción del científico es: " + jugadorCientifico);

        String jugadorComandante ="tiene capacidades y planear estrategicas a largo plazo";
        System.out.println("la principal accion del comandante es: "+jugadorComandante);


    }
}