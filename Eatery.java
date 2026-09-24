import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner; 
import java.util.stream.IntStream;

public class Eatery {
    public static void commande(int[] persons, BufferedWriter file, Scanner input) throws IOException {
        Food[][] food = Food.initialize();
        Menu[] menus = Menu.initializeMenus(food);

        for (int person : persons) {
            System.out.println("\n==========================================");
            System.out.println("Repas numéro " + person);
            System.out.println("1: Commander à la carte");
            System.out.println("2: Commander un Menu / Formule");
            System.out.println("Votre choix :");
            
            int choice = Utils.InputChoice(input, 2);
            Order commande;
            if (choice == 0) {
                commande = Order.Orderfood(input, food);
            } else {
                commande = Order.orderMenu(input, menus);
            }

            String com = commande.toString();
            System.out.println("\nRésumé du repas numéro " + person + " :\n\n" + com + String.format("TOTAL : %.2f euros\n", commande.getTotalPrice()));
            file.write("************  Résumé de la commande N°" + person + " ********************\n\n" 
                       + com + String.format("TOTAL : %.2f euros\n\n", commande.getTotalPrice()));
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            throw new IllegalArgumentException("Pas d'arguments attendus");
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Combien serez-vous pour le repas ?");
        int[] persons = IntStream.range(1, Utils.InputInt(input) + 1).toArray();

        BufferedWriter file;
        try {
            file = new BufferedWriter(new FileWriter(new File("Order.txt")));
            commande(persons, file, input);
            file.close();
            input.close();
        } catch (IOException e) {
            System.out.println("Il y a un souci avec le fichier. Merci de basculer dans la version sans fichier.");
            System.err.println(e);
        }

        if (persons.length > 1) {
            System.out.println("Bon repas et bon appétit à tous les " + persons.length + " ! ^^");
        } else {
            System.out.println("Bon repas et bon appétit ! ^^");
        }
    }
}