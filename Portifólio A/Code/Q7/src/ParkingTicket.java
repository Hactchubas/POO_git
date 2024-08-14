class ParkingTicket implements Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private long entryTime;

    private boolean paid;

    public ParkingTicket(String ticketId, Vehicle vehicle, long entryTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.paid = false;
    }


    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String getTicketId() {
        return ticketId;
    }

    @Override
    public String getVehicleInfo() {
        return vehicle.getType() + " - " + vehicle.getLicensePlate();
    }

    @Override
    public double calculateFee(long currentTime) {
        long parkingDuration = (currentTime - entryTime) / (1000 * 60 * 60); // Convert milliseconds to hours
        double rate = vehicle.getType().equals("Car") ? 2.0 : 1.0; // Example rate per hour
        return rate * parkingDuration;
    }

    @Override
    public void pay(Payment paymentMethod) {
        if (!paid) {
            double feeToPay = calculateFee(System.currentTimeMillis()); // Calculate the fee at the time of payment
            paymentMethod.processPayment(feeToPay);
            paid = true; // Mark the ticket as paid
            System.out.println("Payment successful for ticket ID: " + ticketId);
        } else {
            System.out.println("This ticket has already been paid.");
        }
    }

    @Override
    public boolean isPaid() {
        return paid;
    }
}