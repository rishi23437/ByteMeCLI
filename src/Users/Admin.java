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
        System.out.println("4: View Pending orders");
        System.out.println("5: Process Orders");
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
            }
            required_item.setPrice(price);
            System.out.println("Price updated successfully.");
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

    // ORDER MANAGEMENT
    // 4. View pending orders
    public void view_orders() {
        // ASSUMING orders ONLY HAS PENDING ORDERS
        System.out.println("-------------------------ORDERS-------------------------");
        Iterator<Order> it = Order.orders.iterator();
        int index = 1;
        while (it.hasNext()) {
            Order order = it.next();
            System.out.println("Order " + index + ":");
            order.print_info();
            System.out.println();
        }
    }

    // Update order status. Status will be updated(order will be processed) only by Admin(process_orders()), except when customer cancels order.
    public boolean update_order_status(Order o) {
        Scanner scan = new Scanner(System.in);
        o.print_info();
        System.out.println("Enter the new status for the order:");
        String new_status = scan.nextLine().toUpperCase();
        if (new_status.equalsIgnoreCase(Order.Status.COMPLETED.toString())) {
            o.setStatus(Order.Status.COMPLETED);
            o.getCustomer().getOrder_history().push(o);
        }
        else if (new_status.equalsIgnoreCase(Order.Status.CANCELLED.toString())) {
            o.setStatus(Order.Status.CANCELLED);
            o.getCustomer().getOrder_history().push(o);
        }
        else if (new_status.equalsIgnoreCase(Order.Status.DENIED.toString())) {
            o.setStatus(Order.Status.DENIED);
            o.getCustomer().getOrder_history().push(o);
        }
        else {
            System.out.println("Entered status is invalid or already set.");
            return false;
        }
        System.out.println("Order status updated successfully.");
        Order.orders.remove(o);
        return true;
    }

    // 5. Process orders(finish them, change their status)
    public void process_orders() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Total number of orders pending: " + Order.orders.size());
        System.out.println("How many orders do you want to process?");
        if (!scan.hasNextInt()) {                                   // check for int
            scan.nextLine();
            System.out.println("Please enter a number!");
            return;
        }
        int num_of_orders = scan.nextInt();
        scan.nextLine();
        while (num_of_orders < 0 || num_of_orders > Order.orders.size()) {
            System.out.println("Number of orders is either not positive or greater than the total number of orders.");
            if (!scan.hasNextInt()) {                                   // check for int
                scan.nextLine();
                System.out.println("Please enter a number!");
                continue;
            }
            num_of_orders = scan.nextInt();
            scan.nextLine();
        }
        if (num_of_orders == 0) {
            System.out.println("No orders processed");
            return;
        }

        // Now number of orders is positive
        Iterator<Order> it = Order.orders.iterator();
        int count = 0;
        while (count < num_of_orders) {
            Order order = it.next();
            boolean success = update_order_status(order);
            if (!success) {
                System.out.println("Some orders were not processed because of invalid status.");
                return;
            }
            count++;
        }
    }


    public String getName() {
        return this.name;
    }
}
