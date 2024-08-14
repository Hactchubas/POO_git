
### - UNIVERSIDADE FEDERAL DO CEARÁ - UFC <br/> - INSTITUTO UFC VIRTUAL - IUVI <br/> CURSO DE SISTEMAS E MÍDIAS DIGITAIS <br/> - DISCIPLINA: SMD0017 - PROGRAMAÇÃO ORIENTADA A OBJETOS


### Kauã Souza Maia - 536732

## LISTA DE EXERCÍCIOS – POO e UML INTRODUTÓRIAS 

1. ####  Descreva, com suas palavras, o que são classes, objetos e instâncias. Dê exemplos:<hr>
 - <b>Classes:</b> São definições genéricas de partes reutilizáveis do nosso código, são elementos base da programação orientada a objetos, e funcionam para determinar a estrutura, relacionamentos e funcionalidades de partes do código.
  ``` java
  public class MinhaCLasse {
        private String atributo1;

        public void funcionalidade(){
            System.out.println(atributo1);
        }
  }
  ```
 - <b>Objetos:</b> São alocações da memória feita pelo código seguindo as estruturação determinada pelas classes, objetos estão relacionadas a classes e são como se fosse unidades daquela classe, como dito anteriormente a classe é uma determinação genérica, enquanto o objetos é específico, cada objeto é um elemento específico e único, apesar de poderem (nem sempre) serem da mesma classe, como se fizessem parte daquela categoria.
 - <b>Instância:</b> Instância é um termo bastante intercambiável com objeto, as classes são usadas quando são instanciadas e então viram objetos, ou seja, objeto é uma instância de uma classe, um local da memória foi criado a partir da instância de uma classe e é permitido no formato de um objeto.
Qual o propósito dos atributos na orientação a objetos? Dê exemplos
``` java
 // Enquanto o objeto vai ser persistido na variável "objeto", ele foi atribuído a apartir de uma instância de 'MinhaClass' criada no lado direito da atriuição.

MinhaClasse objeto = new MinhaClasse();
```

2. #### Qual o propósito dos atributos na orientação a objetos? Dê exemplos.<hr>
-  Atributos são partes das anteriormente explicadas "classe", atributos ajudam a definir como uma classe funciona, para salvar o estado de um objeto, encapsular os dados e infoemações de uma classe, manter . <br/> São as partes da classe, que ajudam a definir seus diferentes comportamentos e identidades:
``` kotlin
//  **KOTLIN CODE** 
// Definindo uma classe chamada Pessoa
class Pessoa(
    var nome: String,     // Atributo que armazena o nome da pessoa
    var idade: Int,       // Atributo que armazena a idade da pessoa
    var altura: Double    // Atributo que armazena a altura da pessoa
)

// Função principal
fun main() {
    // Criando uma instância da classe Pessoa para João
    val pessoa1 = Pessoa("João", 30, 1.75)

    // Criando uma instância da classe Pessoa para Maria
    val pessoa2 = Pessoa("Maria", 25, 1.68)

    // Exibindo os atributos da pessoa1 (João)
    println("Nome: ${pessoa1.nome}, Idade: ${pessoa1.idade}, Altura: ${pessoa1.altura}")

    // Exibindo os atributos da pessoa2 (Maria)
    println("Nome: ${pessoa2.nome}, Idade: ${pessoa2.idade}, Altura: ${pessoa2.altura}")
}

```

3. #### Pra que servem os métodos na orientação a objetos? Dê exemplos.<hr>
-  Enquanto atributos, sobretudo, nos ajudam a definir a natureza de uma classe e seus estados, métodos tem como principal funcionalidade determinar seu funcionamento, os métodos descrevem como aquela classe se comporta e quais as formas de se interagir com ela. 

```python
# Definindo uma classe chamada ContaBancaria
class ContaBancaria:
    # O método __init__ é o construtor da classe. Ele é chamado quando criamos uma nova instância (objeto) da classe.
    def __init__(self, titular, saldo=0):
        self.titular = titular  # Atributo que armazena o nome do titular da conta
        self.saldo = saldo      # Atributo que armazena o saldo da conta, inicialmente 0

    # Método para depositar dinheiro na conta
    def depositar(self, valor):
        self.saldo += valor  # Incrementa o saldo pelo valor depositado
        print(f"Depósito de R${valor:.2f} realizado com sucesso!")

    # Método para sacar dinheiro da conta
    def sacar(self, valor):
        # Verifica se há saldo suficiente para o saque
        if valor <= self.saldo:
            self.saldo -= valor  # Decrementa o saldo pelo valor sacado
            print(f"Saque de R${valor:.2f} realizado com sucesso!")
        else:
            print("Saldo insuficiente para realizar o saque.")

    # Método para exibir o saldo atual da conta
    def exibir_saldo(self):
        print(f"O saldo atual da conta de {self.titular} é R${self.saldo:.2f}")

# Instanciando a classe ContaBancaria para o titular João, "conta_joao" passa a ser um objeto da classe
conta_joao = ContaBancaria("João")

# Interagindo com a conta de João através dos métodos
conta_joao.depositar(1000)  # João deposita R$1000,00
conta_joao.exibir_saldo()   # Exibe o saldo após o depósito

conta_joao.sacar(500)       # João saca R$500,00
conta_joao.exibir_saldo()   # Exibe o saldo após o saque

conta_joao.sacar(600)       # João tenta sacar R$600,00, mas o saldo é insuficiente
conta_joao.exibir_saldo()   # Exibe o saldo final
```

4. #### Como podemos criar (instanciar) e destruir (remover) objetos? Dê exemplos.<hr>
- Em java, para criar um objeto você deve fazer a instância da classe utilizando o operador "new" e atribuindo-o a um tipo da classe que será instanciada.
- Para a destruição manual de objetos em java o que pode ser feito é atribuir null à referência do objeto e chamar
o coletor de lixo do java que deve liberar o espaço do objeto que havia sido instanciado já que elee não é mais alcançado, pois foram perdidas as referências a ele. 
Obs.: O javafaz varredura automática de coletor de lixo, então não é comum chamar o coletor, pois uma vez que os objetos perdem suas referências, o coleotr libera a memória ocupada por eles.
```java
// Definindo a classe Carro
public class Carro {
    private String modelo;
    private int ano;

    public Carro(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public void mostrarDetalhes() {
        System.out.println("Modelo: " + modelo + ", Ano: " + ano);
    }
}

public class Principal {
    public static void main(String[] args) {
        // Criando um objeto da classe Carro
        Carro carro1 = new Carro("Fusca", 1970);
        carro1.mostrarDetalhes();  // Exibe os detalhes do carro

        // Removendo a referência ao objeto
        carro1 = null;

        // Solicitação para o coletor de lixo verificar a coleta
        System.gc();
    }
}

```
 - Exemplo em C++, perceba como o processo é bem análogo com instância usando o operador "new", no entando, C++ possui o operador "delete", tornando o ponteiro inválido e a memória devolvida ao sistema.
  
```c++
#include <iostream>
#include <string>

class Carro {
private:
    std::string modelo;
    int ano;

public:
    // Construtor
    Carro(const std::string& modelo, int ano) : modelo(modelo), ano(ano) {}

    // Método para exibir detalhes do carro
    void mostrarDetalhes() const {
        std::cout << "Modelo: " << modelo << ", Ano: " << ano << std::endl;
    }
};

int main() {
    // Criando um objeto da classe Carro usando alocação dinâmica
    Carro* carro1 = new Carro("Fusca", 1970);
    carro1->mostrarDetalhes();  // Exibindo os detalhes do carro

    // Deletando o objeto para liberar a memória
    delete carro1;

    // Após a exclusão, carro1 não deve mais ser usado.
    // carro1->mostrarDetalhes(); // Isso seria inseguro

    return 0;
}

```

5. #### O que é um Diagrama de Casos de Uso (UC, Use Cases)? Quais os elementos que o compõem?<hr> 

    
- O diagrama de casos de uso é uma ferramenta visual utilizada na engenharia de software, e no desenvolvimento de software que ajuda a entender de forma ampla as interações e relações entre o usuário e o sistema.</br>Sobre os elementos que compoem os diagramas de casos de uso:
  - Atores:
    - Definição: São as entidades que interagem com o sistema, geralmente pessoas, mas também podem ser outros sistemas ou dispositivos.
    - Representação: Normalmente representados por figuras de um boneco/sticke/boneco palito
  - Casos de uso:
    - Definição: Representam funcionalidades ou serviços que o sistema oferece aos atores. Cada caso de uso descreve um cenário ou uma sequência de ações que resultam em um resultado específico para o ator. 
    - Representação: São representados por elipses ou círculos.
  - Relações:
    -   Associação: Conecta atores aos casos de uso para mostrar que o ator participa ou utiliza o caso de uso. Representada por uma linha sólida.
    -   Generalização: Mostra que um ator ou caso de uso é uma especialização de outro. Representado por uma linha sólida com uma seta vazada na ponta.
    -   Inclusão (Include): Indica que um caso de uso sempre inclui outro caso de uso como parte de seu processo. Representado por uma linha com uma seta vazada e a palavra "include".
    -   Extensão (Extend): Indica que um caso de uso pode opcionalmente adicionar comportamentos a outro caso de uso, geralmente em condições específicas. Representado por uma linha com uma seta vazada e a palavra "extend".
  -   Sistema:

      -   Definição: O sistema que está sendo modelado. É representado por um retângulo que contém todos os casos de uso.

6. #### O que é um Diagrama de Classes? Quais os elementos que o compõem?<hr> 

    
- O diagrama d eclasse é uma representação visual das clsses de um sistema, nele estão inclusos, dependendo da necessidade de quem o faz, as classes, seu atributos, métodos e uma das partes mais importantes quesão as relações, o que ajuda a enxergar como o sistema se comporta e como seu elementos estão relacionados, podendo perceber de forma simples relações de herança, implementação, agrupamento etc..</br>Sobre os elementos que compoem os diagramas de class:
  
  - Classes:

    - Definição: É a estrutura definida em atributos e métodos, como mencionado anteriormente serve de molde para a criação de objetos.
    - Representação: As classes são representadas por retângulos divididos em três partes:
        - Nome da Classe: Aparece no topo do retângulo.
        - Atributos: Listados no meio do retângulo. Representam as propriedades ou dados que a classe possui.
        - Métodos: Listados na parte inferior do retângulo. Representam as funções ou comportamentos que a classe pode executar.

  - Atributos:
    - Definição: São as propriedades ou características de uma classe, ajudam a definir sua natureza e salvar seu estado.
    - Representação: Os atributos são listados no meio da classe, geralmente com seus tipos e, opcionalmente, seus valores iniciais.
  
  - Visibilidade:
    - No diagrama, a visibilidade dos métodos e atributos das classes são representados por uma siboligia nates de seu nome seguindo o seguinte:
      - "+" Público (Public)
      - "-" Privado (Private)
      - "#" Protegido (Protected)

  - Associações:
    - Definição: Representam as relações entre as classes. Podem indicar como uma classe se relaciona ou interage com outra.
    - Representação: As associações são representadas por linhas que conectam as classes.

    - Multiplicidade: Indica quantas instâncias de uma classe estão associadas a uma instância de outra classe (por exemplo, 1:1, 1
, N
).

  - Agregação:
    - Definição: Uma forma especial de associação que indica que uma classe é composta por outras classes, mas as partes podem existir independentemente.
    - Representação: Representada por uma linha com um losango vazio na extremidade que está conectada à classe "todo".

  - Composição:
    - Definição: Uma forma mais forte de agregação onde as partes são dependentes do todo, ou seja, se o todo é destruído, as partes também são, e/ou o todo não existe sem as partes.
    - Representação: Representada por uma linha com um losango preenchido na extremidade que está conectada à classe "todo".
  
  - Generalização/Herança:

    - Definição: Representa uma relação "é um" entre uma classe base (superclasse) e uma classe derivada (subclasse). A subclasse herda atributos e métodos da superclasse.
    - Representação: Representada por uma linha sólida com uma seta vazada na ponta, apontando para a superclasse.
     