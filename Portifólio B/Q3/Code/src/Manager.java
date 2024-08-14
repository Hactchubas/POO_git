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

    @Override
    public void assignTask(String task) {
        System.out.println(getName() + " (Manager) está delegando a tarefa: " + task);
    }
}