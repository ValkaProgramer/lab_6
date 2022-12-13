class Menu{
    private Beverage[] beverages = new Beverage[8];
    public Menu(){
        this.beverages[0] = new Cappucino();
        this.beverages[1] = new Latte();
        this.beverages[2] = new Frappe();
        this.beverages[3] = new DoubleLatte();
        this.beverages[4] = new IcedLatte();
        this.beverages[5] = new Lemonade();
        this.beverages[6] = new Milkshake();
        this.beverages[7] = new Smoothie();
    }

    public Beverage getBeverage(int id){
        return this.beverages[id];
    }

    public void get(View view){
        for (Beverage beverage : beverages) {
            view.printMenu(beverage);
        }
    }
}