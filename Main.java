import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        LaptopStore store = new LaptopStore();
        store.generateLaptops(100);

        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        System.out.println("Welcome to the Laptop Store!");

        while (continueProgram) {
            Map<String, Object> criteria = new HashMap<>();
            boolean moreCriteria = true;

            while (moreCriteria) {
                System.out.println("Enter the number corresponding to the desired criterion:");
                System.out.println("1 - RAM");
                System.out.println("2 - Storage");
                System.out.println("3 - Operating System");
                System.out.println("4 - Color");
                System.out.println("5 - Finish criteria input");

                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter minimum RAM value: ");
                        criteria.put("ram", scanner.nextInt());
                        scanner.nextLine();  // Consume newline
                        break;
                    case 2:
                        System.out.print("Enter minimum storage value: ");
                        criteria.put("hddCapacity", scanner.nextInt());
                        scanner.nextLine();  // Consume newline
                        break;
                    case 3:
                        System.out.print("Enter operating system: ");
                        criteria.put("os", scanner.nextLine());
                        break;
                    case 4:
                        System.out.print("Enter color: ");
                        criteria.put("color", scanner.nextLine());
                        break;
                    case 5:
                        moreCriteria = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }

            Set<Laptop> filteredLaptops = store.getLaptops().stream()
                    .filter(laptop -> {
                        boolean matches = true;
                        if (criteria.containsKey("ram")) {
                            matches = matches && laptop.getRam() >= (int) criteria.get("ram");
                        }
                        if (criteria.containsKey("hddCapacity")) {
                            matches = matches && laptop.getHddCapacity() >= (int) criteria.get("hddCapacity");
                        }
                        if (criteria.containsKey("os")) {
                            matches = matches && laptop.getOs().equalsIgnoreCase((String) criteria.get("os"));
                        }
                        if (criteria.containsKey("color")) {
                            matches = matches && laptop.getColor().equalsIgnoreCase((String) criteria.get("color"));
                        }
                        return matches;
                    })
                    .collect(Collectors.toSet());

            if (filteredLaptops.isEmpty()) {
                System.out.println("No laptops match the specified criteria.");
            } else {
                System.out.println("Found laptops:");
                filteredLaptops.forEach(System.out::println);
            }

            System.out.println("Would you like to continue? (yes/no)");
            String continueResponse = scanner.nextLine().trim().toLowerCase();
            if (continueResponse.equals("no")) {
                continueProgram = false;
            }
        }

        System.out.println("Thank you for visiting the Laptop Store! Goodbye!");
    }
}
