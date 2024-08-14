package composition;

// Classe Moto usando composição
public class Moto {
    public String modelo;
    public int ano;
    public boolean temSidecar;
    Motor motor = new Motor(); // Composição

    public void empinar() {
        System.out.println("A moto está empinando.");
    }

    public void acelerar() {
        motor.acelerar(); // Delegando comportamento para o motor
    }
}
