import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException; // Indispensable pour la gestion d'erreurs en Java 8
import java.util.Scanner; 
import java.util.stream.IntStream;

public class Resto {
	public static void commande(int[] persons, BufferedWriter file , Scanner input) throws IOException{
		Food [] commande = new Food [5];
		Food[][] food = {{new Food("SALADE", 3.56), 
		new Food("SOUPE", 2.01),
		new Food("QUICHE", 7.89),
		new Food("MELON", 4.56),
		new Food("TOAST DE MOUSSE DE CANARD", 9.08), 
		new Food("RADIS", 6.76), 
		new Food("OLIVES", 5.43),
		new Food("TOMATES", 3.78),
		new Food("AUCUNE", 0.00),
		new Food("SAUCISSON", 9.00),
		new Food("SAUMON", 7.01)},
	{new Food("POULET", 3.67),
	new Food("VEAU", 11.98),
	new Food("BOEUF", 20.65),
	new Food("MOUTON", 14.89),
	new Food("CANARD", 5.56),
	new Food("AGNEAU", 3.99),
	new Food("OEUFS", 4.43),
	new Food("TOFU", 38.90),
	new Food("AUCUN", 0.00),
	new Food("JAMBON", 13.45),
	new Food("GALETTES AVEC DES OEUFS, DES CHAMPIGNONS, DU JAMBON, DU BEURRE ET DU FROMAGE RÂPÉE", 5.01)
	},
	{
		new Food("FRITES", 2.12),
		new Food("RIZ",1.34),
		new Food("PATES", 1.01),
		new Food("CAROTTES", 2.08),
		new Food("ORANGES BLEUES", 2.01),
		new Food("POMME DE TERRE DAUPHINE", 1.98),
		new Food("SALADE", 2.09),
		new Food("HARICOTS VERTS", 1.55),
		new Food("FLAGEOLETS",1.45),
		new Food("AUCUN",0.00),
		new Food("SALADE DE FRUITS COMPOSÉE DE MANGUES, BANANES, NOIX, RAISINS SECS, NECTARINES, FRAISES, FRAMBOISES, CERISES, KIWIS ET MANDARINES",5.09)
	}, 
	{
		new Food("EAU", 0.00),
		new Food("AUCUN",0.00),
		new Food("CIDRE", 10.09),
		new Food("JUS D'ORANGE", 5.09),
		new Food("WHISKY", 45.89),
		new Food("VIN JAUNE", 24.81),
		new Food("VIN ROUGE", 25.80),
		new Food("VIN BLANC", 25.59),
		new Food("FUZE TEA", 6.78),
		new Food("JUS DE RAISIN", 5.90),
		new Food("SIROP à L'EAU", 3.89)
	},
	{
		new Food("TARTE AUX POMMES", 8.34),
		new Food("FONDANT AU CHOCOLAT", 7.98),
		new Food("GATEAU AU YAOURT", 4.89),
		new Food("CRÊPE AU SIROP D'ÉRABLE", 3.89),
		new Food("MONT D'OR", 7.55),
		new Food("ANANAS", 4.67),
		new Food("MOUSSE AU CHOCOLAT", 3.67),
		new Food("POMMES", 2.97),
		new Food("COMPOTE DE POIRE", 3.12),
		new Food("20 COOKIES DE 34 CM", 5.01),
		new Food("AUCUN", 0.00)
	}};
	
		for(int person:persons) {
			System.out.println("repas numero " + person);
			System.out.println(Food.foodString(food[0], "choix Entrée: \n"));
			commande[0] = food[0][InputChoice(input)];

			System.out.println(Food.foodString(food[1], "choix Plats: \n"));
			commande[1] = food[1] [InputChoice(input)];

			System.out.println(Food.foodString(food[2], "choix Accompagnements: \n"));
			commande[2] = food[2] [InputChoice(input)];

			System.out.println(Food.foodString(food[3], "choix Boissons: \n"));
			commande[3] = food[3] [InputChoice(input)];

			System.out.println(Food.foodString(food[4], "choix Desserts: \n"));
			commande[4] = food[4] [InputChoice(input)];

			String com =commande[0].toString() + commande[1].toString() + commande[2].toString() + commande[3].toString() + commande[4].toString();
			System.out.println("Résumé du repas numéro " + person + ":\n\n" + com);
			file.write("************  Résumé de la commande N°" + person + "********************\n\n" +com);
	
		}
	}
	public static int InputInt(Scanner input) {
		while(!input.hasNextInt()) input.next();
		return input.nextInt();
	}
	public static int InputChoice(Scanner input) {
		int choiceuser = InputInt(input);
		while(choiceuser < 1 || choiceuser > 11) choiceuser = InputInt(input);
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
		
		
		System.out.println("Bon repas et bon appétit tout les " + persons.length + ".  ^^");
	}

}