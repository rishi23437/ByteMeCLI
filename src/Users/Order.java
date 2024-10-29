package Users;

import java.util.ArrayList;

public class Order {
    private ArrayList<FoodItem> items;                          // items ordered
    private Customer customer;                      // customer who ordered the item
    private enum Status {PENDING, COMPLETED, CANCELLED};

    private Status status;

    public Order(ArrayList<FoodItem> items, Customer customer) {
        this.items = items;
        this.customer = customer;
        this.status = Status.PENDING;
    }
}
