package Users;

import java.time.Instant;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Order {
    private ArrayList<FoodItem> items;                          // items ordered
    private ArrayList<Integer> quantities;
    private int total_price;
    private Customer customer;                      // customer who ordered the item
    private final Instant arrival_time;                   // tracks arrival time
    protected static int total_sales = 0;
    protected static int completed_orders = 0;

    protected enum Status {PENDING, COMPLETED, CANCELLED, DENIED};
    private Status status;

    protected static ArrayList<Order> cancelled_or_denied_orders = new ArrayList<>();
    private boolean refund;

    // contains only current pending orders
    protected static PriorityQueue<Order> orders = new PriorityQueue<>(new CustomerPQComparator());

    public Order(ArrayList<FoodItem> items, ArrayList<Integer> quant, Customer customer, int price) {
        this.items = items;
        this.customer = customer;
        this.quantities = quant;
        this.total_price = price;
        this.status = Status.PENDING;
        this.arrival_time = Instant.now();
        total_sales += price;
    }


    public void print_info() {
        System.out.println("Customer: " + customer.getName() + "\n");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).toString());
            System.out.println("Quantity: " + quantities.get(i));
            System.out.println();
        }
        System.out.println("Status: " + this.status);
        if (status == Status.CANCELLED && !refund) {
            System.out.println("Refund not processed yet.");
        }
        else if (status == Status.CANCELLED && refund) {
            System.out.println("Refund completed!");
        }
    }


    public Status getStatus() { return status; }
    public void setStatus(Status status) {
        // Also use this to CHANGE STATUS TO DENIED FROM PENDING, when ADMIN REMOVES AN ITEM present in the order
        this.status = status;
        if (status == Status.CANCELLED || status == Status.DENIED) {
            total_sales -= this.total_price;
            cancelled_or_denied_orders.add(this);
            refund = false;

            for (int i = 0; i < items.size(); i++) {
                for (FoodItem menu_item: FoodItem.menu) {
                    if (items.get(i).getName().equals(menu_item.getName())) {
                        // Resetting <bought>
                        menu_item.bought -= quantities.get(i);
                    }
                }
            }
        }
        if (status == Status.COMPLETED) {
            completed_orders++;
        }
    }
    public Customer getCustomer() { return customer; }
    public Instant getArrival_time() { return arrival_time; }
    public ArrayList<FoodItem> getItems() { return items; }
    public void setRefund(boolean refund) { this.refund = refund; }
    public ArrayList<Integer> getQuantities() { return quantities; }
    public int getTotal_price() { return total_price; }
}
