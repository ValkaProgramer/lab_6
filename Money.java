abstract class Money{

    protected String currency;
    protected int amount;

    public String getCurrency() {
        return currency;
    }

    public void setAmount(int quantity){
        this.amount += quantity;
    }

    public int getAmount() {
        return amount;
    }
}