package inheritance;

// Subclasse Moto que herda de Veiculo
class Moto extends Veiculo {
    boolean temSidecar;
    public void empinar() {
        System.out.println("A moto está empinando.");
    }
}
