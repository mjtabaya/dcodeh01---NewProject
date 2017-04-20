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
	}
	
	//we call this to make a ShopHelper instance the first time it's called
	//and to limit instantiation to that single instance
	public static ShopHelper getShopHelperInstance() {
		return (sh==null) 
				? new ShopHelper()
				: sh;
	}
	
	public void addToCart(String input, int amount)
	{
		String type = input.substring(0, 0); //expected P, E or T
		try
		{
			if(type=="P")
				cart.addItem(FactoryProducer.getFactory(type).getPotion(input));
			else if(type=="E")
				cart.addItem(FactoryProducer.getFactory(type).getElixir(input));
			else if(type=="T")
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
	private static Cart getCart() {
		return cart;
	}

	private static void setCart(Cart cart) {
		ShopHelper.cart = cart;
	}

}
