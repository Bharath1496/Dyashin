package Management;

import Menu.*;
import Orders.*;
import PaymentHandling.*;
import java.util.Scanner;

public class Customer {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Menu menu = new Menu();
        menu.addItem("Burger", 50);
        menu.addItem("Pizza", 80);
        menu.addItem("Pasta", 70);

        Order order = new Order();
        PaymentHandling paymentHandling = new PaymentHandling();
        OrderHistory orderHistory = new OrderHistory();
        
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Display Menu");
            System.out.println("2. Place an Order");
            System.out.println("3. Order History");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  
            
            switch (choice) {
                case 1:
                    
                    menu.displayMenu();
                    break;
                case 2:
                    
                    placeOrder(menu, order, scanner);
                    displayTotalAndProcessPayment(order, paymentHandling, scanner);
                    orderHistory.addOrder(order);
                    break;
                
                case 3:
                	orderHistory.displayOrderHistory();
                	break;
                case 4:
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void placeOrder(Menu menu, Order order, Scanner scanner) {
        while (true) {
            System.out.print("\nEnter the name of the item to order (or type 'done' to finish): ");
            
            String itemName = scanner.nextLine();
            
            if (itemName.equalsIgnoreCase("done")) {
                break;
            }
            
            Item item = menu.findItemByName(itemName);
            if (item == null) {
                System.out.println("Item not found in the menu.");
                continue;
            }

            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); 

            order.addItemToOrder(item, quantity);
            System.out.println("Added " + quantity + " " + item.getName() + "(s) to your order.");
        }
    }

    private static void displayTotalAndProcessPayment(Order order, PaymentHandling paymentHandling, Scanner scanner) {
       
        order.displayOrder();
        
        while (true) {
            System.out.print("\nEnter payment amount: ");
            
            String input = scanner.nextLine();  

            
            if (!isValidNumericInput(input)) {
                System.out.println("Invalid payment amount! Please enter a valid numeric value.");
                continue;  
            }

            
            double paymentAmount = Double.parseDouble(input);
            
//            double paymentAmount = scanner.nextDouble();

            try {
                
                paymentHandling.processPayment(order, paymentAmount);
                break;  
            } 
            catch (InsufficientPaymentException | InvalidPaymentAmoutException e) 
            {
               
                System.out.println(e.getMessage());
                System.out.println("Please try again.");
            }
        }
     
        
    }
    
    private static boolean isValidNumericInput(String input) {
        
        try {
            Double.parseDouble(input);  
            return true;  
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
