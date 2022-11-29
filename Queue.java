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

    public void enqueue(Customer customer){
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
        System.out.println(customer.name + " ordered one " + customer.getBeverage().name);
    }

    public void dequeue(Profit profit, boolean bool, float chance){
        Customer done = front.info;
        if(bool){
            front = front.next;
            if(isEmpty()) rear = null;
            size--;
            System.out.println(done.getBeverage().name + " for " + done.name + " is ready!");
            profit.setAmount(done.getBeverage().price);
        } else if(new Random().nextBoolean()){
            System.out.println(done.name + " is ready to wait, but your chances on tips are small");
            chance *= 0.25;
            return;
        } else {
            System.out.println(done.name + " was so pissed of (s)he left, no need for another " + done.getBeverage().name);
            front = front.next;
            if(isEmpty()) rear = null;
            size--;
            chance = 0;
            return;
        }
    }
    
    public Customer front(){
        return !isEmpty() ? front.info : null;
    }

    public void updateQueue(Menu menu){
        spawnEnd = new Date().getTime() / 1000;

        if(cooldown.getInterval() < spawnEnd - spawnStart){
            cooldown.setInterval();
            spawnStart = spawnEnd;
            this.enqueue(new Customer(menu));
        }
    }
}