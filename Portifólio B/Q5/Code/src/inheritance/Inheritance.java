package inheritance;

public class Inheritance {
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.modelo = "Sedan";
        carro.ano = 2020;
        carro.numeroDePortas = 4;
        carro.acelerar();
        carro.abrirPortaMalas();

        Moto moto = new Moto();
        moto.modelo = "Esportiva";
        moto.ano = 2021;
        moto.temSidecar = false;
        moto.acelerar();
        moto.empinar();
    }
}
