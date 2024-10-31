package Users;

import java.util.Stack;

public class Customer extends User {
    private Boolean vip = false;

    // LIFO, therefore sorted based on jo order last khatam hua
    private Stack<Order> order_history = new Stack<Order>();

    public Customer() {
        this.password = null;
    }

    public Customer(String name, String password) {
        super(name);
        this.password = password;
    }

    @Override
    public void print_functionalities() {
        System.out.println("Operations available to perform:");
        System.out.println("0: Quit");
        System.out.println("1: View Menu");
    }

    // BROWSE MENU
    // 1. View All items
    public void print_menu() {
        System.out.println("-----------------------MENU---------------------:");
        for (FoodItem item: FoodItem.menu) {
            System.out.println(item);
            System.out.println();
        }
    }

    // 2. Search Functionality


    public String getName() {
        return this.name;
    }
    public String getPassword() {
        return this.password;
    }

    public Boolean isVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public Stack<Order> getOrder_history() {
        return order_history;
    }
}
