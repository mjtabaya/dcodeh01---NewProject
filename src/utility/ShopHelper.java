package utility;

import exception.InvalidItemException;
import factory.FactoryProducer;
import model.Cart;
import model.Inventory;

//Singleton design pattern, making sure that there's only one shophelper instance handling a cart
//This is the one we call in main to process input and update the cart
public class ShopHelper {
	
	//static sets only one instance of each field
	private static Cart cart;
	private static Inventory inventory;
	private static ShopHelper sh;
	
	//constructor is set to private
	private ShopHelper()
	{
		setCart(new Cart());
		inventory = new Inventory();
		//System.out.println("Cart and inventory initialized");
	}
	
	//we call this to make a ShopHelper instance the first time it's called
	//and to limit instantiation to that single instance
	public static ShopHelper getShopHelperInstance() 
	{return (sh==null) ? sh = new ShopHelper(): sh;}
	
	public void addToCart(String input, int amount)
	{
		//use this sysout to verify input and amount parameters
		//System.out.println(input + " amount: " + Integer.toString(amount));
		String type = input.substring(0, 1); //expected P, E or T
		
		try
		{
			int i =0;
			if(type.contentEquals("P"))
				for (i=0; i<amount; i++)
					addToCart(type,input);
			else if(type.contentEquals("E"))
				for (i=0; i<amount; i++)
					addToCart(type,input);
			else if(type.contentEquals("T"))
				for (i=0; i<amount; i++)
					addToCart(type,input);
			else
				throw new InvalidItemException();
		}
		catch (InvalidItemException iie)
		{
			System.err.println("Add to Cart: " + iie.getMessage());
		}
	}

	//use by Display
	public static Cart getCart() {return cart;}

	private static void setCart(Cart cart) {ShopHelper.cart = cart;}
	
	//use for fetching from inventory, deducting from stock
	public void addToCart(String type, String code)
	{
		if (inventory.fetchItem(code)) //if item was fetched successfully
		{
			cart.addItem(FactoryProducer.getFactory(type).getPotion(code));
		}
		//else
			//do out of stock display
	}
	
	//use for displaying stock only
	public boolean checkInventory(String itemCode)
	{
		return inventory.checkStock(itemCode);
	}
	
	
	
	

}
