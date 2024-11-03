package Users;

import java.util.Scanner;
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
        System.out.println("1: Become a VIP");
        System.out.println("2: View Menu");
        System.out.println("3: Search for an item");
        System.out.println("4: Filter items based on categories");
        System.out.println("5: Sort items based on their prices(ascending/descending order)");
    }

    // 1. BECOME VIP
    public void become_vip() {
        Scanner scan = new Scanner(System.in);
        System.out.println("You have to pay Rs.1000. Do you want to continue? (Y/N)");
        String choice = scan.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            this.vip = true;
            System.out.println("You are now a VIP!");
        }
    }

    // BROWSE MENU
    // 2. View All items
    public void print_menu() {
        System.out.println("-----------------------MENU---------------------:");
        for (FoodItem item: FoodItem.menu) {
            System.out.println(item);
            System.out.println();
        }
    }

    // 3. Search Functionality
    public void search() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the name of the item you would like to search:");
        String name = scan.nextLine().toUpperCase();
        for (FoodItem item: FoodItem.menu) {
            if (name.equals(item.getName())) {
                System.out.println(item);
                return;
            }
        }
        System.out.println("Item with given name not found.");
    }

    // 4. Filter by Category
    public void filter() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the category of items which you would like to search:");
        String category = scan.nextLine().toUpperCase();

        boolean found = false;
        for (FoodItem item: FoodItem.menu) {
            if (category.equals(item.getCategory())) {
                System.out.println(item);
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No item with the given category exists in the menu.");
        }
    }

    public void sort_menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to sort the items in ascending or descending order? (A/D):");
        String choice = scan.nextLine().toUpperCase();

        FoodItem.menu.sort(new MenuComparator());
        if (choice.equalsIgnoreCase("a")) {
            // Complete this, and descending order wala case
            System.out.println("Food Items sorted by prices in ascending order:");
            for (FoodItem item: FoodItem.menu) {
                System.out.println(item);
                System.out.println();
            }
        }
        else {
            System.out.println("Food Items sorted by prices in descending order:");
            for (int i = FoodItem.menu.size() - 1; i >= 0; i--) {
                System.out.println(FoodItem.menu.get(i));
                System.out.println();
            }
        }
    }



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
