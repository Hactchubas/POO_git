class Motorbike implements Vehicle {
    private String licensePlate;
    private String model;

    public Motorbike(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String getType() {
        return "Motorbike";
    }

    public String getModel() {
        return model;
    }
}
