import Users.Admin;
import Users.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // No need to keep LIST OF ADMINS ig???
    // KEEP LIST OF CUSTOMERS

    public static ArrayList<Customer> customers = new ArrayList<>();

    // RIGHT NOW: DESIGN BY FLOW
    public static void main(String[] args) {
        /*
        Pehle: IDENTIFICATION OF USER -
        1. Ask if Users.Customer of Users.Admin
            a. Users.Admin: sign in using name and password. No need to register them rn
            b. Users.Customer: Signup/login functions
        */
        Scanner sc = new Scanner(System.in);

        System.out.println("\n" +
                " _______             __                     __       __          __ \n" +
                "/       \\           /  |                   /  \\     /  |        /  |\n" +
                "$$$$$$$  |__    __ _$$ |_    ______        $$  \\   /$$ | ______ $$ |\n" +
                "$$ |__$$ /  |  /  / $$   |  /      \\       $$$  \\ /$$$ |/      \\$$ |\n" +
                "$$    $$<$$ |  $$ $$$$$$/  /$$$$$$  |      $$$$  /$$$$ /$$$$$$  $$ |\n" +
                "$$$$$$$  $$ |  $$ | $$ | __$$    $$ |      $$ $$ $$/$$ $$    $$ $$/ \n" +
                "$$ |__$$ $$ \\__$$ | $$ |/  $$$$$$$$/       $$ |$$$/ $$ $$$$$$$$/ __ \n" +
                "$$    $$/$$    $$ | $$  $$/$$       |      $$ | $/  $$ $$       /  |\n" +
                "$$$$$$$/  $$$$$$$ |  $$$$/  $$$$$$$/       $$/      $$/ $$$$$$$/$$/ \n" +
                "         /  \\__$$ |                                                 \n" +
                "         $$    $$/                                                  \n" +
                "          $$$$$$/                                                   ");
        System.out.println("Welcome to our online Food Ordering Application!");

        boolean flag = true;
        while (flag) {
            System.out.println("Enter your role: ");
            System.out.println("0: Quit");
            System.out.println("1: Admin");
            System.out.println("2: Customer");
            if (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Please enter a number!");
                continue;
            }
            int role = sc.nextInt();
            sc.nextLine();

            if (role == 0) {
                break;
            }

            else if (role == 1) {
                // Admin
                System.out.println("Enter admin password: ");
                String password = sc.nextLine();
                if (!password.equals("a")) {
                    System.out.println("Password is incorrect. Try again.");
                    continue;
                }
                System.out.println("Enter your name: ");
                String name = sc.nextLine();
                Admin admin = new Admin(name);
                System.out.println("Admin signed in Successfully.");

                // ADMIN FUNCTIONALITIES
                while (true) {
                    admin.print_functionalities();
                    System.out.print("Which operation would you like to do?");
                    if (!sc.hasNextInt()) {                                   // check for int
                        sc.nextLine();
                        System.out.println("Please enter a number!");
                        continue;
                    }
                    int op = sc.nextInt();
                    sc.nextLine();

                    // Operations
                    if (op == 0) {                                  // No operation, quit
                        System.out.println();
                        break;
                    }
                    else if (op == 1) {
                        admin.add_item();
                        System.out.println();
                    }
                    else if (op == 2) {
                        admin.update_item();
                        System.out.println();
                    }
                    else if (op == 3) {
                        admin.remove_item();
                        System.out.println();
                    }
                    else if (op == 4) {
                        admin.view_orders();
                        System.out.println();
                    }
                    else if (op == 5) {
                        admin.process_orders();
                        System.out.println();
                    }
                    else if (op == 6) {
                        admin.process_refund();
                        System.out.println();
                    }
                    else if (op == 7) {
                        admin.next_day();
                        System.out.println();
                    }
                    else if (op == 8) {
                        admin.daily_sales_report();
                        System.out.println();
                    }
                    else {
                        System.out.println("Enter a valid choice.");
                    }
                }
            }
            else if (role == 2) {
                // Customer
                // LOGIN/SIGNUP
                System.out.println("Enter your name/username: ");
                String name = sc.nextLine();
                System.out.println("Enter your password: ");
                String password = sc.nextLine();

                boolean flag1 = false;                                // for existence of customer with given name and pass
                boolean retry = false;                                // name correct, pass wrong
                Customer customer = new Customer();
                for (Customer c : customers) {
                    if (c.getName().equals(name) && !c.getPassword().equals(password)) {
                        // Customer EXISTS, password is wrong
                        System.out.println("User already exits and password is incorrect. Try again.");
                        retry = true;
                        break;
                    }
                    else if (c.getName().equals(name) && c.getPassword().equals(password)) {
                        // Customer exists, password is right
                        flag1 = true;
                        customer = c;
                    }
                }
                if (retry) {
                    // Customer EXISTS, password is wrong. Retry
                    continue;
                }
                if (flag1) {
                    System.out.println("You have successfully logged in.");
                }
                else {
                    System.out.println("No such user exists with the given name. Do you want to signup?");
                    System.out.println("1. Yes, 2. No");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    if (choice == 1) {
                        customer = new Customer(name, password);
                        customers.add(customer);
                        System.out.println("You have successfully signed up.");
                    }
                    else {
                        // User not signup or logged in.
                        continue;
                    }
                }

                // CUSTOMER FUNCTIONALITIES
                while (true) {
                    customer.print_functionalities();
                    System.out.print("Which operation would you like to do?");
                    if (!sc.hasNextInt()) {                                   // check for int
                        sc.nextLine();
                        System.out.println("Please enter a number!");
                        continue;
                    }
                    int op = sc.nextInt();
                    sc.nextLine();

                    // Operations
                    if (op == 0) {                                  // No operation, quit
                        System.out.println();
                        break;
                    }
                    else if (op == 1) {
                        customer.become_vip();
                        System.out.println();
                    }
                    else if (op == 2) {
                        customer.print_menu();
                        System.out.println();
                    }
                    else if (op == 3) {
                        customer.search();
                        System.out.println();
                    }
                    else if (op == 4) {
                        customer.filter();
                        System.out.println();
                    }
                    else if (op == 5) {
                        customer.sort_menu();
                        System.out.println();
                    }
                    else if (op == 6) {
                        if (customer.isCurrent_pending_order()) {
                            System.out.println("You cannot place an order right now because you already have a pending order.");
                            continue;
                        }
                        customer.place_order();
                        System.out.println();
                    }
                    else if (op == 7) {
                        customer.view_order_status();
                        System.out.println();
                    }
                    else if (op == 8) {
                        customer.cancel_order();
                        System.out.println();
                    }
                    else if (op == 9) {
                        customer.view_order_history();
                        System.out.println();
                    }
                    else if (op == 10) {
                        customer.reorder();
                        System.out.println();
                    }
                    else {
                        System.out.println("Enter a valid choice.");
                    }
                }
            }
            else {
                // Neither admin nor customer
                System.out.println("Enter a valid choice.");
            }
        }
    }
}
