package utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
	static String typeInput = "";
	
	public static void runShop()
	{
		Display.setIsOpen(true);
		try
		{
			Display.loadScreen(1);
			while(Display.isOpen())
			{
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
		System.out.println("Checking shop operation for: " + input);
		if(!input.matches(".*\\d+.*")) //does not contain numbers, it's an operator else an invalid input
		{
			try
			{
				if (isValidInput(input, 1))
					switch(input)
					{
						case "A":
							System.out.println("'A' operation confirmed, moving to sub-operation.");
							Display.setState(1);
							Display.mainOperation(input);
							break;
						case "R":
							System.out.println("'B' operation confirmed, moving to sub-operation.");
							Display.setState(2);
							Display.mainOperation(input);
							break;
						case "D":
							System.out.println("'D' operation confirmed, moving to sub-operation.");
							Display.setState(3);
							Display.mainOperation(input);
							break;
						case "C":
							System.out.println("'C' operation confirmed, moving to sub-operation.");
							Display.setState(4);
							Display.mainOperation(input);
							break;
						default:
							throw new InvalidOperationInputException();
					}
			}
			catch(InvalidOperationInputException ioie)
			{
				System.out.println(ioie.getMessage());
				Display.setState(04);
				Display.subOperation("");
			}
		}
		
		//else check if input is for an item code
		else if(Display.getState()!=4&&Display.getState()<10)
		{
			System.out.println("Input for product code detected.");
			try
			{
				if(isValidInput(input, 2))
				{
					System.out.println("Product code [" + itemInput + "] verified. Passing to sub-operation..");
					subOperation(itemInput); //pass itemCode
				}
			}
			catch (InvalidItemException iie)
			{
				System.out.println("Input for product code was invalid.");
				Display.setState(04);
				Display.subOperation("");
			}
		}
		
		//else check if input is for an item amount
		else if (Display.getState()==12)
		{
			System.out.println("Input for [Add] amount detected.");
			try
			{
				if(isValidInput(input, 3))
				{
					System.out.println("Amount verified. Passing to sub-operation [Add]..");
					subOperation(input); 	//pass itemAmount input
				}
			}
			catch (InvalidQuantityException iqe)
			{
				System.out.println("Invalid [Add] amount detected. " + iqe.getMessage());
				Display.setState(14);
				Display.subOperation(input);
			}
		}

		else if (Display.getState()==22)
		{
			System.out.println("Input for [Remove] amount detected.");
			try
			{
				if(isValidInput(input, 4))
				{
					System.out.println("Amount verified. Passing to sub-operation [Remove]..");
					subOperation(input); 	//pass itemAmount input
				}
			}
			catch (InvalidQuantityException iqe)
			{
				System.out.println("Invalid [Remove] amount detected. " + iqe.getMessage());
				Display.setState(14);
				Display.subOperation(input);
			}
		}
		else if (Display.getState()==4)
			try
			{
				if(isValidInput(input,4))
					subOperation(input);	//pass cardNumber input
			}
			catch (InvalidCreditCardNumberException icce)
			{
				Display.setState(14);
				subOperation(input);
			}
		else
		{
			Display.setState(04);
			Display.subOperation("");
		}
		
	}
	

	//always only enters this method when input isn't A|R|D|C
	//input could be an itemcode, amount or card number
	private static void subOperation(String input)
	{
		System.out.println("Input code/amount detected. Verifying input..");
		
		int suboper = Display.getState(); //checks which state we're in
		System.out.println("Sub-operation in process. State: " + suboper);
		
		if (suboper < 10) //if in A|R|D|C state, +10 set to next phase:amount input or description display
		{
			switch(suboper)
			{
				case 1:
					Display.setState(12); 	//set state to add:amount input
					System.out.println("Proceeding to [Add] item process..");
					Display.subOperation(input);
					break;
				case 2:
					Display.setState(22); 	//set state to remove:amount input
					System.out.println("Proceeding to [Remove] item process..");
					Display.subOperation(input);
					break;
				case 3:
					Display.setState(33); 	//display successful state?
					System.out.println("Proceeding to [Display] item process..");
					Display.subOperation(input);
					break;
				case 4:
					Display.setState(42);	//set state to credit card input
					Display.subOperation(input);
					break;
				default:
					throw new InvalidItemException();
			}
		}
		else
			System.out.println("Input for amount verified.");
			switch(suboper)	//input state done, accept amount and try to process
			{
				case 12:
					if(addToCart(itemInput, Integer.parseInt(input)))
					{
						System.out.println("Amount verified. Add process commence.");
						Display.setState(13);
						Display.subOperation(input);
					}
					else
					{
						System.out.println("Invalid amount in sub-operation 12 detected..");
						Display.setState(14);
						Display.subOperation(input);
					}
					break;
				case 22:
					if(removeFromCart(itemInput, Integer.parseInt(input)))
					{
						System.out.println("Amount verified. Remove process commence.");
						Display.setState(23);
						Display.subOperation(input);
					}
					else
					{
						System.out.println("Removal process for [" + itemInput + "],[" + input + "] encountered a problem.");
						System.out.println("Invalid amount in sub-operation 13 detected..");
						Display.setState(24);
						Display.subOperation(input);
					}
					break;
				case 42:
					if(addToCart(itemInput, Integer.parseInt(input)))
					{
						Display.setState(43);
						Display.subOperation(input);
					}
					else
					{
						Display.setState(44);
						Display.subOperation(input);
					}
					Display.setIsOpen(false); //card input successful, stop demo
					break;
			}
	}
	
	private static boolean addToCart(String productCode, int amount)
	{
		String itemCode = CodeTranslator.getProductmap().get(productCode);
		System.out.println("Adding [" + amount + "] of [" + itemCode + "] to cart.");
		return ShopHelper.getShopHelperInstance().processOrder(itemCode, amount);
	}
	
	private static boolean removeFromCart(String productCode, int amount)
	{
		boolean successfullyRemoved = false;
		if (amount > maxStock)
			amount = maxStock;
		for (int i = 0; i<amount;i++)
			{
				System.out.println("Removal check [" + i + "] of [" + amount + "]");
				String itemCode = CodeTranslator.getProductmap().get(productCode);//translate code into itemCode
				String productType = itemCode.substring(0, 1);
				successfullyRemoved = ShopHelper.getCart().removeItem(ShopHelper.getProduct(productType, itemCode));
				System.out.println("Removal result: " + successfullyRemoved);
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
				String i = input.toUpperCase();
				if(input.length()>1&&i!="A"&&i!="R"&&i!="D"&&i!="C")
					throw new InvalidOperationInputException();
				break;
			case 2:
				System.out.println("Verifying " + input);
				if(Integer.parseInt(input)>CodeTranslator.totalProducts) //if greater than selectable codes
					throw new InvalidItemException();
				else if (input.length()==1)
					input = "0" + input.toString();
				itemInput = input;
				System.out.println("Input check: " + itemInput);
				break;
			case 3:
				int amountAddRequested = Integer.parseInt(input);
				if(amountAddRequested<=0||amountAddRequested>maxStock||!isValidAddAmount(itemInput, amountAddRequested)) //if input greater than possible amount
					throw new InvalidQuantityException();
				break;
			case 4:
				int amountRemoveRequested = Integer.parseInt(input);
				if(amountRemoveRequested<=0||amountRemoveRequested>maxStock||!isValidRemoveAmount(itemInput, amountRemoveRequested)) //if input greater than possible amount
					throw new InvalidQuantityException();
				break;
			case 5:
				//if invalid credit card format/length return false
				throw new InvalidCreditCardNumberException();
			default:
				return false;
				
		}
		return true;
	}
	
	private static boolean isValidAddAmount(String productCode, int amount)
	{
		String itemCode = CodeTranslator.getProductmap().get(productCode);
		System.out.println("Checking if [" + amount + "] of [" + itemCode + "] can be added..");
		boolean result = (amount <= ShopHelper.getShopHelperInstance().getInventory().checkStock(itemCode));
		System.out.println("Result: " + result);
		return result;
	}
	
	private static boolean isValidRemoveAmount(String productCode, int amount)
	{
		String itemCode = CodeTranslator.getProductmap().get(productCode);
		System.out.println("Checking if [" + amount + "] of [" + itemCode + "] can be removed..");
		
		String type = itemCode.substring(0,1);
		System.out.println("Product Type: ["+ type + "] confirmed. Checking cart match..");
		
		int cartAmount = ShopHelper.getCart().getCount(ShopHelper.getProduct(type, itemCode));
		boolean result = false;
		
		if (cartAmount>(0))
		{
			System.out.println("Match in cart found. Amount: " + cartAmount);
			System.out.println("Amount in cart: " + cartAmount);
			result = (amount <= cartAmount);
			System.out.println("isValidRemoveAmount Result: " + result);
			return true;
		}
		else
			System.out.println("No match in cart found.");
			return false;
	}
	
	public static void testRun()
	{
		ShopHelper.getShopHelperInstance().processOrder("P1", 2);
		ShopHelper.getShopHelperInstance().processOrder("P2", 3);
		ShopHelper.getShopHelperInstance().processOrder("P3", 4);
		ShopHelper.getShopHelperInstance().processOrder("E1", 5);
		ShopHelper.getShopHelperInstance().processOrder("E2", 6);
		ShopHelper.getShopHelperInstance().processOrder("E3", 7);
		ShopHelper.getShopHelperInstance().processOrder("T1", 8);
		ShopHelper.getShopHelperInstance().processOrder("T2", 9);
		ShopHelper.getShopHelperInstance().processOrder("T3", 10);

		//second reorders
		ShopHelper.getShopHelperInstance().processOrder("P1", 2); //should return total 4 of P1
		ShopHelper.getShopHelperInstance().processOrder("P2", 3); //which they do, thus
		ShopHelper.getShopHelperInstance().processOrder("P3", 4); 
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
