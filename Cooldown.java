import java.util.Random;

class Cooldown{

    private int interval;

    public Cooldown(){
        this.interval = 0;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval() {
        interval = new Random().nextInt(6) + 5;
    }
    
}