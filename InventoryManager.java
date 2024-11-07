import java.util.ArrayList;
import java.util.Scanner;

class InventoryItem {
    String name;
    int quantity;
    double price;

    public InventoryItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - Quantity: " + quantity + ", Price: $" + price;
    }
}

public class InventoryManager {
    private static ArrayList<InventoryItem> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Delete Item");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addItem();
                    break;
                case "2":
                    viewInventory();
                    break;
                case "3":
                    deleteItem();
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        
        inventory.add(new InventoryItem(name, quantity, price));
        System.out.println("Item added successfully!");
    }

    private static void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("No items in inventory.");
            return;
        }
        System.out.println("\nInventory Items:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i));
        }
    }

    private static void deleteItem() {
        viewInventory();
        if (inventory.isEmpty()) {
            return;
        }
        System.out.print("Enter item number to delete: ");
        int itemNum = Integer.parseInt(scanner.nextLine());
        if (itemNum > 0 && itemNum <= inventory.size()) {
            inventory.remove(itemNum - 1);
            System.out.println("Item deleted successfully!");
        } else {
            System.out.println("Invalid item number.");
        }
    }
}
