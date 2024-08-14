class Car implements Vehicle {
    private String licensePlate;
    private String model;

    public Car(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String getType() {
        return "Car";
    }

    public String getModel() {
        return model;
    }
}