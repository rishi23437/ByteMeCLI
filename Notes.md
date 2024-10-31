(delete this file later(probably))
(UPDATE this EVERYTIME YOU STOP WORKING: write down what to do next)

# Work log
### Admin: Menu Management
- Order Management - Admin
- KUCH AISA KARO, JIS SE ORDERS SHOULD ONLY CONTAIN PENDING ORDERS. After completing, cancelling, or denying an order, the order should be REMOVED FROM orders, and ADDED TO CUSTOMER HISTORY


# Note
- KUCH AISA KARO, JIS SE ORDERS SHOULD ONLY CONTAIN PENDING ORDERS. After completing, cancelling, or denying an order, the order should be REMOVED FROM orders, and ADDED TO CUSTOMER HISTORY
- Wherever you can take input with Strings(maybe y/n), prefer that over integers
- For each item, you SHOULD MAKE DIFFERENT OBJECTS:
  - Item should be identified by its name, and an object should be in the menu(special request = null)
  - For the same item in an order list of a customer, create a SEPARATE object for the item(identify using name):
    - Ask for special request
- 4, 5 of Admin functionalities NOT CHECKED YET(NOT RUN), because checking them involves placing orders. Check after some Customer Order functionalities have been introduced
- THINKING CURRENTLY: to process VIP orders first, make a process_orders() method for Admins, which asks them how many orders do they want to process. It processes the orders in standard order(vip, fifo). NO CHOICE OF ADMIN.

# Users
## Customer(Students)
- Browse canteen menu
- place orders
- track delivery
(Maintain order histories)


## Admin(Canteen staff)
- Manage menu(update, delete, etc items from the menu)
- Process orders efficiently
- Daily Sales Report

## Collections will be used for
- Menu: Note - You will have to sort by price. USE PQ, tab sorted honge
- List of current orders to be processed
- Order History of each customer

## Order
- Uniqueness of pending orders: Customer names 