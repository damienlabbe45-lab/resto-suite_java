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
        return name + "   " + price + "euros \n\n";
    }

    public static String foodString(Food[] foods, String message){
        int i =1;
        for(Food food:foods){
            message = message + i + ": " + food.name + " " + food.price + " euros ";
        i++;
        }
        return message;
        
    }

    
    
}