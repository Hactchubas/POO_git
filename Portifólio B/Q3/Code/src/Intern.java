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
