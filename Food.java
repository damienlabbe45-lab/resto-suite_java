public class Food{
    private String name;
    private Double price;

    public Food(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "   " + price + "euros \n\n";
    }

    
    
}