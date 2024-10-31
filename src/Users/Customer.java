package Users;

public class Customer extends User {
    private Boolean vip = false;

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
            System.out.println("\n");
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
}
