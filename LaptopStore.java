import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LaptopStore {
    private Set<Laptop> laptops = new HashSet<>();
    private Random random = new Random();

    public void generateLaptops(int count) {
        String[] models = {"Dell", "HP", "Apple", "Asus", "Lenovo", "Acer", "MSI", "Samsung", "Sony", "Microsoft"};
        String[] os = {"Windows", "macOS", "Linux"};
        String[] colors = {"Black", "Silver", "Gray", "Red", "Blue", "White"};

        for (int i = 0; i < count; i++) {
            String model = models[random.nextInt(models.length)];
            int ram = (random.nextInt(4) + 1) * 8; // 8, 16, 24, 32
            int hddCapacity = (random.nextInt(5) + 1) * 256; // 256, 512, 768, 1024, 1280
            String osType = os[random.nextInt(os.length)];
            String color = colors[random.nextInt(colors.length)];
            double price = 500 + random.nextDouble() * 2500;

            laptops.add(new Laptop(model, ram, hddCapacity, osType, color, price));
        }
    }

    public void displayAllLaptops() {
        laptops.forEach(System.out::println);
    }

    public Set<Laptop> getLaptops() {
        return laptops;
    }
}
