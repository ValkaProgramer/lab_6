import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

class Simulation{
    public void simulate(){

        Date counter = new Date();
        Properties prop = new Properties();
        FileInputStream ip;
        try {
            ip = new FileInputStream("/home/gachifun/lab_6/src/main/resources/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int someVar = 7;

        Presenter presenter = new Presenter();

        Profit profit = new Profit(), yourMoney = new Profit(), baristaMoney = new Profit();
        Tips tips = new Tips();
        Queue queue = new Queue();
        Menu menu = new Menu();
        Barista barista = new Barista(Integer.parseInt(prop.getProperty("level")));

        Random rand = new Random();
        boolean bool, isWrittenOnce = false;
        float chance = 16;



        menu.get(presenter);

        while(someVar <= 24){

            queue.updateQueue(menu, Integer.parseInt(prop.getProperty("season")), Integer.parseInt(prop.getProperty("day")), presenter);

            if (!queue.isEmpty()) {
                isWrittenOnce = false;
            }

            if(queue.isEmpty() && !isWrittenOnce){
                presenter.printCustomerWaiting();
                isWrittenOnce = true;
            }

            if(!queue.isEmpty()){
                bool = barista.makeBeverage(queue.front().getBeverage(), presenter);
                queue.dequeue(profit, bool, chance, presenter);
                presenter.printCurrentProfit(profit);
                if(chance >= new Random().nextInt(100)) tips.addAmount(rand.nextInt(9));
                presenter.printCurrentTips(tips);
                chance = 16;
            }

            if((new Date().getTime() - counter.getTime()) > 60000){
                presenter.printMoneyDistribution(someVar++);
                yourMoney.addAmount(0.2 * profit.getAmount());
                presenter.printTodayMoney(yourMoney);
                baristaMoney.addAmount(profit.getAmount() * 0.5);
                presenter.printAverageSalary(baristaMoney, someVar);
                profit.setAmount(0);
                counter = new Date();
            }
        }
    }
}