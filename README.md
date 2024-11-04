# Byte Me! - Food Ordering System
Byte Me! is a CLI-based Food Ordering System, which manages and facilitates Customer and Admin(Staff) operations. I made this application as a part of my Advanced Programming Course.

## Assumptions
### Food Items
- Prices of food items are taken to be integers(not floating point numbers)
- Name of food item cannot be changed, since an item is identified by its name
- By default, an item is available
- An item can be searched by its name, or filtered by its category.

### Admin
- Password for all admins is "a"
- Special Requests can be added by Customers, and Admins can view them.
- I have simulated dates via assuming that the admin can SWITCH THE DATE to the next day. This is logical because the admin(owner of canteen) should decide when to end sales for the day and wind up. When he does so, daily attributes like number of orders will be reset.
- Therefore, generate the daily sales report before switching to the next day.

### Customer
- I am identifying customers by their names, so the names should be unique. They should be treated as usernames.
- Customers can view the status of refunds by tracking their order histories.
- Customers can search items by name.

### Orders
- 'PENDING' includes preparing, out for delivery, ie., all orders which have not been completed, cancelled or denied are pending. At the time of writing the code, the other types of status WERE NOT MENTIONED
- A single customer can ONLY place a single order at a time. If an order by a customer is 'PENDING', then the customer cannot place another order.
- Admin can ONLY update the status of PENDING orders
- Admin can update the status of orders(process orders) ONLY in the order mentioned in the pdf(Priority to VIPs, then based on arrival time).
- If an order has been DENIED, the customer can view its status(denied) and other details in their ORDER HISTORY.


## Collections
I have utilized various collections to implement the following:
- Menu: I used an ArrayList.
- List of current orders to be processed: I used a Priority Queue, with my self-defined implementation of Comparator().
- Order History of each customer: I used a Stack.