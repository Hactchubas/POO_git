class CreditCardPayment implements Payment {
    private String cardNumber;
    private String cardHolderName;
    private double amountPaid;

    public CreditCardPayment(String cardNumber, String cardHolderName) {

        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void processPayment(double amount) {
        this.amountPaid = amount;
        System.out.println("Processing credit card payment of $" + amount + " on "+ cardHolderName +"'s card");
    }

    @Override
    public String getPaymentDetails() {
        return "Credit card payment of $" + amountPaid + " on card " + cardNumber;
    }
}