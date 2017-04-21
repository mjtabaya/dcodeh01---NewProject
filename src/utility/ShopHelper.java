package utility;

import exception.InvalidItemException;
import factory.FactoryProducer;
import model.Cart;

//Singleton design pattern, making sure that there's only one shophelper instance handling a cart
//This is the one we call in main to process input and update the cart
public class ShopHelper {
	
	private static Cart cart;
	private static ShopHelper sh;
	
	//constructor is set to private
	private ShopHelper(){
		setCart(new Cart());
		//System.out.println("Cart initialized");
	}
	
	//we call this to make a ShopHelper instance the first time it's called
	//and to limit instantiation to that single instance
	public static ShopHelper getShopHelperInstance() {
		return (sh==null) 
				? sh = new ShopHelper()
				: sh;
	}
	
	public void addToCart(String input, int amount)
	{
		//use this sysout to verify input and amount parameters
		//System.out.println(input + " amount: " + Integer.toString(amount));
		String type = input.substring(0, 1); //expected P, E or T
		try
		{
			if(type.contentEquals("P"))
				for (int i=0; i<amount; i++)
					cart.addItem(FactoryProducer.getFactory(type).getPotion(input));
			else if(type.contentEquals("E"))
				for (int i=0; i<amount; i++)
					cart.addItem(FactoryProducer.getFactory(type).getElixir(input));
			else if(type.contentEquals("T"))
				for (int i=0; i<amount; i++)
					cart.addItem(FactoryProducer.getFactory(type).getTrinket(input));
			else
				throw new InvalidItemException();
		}
		catch (InvalidItemException iie)
		{
			System.err.println("Add to Cart: " + iie.getMessage());
		}
	}

	//use by Display
	public static Cart getCart() {
		return cart;
	}

	private static void setCart(Cart cart) {
		ShopHelper.cart = cart;
	}

}
