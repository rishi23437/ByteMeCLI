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

        boolean flag = true;
        while (flag) {
            System.out.println("Enter your role(1 for Admin, 2 for Customer, 0 to quit): ");
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

            }
            else {
                // Neither admin nor customer
                System.out.println("Enter a valid choice.");
            }
        }
    }
}
