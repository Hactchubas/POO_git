import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ParkingLotController {
    private Map<String, Ticket> activeTickets;
    private int lastTicketNumber;

    public ParkingLotController() {
        this.activeTickets = new HashMap<>();
        this.lastTicketNumber = 0; // Initialize the last ticket number to 0
    }

    // Method to handle vehicle entry
    public void vehicleEntry(Vehicle vehicle) {
        long entryTime = System.currentTimeMillis();
        Ticket ticket = new ParkingTicket(generateTicketId(), vehicle, entryTime);
        activeTickets.put(ticket.getTicketId(), ticket);
        System.out.println("Vehicle entered: " + vehicle.getType() + " - " + vehicle.getLicensePlate());
        System.out.println("Ticket issued: " + ticket.getTicketId());
    }

    // Method to handle vehicle exit
    public void vehicleExit(String ticketId, Payment paymentMethod) {
        ParkingTicket ticket = (ParkingTicket) activeTickets.get(ticketId);
        if (ticket != null) {
            ticket.pay(paymentMethod);
            if ((ticket).isPaid()) {
                activeTickets.remove(ticketId);
                System.out.println("Vehicle exited with ticket ID: " + ticketId);
            }
        } else {
            System.out.println("Invalid ticket ID: " + ticketId);
        }
    }

    // Method to generate sequential ticket IDs
    private String generateTicketId() {
        lastTicketNumber++; // Increment the last ticket number
        return "TCKT" + lastTicketNumber; // Create a new ticket ID
    }

    // Method to simulate parking duration (for testing purposes)
    public void simulateParkingDuration(long seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }

    // Method to check the status of a ticket
    public void checkTicketStatus(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket != null) {
            System.out.println("Ticket ID: " + ticket.getTicketId());
            System.out.println("Vehicle Info: " + ticket.getVehicleInfo());
            System.out.println("Parking duration (in hours): " + calculateParkingDuration(ticket));
        } else {
            System.out.println("Invalid ticket ID: " + ticketId);
        }
    }

    // Helper method to calculate the parking duration
    private long calculateParkingDuration(Ticket ticket) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - ((ParkingTicket) ticket).getEntryTime()) / (1000 * 60 * 60);
    }

    public static void main(String[] args) throws InterruptedException {
        // Create a ParkingLotController instance
        ParkingLotController parkingLot = new ParkingLotController();

        // Create vehicles
        Vehicle car = new Car("ABC1234", "Sedan");
        Vehicle motorbike = new Motorbike("XYZ5678", "Sport");

        // Simulate vehicle entry
        parkingLot.vehicleEntry(car);
        parkingLot.vehicleEntry(motorbike);

        // Simulate parking duration
        parkingLot.simulateParkingDuration(5); // Wait for 5 seconds (simulate parking time)

        // Check ticket status before payment
        parkingLot.checkTicketStatus("TCKT1");

        // Simulate vehicle exit with payment
        Payment carPayment = new CreditCardPayment("1234-5678-9876-5432", "Jaão Macedo");
        parkingLot.vehicleExit("TCKT1", carPayment);

        // Attempt to exit with the same ticket to demonstrate it's already paid
        parkingLot.vehicleExit("TCKT1", carPayment);
    }
}
