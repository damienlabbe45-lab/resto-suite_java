public class FormulaDefy extends Formula{
    boolean win;

    public FormulaDefy(String name, Food[][] foods, Double price) {
        super(name, foods, price);
        win = false;
    }

    public void win(){
        win = true;
    }
    @Override
    public String toString() {
         
        return super.toString() + "si vous réussisez à tout manger complètement sans laisser une miette, le prix devient 23 euros. Tenterez vous ce menu?";
    }

    @Override 
    public Double getPrice(){
        return  this.win ? 23.00 : this.price;
    }

    
    
}
