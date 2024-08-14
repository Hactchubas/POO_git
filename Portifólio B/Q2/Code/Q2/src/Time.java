
import java.util.List;

class Time {
    private String nome;
    private Estadio estadio; // Agregação: o estádio pode existir independentemente do time
    private List<Jogador> jogadores; // Composição: os jogadores existem dentro do contexto do time e o time depende deles para existir

    public Time(String nome,List<Jogador> jogadores,  Estadio estadio) {
        this.nome = nome;
        this.estadio = estadio;
        this.jogadores = jogadores;
    }

    public String getNome() {
        return nome;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void listarJogadores() {
        System.out.println("Jogadores do " + this.nome + ":");
        for (Jogador jogador : jogadores) {
            System.out.println("- " + jogador.getNome() + " torce para" + jogador.getTime());
        }
    }
}
