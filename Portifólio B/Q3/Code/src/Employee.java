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