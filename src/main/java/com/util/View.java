public class View {
    public void printCustomerWaiting(){
        System.out.println("--------------------------------------------------------\n" + 
        "Waiting for customers...\n" + "--------------------------------------------------------");
    }
    public void printCurrentProfit(Profit profit){
        System.out.println("Current profit is " + profit.getAmount() + " " + profit.getCurrency());
    }
    public void printCurrentTips(Tips tips){
        System.out.println("Current tips are " + tips.getAmount() + " " + tips.getCurrency());
    }
    public void printMoneyDistribution(int someVar){
        System.out.println("It's " + someVar++ + ":00 :\n"  +  
        "Profit was splitted: 20% to you, 50% to Barista, 30% to materials");
    }
    public void printTodayMoney(Money yourMoney){
        System.out.println("Your money for today are : " + yourMoney.getAmount());
    }
    public void printAverageSalary(Profit baristaMoney, int someVar){
        System.out.println("You paid Barista " + baristaMoney.getAmount() / (someVar++ - 7) + " average");
    }
    public void printBeverageDone(Customer done){
        System.out.println(done.getBeverage().name + " for " + done.name + " is ready!");
    }
    public void printSmallFail(Customer done){
        System.out.println(done.name + " is ready to wait, but your chances on tips are small");
    }
    public void printBigFail(Customer done){
        System.out.println(done.name + " was so pissed of (s)he left, no need for another " + done.getBeverage().name);
    }
    public void printOrder(Customer customer){
        System.out.println(customer.name + " ordered one " + customer.getBeverage().name);
    }
    public void printMenu(Beverage beverage){
        System.out.println(beverage.name);
        System.out.println(beverage.amount + "gr");
        System.out.println(beverage.price + " MDL");
        System.out.println("---------------------------------------");
    }
    public void printMilkFail(){
        System.out.println("Oh no, you spilled the milk");
    }
    public void printWaterFail(){
        System.out.println("Oh no, you spilled the water");
    }
    public void printMixFail(){
        System.out.println("Oh no, you didn't respect proportions");
    }
    public void printIceFail(){
        System.out.println("Oh no, ice melted away");
    }
    public void printLemonFail(){
        System.out.println("Oh no, you picked rotten lemon");
    }
    public void printFruitFail(){
        System.out.println("Oh no, you picked some rotten fruits");
    }
    public void print(){
        System.out.println();
    }
}
