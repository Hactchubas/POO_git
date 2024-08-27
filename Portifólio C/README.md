### Kauã Souza Maia - 536732

## [LISTA DE EXERCÍCIOS – Associações e Herança (link para Repositório)](https://github.com/Hactchubas/POO_git/tree/master/Portifólio%20B) 


### 1. Desenvolva uma discussão sobre (a) “O que é o polimorfismo” e (b) “como esse pilar da POO pode ser implementado”. Sugestão: abordar os conceitos de ligação antecipada (early binding) e ligação tardia (late binding)  <hr>

- a) Polimorfismo é um dos pilares da programação orientada a objetos. Ela representa a mutabilidade do código orientado a objetos, fazendo com que seja mais flexível e dinâmico, colocando dentro das regras do código estruturado de sua natureza uma maneira de moldar para diferentes ocasiões. 
  <br><br>
  Como o próprio nome sugere, "poli" (muitos, multiplos) "morfismo" (forma), trata-se de elementos do código serem flexíveis quanto a forma, apesar de manterem sua natureza. Em termos simples, polimorfismo permite que um único método ou interface opere em diferentes tipos de dados ou objetos.<br><br>
  Duas são as formas principais do polimorfismo, Sobrecarga e Sobrescrita:
    - Sobrecarga: Ocorre quando métodos compatilham o mesmo nome, mas diferem em suas assinaturas, seja o número ou tipo dos parâmetros.
    - Sobrescrita: Ocorre quando uma subclasse substitui o comportamento de um método da superclasse. Isso permite que objetos de diferentes classes que compartilham um mesmo método (ou que implementam a mesma interface) possam ser tratados de maneira uniforme.
  
- b) O polimorfismo pode ser implementado em diferentes contexto e necessidades, mas para exemplo e aprofundamento explicativo podemos explorar os conceitos (como sugerido) de "Early Binding" e "Late Binding"
  - Early binding (ou Ligação antecipada): Ocorre em tempo de compilação. Neste caso, o compilador determina qual método deve ser chamado com base na assinatura dos métodos. A sobrecarga de métodos é um exemplo típico de ligação antecipada.
  <br>
  <br>
  Ex.: Imagine que estamos desenvolvendo um sistema que precisa autenticar usuários de diferentes maneiras: através de um nome de usuário e senha, através de um token de API, ou até mesmo via integração com um sistema OAuth.

```java
class AutenticacaoService {

    // Método para autenticação por nome de usuário e senha
    public boolean autenticar(String username, String password) {
        // Lógica para autenticar usando nome de usuário e senha
        if(username.equals("admin") && password.equals("1234")) {
            return true;
        }
        return false;
    }

    // Sobrecarga para autenticação por token de API
    public boolean autenticar(String apiToken) {
        // Lógica para autenticar usando um token de API
        if(apiToken.equals("valid_api_token")) {
            return true;
        }
        return false;
    }

    // Sobrecarga para autenticação via OAuth
    public boolean autenticar(OAuthToken oAuthToken) {
        // Lógica para autenticar usando OAuth
        if(oAuthToken.isValid()) {
            return true;
        }
        return false;
    }
}

class OAuthToken {
    // Simulação de um token OAuth
    public boolean isValid() {
        // Verifica se o token é válido
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        AutenticacaoService authService = new AutenticacaoService();

        // Autenticação por nome de usuário e senha
        boolean isAuthenticated = authService.autenticar("admin", "1234");
        System.out.println("Autenticado por nome de usuário/senha: " + isAuthenticated);

        // Autenticação por token de API
        isAuthenticated = authService.autenticar("valid_api_token");
        System.out.println("Autenticado por token de API: " + isAuthenticated);

        // Autenticação via OAuth
        OAuthToken oAuthToken = new OAuthToken();
        isAuthenticated = authService.autenticar(oAuthToken);
        System.out.println("Autenticado via OAuth: " + isAuthenticated);
    }
}
```

  -
    - Late Binding (Ligação tardia): Ocorre quando a decisão sobre qual método invocar é feita em tempo de execução. Isso é típico da sobrescrição de métodos em hierarquias de herança, onde o método que será chamado depende do tipo real do objeto.
  <br>
  <br>
  Ex.: Imagine que estamos desenvolvendo um sistema de notificação onde diferentes tipos de notificações precisam ser enviadas. Cada tipo de notificação (email, SMS, push notification) terá uma implementação específica de envio. Utilizamos a sobrescrita de métodos para permitir que cada tipo de notificação implemente seu próprio comportamento.

```java
// Classe base para notificações
abstract class Notificacao {
    // Método a ser sobrescrito nas subclasses
    public abstract void enviar(String mensagem);
}

// Classe concreta para notificações por email
class NotificacaoEmail extends Notificacao {
    @Override
    public void enviar(String mensagem) {
        // Lógica para enviar email
        System.out.println("Enviando email com a mensagem: " + mensagem);
    }
}

// Classe concreta para notificações por SMS
class NotificacaoSMS extends Notificacao {
    @Override
    public void enviar(String mensagem) {
        // Lógica para enviar SMS
        System.out.println("Enviando SMS com a mensagem: " + mensagem);
    }
}

// Classe concreta para notificações por push notification
class NotificacaoPush extends Notificacao {
    @Override
    public void enviar(String mensagem) {
        // Lógica para enviar push notification
        System.out.println("Enviando Push Notification com a mensagem: " + mensagem);
    }
}

public class Main {
    public static void main(String[] args) {
        // Criamos diferentes tipos de notificações
        Notificacao notificacaoEmail = new NotificacaoEmail();
        Notificacao notificacaoSMS = new NotificacaoSMS();
        Notificacao notificacaoPush = new NotificacaoPush();

        // Usamos ligação tardia para enviar a mensagem de acordo com o tipo da notificação em tempo de execução
        notificacaoEmail.enviar("Bem-vindo ao nosso serviço!");
        notificacaoSMS.enviar("Seu código de verificação é 1234.");
        notificacaoPush.enviar("Você tem uma nova mensagem.");
    }
}
```

### 2. Explique como funcionam as (tentativas de) conversões entre tipos polimórficos, isto é, upcasting e downcasting. Dê exemplos em código-fonte. Quando devemos usar um ou o outro ao criar um programa de computador?  <hr>

- Upcasting e Downcasting são formas de tratar e acessar objetos baseado em sua herança ou super/sub classes. Em geral, suas utilizações dependem da necessecidade de ser mais genérico ou específico.
  <br><br>
Exemplo: Upcasting e Downcasting em um Sistema de Gerenciamento de Usuários
  -   Explicação do Upcasting: No exemplo, RegularUser e Admin são subclasses de User. Através do upcasting, estamos tratando usuario1 e usuario2 como instâncias de User, permitindo que chamemos o método realizarAcao que é implementado de forma polimórfica em cada subclasse.
  -   Explicação do Downcasting: No método verificarERealizarAcao, estamos verificando se o usuario é uma instância de Admin usando instanceof. Se for, realizamos o downcasting para que possamos acessar propriedades ou métodos específicos da classe Admin. Se não for, tratamos como um RegularUser.

```java 
import java.lang.reflect.Array;
import java.util.*;

// Classe base para usuários
abstract class User {
    protected String nome;

    public User(String nome) {
        this.nome = nome;
    }

    public abstract void realizarAcao();

    public String getNome() {
        return this.nome;
    }
}

// Classe concreta para usuários regulares
class RegularUser extends User {
    public RegularUser(String nome) {
        super(nome);
    }

    @Override
    public void realizarAcao() {
        System.out.println(nome + " está realizando uma ação de usuário regular.");
    }
}

// Classe concreta para usuários administradores
class Admin extends User {
    public Admin(String nome) {
        super(nome);
    }

    @Override
    public void realizarAcao() {
        System.out.println(nome + " está realizando uma ação de administrador.");
    }
}

public class Q2 {
    public static void main(String[] args) {
        /**
         * Upcasting
         **/
        User usuario1 = new RegularUser("Alice"); // Upcasting implícito
        User usuario2 = new Admin("Bob"); // Upcasting implícito

        // Chama a ação específica do usuário
        usuario1.realizarAcao(); // Output: "Alice está realizando uma ação de usuário regular."
        usuario2.realizarAcao(); // Output: "Bob está realizando uma ação de administrador."

        // Forma de generalizar esse objetos pondo em uma lista da classe genérica apesar de serem diferentes
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(usuario1);
        userList.add(usuario2);

        for (User user : userList){
            System.out.println(user.getNome() +": "+user.getClass());
        }
        // Alice: class RegularUser
        // Bob: class Admin

        /**
         * Downcasting 
         */
        User usuario3 = new RegularUser("Alice"); // Upcasting
        User usuario4 = new Admin("Bob"); // Upcasting

        verificarERealizarAcao(usuario3); // Verifica e realiza ação
        verificarERealizarAcao(usuario4); // Verifica e realiza ação


    }

    // Downcating apresenta riscos a mais ao ser utilizado 
    // e por isso é importante tratar e/ou pensar nisso quando usar no código.
    public static void verificarERealizarAcao(User usuario) {
        if (usuario instanceof Admin) { // Verificação antes do downcasting
            Admin admin = (Admin) usuario; // Downcasting explícito
            System.out.println(admin.nome + " tem acesso a ações administrativas.");
            admin.realizarAcao();
        } else {
            System.out.println(usuario.nome + " não é um administrador.");
            usuario.realizarAcao();
        }
    }
}
```

### 3. O que é uma classe abstrata? Para quê serve? Mostre um exemplo em UML e em código-fonte.  <hr>

- Classe abstrata é uma forma de criar uma entidade da POO como se fosse uma classe comum, mas com alguns detalhes. Uma classe abstrata não pode ser instanciada, sua função está em ser de base para outras classes que vem a seguir, pois suas subclasses vão poder desfrutar da estrutura dela pré estabelecida. No entanto, outra caracteristia chave de uma clasee abstrata é que além dos métodos comuns (concretos) que ela possui e as suas classes filhas herdam, ela tem também métodos abstrados, métodos esses que tem estrutura, mas não implementação, obrigando que suas subclasses se responsaiblizem por isso.
Ou seja ela serve pois:
  -  Fornece uma Base Comum: Uma classe abstrata serve como uma base comum para um grupo de classes relacionadas, garantindo que todas as subclasses compartilhem uma estrutura e um comportamento comuns.
  -  Define Contratos: Ao incluir métodos abstratos, uma classe abstrata pode definir um "contrato" que as subclasses devem seguir. Isso força as subclasses a fornecer implementações específicas para esses métodos.
  -  Facilita a Manutenção: Como as subclasses compartilham código comum definido na classe abstrata, isso facilita a manutenção e a reutilização do código.
-  Exemplo: Vamos considerar um exemplo em que estamos implementando um sistema para gerenciar conexões entre dispositivos Android usando diferentes protocolos, como Bluetooth e Wi-Fi Direct. Nesse contexto, podemos usar uma classe abstrata para definir um contrato comum para qualquer tipo de conexão, enquanto as subclasses implementam a lógica específica para cada tipo de conexão.

<img src="./Assets/Q3_diagram.png" />

```java 
// Classe abstrata Connection
abstract class Connection {
    protected String deviceName;

    public Connection(String deviceName) {
        this.deviceName = deviceName;
    }

    // Método abstrato para conectar ao dispositivo
    public abstract boolean connect();

    // Método abstrato para desconectar do dispositivo
    public abstract void disconnect();

    // Método concreto para exibir o status da conexão
    public void showStatus(String status) {
        System.out.println("Status da conexão com " + deviceName + ": " + status);
    }
}

// Subclasse para conexão via Bluetooth
class BluetoothConnection extends Connection {
    public BluetoothConnection(String deviceName) {
        super(deviceName);
    }

    @Override
    public boolean connect() {
        // Lógica fictícia para conectar via Bluetooth
        System.out.println("Tentando conectar ao dispositivo " + deviceName + " via Bluetooth...");
        boolean success = true; // Supondo que a conexão foi bem-sucedida
        showStatus(success ? "Conectado via Bluetooth" : "Falha na conexão Bluetooth");
        return success;
    }

    @Override
    public void disconnect() {
        // Lógica fictícia para desconectar via Bluetooth
        System.out.println("Desconectando de " + deviceName + " via Bluetooth...");
        showStatus("Desconectado via Bluetooth");
    }
}

// Subclasse para conexão via Wi-Fi Direct
class WifiDirectConnection extends Connection {
    public WifiDirectConnection(String deviceName) {
        super(deviceName);
    }

    @Override
    public boolean connect() {
        // Lógica fictícia para conectar via Wi-Fi Direct
        System.out.println("Tentando conectar ao dispositivo " + deviceName + " via Wi-Fi Direct...");
        boolean success = true; // Supondo que a conexão foi bem-sucedida
        showStatus(success ? "Conectado via Wi-Fi Direct" : "Falha na conexão Wi-Fi Direct");
        return success;
    }

    @Override
    public void disconnect() {
        // Lógica fictícia para desconectar via Wi-Fi Direct
        System.out.println("Desconectando de " + deviceName + " via Wi-Fi Direct...");
        showStatus("Desconectado via Wi-Fi Direct");
    }
}

// Exemplo de uso no main
public class Main {
    public static void main(String[] args) {
        Connection bluetoothConnection = new BluetoothConnection("Speaker");
        Connection wifiDirectConnection = new WifiDirectConnection("Smart TV");

        bluetoothConnection.connect();
        wifiDirectConnection.connect();

        bluetoothConnection.disconnect();
        wifiDirectConnection.disconnect();
    }
}
```