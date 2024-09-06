import java.sql.SQLOutput;
import java.util.Scanner;

public class persona4 {
    public static void main(String[] args) {
//introduccion
        String pandemic_game= " 4 jugadores";
        System.out.println("Bienvenidos a Pandemic games, un juego para"+pandemic_game.toUpperCase());
        String opciones= new String ("LAS CARTAS DISPONIBLES SON: buenos aires-el cairo-miami-san francisco-paris-sao pablo-madrid ");
        System.out.println(opciones);

        //cartas de ciudades (principales roles)

        Scanner cartas_ciudad = new Scanner(System.in);
        System.out.println("que carta desea elegir para ver sus concecuencias: ");
        String ciudad = cartas_ciudad.nextLine();
        switch (ciudad) {
            case "buenos aires":
                System.out.println("los eventos son la mayor causa de infecciones en esta ciudad");
                System.out.println("tambien sera bueno para intercambiar cartas e ir a otras ciudades y estrategias");
                break;
            case "el cairo":
                System.out.println("es una de las ciudades con mas brotes y casos de infecciones");
                System.out.println("es esencial el uso de tratamientos curativos ante cualquier infeccion");
                break;

            case "miami":
                System.out.println("a pesar de que hay brotes, es una mejor opcion que otras ");
                System.out.println("puede ir como estrategia para controlar la propagación de enfermedades en América del Norte.");

            case "san francisco":
                    System.out.println("");





        }
    }
}
