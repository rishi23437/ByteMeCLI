package Users;

public class FoodItem {
    /*
    1. Treat <name> as an identifier for an item.
    2. price should be > 0
    3. By default, an item is available
    */
    private final String name;            // NAME OF ITEM CANNOT BE CHANGED
    private int price;                    // Taking prices of items to be integers
    private boolean available;

    public FoodItem(String name, int price) {
        this.name = name;
        this.price = price;
        this.available = true;
    }

    public String getName() { return name; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) { this.available = available; }
}
