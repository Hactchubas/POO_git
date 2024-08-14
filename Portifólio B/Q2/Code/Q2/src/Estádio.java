// Classe Estadio representando um estádio de futebol
class Estadio {
    private String nome;
    private String localizacao;

    public Estadio(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }
}

