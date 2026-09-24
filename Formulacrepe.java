public class Formulacrepe extends  Formula{
    private int countercrepes;
    public Formulacrepe(String name, Food[][] foods) {
        super(name, foods, 0.00);
        countercrepes = 0;
    }

    @Override
    public String toString() {
        String message = "formule " + this.getName() + " : \n le repas n'est constutié que de crèpes et de galette ";
        message = message + "on peut manger : \n";
        for(Food food: this.foods[0]) message = message + food.toString() + "\n";
        return message + "le prix est de 2,50 euros par crêpes et galettes ainsi que les accompagnements dont vous avez vu le prix. ";
    }

    public Double getPrice(Food[] food) {
        return 2.50 * countercrepes + Food.priceCommande(food);
    }

    public void addcrepe(){
        this.countercrepes++; 
    }
    
}
