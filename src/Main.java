package src;

import java.util.Scanner;

public class Main {

    static int nextId = 1; // Auto-generate IDs starting from 1
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        int choice;

        System.out.println("Welcome to Kitchen Inventory Manager!");

        do {
            printMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addItem(inventory);
                    break;
                case 2:
                    inventory.viewItems();
                    break;
                case 3:
                    System.out.print("Enter item name to search: ");
                    String name = scanner.nextLine();
                    inventory.searchItem(name);
                    break;
                case 4:
                    int id = readInt("Enter item ID to update: ");
                    int qty = readInt("Enter new quantity: ");
                    inventory.updateItem(id, qty);
                    break;
                case 5:
                    int deleteId = readInt("Enter item ID to delete: ");
                    inventory.deleteItem(deleteId);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1-6.");
            }

        } while (choice != 6);

        scanner.close();
    }

    // Print the main menu
    static void printMenu() {
        System.out.println("\n==============================");
        System.out.println("  Kitchen Inventory Manager  ");
        System.out.println("==============================");
        System.out.println("1. Add Item");
        System.out.println("2. View Items");
        System.out.println("3. Search Item");
        System.out.println("4. Update Quantity");
        System.out.println("5. Delete Item");
        System.out.println("6. Exit");
        System.out.println("==============================");
    }

    // Collect item details from user and add to inventory
    static void addItem(Inventory inventory) {
        System.out.println("\n--- Add New Item ---");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter category (e.g. Dairy, Grains): ");
        String category = scanner.nextLine();

        int quantity = readInt("Enter quantity: ");

        System.out.print("Enter expiry date (dd-MM-yyyy) or N/A: ");
        String expiryDate = scanner.nextLine();

        System.out.print("Is this a perishable item? (y/n): ");
        String answer = scanner.nextLine().trim().toLowerCase();

        Item item;
        if (answer.equals("y")) {
            item = new PerishableItem(nextId++, name, category, quantity, expiryDate);
        } else {
            item = new Item(nextId++, name, category, quantity, expiryDate);
        }

        inventory.addItem(item);
    }

    // Helper: safely read an integer from the user
    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
