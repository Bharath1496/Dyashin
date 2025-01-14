package Menu;

import java.util.ArrayList;

public class Menu implements MenuFeatures{
	
	private ArrayList<Item> menu = new ArrayList<>();

	public Menu() 
	{
		 
	}
	
	@Override
	public void addItem(String name, double price) 
	{
        for (Item item : menu) 
        {
            if (item.getName().equalsIgnoreCase(name)) 
            {
                System.out.println("Item already exists in the menu.");
                return;
            }
        }
        menu.add(new Item(name, price));
        System.out.println("Item added successfully.");
    }
	
	@Override
	public void removeItem(String name) 
	{
        for (Item item : menu) 
        {
            if (item.getName().equalsIgnoreCase(name)) 
            {
                menu.remove(item);
                System.out.println("Item removed successfully.");
                return;
            }
        }
        System.out.println("Item not found in the menu.");
    }
	
	@Override
	public void updateItemPrice(String name, double newPrice) 
	{
        for (Item item : menu) 
        {
            if (item.getName().equalsIgnoreCase(name)) 
            {
                item.setPrice(newPrice);
                System.out.println("Item price updated successfully.");
                return;
            }
        }
        System.out.println("Item not found in the menu.");
    }
	
	 @Override
	 public void displayMenu() 
	 {
	        
		 if (menu.isEmpty()) 
		 {
	        System.out.println("The menu is empty.");
	     } 
		 else 
	     {
	        System.out.println("Menu Items:");
	         
	        for (Item item : menu) 
	         {
	                System.out.println(item);
	         }
	      }
	  }
	 
	 @Override
	 public Item findItemByName(String name) 
	 {
	        for (Item item : menu) 
	        {
	            if (item.getName().equalsIgnoreCase(name)) 
	            {
	                return item;
	            }
	        }
	        return null;
	    }
	    
}
