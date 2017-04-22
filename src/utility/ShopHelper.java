package utility;

import exception.InvalidItemException;
import factory.FactoryProducer;
import model.Cart;
import model.Inventory;
import model.Item;

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
	
	//********we call this to make a ShopHelper instance the first time it's called*****//
	//****************and to limit instantiation to that single instance****************//
	public static ShopHelper getShopHelperInstance() 
	{return (sh==null) ? sh = new ShopHelper(): sh;}
	
	public String inputToCode(String input)
	{
		return null;
	}
	
	
	public boolean processItem(String input, int amount)
	{
		//********use this sysout to verify input and amount parameters**************//
		//********System.out.println(input + " amount: " + Integer.toString(amount));//
		String type = input.substring(0, 1); //expected P, E or T
		boolean successful = false;
		try
		{
			int i =0;
			if(type.contentEquals("P"))
				for (i=0; i<amount; i++)
					successful = addToCart(type,input);
			else if(type.contentEquals("E"))
				for (i=0; i<amount; i++)
					successful = addToCart(type,input);
			else if(type.contentEquals("T"))
				for (i=0; i<amount; i++)
					successful = addToCart(type,input);
			else
				throw new InvalidItemException();
		}
		catch (InvalidItemException iie)
		{
			System.err.println("Add to Cart: " + iie.getMessage());
		}
		return successful;
	}

	
	//use for fetching from inventory, deducting from stock
	private boolean addToCart(String type, String code)
	{
		if (inventory.fetchItem(code)) //if item was fetched successfully
		{
			if(type.equals("P"))
				cart.addItem(FactoryProducer.getFactory(type).getPotion(code));
			else if(type.equals("E"))
				cart.addItem(FactoryProducer.getFactory(type).getElixir(code));
			else if(type.equals("T"))
				cart.addItem(FactoryProducer.getFactory(type).getTrinket(code));
			return true;
		}
		else
			return false;
	}
	
	//use for displaying stock only
	public int checkInventory(String itemCode)
	{
		return inventory.checkStock(itemCode);
	}
	

	//use by Display
	public static Cart getCart() 
	{
		if(sh==null)
				sh = new ShopHelper();
		return cart;
	}

	private static void setCart(Cart cart) {ShopHelper.cart = cart;}

}
