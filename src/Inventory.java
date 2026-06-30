package src;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> items = new ArrayList<>();

    // 1. Add an item to the list
    public void addItem(Item item) {
        items.add(item);
        System.out.println("Item added successfully!");
    }

    // 2. Display all items
    public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("No items in inventory.");
            return;
        }
        System.out.println("\n========== Kitchen Inventory ==========");
        for (Item item : items) {
            item.displayItem();
        }
    }

    // 3. Search item by name
    public void searchItem(String name) {
        boolean found = false;
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.println("\n--- Item Found ---");
                item.displayItem();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Item not found: " + name);
        }
    }

    // 4. Update quantity by item ID
    public void updateItem(int id, int newQuantity) {
        for (Item item : items) {
            if (item.getId() == id) {
                item.setQuantity(newQuantity); // FIXED: directly set new quantity
                System.out.println("Quantity updated for: " + item.getName());
                return;
            }
        }
        System.out.println("Item with ID " + id + " not found.");
    }

    // 5. Delete item by ID
    public void deleteItem(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                String removedName = items.get(i).getName();
                items.remove(i);
                System.out.println("Deleted: " + removedName);
                return;
            }
        }
        System.out.println("Item with ID " + id + " not found.");
    }
}
