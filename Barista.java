import java.util.Date;
import java.util.Random;

public class Barista extends Person{

    public Barista(){
        setName();
    }

    protected void setName(){
        this.name = new Random().nextInt(7) <= 2 ? "Bob" : "John";
    }

    public void finishOrder(Queue queue){

    }

    public boolean makeBeverage(Beverage beverage){

        Date start = new Date();
        boolean isDoneSuccessfully = beverage.type == "Coffee" ? makeCoffee() :
        beverage.type == "Milkshake" ? makeMilkshake() : 
        beverage.type == "Smoothie" ? makeSmoothie() : 
        beverage.type == "Cold Coffee" ? makeColdCoffee() : makeLemonade();

        while(true){
            Date now = new Date();
            if(((now.getTime() - start.getTime()) > beverage.time * 1000) || !isDoneSuccessfully) break;
        }

        return isDoneSuccessfully; 
    }

    private boolean addMilk(){
        boolean success = new Random().nextInt(100) > 3;
        if (!success) System.out.println("Oh no, you spilled the milk");
        return success;
    }

    private boolean boilWater(){
        boolean success = new Random().nextInt(100) > 3;
        if (!success) System.out.println("Oh no, you spilled the water");
        return success;
    }

    private boolean mixCoffee(){
        boolean success = new Random().nextInt(1000) > 9;
        if (!success) System.out.println("Oh no, you didn't respect proportions");
        return success;
    }

    private boolean grindIce(){
        boolean success = new Random().nextInt(100) > 2;
        if (!success) System.out.println("Oh no, ice melted away");
        return success;
    }

    private boolean squishLemon(){
        boolean success = new Random().nextInt(100) > 3;
        if (!success) System.out.println("Oh no, you picked rotten lemon");
        return success;
    }

    private boolean grindFruits(){
        boolean success = new Random().nextInt(100) > 3;
        if (!success) System.out.println("Oh no, you picked some rotten fruits");
        return success;
    }

    public boolean makeCoffee(){
        return addMilk() && boilWater() && mixCoffee();
    }

    public boolean makeColdCoffee(){
        return addMilk() && mixCoffee();
    }

    private boolean makeLemonade(){
        return grindIce() && squishLemon();
    }

    private boolean makeMilkshake(){
        return grindIce() && addMilk();
    }

    private boolean makeSmoothie(){
        return grindIce() && grindFruits() && addMilk();
    }
}