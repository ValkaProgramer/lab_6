import java.util.Random;

class Cooldown{

    private double interval;

    public Cooldown(){
        this.interval = 0;
    }

    public double getInterval() {
        return interval;
    }

    public void setInterval(int day) {
        this.interval = (new Random().nextInt(6) + 5) * day == 1 || day == 6 || day == 7 ? 0.5 :
        day == 2 || day == 3 ? 0.8 : 1;
    }
    
}