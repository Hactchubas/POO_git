class CashPayment implements Payment {
    private double amountPaid;

    @Override
    public void processPayment(double amount) {
        this.amountPaid = amount;
        System.out.println("Processing cash payment of $" + amount);
    }

    @Override
    public String getPaymentDetails() {
        return "Cash payment of $" + amountPaid;
    }
}