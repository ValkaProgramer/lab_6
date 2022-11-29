import java.util.Date;
import java.util.Random;

class Main{
    public static void main(String[] args){

        Date counter = new Date();

        int day = 1, season = 1, level = 5,
        someVar = 7;

        Profit profit = new Profit(), yourMoney = new Profit(), baristaMoney = new Profit();
        Tips tips = new Tips();
        Queue queue = new Queue();
        Menu menu = new Menu();
        Barista barista = new Barista(level);

        Random rand = new Random();
        boolean bool, isWrittenOnce = false;
        float chance = 16;



        menu.get();
        // System.out.print("\033[H\033[2J");

        while(someVar <= 24){

            queue.updateQueue(menu, season, day);

            if (!queue.isEmpty()) {
                isWrittenOnce = false;
            }

            if(queue.isEmpty() && !isWrittenOnce){
                System.out.println("--------------------------------------------------------\n" + 
                "Waiting for customers...\n" + "--------------------------------------------------------");
                isWrittenOnce = true;
            }

            if(!queue.isEmpty()){
                bool = barista.makeBeverage(queue.front().getBeverage());
                queue.dequeue(profit, bool, chance);
                System.out.println("Current profit is " + profit.getAmount() + " " + profit.getCurrency());
                if(chance >= new Random().nextInt(100)) tips.addAmount(rand.nextInt(9));
                System.out.println("Current tips are " + tips.getAmount() + " " + tips.getCurrency());
                chance = 16;
            }

            if((new Date().getTime() - counter.getTime()) > 60000){
                System.out.println("It's " + someVar++ + ":00 :\n"  +  
                "Profit was splitted: 20% to you, 50% to Barista, 30% to materials");
                yourMoney.addAmount(0.2 * profit.getAmount());
                System.out.println("Your money for today are : " + yourMoney.getAmount());
                baristaMoney.addAmount(profit.getAmount() * 0.5);
                System.out.println("You paid Barista " + baristaMoney.getAmount() * (someVar++ - 7) + " average");
                profit.setAmount(0);
                counter = new Date();
            }
        }
    }
}