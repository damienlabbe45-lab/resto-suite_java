public class Menu extends Food {
    protected Food[][] foods;

    public Menu(String name, Food[][] foods, Double price) {
        super(name, price);
        this.foods = foods;
    }

    public Food[][] getFoods() {
        return foods;
    }

    @Override
    public String toString() {
        String[] categories = {
            "Entrées : \n", 
            "Plats : \n", 
            "Accompagnements : \n", 
            "Boissons : \n", 
            "Desserts : \n"
        };
        int counter = 0;
        String message = "Formule " + getName() + " (Prix : " + String.format("%.2f", getPrice()) + " euros) :\n";
        while (foods != null && counter < foods.length) {
            if (foods[counter] != null && foods[counter].length > 0) {
                if (counter < categories.length) {
                    message += categories[counter];
                } else {
                    message += "Choix supplémentaires : \n";
                }
                for (Food food : foods[counter]) {
                    if (food != null) {
                        message += "  - " + food.getName() + "\n";
                    }
                }
                message += "\n";
            }
            counter++;
        }
        return message;
    }

    public static Menu[] initializeMenus(Food[][] allFoods) {
        Menu menuGourmand = new Menu("Gourmand", new Food[][] {
            { allFoods[0][0], allFoods[0][1] },
            { allFoods[1][0], allFoods[1][1] },
            { allFoods[2][0], allFoods[2][1] },
            { allFoods[3][0], allFoods[3][1] },
            { allFoods[4][0], allFoods[4][1] }
        }, 22.00);

        CrepeMenu menuCrepe = new CrepeMenu("Breton", new Food[][] {
            { 
                allFoods[1][11], // 1 GALETTE AVEC DES OEUFS, DES CHAMPIGNONS, DU JAMBON, DU BEURRE ET DU FROMAGE RÂPÉE
                new Food("Galette Complète (Œuf, Jambon, Fromage)", 2.50),
                new Food("Galette Saucisse", 2.50),
                new Food("Galette Chèvre Miel", 2.50),
                new Food("Crêpe Sucre", 2.50),
                new Food("Crêpe Beurre-Sucre", 2.50),
                new Food("Crêpe au Miel", 2.50),
                new Food("Crêpe au Sirop d'Érable", 2.50),
                new Food("Crêpe au Nutella", 2.50),
                new Food("Crêpe Nutella Banane", 2.50),
                new Food("Crêpe Caramel Beurre Salé", 2.50),
                new Food("Crêpe Confiture", 2.50),
                new Food("Crêpe Citron Sucre", 2.50)
            },
            { allFoods[3][2], allFoods[3][0], allFoods[3][8], allFoods[3][14] } // Bolée de cidre, carafe, Fuze Tea...
        });

        ChallengeMenu menuChallenge = new ChallengeMenu("Ogre", allFoods, 35.00);

        return new Menu[] { menuGourmand, menuCrepe, menuChallenge };
    }
}
