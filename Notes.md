(delete this file later(probably))
(UPDATE this EVERYTIME YOU STOP WORKING: write down what to do next)

# Work log
### Admin Functionalities
- TO DO: Sales Report generation
  - Most popular items: implement <bought>: DONE
  - Sort menu according to bought


### Customer Fucntionalities


# Thinking
How:
- thinking about creating a variable called <bought> which tracks the number of items bought: DONE
- change bought while adding items in orders: DONE
- After each 'day', bought for each item on the menu is reset. Also reset total_sales, and completed_orders: DONE
- Most popular items can be calculated by sorting the menu based on <bought>. You can print name of item.

- change total sales while initiating an order(placing it), cancelling it, and DENYING it: DONE

# Note
- KUCH AISA KARO, JIS SE ORDERS SHOULD ONLY CONTAIN PENDING ORDERS. After completing, cancelling, or denying an order, the order should be REMOVED FROM orders, and ADDED TO CUSTOMER HISTORY.       DONE
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


## Order
- Uniqueness of pending orders: Customer names 


# Collections
I have utilized various collections to implement the following:
- `Menu`: I used an ArrayList.
- `List of current orders` to be processed: I used a Priority Queue, with my self-defined implementation of Comparator().
- `Order History` of each customer: I used a Stack.