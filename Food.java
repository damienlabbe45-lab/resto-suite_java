public class Food{
    private String name;
    private Double price;

    public Food(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    

    public Food() {
    }



    @Override
    public String toString() {
        return name + "   " + price + " euros \n\n";
    }

    public static String foodString(Food[] foods, String message){
        int i =1;
        for(Food food:foods){
            message = message + i + ": " + food.name + " " + food.price + " euros \n";
        i++;
        }
        return message;
        
    }

    public static Double priceCommande(Food[] foods){
        Double pricetotal = 0.00;
        for(Food food:foods) pricetotal = pricetotal + food.price;
        return pricetotal;
    }

    public static Food[] [] initialize(){
        return new Food[] []{{new Food("SALADE SERVIE AVEC DU CHÈVRE", 3.56) ,  
        new Food("SOUPE AU POISSON À LA TOMATE, À LA MENTHE ET À LA CAROTTE", 9.01),
		new Food("MINI QUICHE LORRAINE", 7.89),
		new Food("MELON COMPLET", 4.56), new Food("6 TOAST DE MOUSSE DE CANARD", 9.08), 
		new Food("23 RADIS avec du beurre", 6.76), 
		new Food("23 OLIVES", 5.43), new Food("9 TOMATES", 3.78),
		new Food("AUCUNE", 0.00), new Food("SAUCISSON PURE PORC ", 9.00),
		new Food("CAVIARD", 19.89), new Food("CAROTTES RÂPÉES", 4.12),
		new Food("6 CORNICHONS", 4.67)
	},
	{new Food("POULET RÔTI", 12.67), new Food("BLANQUETTE DE VEAU", 12.98),
	new Food("FAUX FILET DE BOEUF", 34.65), new Food("MOUTON AU MIEL ET AUX ÉPICES", 15.89),
	new Food("MAGRET DE CANARD", 19.56), new Food("CÖTES D'AGNEAU RÔTI", 14.99),
	new Food("OMELETTE FAÇON PAYSANNE AUX CHAMPIGNONS, À LA CRÈME FRAÎCHE, AU SUCRE ET AU BEURRE", 8.43),
	new Food("5 KG DE TOFU", 38.90), new Food("AUCUN", 0.00),
	new Food("4 TRANCHES DE JAMBON", 14.45),new Food("ENTRECÔTE DE BOEUF", 30.34),
	new Food("1 GALETTE AVEC DES OEUFS, DES CHAMPIGNONS, DU JAMBON, DU BEURRE ET DU FROMAGE RÂPÉE", 6.01),
	new Food("4 SAUCISSES DE TOULOUSE GRILLÉES", 15.23)
	},
	{
		new Food("FRITES", 3.12), new Food("RIZ",1.34), new Food("PATES", 1.01),
		new Food("CONCOMBRE", 1.89), new Food("CAROTTES", 2.08), new Food("POMME DE TERRE DAUPHINE", 1.98),
		new Food("SALADE", 2.09), new Food("HARICOTS VERTS", 1.55), new Food("FLAGEOLETS",1.45),
		new Food("AUCUN",0.00), new Food("RATATOUILLE", 7.12), new Food("PARMESAN RÂPÉ", 1.89)
	}, 
	{
		new Food("CARAFE D'EAU", 0.00), new Food("AUCUN",0.00), new Food("BOLÉE DE CIDRE", 10.09),
		new Food("VERRE DE JUS D'ORANGE", 5.09), new Food("VERRE DE WHISKY", 30.89),
		new Food("VERRE DE VIN JAUNE", 23.81), new Food("VERRE DE VIN ROUGE", 24.80),
		new Food("VERRE DE VIN BLANC", 24.59), new Food("BOUTEILLE DE FUZE TEA", 6.78),
		new Food("VERRE DE JUS DE RAISIN", 5.90), new Food("SIROP à L'EAU", 3.89),
		new Food("CALVADOS", 27.67), new Food("BOUTEILLE DE COCA COLA", 10.34), new Food("CAFÉ", 1.78), 
		new Food("VERRE DE FUZE TEA", 1.34), new Food("VERRE DE COCA COLA", 2.34)
	},
	{
		new Food("TARTE AUX POMMES", 8.34), new Food("FONDANT AU CHOCOLAT", 7.98),
		new Food("GATEAU AU YAOURT", 4.89), new Food("CRÊPE AU SIROP D'ÉRABLE", 3.89),
		new Food("MONT D'OR", 7.55), new Food("ANANAS", 4.67),
		new Food("MOUSSE AU CHOCOLAT", 3.67),
		new Food("3 POMMES", 2.97), new Food("COMPOTE DE POIRE", 3.12),
		new Food("20 COOKIES DE 34 CM", 35.01), new Food("ORANGES BLEUES", 2.01),
		new Food("AUCUN", 0.00), new Food("8 MINIS VINOISSERIES", 5.56),
		new Food("SALADE DE FRUITS COMPOSÉE DE MANGUES, BANANES, NOIX, RAISINS SECS, NECTARINES, FRAISES, FRAMBOISES, CERISES, KIWIS ET MANDARINES",5.09),
		new Food("KOUIGN-AMANN (GÂTEAU COMPLET)", 19.98), new Food("TARTE AU SUCRE (GATEAU COMPLET)", 10.98),
		new Food("GRANDE ASSIETTE DE FROMAGE", 10.09)
		
	}};
    }

    
}