import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException; // Indispensable pour la gestion d'erreurs en Java 8
import java.util.Scanner; 
import java.util.stream.IntStream;

public class Resto {
	public static void commande(int[] persons, BufferedWriter file , Scanner input) throws IOException{
		String [] commande = new String [5];
		String [] entree = {"SALADE","SOUPE","QUICHE","MELON","TOAST DE MOUSSE DE CANARD", "RADIS","OLIVES","TOMATES","AUCUNE","SAUCISSON","SAUMON"};
		String [] plats = {"POULET","VEAU","BOEUF","MOUTON","CANARD","AGNEAU","OEUFS","TOFU","AUCUN","JAMBON","GALETTES AVEC DES OEUFS, DES CHAMPIGNONS, DU JAMBON, DU BEURRE ET DU FROMAGE RÂPÉE"};
		String [] accompagnements = {"FRITES","RIZ","PATES","CAROTTES","ORANGES BLEUES","POMME DE TERRE DAUPHINE","SALADE","HARICOTS VERTS","FLAGEOLETS","AUCUN","SALADE DE FRUITS COMPOSÉE DE MANGUES, BANANES, NOIX, RAISINS SECS, NECTARINES, FRAISES, FRAMBOISES, CERISES, KIWIS ET MANDARINES"};
		String [] boissons = {"EAU","AUCUN","CIDRE","JUS D'ORANGE","WHISKY","VIN JAUNE","VIN ROUGE","VIN BLANC","FUZE TEA","JUS DE RAISIN","SIROP à L'EAU"};
		String [] desserts = {"TARTE AUX POMMES","FONDANT AU CHOCOLAT","GATEAU AU YAOURT","CRÊPE AU SIROP D'ÉRABLE","MONT D'OR","ANANAS","MOUSSE AU CHOCOLAT","POMMES","COMPOTE DE POIRE","20 COOKIES DE 34 CM","AUCUN"};
		for(int person:persons) {
			System.out.println("repas numero " + person);
			System.out.println("choix Entrée: \n [1 - SALADE] [2 - SOUPE] [3 - QUICHE] [4 - MELON] [5 - TOAST DE MOUSSE DE CANARD] [6 - RADIS] [7 - OLIVES] [8 - TOMATES] [9 - AUCUNE] [10 - SAUCISSON] [11 - SAUMON]\n vous prendrez quoi comme entrée? [SAISSISEZ LE NOMBRE CORRESPONDANT]");
			commande[0] = entree[InputChoice(input)];
			System.out.println("choix Plats: \n [1 - POULET] [2 - VEAU] [3 - BOEUF] [4 - MOUTON] [5 - CANARD] [6 - AGNEAU] [7 - OEUFS] [8 - TOFU] [9 - AUCUN] [10 - JAMBON] [11 - GALETTES AVEC DES OEUFS, DES CHAMPIGNONS, DU JAMBON, DU BEURRE ET DU FROMAGE RÂPÉE \n vous prendrez quoi comme plats? [SAISSISEZ LE NOMBRE CORRESPONDANT]");
			commande[1] = plats[InputChoice(input)];
			System.out.println("choix accompagnements: \n [1 - FRITES] [2 - RIZ] [3 - PATES] [4 - CAROTTES] [5 - ORANGES BLEUES] [6 - POMMES DE TERRE DAUPHINE] [7 - SALADE] [8 - HARICOTS VERTS] [9 - FLAGEOLETS] [10 - AUCUN] [11 - SALADE DE FRUITS COMPOSÉE DE MANGUES, BANANES, NOIX, RAISINS SECS, NECTARINES, FRAISES, FRAMBOISES, CERISES, KIWIS ET MANDARINES] \n vous prendrez quoi pour accompagner vos plats? [SAISSISEZ LE NOMBRE CORRESPONDANT]");
			commande[2] = accompagnements[InputChoice(input)];
			System.out.println("choix boissons: \n [1 - EAU] [2 - AUCUN] [3 - CIDRE] [4 - JUS D'ORANGE] [5 - WHISKY] [6 - VIN JAUNE] [7 - VIN ROUGE] [8 - VIN BLANC] [9 - FUZE TEA] [10 - JUS DE RAISIN] [11 - SIROP À L'EAU] \n vous prendrez quoi comme boissons? [SAISSISEZ LE NOMBRE CORRESPONDANT]");
			commande[3] = boissons[InputChoice(input)];
			System.out.println("choix desserts: \n [1 - TARTE AUX POMMES] [2 - FONDANT AU CHOCOLAT] [3 - GATEAU AU YAOURT] [4 - CRÊPE AU SIROP D'ÉRABLE] [5 - MONT D'OR] [6 - ANANAS] [7 - MOUSSE AU CHOCOLAT] [8 - POMMES] [9 - COMPOTE DE POIRE] [10 - 20 COOKIES DE 34 CM] [11 - AUCUN] \n vous prendrez quoi comme desserts? [SAISSISEZ LE NOMBRE CORRESPONDANT]");
			commande[4] = desserts[InputChoice(input)];
			String com =commande[0] + "\n\n" + commande[1] + "\n\n" + commande[2] + "\n\n" + commande[3] + "\n\n" + commande[4];
			System.out.println("Résumé du repas numéro " + person + ":\n\n" + com + "\n\n");
			file.write("************  Résumé de la commande N°" + person + "********************\n\n" +com + "\n\n");
	
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