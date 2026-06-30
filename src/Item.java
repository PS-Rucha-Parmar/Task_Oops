package src;

public class Item {

    private int id;
    private String name;
    private String category;
    private int quantity;
    private String expiryDate;

    // Constructor
    public Item(int id, String name, String category, int quantity, String expiryDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    // Display item details
    public void displayItem() {
        System.out.println("------------------------------------------");
        System.out.println("ID           : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Category     : " + category);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Expiry Date  : " + expiryDate);
        System.out.println("------------------------------------------");
    }

    // Getters
    public int getId()           { return id; }
    public String getName()      { return name; }
    public String getCategory()  { return category; }
    public int getQuantity()     { return quantity; }
    public String getExpiryDate(){ return expiryDate; }

    // Setters
    public void setId(int id)                  { this.id = id; }
    public void setName(String name)           { this.name = name; }
    public void setCategory(String category)   { this.category = category; }
    public void setQuantity(int quantity)      { this.quantity = quantity; }
    public void setExpiryDate(String expiryDate){ this.expiryDate = expiryDate; }
}
