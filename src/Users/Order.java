package Users;

import java.time.Instant;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Order {
    private ArrayList<FoodItem> items;                          // items ordered
    private Customer customer;                      // customer who ordered the item
    private final Instant arrival_time;                   // tracks arrival time

    protected enum Status {PENDING, COMPLETED, CANCELLED, DENIED};
    private Status status;

    protected static PriorityQueue<Order> orders = new PriorityQueue<>(new CustomerPQComparator());

    public Order(ArrayList<FoodItem> items, Customer customer) {
        this.items = items;
        this.customer = customer;
        this.status = Status.PENDING;
        this.arrival_time = Instant.now();
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        // Also use this to CHANGE STATUS TO DENIED FROM PENDING, when ADMIN REMOVES AN ITEM present in the order
        this.status = status;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Instant getArrival_time() {
        return arrival_time;
    }
    public ArrayList<FoodItem> getItems() {
        return items;
    }
}
