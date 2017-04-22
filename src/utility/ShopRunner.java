package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import view.Display;

public class ShopRunner {
	
	//** runShop() is the one we call in main
	//** Display.state determines what state our shop is in
	//** codes: Add=1 Remove=2 Describe=3 Checkout=4
	//** subcodes: ItemAmount=12 RemoveAmount=22 CardInput=42

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String itemInput = "";
	static int amountInput = 0;
	static String cardInput = "";
	
	public static void runShop()
	{
		Display.setIsOpen(true);
		try
		{
			while(Display.isOpen())
			{
				Display.loadScreen(1);;
				String input = reader.readLine();
				shopOperation(input.toUpperCase());
			}
		}
		
		catch (Exception e)
		{
			System.err.println(e);
		}
	}
	
	public static void shopOperation(String input)
	{
		switch(input)
		{
			case "A":
				Display.setState(1);
				Display.mainOperation(input);
				break;
			case "R":
				Display.setState(2);
				Display.mainOperation(input);
				break;
			case "D":
				Display.setState(3);
				Display.mainOperation(input);
				break;
			case "C":
				Display.setState(4);
				Display.mainOperation(input);
				break;
			default:
				int numInput = Integer.parseInt(input);
				if(Display.getState()<1||numInput<0||numInput>50)
					Display.mainOperation(input);
				else
					subOperation(input); //pass itemCode or cardnum input
				break;
		}
		
	}
	

	//always only enters this method when input isn't A|R|D|C and within our item code numbers
	private static void subOperation(String input)
	{
		int suboper = Display.getState(); //checks if we're in A|R|D|C state
		
		if (suboper < 10)
			switch(suboper)
			{
				case 1:
					Display.setState(12); 	//set state to add:amount input
					itemInput = input;		//store itemInput
					break;
				case 2:
					Display.setState(22); 	//set state to remove:amount input
					itemInput = input;
					break;
				case 3:
					Display.setState(5); 	//display successful state?
					break;
				case 4:
					Display.setState(42);	//set state to credit card input
					break;
				default:
					Display.mainOperation("some kind of error lol");
			}
		else
			switch(suboper)
			{
				case 12:
					addToCart(itemInput, Integer.parseInt(input));
					Display.setState(51);
					break;
				case 22:
					addToCart(itemInput, Integer.parseInt(input));
					Display.setState(52);
					break;
				case 42:
					addToCart(itemInput, Integer.parseInt(input));
					Display.setState(54);
					Display.setIsOpen(false); //card input successful, stop demo
					break;
			}
	}
	
	private static boolean addToCart(String itemCode, int amount)
	{
		return ShopHelper.getShopHelperInstance().processItem(itemCode, amount);
	}
	
	private static boolean removeFromCart(String itemCode, int amount)
	{
		return ShopHelper.getShopHelperInstance().processItem(itemCode, amount);
	}
	
	private static boolean creditCardInput(String cardInput)
	{
		//credit card processing logic
		return false;
	}
	
	public static void testRun()
	{
		ShopHelper.getShopHelperInstance().processItem("P1", 2);
		ShopHelper.getShopHelperInstance().processItem("P2", 3);
		ShopHelper.getShopHelperInstance().processItem("P3", 4);
		ShopHelper.getShopHelperInstance().processItem("E1", 5);
		ShopHelper.getShopHelperInstance().processItem("E2", 6);
		ShopHelper.getShopHelperInstance().processItem("E3", 7);
		ShopHelper.getShopHelperInstance().processItem("T1", 8);
		ShopHelper.getShopHelperInstance().processItem("T2", 9);
		ShopHelper.getShopHelperInstance().processItem("T3", 10);

		//second reorders
		ShopHelper.getShopHelperInstance().processItem("P1", 2); //should return total 4 of P1
		ShopHelper.getShopHelperInstance().processItem("P2", 3); //which they do, thus
		ShopHelper.getShopHelperInstance().processItem("P3", 4); 
		//ordering the same item regardless of the amount works
		
		
		//store cart items in local variable "itemCart" for easier use
		//List<ArrayList<String>> itemCart = ShopHelper.getCart().getItems();
		
		//System.out.println(String.format("%30s", "-----Test Run Output---"));
		
		//displaying each arraylist to be implemented by Display.java as a method
		//that accepts "List<ArrayList<String>> itemCart" as a parameter
		//(that is one arraylist = item rearranged to a <name,count,price>)
		//first .get is for items *unique items* 2nd get is for the above n,c,p
//		for (int i = itemCart.size()-1; i > -1 ; i--) //reverse to print the first item ordered first
//		{
//			String n = Display.AlignLeftTextInField(("Item name: " + itemCart.get(i).get(0)), 30);
//			String a = Display.AlignLeftTextInField(("| Item amount: " + itemCart.get(i).get(1)),30);
//			String p = Display.AlignLeftTextInField(("| Total price: " + itemCart.get(i).get(2)),30);
//			System.out.println(String.format("%30s%30s%30s", n,a,p));
//		}
	}

}
