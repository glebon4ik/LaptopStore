public class Laptop {
    private String model;
    private int ram;
    private int hddCapacity;
    private String os;
    private String color;
    private double price;

    public Laptop(String model, int ram, int hddCapacity, String os, String color, double price) {
        this.model = model;
        this.ram = ram;
        this.hddCapacity = hddCapacity;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    public String getModel() { return model; }
    public int getRam() { return ram; }
    public int getHddCapacity() { return hddCapacity; }
    public String getOs() { return os; }
    public String getColor() { return color; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("Laptop [Model: %s, RAM: %dGB, HDD: %dGB, OS: %s, Color: %s, Price: $%.2f]", 
            model, ram, hddCapacity, os, color, price);
    }
}
