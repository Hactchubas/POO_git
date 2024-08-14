package composition;

// Classe Carro usando composição
public class Carro {
    public String modelo;
    public int ano;
    public int numeroDePortas;
    Motor motor = new Motor(); // Composição

    public void abrirPortaMalas() {
        System.out.println("Abrindo o porta-malas.");
    }

    public void acelerar() {
        motor.acelerar(); // Delegando comportamento para o motor
    }
}
