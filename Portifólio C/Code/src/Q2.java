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
    public static void main(String[] args) throws Exception {
        /**
         * Upcasting
         **/
        System.out.println("Upcasting --------");
        User usuario1 = new RegularUser("Kauã"); // Upcasting implícito
        User usuario2 = new Admin("Gilvan"); // Upcasting implícito

        // Chama a ação específica do usuário
        usuario1.realizarAcao(); // Output: "Alice está realizando uma ação de usuário regular."
        usuario2.realizarAcao(); // Output: "Bob está realizando uma ação de administrador."

        // Perceba que o upcasting é implicito, pois temos sempre certeza que cada subclasse é uma especialização da superclasse
        // e assim pode ser tratada como uma instância dela.
        // Forma de generalizar esse objetos pondo em uma lista da classe genérica apesar de serem especializadas
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(usuario1);
        userList.add(usuario2);

        for (User user : userList){
            System.out.println(user.getNome() +": "+user.getClass());
        }
        // Alice: class RegularUser
        // Bob: class Admin
        System.out.println("--------");
        System.out.println("Downcasting --------");
        /**
         * Downcasting
         */

        verificarERealizarAcao(usuario1); // Verifica e realiza ação
        verificarERealizarAcao(usuario2); // Verifica e realiza ação

        // Aqui outro exemplo do porque o downcast não é tão natural quanto o upcasting
        // Não temos como ter certeza se as instâcias de user são do tipo específica que se quer usar.
        ArrayList<Admin> userList2 = new ArrayList<>();
        for (User user : userList){
            adicionarALista(user, userList2);
        }
        System.out.println("--------");
    }

    public static  void adicionarALista(User user, ArrayList<Admin> list) throws Exception{
        try{
            Admin admin1 = (Admin) user;
            if(list.add(admin1)){
                System.out.println(admin1.getNome() +": "+admin1.getClass()+" adicionado à lista de Admin com sucesso");
            }
        } catch (Exception e){
            System.out.println("Falha ao adicionar "+ user.getNome() +" a lista de Admin: "+ e);
        }
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