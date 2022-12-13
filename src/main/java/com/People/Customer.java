import java.util.Random;

public class Customer extends Person {
    
    private Beverage beverage;

    public Customer(Menu menu, int season){
        setName();
        setBeverage(menu, season);
    }

    protected void setName(){
        switch (new Random().nextInt(21)) {
            case 0: this.name = "Jayce";
                break;
            case 1: this.name = "Alice";
                break;
            case 2: this.name = "Victor";
                break;
            case 3: this.name = "Kevin";
                break;
            case 4: this.name = "Mary";
                break;
            case 5: this.name = "Selena";
                break;
            case 6: this.name = "Samuel";
                break;
            case 7: this.name = "Ryan";
                break;
            case 8: this.name = "Jake";
                break;
            case 9: this.name = "Scarlet";
                break;
            case 10: this.name = "Jotaro";
                break;
            case 11: this.name = "Marvelin";
                break;
            case 12: this.name = "Diona";
                break;
            case 13: this.name = "Tartaglia";
                break;
            case 14: this.name = "Dante";
                break;
            case 15: this.name = "Desmond";
                break;
            case 16: this.name = "Miles";
                break;
            case 17: this.name = "Mileena";
                break;
            case 18: this.name = "Samwell";
                break;
            case 19: this.name = "Tommy";
                break;
            case 20: this.name = "Gamora";
                break;
            default:
                break;
        }
    }

    private void setBeverage(Menu menu, int season){
        this.beverage = menu.getBeverage(new Random().nextInt(season == 1 ? 4 : 8));
    }

    public Beverage getBeverage(){
        return this.beverage;
    }

}
