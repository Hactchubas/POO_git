interface Ticket {
    String getTicketId();
    String getVehicleInfo();
    double calculateFee(long parkingDuration);
    void pay(Payment paymentMethod);
    boolean isPaid();
}