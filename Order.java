import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private Food[] items;

    public Order(int capacity) {
        this.items = new Food[capacity];
    }

    public void setItem(int index, Food food) {
        if (index >= 0 && index < items.length) {
            this.items[index] = food;
        }
    }

    public Food[] getItems() {
        return items;
    }

    public Double getTotalPrice() {
        Double total = 0.0;
        for (Food item : items) {
            if (item != null) {
                total += item.getPrice();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Food item : items) {
            if (item != null) {
                sb.append(item.toString());
            }
        }
        return sb.toString();
    }

    public static Order Orderfood(Scanner input, Food[][] food) {
        Order order = new Order(5);
        System.out.println(Food.foodString(food[0], "choix Entrée: \n"));
        order.setItem(0, food[0][Utils.InputChoice(input, food[0].length)]);

        System.out.println(Food.foodString(food[1], "choix Plats: \n"));
        order.setItem(1, food[1][Utils.InputChoice(input, food[1].length)]);

        System.out.println(Food.foodString(food[2], "choix Accompagnements: \n"));
        order.setItem(2, food[2][Utils.InputChoice(input, food[2].length)]);

        System.out.println(Food.foodString(food[3], "choix Boissons: \n"));
        order.setItem(3, food[3][Utils.InputChoice(input, food[3].length)]);

        System.out.println(Food.foodString(food[4], "choix Desserts: \n"));
        order.setItem(4, food[4][Utils.InputChoice(input, food[4].length)]);

        return order;
    }

    public static Order orderMenu(Scanner input, Menu[] menus) {
        System.out.println("\n==========================================");
        System.out.println("--- DÉTAIL DES MENUS / FORMULES DISPONIBLES ---");
        System.out.println("==========================================\n");

        for (int i = 0; i < menus.length; i++) {
            System.out.println("--- [ Option " + (i + 1) + " : " + menus[i].getName() + " ] ---");
            System.out.println(menus[i].toString());
        }

        System.out.println("Entrez le numéro du menu souhaité (1-" + menus.length + ") :");
        int menuChoice = Utils.InputChoice(input, menus.length);
        Menu selectedMenu = menus[menuChoice];

        List<Food> selectedItems = new ArrayList<>();
        selectedItems.add(selectedMenu);

        if (selectedMenu instanceof CrepeMenu) {
            CrepeMenu crepeMenu = (CrepeMenu) selectedMenu;
            System.out.println("\nCombien de crêpes/galettes voulez-vous commander ?");
            int nbCrepes = Utils.InputInt(input);
            for (int i = 0; i < nbCrepes; i++) {
                System.out.println(Food.foodString(selectedMenu.getFoods()[0], "Choisissez la crêpe/galette N°" + (i + 1) + " : \n"));
                int c = Utils.InputChoice(input, selectedMenu.getFoods()[0].length);
                crepeMenu.addcrepe();
                selectedItems.add(new Food(" - Crêpe/Galette: " + selectedMenu.getFoods()[0][c].getName(), 0.00));
            }
            if (selectedMenu.getFoods().length > 1) {
                System.out.println(Food.foodString(selectedMenu.getFoods()[1], "Choisissez votre boisson : \n"));
                int b = Utils.InputChoice(input, selectedMenu.getFoods()[1].length);
                Food drink = selectedMenu.getFoods()[1][b];
                crepeMenu.addExtraFood(drink);
                selectedItems.add(new Food(" - Boisson: " + drink.getName(), 0.00));
            }
        } else {
            Food[][] mFoods = selectedMenu.getFoods();
            for (int i = 0; i < mFoods.length; i++) {
                if (mFoods[i] != null && mFoods[i].length > 0) {
                    System.out.println(Food.foodString(mFoods[i], "Choix de l'élément (" + (i + 1) + ") : \n"));
                    int choice = Utils.InputChoice(input, mFoods[i].length);
                    selectedItems.add(new Food(" - Choix " + (i + 1) + ": " + mFoods[i][choice].getName(), 0.00));
                }
            }

            if (selectedMenu instanceof ChallengeMenu) {
                ChallengeMenu cm = (ChallengeMenu) selectedMenu;
                System.out.println("\n[ Le serveur vient inspecter votre assiette à la fin du repas... ]");
                
                // Tirage au sort cryptographiquement sécurisé avec probabilité 1 / 20 000
                SecureRandom random = new SecureRandom();
                boolean success = (random.nextInt(20_000) == 0);

                if (success) {
                    cm.win();
                    System.out.println("-> LÉGENDAIRE ! Vous avez tout englouti sans laisser une seule miette ! Le tarif passe à 23.00€ !");
                } else {
                    System.out.println("-> Sans surprise, il reste des aliments... Le challenge a échoué. Tarif plein appliqué.");
                }
            }
        }

        Order order = new Order(selectedItems.size());
        for (int i = 0; i < selectedItems.size(); i++) {
            order.setItem(i, selectedItems.get(i));
        }
        return order;
    }
}