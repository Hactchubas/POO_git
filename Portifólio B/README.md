### Kauã Souza Maia - 536732

## [LISTA DE EXERCÍCIOS – Associações e Herança (link para Repositório)](https://github.com/Hactchubas/POO_git/tree/master/Portifólio%20B) 


### 1. Quais são as associações presentes na UM? Quais são as suas propriedades e como essas associações são implementadas no código-fonte (Java, C++ ou C#)? <hr>
- Associação Simples - [Código](https://github.com/Hactchubas/POO_git/tree/master/Portifólio%20B/Q1/Code/Q1/src/simple_assoc)
  - É um dos relacionamentos mais básico entre dois objetos, em que representa que um está relacionado a outro.
  - Propriedades: 
    - Multiplicidade: Quantifica como uma classe está relacionada a outra em questões numéricas. 
    - Direcionalidade (se a associação é unidirecional ou bidirecional)  
<img src="./Q1/Assets/Q1_diagram_mult.png" alt="Diagram of the Parking Lot Classes" />

| Multiplicidade | Descrição |
|----------------|-----------|
| 0..1           | No máximo um. Indica que os objetos da classe associada não precisam obrigatoriamente estar relacionados.|
| 1..1           | Um e somente um. Indica que apenas um objeto da classe se relaciona com os objetos da outra classe.|
| 1..*           | Um ou muitos. Indica que há pelo menos um objeto envolvido no relacionamento.|
| 0..*           | Muitos. Indica que podem haver muitos objetos da classe envolvidos no relacionamento|
| 3..5           | Valores específicos. |

<br>
<br>
<br>

- Agregação - [Código](https://github.com/Hactchubas/POO_git/tree/master/Portifólio%20B/Q1/Code/Q1/src/agreg)
  - É uma forma especial de associação que demonstra que um objeto precisa ser complementado por um objeto de outra classe.
  - Relação "Todo-Parte":
    - objeto-todo: Parte maior, que é composta pelas partes.
    - objeto-parte: Parte menor, que compõe o objeto-todo
  - Representação: Uma linha contínua com um losango sem preenchimento na extremidade que contém os objetos-todo

    <img src="./Q1/Assets/Q1_diagram_agreg.png" alt="Diagram of the Parking Lot Classes" />

- Composição - [Código](https://github.com/Hactchubas/POO_git/tree/master/Portif%C3%B3lio%20B/Q1/Code/Q1/src/agreg)
  - Uma variação do tipo agregação em que o vínculo entre objetos-todo e objetos-parte é mais forte
  - Objetos-parte têm que pertencer ao objeto-todo:
    - O todo não existe (ou não faz sentido) sem as partes
    - Ou, as partes não existem sem o todo
  - Representação: Uma linha contínua com um losango preenchido na extremidade que contém os objetos-todo
  
    <img src="./Q1/Assets/Q1_diagram_comp.png" alt="Diagram of the Parking Lot Classes" />


- Especialização / Generalização (Herança) - [Código](https://github.com/Hactchubas/POO_git/tree/master/Portif%C3%B3lio%20B/Q1/Code/Q1/src/agreg)
  - Identificar super-classe (geral) e subclasses (especializadas)
    - Semântica “é um”
    - Tudo que a classe geral pode fazer, as classes específicas também podem
  - Todos os atributos e métodos definidos na super-classe são
herdados pelas sub-classes 

    <img src="./Q1/Assets/Q1_diagram_heran.png" alt="Diagram of the Parking Lot Classes" /> 


- Dependência - [Código](https://github.com/Hactchubas/POO_git/tree/master/Portif%C3%B3lio%20B/Q1/Code/Q1/src/agreg)
  - Identifica uma ligação fraca entre objetos de duas classes
  - Representado por uma reta tracejada entre duas classes com uma seta na ponta que indica a dependência (no exemplo: DVD depende de Funcionario) 
  
    <img src="./Q1/Assets/Q1_diagram_depend.png" alt="Diagram of the Parking Lot Classes" /> 
  



### 2. Qual a diferença entre agregação e composição? Dê exemplos com código/UML. <hr>
[Códigos do exemplo](https://github.com/Hactchubas/POO_git/tree/master/Portifólio%20B/Q2/Code/Q2/src)
- Como explicado na questão 1, o que difere entre agragação e composição é a força das relações. Agragação, sendo mais fraca, uma classe complementa atributos de outra, mas elas não dependem entre si para existir. 
- Na composição no entanto não é assim, existe uma relação mais forte em que uma classe só existe na presença da outra e/ou uma só faz sentido existir se ela fizer parte (compor outra).
- No exemplo a seguir imagine o seguinte:
  - Um Time só existe se ele tiver jogadores para o compor, assim como os jogadores só são realmete jogadores se estiverem em um time.
  - Um estádio existe independenete do time, uma vez construído ele pode ser usado em muitos contextos, mas o estádio pode fazer parte do time, pode ser que aquele estádio "seja do time X", fazendo parte da identidade daquele time.
  <img src="./Q2/Assets/Q2_diagram.png" alt="Diagram of the Parking Lot Classes" /> 

```java    
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
```
```java 
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
```
```java 
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
```
```java 
public class Pessoa {

    public String nome;
    private Long id;
}
```


### 3. Explique o que é herança? Explique como funcionam os mecanismos de sobreposição (override) e de sobrecarga (overload) de métodos<hr>
  - #### a) Implemente um pequeno programa ilustrando esses três conceitos.
    - A sobrecarga (overloading) ocorre quando você mantém o mesmo nome do método, mas altera o número ou o tipo de parâmetros. A sobrescrita (overriding) acontece quando você mantém o mesmo nome e assinatura do método, mas altera a implementação. Além disso, é possível sobrecarregar métodos privados e estáticos, mas não é possível sobrescrevê-los.
  
```java    
class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Método para calcular o salário
    public double calculateSalary() {
        return baseSalary;
    }

    public void assignTask(String task) {
        System.out.println(name + " está realizando a tarefa: " + task);
    }

    // Sobrecarga do método assignTask com complexidade
    public void assignTask(String task, int priority) {
        System.out.println(name + " está realizando a tarefa: " + task + " com prioridade " + priority);
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}
```
```java    
class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    // Sobrepondo o método calculateSalary
    @Override
    public double calculateSalary() {
        return super.calculateSalary() + bonus;
    }
    // Sobrepondo o método assignTask
    @Override
    public void assignTask(String task) {
        System.out.println(getName() + " (Manager) está delegando a tarefa: " + task);
    }
}
```
```java    
class Intern extends Employee {
    public Intern(String name, double baseSalary) {
        super(name, baseSalary);
    }

    // Sobrepondo o método calculateSalary
    @Override
    public double calculateSalary() {
        return super.calculateSalary() * 0.5; // Estagiário recebe metade do salário base
    }
    // Sobrepondo o método assignTask
    @Override
    public void assignTask(String task) {
        System.out.println(getName() + " (Intern) está realizando a tarefa: " + task);
    }
}
```
```java    
public class Main {
    public static void main(String[] args) {
        // Criando objetos
        Employee emp = new Employee("John", 3000);
        Manager mgr = new Manager("Alice", 5000, 2000);
        Intern intern = new Intern("Bob", 1500);

        // Exibindo salários
        System.out.println(emp.getName() + " Salário: " + emp.calculateSalary());
        System.out.println(mgr.getName() + " Salário: " + mgr.calculateSalary());
        System.out.println(intern.getName() + " Salário: " + intern.calculateSalary());

        // Atribuindo tarefas
        emp.assignTask("Revisar relatórios");
        mgr.assignTask("Preparar apresentação");
        intern.assignTask("Organizar arquivos");

        // Demonstrando sobrecarga
        emp.assignTask("Revisar relatórios", 1);
        mgr.assignTask("Preparar apresentação", 2);
    }
}
```

### 4. Desenvolva uma discussão sobre o recurso de herança múltipla, seus perigos e suas oportunidades.<hr>
A herança múltipla é um recurso que torna capaz que uma classe (subclasse) herde de mais de uma classe (superclasses). Herdando então todos os atributos e métodos das superclasses.<br><br>
Isso cria algumas vantagens e utilidades como facilitar o reuso de parte de código, prevenindo a duplicação, fazendo com que uma classe possa aproveitar funcionalidades de diversas classes base, tornando assim modular a manutenção do código, por exemplo:
  - Uma classe `A` herde das classes `B` e `C`, e uma funcionalidade de `A` parou de funcionar, pode ser mais fácil entender e corrigir essa funcionalidade se eu sei que ela é específica de `C`, assim consertando `C` eu garanto que todas as instâncias de `A` funcionem.<br><br>
  
Legal, muito interessante, no entanto essa é uma faca de dois gumes. Pois imagine que uma classe herde  de muitas outras, isso pode criar um clomplexibilidade tão grande que torne difícil determinar onde está o problema e atacar o ponto do código que o está causando de forma efetiva.<br><br>
Ademais, imagine agora os problemas que podem aparecer quando classes diferentes por ventura possuem métodos e atributos com o mesmo nome, como o código vai saber qual e quando usar? Cria-se um problema de ambiguidade, então para resolver acaba tornando mais código e mais trabalho aquilo que deveria ser um simplificador da questão.<br><br>
Em conclusão, a herança múltipla é uma ferramenta poderosa na programação orientada a objetos, capaz de oferecer grande flexibilidade e reuso de código. No entanto, os desafios e perigos associados, como a ambiguidade de métodos, a complexidade de manutenção e os conflitos de atributos, exigem que ela seja utilizada com cautela. Muitas linguagens modernas, como Java e C#, evitam herança múltipla direta e preferem o uso de interfaces como uma maneira mais segura e controlada de implementar múltiplos comportamentos, minimizando os problemas e ajudando a criar sistemas mais robustos e fáceis de manter.

### 5. Quais as vantagens e desvantagens de usar composição no lugar da herança? Essa é talvez a questão mais importe da disciplina!<hr>

Herança é útil para situações onde existe uma clara relação "é-um" e onde é necessário compartilhar comportamento comum entre classes relacionadas. No entanto, a composição oferece maior flexibilidade e modularidade, tornando-se uma escolha melhor para sistemas complexos ou quando se deseja desacoplar as classes e promover a reutilização de componentes. A decisão entre usar herança ou composição depende do contexto específico e dos requisitos do sistema que você está desenvolvendo.
- Herança:
  - Vantagem: Compartilhamento de código entre classes relacionadas (Carro e Moto herdam comportamento de Veiculo).
  - Desvantagem: Se a hierarquia se tornar complexa, pode ser difícil de manter e estender. Por exemplo, se precisarmos criar uma nova classe Bicicleta, que não tem um motor, a herança pode não ser apropriada.
  
```java
package inheritance;
// Classe base Veiculo
public class Veiculo {
    String modelo;
    int ano;

    public void acelerar() {
        System.out.println("O veículo está acelerando.");
    }
}
```
```java
package inheritance;
// Subclasse Moto que herda de Veiculo
class Moto extends Veiculo {
    boolean temSidecar;
    public void empinar() {
        System.out.println("A moto está empinando.");
    }
}
```
```java
package inheritance;
// Subclasse Carro que herda de Veiculo
class Carro extends Veiculo {
    int numeroDePortas;
    public void abrirPortaMalas() {
        System.out.println("Abrindo o porta-malas.");
    }
}

```
```java
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
```
- Composição
  - Vantagem: Maior flexibilidade. O comportamento de aceleração é delegado ao componente Motor, o que permite a reutilização do componente em várias classes (Carro e Moto). O código é mais modular e fácil de manter, pois o Motor pode ser facilmente substituído ou alterado sem impactar diretamente as classes Carro e Moto.
  - Desvantagem: Potencial aumento na complexidade do código, especialmente se envolver muitos componentes diferentes. Por exemplo, se quisermos adicionar mais comportamentos que não estão diretamente relacionados ao motor, precisaremos adicionar mais componentes.

```java
package composition;
// Componente que define o comportamento de acelerar
class Motor {
    public void acelerar() {
        System.out.println("O motor está acelerando.");
    }
}

```
```java
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
```
```java
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
```
```java
package composition;
public class Composition {
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
```