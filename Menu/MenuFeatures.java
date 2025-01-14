package Menu;

public interface MenuFeatures {
	public void addItem(String name, double price);
	public void removeItem(String name);
	public void updateItemPrice(String name, double newPrice);
	public void displayMenu();
	public Item findItemByName(String name);
	
}
