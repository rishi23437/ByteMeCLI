package Users;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    /*
    1. Password for all admins is "a"
    */

    private static ArrayList<FoodItem> menu;          // CHANGE TO PRIORITY QUEUE

    public Admin(String name) {
        super(name);
        this.password = "a";
        menu = new ArrayList<>();
    }

    // MENU MANAGEMENT
    // 1. Add item
    public void add_item() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the item");
        String name = scan.nextLine();

        System.out.println("Enter the price of the item");
        int price = scan.nextInt();
        scan.nextLine();
        while (price <= 0) {
            System.out.println("Price is non-positive. Enter a positive value for price.");
            price = scan.nextInt();
            scan.nextLine();
        }
        FoodItem item = new FoodItem(name, price);
        menu.add(item);
    }




    public String getName() {
        return this.name;
    }
}
