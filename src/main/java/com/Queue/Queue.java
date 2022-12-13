import java.util.Date;
import java.util.Random;

class Queue{
    private Cooldown cooldown = new Cooldown();

    private Node front, rear;
    private long spawnEnd, spawnStart;
    private int size;

    public Queue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
        this.spawnStart = new Date().getTime() / 1000;
    }

    public class Node{
        Customer info;
        Node next;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(Customer customer, View view){
        if(isEmpty()){
            rear = new Node();
            rear.info = customer;
            rear.next = null;
            front = rear;
        } else {
            rear.next = new Node();
            rear.next.info = customer;
            rear = rear.next;
        }
        size++;
        view.printOrder(customer);
    }

    public void dequeue(Profit profit, boolean bool, float chance, View view){
        Customer done = front.info;
        if(bool){
            front = front.next;
            if(isEmpty()) rear = null;
            size--;
            view.printBeverageDone(done);
            profit.addAmount(done.getBeverage().price);
        } else if(new Random().nextBoolean()){
            view.printSmallFail(done);
            chance *= 0.25;
            return;
        } else {
            view.printBigFail(done);
            front = front.next;
            if(isEmpty()) rear = null;
            size--;
            chance = 0;
            profit.addAmount(done.getBeverage().price * -0.7);
            return;
        }
    }
    
    public Customer front(){
        return !isEmpty() ? front.info : null;
    }

    public void updateQueue(Menu menu, int season, int day, View view){
        spawnEnd = new Date().getTime() / 1000;

        if(cooldown.getInterval() < spawnEnd - spawnStart){
            cooldown.setInterval(day);
            spawnStart = spawnEnd;
            this.enqueue(new Customer(menu, season), view);
        }
    }
}