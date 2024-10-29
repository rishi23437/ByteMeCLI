package Users;

public class Customer extends User {
    public Customer() {
        this.password = null;
    }

    public Customer(String name, String password) {
        super(name);
        this.password = password;
    }

    public String getName() {
        return this.name;
    }
    public String getPassword() {
        return this.password;
    }
}
