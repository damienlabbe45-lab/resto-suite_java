import java.util.ArrayList;
import java.util.List;

public class CrepeMenu extends Menu {
    private int countercrepes;
    private List<Food> extraFoods;

    public CrepeMenu(String name, Food[][] foods) {
        super(name, foods, 0.00);
        this.countercrepes = 0;
        this.extraFoods = new ArrayList<>();
    }

    @Override
    public String toString() {
        String message = "Formule " + this.getName() + " : \nLe repas n'est constitué que de crêpes et de galettes.\n";
        message += "On peut manger : \n";
        if (this.foods != null && this.foods.length > 0 && this.foods[0] != null) {
            for (Food food : this.foods[0]) {
                if (food != null) {
                    message += "- " + food.getName() + "\n";
                }
            }
        }
        return message + "Le prix est de 2,50 euros par crêpe/galette ainsi que les accompagnements dont vous avez vu le prix.\n";
    }

    public void addcrepe() {
        this.countercrepes++; 
    }

    public void addExtraFood(Food food) {
        if (food != null) {
            this.extraFoods.add(food);
        }
    }

    @Override
    public Double getPrice() {
        Double extraTotal = 0.00;
        for (Food f : extraFoods) {
            extraTotal += f.getPrice();
        }
        return 2.50 * countercrepes + extraTotal;
    }

    public Double getPrice(Food[] food) {
        return 2.50 * countercrepes + Food.priceCommande(food);
    }
}
