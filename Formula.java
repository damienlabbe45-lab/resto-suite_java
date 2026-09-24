

public class Formula extends Food{
    private String name;
    private Food[][] foods;
    private Double price ;
    public Formula(String name,Food[][] foods, Double price) {
        this.foods = foods;
        this.price = price;
        this.name = name;
    }
    @Override
    public String toString() {
        int counter = 0;
        String message = "Formule " + name + " à " + price + "euros : ";
         while(foods.length > counter){
            String variable = "";
            if(counter == 0) variable = "Entrée: \n";
            else{if(counter == 1) variable = "Plats: \n";
                else{ if(counter == 2)variable = "Accompagnements:";
                    else {if(counter == 3) variable = "Boissons: \n";
                        else if(counter == 4){variable = "Desserts: \n";}
                    }
                }
            }
            message = message + variable;
            for(Food food: foods[counter]) message = message + food.getName() + "\n\n";
            counter++;
         }
        
        return message ;
    }
    
}
