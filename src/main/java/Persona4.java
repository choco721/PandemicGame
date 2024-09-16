import java.util.Scanner;

public class Persona4 {

    enum CartasJugables {
        CARTAS_DE_CIUDADES,
        CARTAS_DE_ENFERMEDAD,
        CARTAS_DE_EPIDEMIA,
        CARTAS_DE_EVENTO
    }

    enum TiposDeJugadores {
        MEDICO,
        CIENTIFICO,
        MAESTRO,
        COMANDANTE
    }

    enum CartasEvento {
        AIRLIFT,
        RESILIENT_POPULATION,
        GOVERNMENT_GRANT
    }

    enum Roles {
        MEDICO_ELCAIRO,
        COMANDANTE_MIAMI,
        CIENTIFICO_BUENOSAIRES,
        MAESTRO_MOSCOW
    }

    public static void main(String[] args) {
        // Introducción
        String pandemicGame = "estas son sus reglas.";
        System.out.println("Bienvenidos a Pandemic games, " + pandemicGame.toUpperCase());

        // Opciones de cartas
        String opciones = "LAS CARTAS DISPONIBLES SON --> buenos aires - el cairo - tokio - san francisco - paris - sao pablo - moscow";
        System.out.println(opciones);
        int longitudPandemicGame = pandemicGame.length();
        System.out.println("Longitud del texto de introducción: " + longitudPandemicGame);

        // Elección de carta de ciudad
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué carta desea elegir para ver sus consecuencias? ");
        String ciudad = scanner.nextLine().trim().toLowerCase();

        switch (ciudad) {
            case "buenos aires":
                System.out.println("Su color asociado es el amarillo.");
                System.out.println("Los eventos son la mayor causa de infecciones en esta ciudad. También es bueno para intercambiar cartas e ir a otras ciudades.");
                break;
            case "el cairo":
                System.out.println("Su color asociado es el negro.");
                System.out.println("Es una de las ciudades con más brotes y casos de infecciones. Es esencial el uso de tratamientos curativos ante cualquier infección.");
                break;
            case "tokio":
                System.out.println("Su color asociado es el rojo.");
                System.out.println("A pesar de que hay muchos brotes, puede ser una estrategia para centrarse en la enfermedad y buscar curas por su gran tamaño.");
                break;
            case "san francisco":
                System.out.println("Su color asociado es el azul.");
                System.out.println("Su ubicación en la esquina hace que haya menos brotes en comparación con otras ciudades centrales.");
                break;
            case "paris":
                System.out.println("Su color asociado es el azul.");
                System.out.println("Es esencial para compartir cartas con otros jugadores para descubrir una cura, aunque es una ciudad con múltiples infecciones.");
                break;
            case "sao pablo":
                System.out.println("Su color asociado es el amarillo.");
                System.out.println("Los jugadores se trasladan allí para tratar enfermedades.");
                break;
            case "moscow":
                System.out.println("Su color asociado es el negro.");
                System.out.println("Los jugadores intervienen allí principalmente para intercambiar cartas y armar planes para crear nuevas curas.");
                break;
            default:
                System.out.println("Esta carta no está disponible.");
                break;
        }

        System.out.println("...");

        // Tipos de enfermedades
        System.out.println("Ahora veamos cuáles son los tipos de enfermedades:");
        String enfermedades = "Los tipos de enfermedades/brote son -> la negra - la azul - la amarilla - la roja";
        System.out.println(enfermedades);
        int longitudEnfermedad = enfermedades.length();
        System.out.println("Longitud del texto de enfermedades: " + longitudEnfermedad);

        System.out.println("Elija una enfermedad: ");
        String enfermedad = scanner.nextLine().trim().toLowerCase();

        switch (enfermedad) {
            case "la negra":
                System.out.println("Esta enfermedad pertenece a las cartas de Medio Oriente/Asia.");
                break;
            case "la azul":
                System.out.println("Esta enfermedad pertenece a las cartas de Europa y América del Norte.");
                break;
            case "la amarilla":
                System.out.println("Esta enfermedad pertenece a las cartas de América del Sur.");
                break;
            case "la roja":
                System.out.println("Esta enfermedad pertenece a las cartas de Asia y Oceanía.");
                break;
            default:
                System.out.println("Tipo de enfermedad no reconocido.");
                break;
        }

        System.out.println("...");

        // Proceso de Epidemia
        System.out.println("P R O C E S O DE E P I D E M I A");
        String descripcionEpidemia = "es especial y sirve para aumentar la dificultad del juego.";
        System.out.println("El proceso de una epidemia " + descripcionEpidemia);
        int longitudEpidemia = descripcionEpidemia.length();
        System.out.println("Longitud del texto de epidemia: " + longitudEpidemia);

        System.out.println("Ingrese el tipo de carta de epidemia ('intensificacion' o 'reseñar'):");
        String tipo = scanner.nextLine().trim().toLowerCase();

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

        System.out.println("...");

        // Cartas de evento
        System.out.println("C A R T A D E E V E N T O");
        String cartaEvento = "no cuenta como una acción, pero son esenciales para mover al jugador de ciudad en ciudad y así prevenir brotes.";
        System.out.println("Las cartas de evento " + cartaEvento);
        System.out.println("Representaremos cada evento con un número.");
        int longitudEvento = cartaEvento.length();
        System.out.println("Longitud del texto de carta de evento: " + longitudEvento);

        System.out.println("(airlift) --> Movemos cualquier jugador a otra ciudad sin gastar acciones.");
        System.out.println("(resilient_population) --> Se puede descartar una carta de infección.");
        System.out.println("(government_grant) --> Se puede construir una estación de investigación en cualquier ciudad sin descartar una carta valiosa.");

        System.out.println("...");

        // Roles
        System.out.println("J U G A D O R E S");
        String descripcionJugadores = "son aquellos que deben cumplir todas las acciones del juego.";
        System.out.println("Los jugadores " + descripcionJugadores);

        // Descripción de roles
        String jugadorMedico = " utilizar su habilidad especial, que es curar todas las enfermedades en su ciudad actual.";
        System.out.println("La principal acción del médico es: " + jugadorMedico);

        String jugadorMaestro = " realizar intercambios de cartas de ciudad con otros jugadores, sine estar en la misma ciudad.";
        System.out.println("La principal acción del maestro es: " + jugadorMaestro);

        String jugadorCientifico = " descubrir curas con menos cartas.";
        System.out.println("La principal acción del científico es: " + jugadorCientifico);

        String jugadorComandante = " realizar movimientos adisionales por turno.";
        System.out.println("La principal acción del comandante es: " + jugadorComandante);

        System.out.println("...");

        // Ejemplos de roles
        String roles= "los roles, los cuales podrian ser situaciones donde el jugador se puede encontrar, y por ende que pasaria alli.";
        System.out.println("a continuacion veran: "+roles);
        Scanner rol_jugador=new Scanner(System.in);
        System.out.println("elige un rol -->  medico_elcairo , comandante_miami  ,  cientifico_buenosaires  ,  maestro_moscow");
        String accion = rol_jugador.nextLine();

        switch (accion) {
            case "medico_elcairo":
                System.out.println("El médico podría usar la carta de El Cairo para construir estaciones de investigación.");
                break;
            case "comandante_miami":
                System.out.println("El comandante en Miami podría enfrentar brotes masivos en esa ciudad.");
                break;
            case "cientifico_buenosaires":
                System.out.println("Si el científico tiene la carta de Buenos Aires, podrá investigar y descubrir nuevas curas, así como intercambiar cartas.");
                break;
            case "maestro_moscow":
                System.out.println("Si el maestro se encuentra en Moscú, podrá planificar estrategias y, si la ciudad está infectada, deberá manejar la infección de acuerdo con las reglas del juego.");
                break;
            default:
                System.out.println("este rol/situacion no esta disponible");
        }
        }
    }




























