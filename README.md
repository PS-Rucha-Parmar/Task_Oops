# Kitchen Inventory Manager

A simple Java CLI application to manage kitchen grocery items.
Built as a university Object-Oriented Programming (OOP) assignment.

---

## Problem Statement

Managing kitchen inventory manually is inconvenient. Items run out, expire, or
get forgotten. This application provides a simple menu-driven system to keep
track of grocery items stored in the kitchen.

---

## Project Objective

Build a beginner-friendly Java application that demonstrates core OOP concepts:
- Classes and Objects
- Encapsulation
- Inheritance
- Functions (methods)
- Debugging

---

## Features

1. Add Item — store a new grocery item
2. View Items — display all items in the inventory
3. Search Item — find an item by name
4. Update Quantity — change the quantity of an existing item
5. Delete Item — remove an item from the inventory
6. Exit — close the application

---

## Technologies Used

- Language  : Java (Core Java only)
- Interface : Command Line Interface (CLI)
- Input     : Scanner class
- Storage   : ArrayList (in-memory, no database)
- IDE       : Any Java-supported IDE (IntelliJ IDEA, Eclipse, VS Code)

---

## Project Structure

```
KitchenInventoryManager/
│
├── src/
│   ├── Item.java            → Base class (Encapsulation)
│   ├── PerishableItem.java  → Subclass (Inheritance)
│   ├── Inventory.java       → CRUD operations on ArrayList
│   └── Main.java            → Menu, input handling, driver code
│
├── README.md
├── DebuggingReport.md
└── .gitignore
```

---

## Explanation of Every Class

### Item.java
The base class that represents a single grocery item.

All fields are **private** (Encapsulation):
- `id`         → unique item number
- `name`       → item name (e.g. Milk)
- `category`   → item category (e.g. Dairy)
- `quantity`   → how many units are available
- `expiryDate` → expiry date as a string (e.g. 25-07-2026) or N/A

Methods:
- `displayItem()` → prints all item details on screen
- Getters and Setters for every field

---

### PerishableItem.java
Extends `Item` to demonstrate **Inheritance**.

- Uses `super()` in its constructor to pass values to `Item`
- Overrides `displayItem()` using `@Override` to also print "Type : Perishable Item"

This class is intentionally kept simple. Its only purpose is to show how
one class can inherit from another in Java.

---

### Inventory.java
Manages the collection of items using `ArrayList<Item>`.

Methods:
- `addItem(Item item)`            → adds an item to the list
- `viewItems()`                   → prints all items
- `searchItem(String name)`       → finds items by name
- `updateItem(int id, int qty)`   → updates quantity for a given ID
- `deleteItem(int id)`            → removes item by ID

No other logic exists in this class.

---

### Main.java
The entry point of the application.

Responsibilities:
- Displays the menu using `printMenu()`
- Reads user input using `Scanner`
- Calls appropriate `Inventory` methods based on the user's choice
- Contains a helper method `readInt()` to safely read integers

---

## How CRUD Works

| Operation | Method Called       | What Happens                        |
|-----------|---------------------|-------------------------------------|
| Create    | `addItem()`         | New Item object added to ArrayList  |
| Read      | `viewItems()`       | Loops through list and prints items |
| Search    | `searchItem()`      | Finds item by matching name         |
| Update    | `updateItem()`      | Finds item by ID, sets new quantity |
| Delete    | `deleteItem()`      | Finds item by ID, removes from list |

---

## OOP Concepts Demonstrated

### Encapsulation
All fields in `Item.java` are declared `private`.
They cannot be accessed directly from outside the class.
Access is provided only through public getter and setter methods.

Example:
```java
private int quantity;           // cannot be accessed directly

public int getQuantity() {      // controlled read access
    return quantity;
}

public void setQuantity(int quantity) {  // controlled write access
    this.quantity = quantity;
}
```

### Inheritance
`PerishableItem` extends `Item`.
It inherits all fields and methods from `Item` without rewriting them.
It overrides `displayItem()` to add extra output.

Example:
```java
public class PerishableItem extends Item {
    public PerishableItem(int id, String name, String category,
                          int quantity, String expiryDate) {
        super(id, name, category, quantity, expiryDate); // calls Item constructor
    }

    @Override
    public void displayItem() {
        super.displayItem();                             // calls Item's method
        System.out.println("Type : Perishable Item");
    }
}
```

### Classes and Objects
Four classes are defined: `Item`, `PerishableItem`, `Inventory`, `Main`.

Objects are created in `Main.java`:
```java
Item item = new Item(1, "Rice", "Grains", 10, "N/A");
PerishableItem milk = new PerishableItem(2, "Milk", "Dairy", 5, "25-07-2026");
```

### Functions (Methods)
Every action in the project is a method:
- `addItem()`, `viewItems()`, `searchItem()`, `updateItem()`, `deleteItem()`
- `printMenu()`, `readInt()`, `displayItem()`

### Debugging
An intentional bug was introduced in `updateItem()` where quantity was
accidentally increased instead of replaced. The bug was identified using
the IDE debugger and fixed. See `DebuggingReport.md` for the full walkthrough.

---

## How Each Assignment Requirement is Satisfied

| Requirement  | How it is satisfied                                         |
|--------------|-------------------------------------------------------------|
| Functions    | Methods like addItem(), viewItems(), displayItem(), etc.    |
| Classes      | Item, PerishableItem, Inventory, Main                       |
| Objects      | Item and PerishableItem instances created in Main.java      |
| Encapsulation| Private fields + public getters/setters in Item.java        |
| Inheritance  | PerishableItem extends Item with super() and @Override      |
| Debugging    | Bug introduced, documented, debugged, and fixed             |

---

## Project Workflow

```
User launches app
       ↓
Menu is displayed
       ↓
User selects option (1–6)
       ↓
Main.java reads input and calls Inventory method
       ↓
Inventory performs operation on ArrayList<Item>
       ↓
Result is printed to console
       ↓
Menu repeats until user chooses Exit (6)
```

---

## Compilation Instructions

Open PowerShell or Command Prompt.

Navigate to the project folder:
```
cd "C:\Users\RuchaParmar\Downloads\Oops_Project\KitchenInventoryManager"
```

Compile all Java files:
```
javac src\Item.java src\PerishableItem.java src\Inventory.java src\Main.java
```

> If javac is not found in PATH, use the full path:
> `& "C:\Program Files\Java\jdk-26.0.1\bin\javac.exe" src\Item.java src\PerishableItem.java src\Inventory.java src\Main.java`

---

## Execution Instructions

Run the application after compiling:
```
java src.Main
```

> If java is not found in PATH, use the full path:
> `& "C:\Program Files\Java\jdk-26.0.1\bin\java.exe" src.Main`

---

## Sample Output

```
Welcome to Kitchen Inventory Manager!

==============================
  Kitchen Inventory Manager  
==============================
1. Add Item
2. View Items
3. Search Item
4. Update Quantity
5. Delete Item
6. Exit
==============================
Enter your choice: 1

--- Add New Item ---
Enter name: Milk
Enter category (e.g. Dairy, Grains): Dairy
Enter quantity: 5
Enter expiry date (dd-MM-yyyy) or N/A: 25-07-2026
Is this a perishable item? (y/n): y
Item added successfully!
```

---

## Future Improvements

- Save inventory to a file so data persists after the program exits
- Add expiry date validation
- Add a low stock alert when quantity drops below a threshold
- Allow updating item name and category, not just quantity

---

## Author

Name    : Rucha Parmar  
Task of : Oops  
College :  Charusat University
Year    : Fourth Year Engineering
