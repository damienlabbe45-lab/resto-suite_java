

public class Menu extends Food{
    private String name;
    protected Food[][] foods;
    protected Double price ;
    public Menu(String name,Food[][] foods, Double price) {
        this.foods = foods;
        this.price = price;
        this.name = name;
    }
    @Override
    public String toString() {
        String[] categories = {
            "Entrée: \n", 
            "Plats: \n", 
            "Accompagnements: \n", 
            "Boissons: \n", 
            "Desserts: \n"
        };
        int counter = 0;
        String message = "Formule " + name + " à " + price + "e uros : ";
         while(foods.length > counter){
            String variable = categories[counter];
            message = message + variable;
            for(Food food: foods[counter]) message = message + food.getName() + "\n\n";
            counter++;
         }
        
        return message ;
    }
    
}
