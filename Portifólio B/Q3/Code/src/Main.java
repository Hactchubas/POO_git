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