package utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import exception.InvalidCreditCardNumberException;
import exception.InvalidItemException;
import exception.InvalidOperationInputException;
import exception.InvalidQuantityException;
import view.Display;

public class ShopRunner {
	
	//** runShop() is the one we call in main
	//** Display.state determines what state our shop is in
	//** codes: Add=1 Remove=2 Describe=3 Checkout=4
	//** subcodes: ItemAmount=12 RemoveAmount=22 CardInput=42
	//** subcodes: AddSuccess=13 RemoveSuccess=23 DescribeSuccess=33 CardInputSuccess=43
	//** subcodes: AddFail=14 RemoveFail=24 DescribeFail=34 CardInputFail=44

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String itemInput = "";
	static int amountInput = 0;
	static String cardInput = "";
	static int maxStock = ShopHelper.getShopHelperInstance().getInventory().getMaxStock();
	
	public static void runShop()
	{
		Display.setIsOpen(true);
		try
		{
			Display.loadScreen(1);
			while(Display.isOpen())
			{
				String input = reader.readLine();
				if(isValidInput(input, 1))
					shopOperation(input.toUpperCase());
				//else
					//Display general input error message
			}
		}
		
		catch (Exception e)
		{
			System.err.println(e);
		}
	}
	
	public static void shopOperation(String input)
	{
		if(!input.matches(".*\\d+.*")) //does not contain numbers, it's an operator else an invalid input
		{
			try
			{
				if (isValidInput(input, 1))
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
							//Display general error
							break;
					}
			}
			catch(InvalidOperationInputException ioie)
			{
				//Display ioie.getMessage()
			}
		}
		
		//else check if input is for an item code
		else if(Display.getState()!=4&&Display.getState()<10)
		{
			try
			{
				if(isValidInput(input, 2))
				{
					subOperation(input); //pass itemCode
				}
			}
			catch (InvalidItemException iie)
			{
				//Display ioie.getMessage()
			}
		}
		
		//else check if input is for an item amount
		else if (Display.getState()>10)
			try
			{
				if(isValidInput(input, 3))
					subOperation(input); 	//pass itemAmount input
			}
			catch (InvalidQuantityException iqe)
			{
				//Display iqe.getMessage()
			}
		else if (Display.getState()==4)
			try
			{
				if(isValidInput(input,4))
					subOperation(input);	//pass cardNumber input
			}
			catch (InvalidCreditCardNumberException icce)
			{
				//Display icce.getMessage()
			}
		//else
			//Display general input error message
		
	}
	

	//always only enters this method when input isn't A|R|D|C
	//input could be an itemcode, amount or card number
	private static void subOperation(String input)
	{
		int suboper = Display.getState(); //checks which state we're in
		
		if (suboper < 10) //if in A|R|D|C state, +10 set to next phase:amount input or description display
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
					Display.setState(33); 	//display successful state?
					break;
				case 4:
					Display.setState(42);	//set state to credit card input
					break;
				default:
					Display.mainOperation("some kind of error lol");
			}
		else
			switch(suboper)	//input state done, accept amount and try to process
			{
				case 12:
					if(addToCart(itemInput, Integer.parseInt(input)))
						Display.setState(13);
					else
						Display.setState(14);
					break;
				case 22:
					if(removeFromCart(itemInput, Integer.parseInt(input)))
						Display.setState(23);
					else
						Display.setState(24);
					break;
				case 42:
					if(addToCart(itemInput, Integer.parseInt(input)))
						Display.setState(43);
					else
						Display.setState(44);
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
		boolean successfullyRemoved = false;
		if (amount > maxStock)
			amount = maxStock;
		for (int i = 0; i<amount;i++)
			{
				String product = CodeTranslator.productMap.get(itemCode);//translate code into productcode
				String productType = product.substring(0, 1);
				ShopHelper.getShopHelperInstance();
				successfullyRemoved = ShopHelper.getCart().removeItem(ShopHelper.getProduct(productType, product));
			}
		return successfullyRemoved;
	}
	
	private static boolean creditCardInput(String cardInput)
	{
		//credit card processing logic
		return false;
	}
	
	//
	private static boolean isValidInput(String input, int inputFor)
	{
		switch(inputFor)
		{
			case 1:
				if(input.length()>1||input!="A"||input!="R"||input!="D"||input!="C")
					throw new InvalidOperationInputException();
			case 2:
				if(Integer.parseInt(input)>CodeTranslator.totalProducts) //if greater than selectable codes
					throw new InvalidItemException();
			case 3:
				if(Integer.parseInt(input)>maxStock) //if input greater than possible amount
					throw new InvalidQuantityException();
			case 4:
				//if invalid credit card format/length return false
				throw new InvalidCreditCardNumberException();
				
		}
		return true;
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
