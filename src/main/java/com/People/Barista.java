import java.util.Date;
import java.util.Random;

public class Barista extends Person{

    private float efficiency;

    public Barista(float efficiency){
        setName();
        this.efficiency = efficiency;
    }

    protected void setName(){
        this.name = new Random().nextInt(7) <= 2 ? "Bob" : "John";
    }

    public void finishOrder(Queue queue){

    }

    public boolean makeBeverage(Beverage beverage, Presenter presenter){

        Date start = new Date();
        boolean isDoneSuccessfully = beverage.type == "Coffee" ? makeCoffee(presenter) :
        beverage.type == "Milkshake" ? makeMilkshake(presenter) : 
        beverage.type == "Smoothie" ? makeSmoothie(presenter) : 
        beverage.type == "Cold Coffee" ? makeColdCoffee(presenter) : makeLemonade(presenter);

        while(true){
            Date now = new Date();
            if(((now.getTime() - start.getTime()) > beverage.time * 1000 / this.efficiency * 1.5) || !isDoneSuccessfully) break;
        }

        return isDoneSuccessfully; 
    }

    private boolean addMilk(Presenter presenter){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 3;
        if (!success) presenter.printMilkFail();
        return success;
    }

    private boolean boilWater(Presenter presenter){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 3;
        if (!success) presenter.printWaterFail();
        return success;
    }

    private boolean mixCoffee(Presenter presenter){
        boolean success = new Random().nextInt(1000) * this.efficiency / 2.5 > 9;
        if (!success) presenter.printMixFail();
        return success;
    }

    private boolean grindIce(Presenter presenter){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 2;
        if (!success) presenter.printIceFail();
        return success;
    }

    private boolean squishLemon(Presenter presenter){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 3;
        if (!success) presenter.printLemonFail();
        return success;
    }

    private boolean grindFruits(Presenter presenter){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 3;
        if (!success) presenter.printFruitFail();
        return success;
    }

    public boolean makeCoffee(Presenter presenter){
        return addMilk(presenter) && boilWater(presenter) && mixCoffee(presenter);
    }

    public boolean makeColdCoffee(Presenter presenter){
        return addMilk(presenter) && mixCoffee(presenter);
    }

    private boolean makeLemonade(Presenter presenter){
        return grindIce(presenter) && squishLemon(presenter);
    }

    private boolean makeMilkshake(Presenter presenter){
        return grindIce(presenter) && addMilk(presenter);
    }

    private boolean makeSmoothie(Presenter presenter){
        return grindIce(presenter) && grindFruits(presenter) && addMilk(presenter);
    }
}