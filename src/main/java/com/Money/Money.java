abstract class Money{

    protected String currency;
    protected double amount;

    public String getCurrency() {
        return currency;
    }

    public void setAmount(double quantity){
        this.amount = quantity;
    }

    public void addAmount(double quantity){
        this.amount += quantity;
    }

    public double getAmount() {
        return amount;
    }
}