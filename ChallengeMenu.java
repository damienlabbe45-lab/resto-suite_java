public class ChallengeMenu extends Menu {
    private boolean win;

    public ChallengeMenu(String name, Food[][] foods, Double price) {
        super(name, foods, price);
        this.win = false;
    }

    public void win() {
        this.win = true;
    }

    public boolean isWin() {
        return win;
    }

    @Override
    public String toString() {
        return super.toString() + "Si vous réussissez à tout manger complètement sans laisser une miette, le prix devient 23.00 euros. Tenterez-vous ce menu ?\n";
    }

    @Override 
    public Double getPrice() {
        return this.win ? 23.00 : super.getPrice();
    }
}
