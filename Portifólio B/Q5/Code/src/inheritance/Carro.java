package inheritance;

// Subclasse Carro que herda de Veiculo
class Carro extends Veiculo {
    int numeroDePortas;

    public void abrirPortaMalas() {
        System.out.println("Abrindo o porta-malas.");
    }
}
