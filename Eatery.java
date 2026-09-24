import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException; // Indispensable pour la gestion d'erreurs en Java 8
import java.util.Scanner; 
import java.util.stream.IntStream;

public class Eatery {
	public static void commande(int[] persons, BufferedWriter file , Scanner input) throws IOException{
		Food [] commande = new Food [5];
		Food[][] food = Food.initialize();
	
		for(int person:persons) {
			System.out.println("repas numero " + person);
			System.out.println(Food.foodString(food[0], "choix Entrée: \n"));
			commande[0] = food[0][InputChoice(input, food[0].length)];

			System.out.println(Food.foodString(food[1], "choix Plats: \n"));
			commande[1] = food[1] [InputChoice(input, food[1].length)];

			System.out.println(Food.foodString(food[2], "choix Accompagnements: \n"));
			commande[2] = food[2] [InputChoice(input, food[2].length)];

			System.out.println(Food.foodString(food[3], "choix Boissons: \n"));
			commande[3] = food[3] [InputChoice(input, food[3].length)];

			System.out.println(Food.foodString(food[4], "choix Desserts: \n"));
			commande[4] = food[4] [InputChoice(input, food[4].length)];

			String com =commande[0].toString() + commande[1].toString() + commande[2].toString() + commande[3].toString() + commande[4].toString();
			System.out.println("Résumé du repas numéro " + person + ":\n\n" + com +  String.format("%.2f euros", Food.priceCommande(commande)));
			file.write("************  Résumé de la commande N°" + person + "********************\n\n" + com +  String.format("%.2f euros", Food.priceCommande(commande)));
	
		}
	}
	public static int InputInt(Scanner input) {
		while(!input.hasNextInt()) input.next();
		return input.nextInt();
	}
	public static int InputChoice(Scanner input, int max) {
		int choiceuser = InputInt(input);
		while(choiceuser < 1 || choiceuser > max) choiceuser = InputInt(input);
		return choiceuser -1;
	}

	public static void main(String[] args) {
		if( args.length > 0) throw new IllegalArgumentException(" pas d'arguments");
		Scanner input = new Scanner(System.in);
		System.out.println("Combien serez vous pour le repas");
		int[] persons = IntStream.range(1, InputInt(input) + 1).toArray();
		

		BufferedWriter file ;
		try{
			file = new BufferedWriter( new FileWriter(new File( "Order.txt")));
			commande(persons, file, input);
			file.close();
			input.close();
			}
			catch(IOException e){
				System.out.println("il y a un soucis avec le fichier. merci de basculer dans la version sans fichier");
				System.err.println(e);
			}
		
		if(persons.length > 1)System.out.println("Bon repas et bon appétit tout les " + persons.length + ".  ^^");
		else System.out.println("Bon repas et bon appétit.  ^^");
	}

}