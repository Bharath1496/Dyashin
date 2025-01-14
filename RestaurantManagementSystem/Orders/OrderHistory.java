package Orders;

import java.util.ArrayList;

public class OrderHistory {
	
	
    private ArrayList<Order> orderHistory = new ArrayList<>();
    
    private int orderNumberCounter;

    public OrderHistory() 
    {
    	
        orderNumberCounter = 1;  
    }

    
    public void addOrder(Order order) 
    {
        orderHistory.add(order);
        System.out.println("Order #" + orderNumberCounter + " added to history.");
        orderNumberCounter++;  
    }

    
    public void displayOrderHistory() 
    {
        if (orderHistory.isEmpty()) 
        {
            System.out.println("No orders in the history.");
        } 
        else 
        {
            System.out.println("\nOrder History:");
            
            for (int i = 0; i < orderHistory.size(); i++) 
            {
                Order order = orderHistory.get(i);
                System.out.println("\nOrder #" + (i + 1) + ":");
                order.displayOrder();
            }
        }
    }

}
