# Byte Me! - Food Ordering System
Byte Me! is a CLI-based Food Ordering System, which manages and facilitates Customer and Admin(Staff) operations. I made this application as a part of my Advanced Programming Course.

## Assumptions
### Food Items
- Prices of food items are taken to be integers(not floating point numbers)
- Name of food item cannot be changed
- By default, an item is available
- An item can be searched by its name, or filtered by its category.

### Admin
- Password for all admins is "a"

### Customer
- I am identifying customers by their names, so the names should be unique. They should be treated as usernames.

### Orders
- 'PENDING' includes preparing, out for delivery, ie., all orders which have not been completed, cancelled or denied are pending.
- A single customer can ONLY place a single order at a time. If an order by a customer is 'PENDING', then the customer cannot place another order.
- Admin can ONLY update the status of PENDING orders
- Admin can update the status of orders(process orders) ONLY in the order mentioned in the pdf(Priority to VIPs, then based on arrival time).


## Collections
I have utilized various collections to implement the following:
- Menu: I used an ArrayList.
- List of current orders to be processed: I used a Priority Queue, with my self-defined implementation of Comparator().
- Order History of each customer: I used a Stack.
