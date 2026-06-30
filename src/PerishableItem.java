package src;

// PerishableItem extends Item to demonstrate Inheritance
public class PerishableItem extends Item {

    // Constructor calls the parent (Item) constructor using super()
    public PerishableItem(int id, String name, String category, int quantity, String expiryDate) {
        super(id, name, category, quantity, expiryDate);
    }

    // Override displayItem to also show the item type
    @Override
    public void displayItem() {
        super.displayItem();
        System.out.println("Type         : Perishable Item");
        System.out.println("------------------------------------------");
    }
}
