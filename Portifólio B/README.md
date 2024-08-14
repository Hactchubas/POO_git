### Kauã Souza Maia - 536732

## [LISTA DE EXERCÍCIOS – Associações e Herança (link para Repositório)]() 


### 1. Quais são as associações presentes na UM? Quais são as suas propriedades e como essas associações são implementadas no código-fonte (Java, C++ ou C#)? <hr>
- Associação Simples
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

- Agregação
  - É uma forma especial de associação que demonstra que um objetp precisa ser complementado por um objeto de outra classe.
  - Relação "Todo-Parte":
    - objeto-todo: Parte maior, que é composta pelas partes.
    - objeto-parte: Parte menor, que compõe o objeto-todo
  - Representação: Uma linha contínua com um losango sem preenchimento na extremidade que contém os objetos-todo

    <img src="./Q1/Assets/Q1_diagram_agreg.png" alt="Diagram of the Parking Lot Classes" />

- Composição
  - Uma variação do tipo agregação em que o vínculo entre objetos-todo e objetos-parte é mais forte
  - Objetos-parte têm que pertencer ao objeto-todo:
    - O todo não existe (ou não faz sentido) sem as partes
    - Ou, as partes não existem sem o todo
  - Representação: Uma linha contínua com um losango preenchido na extremidade que contém os objetos-todo
  
    <img src="./Q1/Assets/Q1_diagram_comp.png" alt="Diagram of the Parking Lot Classes" />

- Especialização / Generalização (Herança)
  - Identificar super-classe (geral) e subclasses (especializadas)
    - Semântica “é um”
    - Tudo que a classe geral pode fazer, as classes específicas também podem
  - Todos os atributos e métodos definidos na super-classe são
herdados pelas sub-classes 
    <img src="./Q1/Assets/Q1_diagram_heran.png" alt="Diagram of the Parking Lot Classes" /> 

- Dependência
  - Identifica uma ligação fraca entre objetos de duas classes
  - Representado por uma reta tracejada entre duas classes com uma seta na ponta que indica a dependência (no exemplo: DVD depende de Funcionario) 
<img src="./Q1/Assets/Q1_diagram_depend.png" alt="Diagram of the Parking Lot Classes" /> 


1. #### Qual a diferença entre agregação e composição? Dê exemplos com código/UML.

2. #### Explique o que é herança? Explique como funcionam os mecanismos de sobreposição (override) e de sobrecarga (overload) de métodos
- ##### a) Implemente um pequeno programa ilustrando esses três conceitos.

1. #### Desenvolva uma discussão sobre o recurso de herança múltipla, seus perigos e suas oportunidades.

2. #### Quais as vantagens e desvantagens de usar composição no lugar da herança? Essa é talvez a questão mais importante da disciplina!