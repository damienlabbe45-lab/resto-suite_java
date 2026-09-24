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

    
}