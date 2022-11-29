import java.util.Random;

class Main{
    public static void main(String[] args){
        Profit profit = new Profit();
        Tips tips = new Tips();
        Queue queue = new Queue();
        Menu menu = new Menu();
        Barista barista = new Barista();

        Random rand = new Random();
        boolean bool, isWrittenOnce = false;
        float chance = 16;

        menu.get();
        // System.out.print("\033[H\033[2J");

        while(true){

            queue.updateQueue(menu);

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
                if(chance >= new Random().nextInt(100)) tips.setAmount(rand.nextInt(9));
                System.out.println("Current tips are " + tips.getAmount() + " " + tips.getCurrency());
                chance = 16;
            }
        }
    }
}