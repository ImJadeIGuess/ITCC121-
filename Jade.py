#step 1
# List of available menu items with their names and prices
menu = [
    {"name": "Burger", "price": 50},
    {"name": "Fries", "price": 30},
    {"name": "Soda", "price": 20},
    {"name": "Chicken Nuggets", "price": 40},
    {"name": "Ice Cream", "price": 25},
    {"name": "Coffee", "price": 35},
    {"name": "Hotdog", "price": 45},
    {"name": "Salad", "price": 30},
    {"name": "Pizza Slice", "price": 60},
    {"name": "Milkshake", "price": 50},
]

#step 7
# Starting ticket number for each order
ticket_number = 1000

#step 2
# Main loop to allow multiple customers/orders
while True:
    order = []  # Stores the items in the current customer's order
    print("\n--- Order Start ---")

    # Inner loop to handle item selection for the current order
    while True:
        # Display menu
        print("\nJade's Menu:")
        for index in range(len(menu)):
            print(f"{index}. {menu[index]['name']} - ₱{menu[index]['price']}")

        print("\nChoose item number to order, 'v' to view order, 'f' to finish, or 'q' to quit.\n")
        choice = input("Your choice: ").lower()

        # exit the program program
        if choice == 'q':
            print("Thanks for visiting! Goodbye!")
            exit()
#step 3 elif f for finishing order
        # Finish the order by pressing 'f' and print the bill
        elif choice == 'f':
            if order:
                ticket_number += 1  # Iincrement it
                print(f"\nTicket Number: {ticket_number}")
                print("----------------")
                print("Order Receipt:")
                print("----------------")
                total = 0
                for item in order:
                    cost = item['quantity'] * item['price']
                    total += cost
                    print(f"{item['item']} x{item['quantity']} @ ₱{item['price']} = ₱{cost}")
                    print("----------------")
                print(f"Total: ₱{total}")
                print("----------------")
                print("Thank you for your order!")
            else:
                print("You didn't order anything.")
            break  # use break to exit the loopr

#step 5
        # Press 'v' to view current items in the order
        elif choice == 'v':
            if order:
                print("\n--- Current Order ---")
                subtotal = 0
                for item in order:
                    cost = item['quantity'] * item['price']
                    subtotal += cost
                    print(f"{item['item']} x{item['quantity']} @ ₱{item['price']} = ₱{cost}")
                    print("----------------")
                print(f"Subtotal: ₱{subtotal}")
            else:
                print("You haven't added anything to your order yet.")

#step 6
        # If statement
        elif choice.isdigit() and 0 <= int(choice) < len(menu):
            quantity = input("Enter quantity: ")
            if quantity.isdigit() and int(quantity) > 0:
                index = int(choice)  # Converts user -> to index
                order.append({
                    "item": menu[index]["name"],
                    "quantity": int(quantity),
                    "price": menu[index]["price"]
                })
                print(f"Added {quantity} x {menu[index]['name']} to your order.")
            else:
                print("Invalid quantity. Please enter a positive number.")

        # this one handles any other invalid inputs
        else:
            print("Invalid input. Please try again.")
