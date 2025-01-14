package Orders;

import java.util.HashMap;
import java.util.Map;

import Menu.Item;

public class Order 
{
	
	private HashMap<Item, Integer> orderedItems = new HashMap<>();

    public Order() 
    {
        
    }

    
    public void addItemToOrder(Item item, int quantity) 
    {
        if (orderedItems.containsKey(item)) 
        {
            orderedItems.put(item, orderedItems.get(item) + quantity);
        } 
        else 
        {
            orderedItems.put(item, quantity);
        }
    }

    public double calculateTotalPrice() 
    {
        double totalPrice = 0;
        
        for (Map.Entry<Item, Integer> entry : orderedItems.entrySet()) 
        {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += item.getPrice() * quantity;  
        }

        return totalPrice;
    }

    
    public void displayOrder() {
        
    	if (orderedItems.isEmpty()) 
    	{
            System.out.println("No items in the order.");
        } 
        else 
        {
            System.out.println("Order Details:");
            
            for (Map.Entry<Item, Integer> entry : orderedItems.entrySet()) 
            {
                Item item = entry.getKey();
                int quantity = entry.getValue();
                double price = item.getPrice() * quantity;
                System.out.println(item.getName() + " - Quantity: " + quantity + ", Subtotal: " + price);
            }
            
            double totalPrice = calculateTotalPrice();  
            System.out.println("Total Price: " + totalPrice);
        }
    }
    
//    public void displayOrder() 
//    {
//        if (orderedItems.isEmpty()) 
//        {
//            System.out.println("No items in the order.");
//        } 
//        else 
//        {
//            System.out.println("Order Details:");
//            
//            double totalPrice = 0;
//            
//            for (Map.Entry<Item, Integer> entry : orderedItems.entrySet()) 
//            {
//                Item item = entry.getKey();
//                int quantity = entry.getValue();
//                double price = item.getPrice() * quantity;
//                totalPrice += price;
//                System.out.println(item.getName() + " - Quantity: " + quantity + ", Subtotal: $" + price);
//            }
//            
//            System.out.println("Total Price: $" + totalPrice);
//        }
//    }
	
}
