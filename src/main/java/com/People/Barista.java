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

    public boolean makeBeverage(Beverage beverage, View view){

        Date start = new Date();
        boolean isDoneSuccessfully = beverage.type == "Coffee" ? makeCoffee(view) :
        beverage.type == "Milkshake" ? makeMilkshake(view) : 
        beverage.type == "Smoothie" ? makeSmoothie(view) : 
        beverage.type == "Cold Coffee" ? makeColdCoffee(view) : makeLemonade(view);

        while(true){
            Date now = new Date();
            if(((now.getTime() - start.getTime()) > beverage.time * 1000 / this.efficiency * 1.5) || !isDoneSuccessfully) break;
        }

        return isDoneSuccessfully; 
    }

    private boolean addMilk(View view){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 3;
        if (!success) view.printMilkFail();
        return success;
    }

    private boolean boilWater(View view){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 3;
        if (!success) view.printWaterFail();
        return success;
    }

    private boolean mixCoffee(View view){
        boolean success = new Random().nextInt(1000) * this.efficiency / 2.5 > 9;
        if (!success) view.printMixFail();
        return success;
    }

    private boolean grindIce(View view){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 2;
        if (!success) view.printIceFail();
        return success;
    }

    private boolean squishLemon(View view){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 3;
        if (!success) view.printLemonFail();
        return success;
    }

    private boolean grindFruits(View view){
        boolean success = new Random().nextInt(100) * this.efficiency / 2.5 > 3;
        if (!success) view.printFruitFail();
        return success;
    }

    public boolean makeCoffee(View view){
        return addMilk(view) && boilWater(view) && mixCoffee(view);
    }

    public boolean makeColdCoffee(View view){
        return addMilk(view) && mixCoffee(view);
    }

    private boolean makeLemonade(View view){
        return grindIce(view) && squishLemon(view);
    }

    private boolean makeMilkshake(View view){
        return grindIce(view) && addMilk(view);
    }

    private boolean makeSmoothie(View view){
        return grindIce(view) && grindFruits(view) && addMilk(view);
    }
}