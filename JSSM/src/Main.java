import java.util.*;

public class Main {
    static int ticketNumber = 1000;
    // create stat classes
    static class MenuItem {
        String name;
        int price;

        MenuItem(String name, int price) { //this the menu items
            this.name = name;
            this.price = price;
        }
    }

    static class OrderItem { //this is where the quantity and the prices of the orders
        String item;
        int quantity;
        int price;

        OrderItem(String item, int quantity, int price) {
            this.item = item;
            this.quantity = quantity;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //use scanner for user input
        // step 1 create the menu
        List<MenuItem> menu = Arrays.asList(
                new MenuItem("Burger", 50),
                new MenuItem("Fries", 30),
                new MenuItem("Soda", 20),
                new MenuItem("Chicken Nuggets", 40),
                new MenuItem("Ice Cream", 25),
                new MenuItem("Coffee", 35),
                new MenuItem("Hotdog", 45),
                new MenuItem("Salad", 30),
                new MenuItem("Pizza Slice", 60),
                new MenuItem("Milkshake", 50)
        );

        // step 2 use while true for loop
        while (true) {
            List<OrderItem> order = new ArrayList<>();
            System.out.println("\n--- Order Start ---");

            while (true) {
                // displays the menu
                System.out.println("\nMenu:");
                for (int i = 0; i < menu.size(); i++) {
                    MenuItem m = menu.get(i);
                    System.out.printf("%d. %s - ₱%d%n", i, m.name, m.price);
                }

                System.out.println("\nChoose item number to order, 'v' to view order, 'f' to finish, or 'q' to quit.");
                System.out.print("Your choice: ");
                String choice = scanner.nextLine().toLowerCase();

                if (choice.equals("q")) {
                    System.out.println("Thanks for visiting! Goodbye!");
                    System.exit(0);
                } else if (choice.equals("f")) {
                    if (!order.isEmpty()) {
                        ticketNumber++;
                        System.out.printf("\nTicket Number: %d%n", ticketNumber);
                        System.out.println("----------------");
                        System.out.println("Order Receipt:");
                        System.out.println("----------------");
                        int total = 0;
                        for (OrderItem item : order) {
                            int cost = item.quantity * item.price;
                            total += cost;
                            System.out.printf("%s x%d @ ₱%d = ₱%d%n", item.item, item.quantity, item.price, cost);
                            System.out.println("----------------");
                        }
                        System.out.printf("Total: ₱%d%n", total);
                        System.out.println("----------------");
                        System.out.println("Thank you for your order!");
                    } else {
                        System.out.println("You didn't order anything.");
                    }
                    break;
                } else if (choice.equals("v")) {
                    if (!order.isEmpty()) {
                        System.out.println("\n--- Current Order ---");
                        int subtotal = 0;
                        for (OrderItem item : order) {
                            int cost = item.quantity * item.price;
                            subtotal += cost;
                            System.out.printf("%s x%d @ ₱%d = ₱%d%n", item.item, item.quantity, item.price, cost);
                            System.out.println("----------------");
                        }
                        System.out.printf("Subtotal: ₱%d%n", subtotal);
                    } else {
                        System.out.println("You haven't added anything to your order yet.");
                    }
                } else if (choice.matches("\\d+")) {
                    int index = Integer.parseInt(choice);
                    if (index >= 0 && index < menu.size()) {
                        System.out.print("Enter quantity: ");
                        String quantityInput = scanner.nextLine();
                        if (quantityInput.matches("\\d+") && Integer.parseInt(quantityInput) > 0) {
                            int qty = Integer.parseInt(quantityInput);
                            MenuItem selected = menu.get(index);
                            order.add(new OrderItem(selected.name, qty, selected.price));
                            System.out.printf("Added %d x %s to your order.%n", qty, selected.name);
                        } else {
                            System.out.println("Invalid quantity. Please enter a positive number.");
                        }
                    } else {
                        System.out.println("Invalid item number.");
                    }
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        }
    }
}
