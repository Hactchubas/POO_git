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