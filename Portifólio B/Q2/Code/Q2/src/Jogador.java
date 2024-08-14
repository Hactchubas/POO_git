
// Classe Jogador representando um jogador de futebol
class Jogador extends Pessoa {
    public Time time;
    public int numCamisa;

    public Jogador(Time time, int numCamisa){
        this.numCamisa = numCamisa;
        this.time = time;
    }

    public Time getTime() {
        return time;
    }
    public int getNumCamisa() {
        return numCamisa;
    }
    public String getNome() {
        return nome;
    }
}

