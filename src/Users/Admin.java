package Users;

import java.util.*;

public class Admin extends User {
    /*
    1. Password for all admins is "a"
    */

    /*
    MANAGING ORDERS:
    Priorities -
    1. VIP Customer
    2. First in First Out
    */

    public Admin(String name) {
        super(name);
        this.password = "a";
    }

    @Override
    public void print_functionalities() {
        System.out.println("Operations available to perform:");
        System.out.println("0: Quit");
        System.out.println("1: Add Food Item");
        System.out.println("2: Update Food Item");
        System.out.println("3: Remove Food Item");
    }


    // MENU MANAGEMENT
    // 1. Add item
    public void add_item() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the item");
        String name = scan.nextLine().toUpperCase();

        for (FoodItem item : FoodItem.menu) {
            if (name.equals(item.getName())) {
                System.out.println("Item already exists. Choose a different name or perform a different operation.");
                return;
            }
        }

        System.out.println("Enter the category of the item");
        String category = scan.nextLine().toUpperCase();

        System.out.println("Enter the price of the item");
        if (!scan.hasNextInt()) {                                   // check for int
            scan.nextLine();
            System.out.println("Please enter a number!");
            return;
        }
        int price = scan.nextInt();
        scan.nextLine();
        while (price <= 0) {
            System.out.println("Price is non-positive. Enter a positive value for price.");
            if (!scan.hasNextInt()) {                                   // check for int
                scan.nextLine();
                System.out.println("Please enter a number!");
                continue;
            }
            price = scan.nextInt();
            scan.nextLine();
        }
        FoodItem item = new FoodItem(name, category, price);
        FoodItem.menu.add(item);
        System.out.println("Item added successfully.");
    }

    // 2. Update Item Details(Price and/or Availability)
    public void update_item() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the item");
        String name = scan.nextLine();

        // Searching for item
        FoodItem required_item = null;
        for (FoodItem item : FoodItem.menu) {
            if (name.toUpperCase().equals(item.getName())) {
                required_item = item;
                System.out.println(item);                       // uses toString of FoodItem
            }
        }
        if (required_item == null) {
            System.out.println("Item with given name not found.");
            return;
        }

        boolean done = false;
        // Changing availability if required
        System.out.println("Do you want to change the Availability of the item? Enter Y/N");
        String choice = scan.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            done = true;
            System.out.println("Should the item be available or not? 1: available, any other number: not available");
            if (!scan.hasNextInt()) {                                   // check for int
                scan.nextLine();
                System.out.println("Please enter a number!");
                return;
            }
            int c = scan.nextInt();
            scan.nextLine();
            boolean b = c == 1;                     // if c: 1 -> b = true, else b -> false ie., short if statement
            required_item.setAvailable(b);
            System.out.println("Availability updated successfully.");
        }

        // Changing price if required
        System.out.println("Do you want to change the Price of the item? Enter Y/N");
        choice = scan.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            done =  true;
            System.out.println("Enter the new price of the item");
            if (!scan.hasNextInt()) {                                   // check for int
                scan.nextLine();
                System.out.println("Please enter a number!");
                return;
            }
            int price = scan.nextInt();
            scan.nextLine();
            while (price <= 0) {
                System.out.println("Price is non-positive. Enter a positive value for price.");
                if (!scan.hasNextInt()) {                                   // check for int
                    scan.nextLine();
                    System.out.println("Please enter a number!");
                    continue;
                }
                price = scan.nextInt();
                scan.nextLine();
                required_item.setPrice(price);
                System.out.println("Price updated successfully.");
            }
        }
        if (!done) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }
        System.out.println("Item details updated successfully.");
    }

    // 3. Remove item
    public void remove_item() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the item to be removed");
        String name = scan.nextLine().toUpperCase();

        for (FoodItem item: FoodItem.menu) {
            if (name.equals(item.getName())) {
                System.out.println("The required item has been found.");
                System.out.println(item);

                // Changing status of all pending orders containing the item to "denied"
                Iterator<Order> it = Order.orders.iterator();
                while (it.hasNext()) {
                    Order order = it.next();
                    for (FoodItem food: order.getItems()) {
                        if (food.getName().equals(item.getName()) && order.getStatus().equals(Order.Status.PENDING)) {
                            order.setStatus(Order.Status.DENIED);
                        }
                    }
                }

                FoodItem.menu.remove(item);
                System.out.println("Item removed successfully.");
                return;
            }
        }
        System.out.println("Item with the given name not found. Please try again.");
    }

    


    public String getName() {
        return this.name;
    }
}
