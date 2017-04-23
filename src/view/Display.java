package view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import exception.InvalidItemException;

import java.io.IOException;

import utility.CodeTranslator;
import utility.ElixirValues;
import utility.PotionValues;
import utility.ShopHelper;
import utility.TrinketValues;

public class Display {
	
	static String previousInput = "";
	static boolean shopOpen = true;
	static int shopState = 0;
	final static int numPotionTypes = 3;
	final static int numElixirTypes = 3;
	final static int numTrinketTypes = 3;
	final static int numAllTypes = numPotionTypes + numElixirTypes + numTrinketTypes;
	
	
	//constant variables for general
	final static int TOTAL_SCREEN_WIDTH = 100;
	static List<ArrayList<String>> itemCart = ShopHelper.getCart().getItems();
	
	//constant variables for shopInfoScreen
	final static String shopName = "Wiz Magic Item Shop";
	final static String shopAddress = "Axel, Belzerg";
	final static String shopContact = "+8190-1790-1357";
	
	
	//constant variables for itemListScreen
	final static int CODE_NAME_SPACING = 3;
	final static int NAME_COUNT_SPACING = 3;
	final static int COUNT_PRICE_SPACING = 4;
	
	final static int CODE_CHAR_SLOT = 5;
	final static int NAME_CHAR_SLOT = 18;
	final static int COUNT_CHAR_SLOT = 5;
	final static int PRICE_CHAR_SLOT = 6;
	
	final static int SHOP_ITEM_LIST_COLUMN_FIELD = 50;
	final static int CART_ITEM_LIST_COLUMN_FIELD = 50;
	
	//sample values for messageScreen
	static String longMessage = "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn�ft listen. She packed her seven versalia, put her initial into the belt and made herself on the way. When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then";
	
	//constant variables for inputScreen
	final static String addItemString = "A - ADD ITEM";
	final static String removeItemString = "R - REMOVE ITEM";
	final static String describeItemString = "D - DESCRIBE ITEM";
	final static String checkoutCartString = "C - CHECKOUT";
	
		
	//display-screen loader
	public static void loadScreen(int screenCode) throws IOException {
		
		bufferScreen();
		
		switch(screenCode) {
		case 1:
			screenBuilder();
			break;
		case 2:
			itemMenuScreen();
			break;
		default:
			break;
		}
		
	}
	
	//pushes up the previous screens / imitating a clearScreen function
	private static void bufferScreen() {
		for(int i=0; i < 70 ; i++)
			System.out.println();
	}

	//compiles all panel into one whole screen
	private static void screenBuilder() throws IOException {
		
		bufferScreen();
		shopInfoScreen();
		itemListScreen();
		messageScreen(longMessage);
		inputScreen();
	}
	
	//panel displaying shop info
	private static void shopInfoScreen()
	{
		final int SHOP_INFO_ROW_COUNT = 6;
		
		for(int i=0; i < SHOP_INFO_ROW_COUNT ; i++)
		{
			if(i==0)
			{
				for(int x = 0; x < TOTAL_SCREEN_WIDTH; x++)
				{
					System.out.print("=");
				}
				System.out.println();
			}
			else if(i>1 && i<=4)
			{
				switch(i)
				{
				case 2:
					System.out.format("%100s", CenterAlignLeftTextInField(shopName,TOTAL_SCREEN_WIDTH));
					System.out.println();
					break;
				case 3:
					System.out.format("%100s", CenterAlignLeftTextInField(shopAddress,TOTAL_SCREEN_WIDTH));
					System.out.println();
					break;
				default:
					System.out.format("%100s", CenterAlignLeftTextInField(shopContact,TOTAL_SCREEN_WIDTH));
					System.out.println();
					break;
				}
			}
			else
			{
				System.out.println();
			}
		}
		
	}
	
	//panel displaying the item lists (shop items and items in cart)
	private static void itemListScreen()
	{
		final int ITEM_LIST_ROW_COUNT = 20;
		final int ITEM_LIST_HEADER = 2;
		final int ITEM_LIST_COLUMN_TITLE = 4;
		final int ITEM_LIST_BEGIN = 6;
		
		String word1 = "SHOP ITEM LIST";
		String word2 = "ITEMS IN CART";
		
		for(int i=0; i < ITEM_LIST_ROW_COUNT ; i++)
		{
			if(i==0)
			{
				for(int x = 0; x < TOTAL_SCREEN_WIDTH; x++)
				{
					System.out.print("=");
				}
				System.out.println();
			}
			// START DISPLAYING HEADER
			else if(i==ITEM_LIST_HEADER) 
			{
				System.out.format("%50s%1s", CenterAlignLeftTextInField(word1,SHOP_ITEM_LIST_COLUMN_FIELD),"|");
				System.out.format("%50s", CenterAlignLeftTextInField(word2,CART_ITEM_LIST_COLUMN_FIELD));
				System.out.println();
			}
			// START DISPLAYING COLUMN TITLE
			else if(i==ITEM_LIST_COLUMN_TITLE)
			{
				String stringBuild01 = stringLineBuilder(1,SHOP_ITEM_LIST_COLUMN_FIELD,"CODE","ITEM NAME","STOCK", "PRICE");
				String stringBuild02 = stringLineBuilder(2,CART_ITEM_LIST_COLUMN_FIELD,"CODE","ITEM NAME","COUNT", "PRICE");
				
				System.out.format("%50s%1s", LeftAlignLeftTextInField(stringBuild01,SHOP_ITEM_LIST_COLUMN_FIELD),"|");
				System.out.format("%50s", LeftAlignLeftTextInField(stringBuild02,CART_ITEM_LIST_COLUMN_FIELD));
				System.out.println();
			}
			// START DISPLAYING THE ITEM LIST
			else if(i>=ITEM_LIST_BEGIN) 
			{
				String type = "";
				if(i>=ITEM_LIST_BEGIN && (i<(numAllTypes+ITEM_LIST_BEGIN)))
				{
					////////////////////////////// FOR SHOP ITEM LIST /////////////
					int k = 1;
					String[] print = PotionValues.toString(type);
					
					for(int j = 1; j <= numAllTypes ; j++)
					{
						if(j<=numPotionTypes)
						{
							type = "P";
							type += k;
							k++;
							print = PotionValues.toString(type);
						}
						else if(j <= numPotionTypes+numElixirTypes)
						{
							if(k > numPotionTypes)
							{
								k = 1;
							}
							type = "E";
							type += k;
							k++;
							print = ElixirValues.toString(type);
						}
						else if(j <= numPotionTypes+numElixirTypes+numTrinketTypes)
						{
							if(k > numElixirTypes)
							{
								k =1;
							}
							type = "T";
							type += k;
							k++;
							print = TrinketValues.toString(type);
						}
						
						String stringBuild1 = stringLineBuilder(1,CART_ITEM_LIST_COLUMN_FIELD,Integer.parseInt(print[3]),print[0],Integer.parseInt("1"),Double.parseDouble(print[2]));
						
						////////////////////////////////////////////////////////////////
						
						////////////////////////////// FOR CART LIST //////////////////////////
					
						String stringBuild2 = "";
						if(j <= itemCart.size())
						{
							stringBuild2 = stringLineBuilder(2,CART_ITEM_LIST_COLUMN_FIELD,Integer.parseInt(itemCart.get(j-1).get(3)),itemCart.get(j-1).get(0),Integer.parseInt(itemCart.get(j-1).get(1)),Double.parseDouble(itemCart.get(j-1).get(2)));
						}
						
						////////////////////////////////////////////////////////////////////////
						
						System.out.format("%50s%1s", LeftAlignLeftTextInField(stringBuild1,SHOP_ITEM_LIST_COLUMN_FIELD),"|");
						System.out.format("%50s", LeftAlignLeftTextInField(stringBuild2,CART_ITEM_LIST_COLUMN_FIELD));
						
						
						
						System.out.println();
						
						type = type.substring(0, type.length()-1);
						i++;
					}
				}
				else
				{
					// if you want to see number of rows
					//System.out.print(i);
					
					/*
					if(i>=10)
					{
						System.out.format("%49s", "|");
					}
					else
					{
						System.out.format("%50s", "|");
					}
					*/
					
					System.out.format("%51s", "|");
					System.out.println();
				}
			}
			else
			{
				// if you want to see number of rows
				// System.out.print(i);
				
				/*
				if(i>=10)
				{
					System.out.format("%49s", "|");
				}
				else
				{
					System.out.format("%50s", "|");
				}
				*/
				
				System.out.format("%51s", "|");
				System.out.println();
			}
			
		}
	}
	
	private static void messageScreen(String message)
	{
		final int MESSAGE_SCREEN_ROW_COUNT = 6;
		final int MESSAGE_SLOT = TOTAL_SCREEN_WIDTH - 14;
		
		char[] messageArray = message.toCharArray();  
		String[] words = new String[50];
		
		int wordCount = 0;
		
		for(int f = 0; f < messageArray.length-1 ; f++)
		{
			if(messageArray[f]==' ')
			{
				wordCount++;
			}
		}
		
		int x = 0;
		int m = 0;
		int j = 0;
		
		for(int y = 0; y < words.length-1; y++)
		{
			String word = "";
			
			if(y < wordCount)
			{
				for(; messageArray[x]!=' '; x++)
				{
					word += messageArray[x];
				}
			}
			else
			{
				word =" ";
			}
			x++;
			
			words[y]=word;
		}
		
		for(int i=0; i < MESSAGE_SCREEN_ROW_COUNT ; i++)
			{
				if(i==0)
				{
					for(int k = 0; k < TOTAL_SCREEN_WIDTH; k++)
					{
						System.out.print("=");
					}
					System.out.println();
				}
				else if(i>1 && i<=4)
				{
					String displayMessage = "";
					
					switch(i)
					{
					case 2:
						for(; j < MESSAGE_SLOT; j++)
						{
							for(; displayMessage.length()<=MESSAGE_SLOT ; m++)
							{
									displayMessage += (words[m] + " ");
							}
						}
						j++;
						break;
					case 3:
						for(; (j <= MESSAGE_SLOT*2)&&(j > MESSAGE_SLOT); j++)
						{
							for(; (displayMessage.length()<=MESSAGE_SLOT)&&(m<words.length-1) ; m++)
							{
									displayMessage += (words[m] + " ");
							}
						}
						j++;
						break;
					default:
						for(; (j <= MESSAGE_SLOT*3)&&(j > MESSAGE_SLOT*2); j++)
						{
							for(; (displayMessage.length()<=MESSAGE_SLOT)&&(m<words.length-1) ; m++)
							{
									displayMessage += (words[m] + " ");
							}
						}
						break;
					}
					
					System.out.format("%100s", LeftAlignLeftTextInField(displayMessage,TOTAL_SCREEN_WIDTH));
					System.out.println();
				}
				else
				{
					System.out.println();
				}
			}
	}
	
	private static void inputScreen() throws IOException
	{
		final int INPUT_SCREEN_ROW_COUNT = 6;
		
		for(int i=0; i < INPUT_SCREEN_ROW_COUNT ; i++)
		{
			if(i==0)
			{
				for(int k = 0; k < TOTAL_SCREEN_WIDTH; k++)
				{
					System.out.print("=");
				}
				System.out.println();
			}
			else if(i==2)
			{
				System.out.format("%25s%25s%25s%25s", CenterAlignLeftTextInField(addItemString,25),CenterAlignLeftTextInField(removeItemString,25),CenterAlignLeftTextInField(describeItemString,25),CenterAlignLeftTextInField(checkoutCartString,25));
			}
			else if(i==INPUT_SCREEN_ROW_COUNT-1)
			{
				System.out.format("%85s", "===================================================     PLEASE SELECT AN OPTION:     ");
			}
			else
			{
				System.out.println();
			}
		}			
	}
	
	private static void itemMenuScreen() {
		
	}
	
	//used by itemListScreen to build a formatted string per line
	private static String stringLineBuilder(int column, int field, int itemCode, String itemName, int itemCount, double itemPrice)
	{
		String value = "";
		DecimalFormat two = new DecimalFormat("0.00");
		
		String itemCodeString = Integer.toString(itemCode);
		String itemCountString = Integer.toString(itemCount);
		String itemPriceString = two.format(itemPrice);
		
		char[] itemNameArray =  itemName.toCharArray();
		char[] itemCodeArray = itemCodeString.toCharArray();
		char[] itemCountArray = itemCountString.toCharArray();
		char[] itemPriceArray = itemPriceString.toCharArray();
	
		for(int i = 0; i < field; i++)
		{
			if(i==0)
			{
				for(int j = 0; j < CODE_CHAR_SLOT; j++)
				{
					if(itemCodeString.length()>j)
					{
						if(itemCode<10)
						{
							value+= "0";
							i++;
							value+=itemCodeArray[j];
						}
						else
						{
							value+=itemCodeArray[j];
						}
						i++;
					}
					else
					{
						value+=" ";
						i++;
					}
				}
			}
			else if (i==(CODE_NAME_SPACING+CODE_CHAR_SLOT))
			{
				for(int k = 0; k < NAME_CHAR_SLOT; k++)
				{
					if(itemName.length()>k)
					{
						value+=itemNameArray[k];
						i++;
					}
					else
					{
						value+=" ";
						i++;
					}
				}
			}
			else if (i==(CODE_NAME_SPACING+CODE_CHAR_SLOT+NAME_COUNT_SPACING+NAME_CHAR_SLOT))
			{
				value+="x ";
				i+=2;
				
				for(int m = 0; m < COUNT_CHAR_SLOT; m++)
				{
					if(itemCountString.length()>m)
					{
						value+=itemCountArray[m];
						i++;
					}
					else
					{
						value+=" ";
						i++;
					}
				}
			}
			else if (i==(CODE_NAME_SPACING+CODE_CHAR_SLOT+NAME_COUNT_SPACING+NAME_CHAR_SLOT+COUNT_PRICE_SPACING+PRICE_CHAR_SLOT))
			{
				value+="P";
				i++;
				
				for(int m = 0; m < PRICE_CHAR_SLOT; m++)
				{
					if(itemPriceString.length()>m)
					{
						value+=itemPriceArray[m];
						i++;
					}
					else
					{
						value+=" ";
						i++;
					}
				}
			}
			else
			{
				value+=" ";
			}
			
		}
		
		return value;
	}
	
	//used by itemListScreen to build a formatted string per line (this one is overloaded)
	private static String stringLineBuilder(int column, int field, String string1, String string2, String string3, String string4)
	{
		String value = "";

		char[] string1Array =  string1.toCharArray();
		char[] string2Array = string2.toCharArray();
		char[] string3Array = string3.toCharArray();
		char[] string4Array = string4.toCharArray();
		
		final int ONE_TWO_SPACING = CODE_NAME_SPACING;
		final int TWO_THREE_SPACING = NAME_COUNT_SPACING;
		final int THREE_FOUR_SPACING = COUNT_PRICE_SPACING;
		
		final int STRING1_SLOT = CODE_CHAR_SLOT;
		final int STRING2_SLOT = NAME_CHAR_SLOT;
		final int STRING3_SLOT = COUNT_CHAR_SLOT;
		final int STRING4_SLOT = PRICE_CHAR_SLOT;
	
		for(int i = 0; i < field; i++)
		{
			if(i==0)
			{
				for(int j = 0; j < STRING1_SLOT; j++)
				{
					if(string1.length()>j)
					{
						value+=string1Array[j];
						i++;
					}
					else
					{
						value+=" ";
						i++;
					}
				}
			}
			else if (i==(ONE_TWO_SPACING+STRING1_SLOT))
			{
				for(int k = 0; k < STRING2_SLOT; k++)
				{
					if(string2.length()>k)
					{
						value+=string2Array[k];
						i++;
					}
					else
					{
						value+=" ";
						i++;
					}
				}
			}
			else if (i==(ONE_TWO_SPACING+STRING1_SLOT+TWO_THREE_SPACING+STRING2_SLOT))
			{
				for(int m = 0; m < STRING3_SLOT; m++)
				{
					if(string3.length()>m)
					{
						value+=string3Array[m];
						i++;
					}
					else
					{
						value+=" ";
						i++;
					}
				}
			}
			else if (i==(ONE_TWO_SPACING+STRING1_SLOT+TWO_THREE_SPACING+STRING2_SLOT+THREE_FOUR_SPACING+STRING4_SLOT))
			{
				for(int m = 0; m < STRING4_SLOT; m++)
				{
					if(string4.length()>m)
					{
						value+=string4Array[m];
						i++;
					}
					else
					{
						value+=" ";
						i++;
					}
				}
			}
			else
			{
				value+=" ";
			}
			
		}
		
		return value;
	}
	
	public static String CenterAlignLeftTextInField(String text, int field)
	{
		int space = (field-text.length())/2;
		String alignedText = text;
		for (int i=0; i<space; i++)
			alignedText+=" ";
		return alignedText;
	}
	
	public static String LeftAlignLeftTextInField(String text, int field)
	{
		final int TAB_SPACING = 7;
		
		int space = (field-TAB_SPACING-text.length());
		String alignedText = text;
		for (int i=0; i<space; i++)
			alignedText+=" ";
		return alignedText;
	}
	
	//former sampleOutput
	public static void mainOperation(String input)
	{
		switch(input)
		{
			case "A":
				longMessage = "[ADD ITEM] selected. Please enter the code of the item you would like. |";
				break;
			case "R":
				longMessage = "[REMOVE ITEM] selected. Please enter the code of the item you would like. |";
				break;
			case "D":
				longMessage = "[DESCRIBE ITEM] selected. Please enter the code of the item you would like. |";
				break;
			case "C":
				longMessage = "You have selected CHECKOUT. |";
				break;
			default:
				longMessage = "Sorry. Wrong input. |";
				break;
		}
		
		try 
		{screenBuilder();} 
		catch (IOException e) 
		{longMessage = e.getMessage();}
	}
	
	public static void subOperation(String itemInput)
	{
		switch(Display.getState())
		{
			case 12:
				longMessage = "[" + itemInput + "] " + printItem(itemInput, 0) + " selected. How many would you like? |";
				previousInput = printItem(itemInput, 0);
				break;
			case 13:
				longMessage = "Added [" + itemInput + "] pcs. of " + previousInput +  " to the cart. Would there be anything else? |";
				setState(0);
				break;
			case 14:
				longMessage = "Sorry, we don't have that much. |";
				Display.setState(1);
				break;
			case 22:
				longMessage = "[" + itemInput + "] "+ printItem(itemInput, 0) + " selected. How many would you like? |";
				break;
			case 23:
				longMessage = "Removed [" + itemInput + "] pcs. of [" + previousInput +  "] from the cart. Would there be anything else? |";
				setState(0);
				break;
			case 33:
				longMessage = "[" + printItem(itemInput, 0) + "]\n" + printItem(itemInput, 1) + "|";
				setState(0);
				break;
			case 42:
				longMessage = "Checking out. Please enter card number |";
				break;
			default:
				longMessage = "Sorry. Wrong input. |";
				break;
		}
		
		try 
		{screenBuilder();} 
		catch (IOException e) 
		{longMessage = e.getMessage();}
	}
	
	private static String printItem(String productCode, int itemPart)
	{
		String itemCode = CodeTranslator.getProductmap().get(productCode);
		String type = itemCode.substring(0, 1); //expected P, E or T
		switch(type)
		{
			case "P":
				return PotionValues.toString(itemCode)[itemPart];
			case "E":
				return ElixirValues.toString(itemCode)[itemPart];
			case "T":
				return TrinketValues.toString(itemCode)[itemPart];
			default:
				throw new InvalidItemException();
		}
	}
	
	public static void displayItem(String itemInput)
	{
		//logic for displaying an item's description :D
	}
	
	//////////////////////////////////////////////////////////////////////
	
	public static void printCatalog()
    {//shoplist print be like:
        int code=1;
        int itype=1; //i<subtypes of each
        String type="";
       
        if (itype==1)
        {
            type = "P";
            for(int i=1; i<numPotionTypes+1; i++) //i<subtypes of potion
            {
                type += i;
                String[] print = PotionValues.toString(type);
                System.out.print("Item Entry [" + code + "]");
                for(int j=0; j<3; j++) //j<itemAttributes, name,desc.price,etc.
                {
                    System.out.println(print[j]);
                }
                type = type.substring(0, type.length()-1); //remove subtype
                code++; //iterate item code
            }
            itype++; //move to next type: elixirs
        }
        
        if (itype==2)
        {
        	type = "E";
            for(int i=1; i<numElixirTypes+1; i++)
            {
                type += i;
                String[] print = ElixirValues.toString(type);
                System.out.print("Item Entry [" + code + "]");
                for(int j=0; j<3; j++)
                {
                    System.out.println(print[j]);
                }
                type = type.substring(0, type.length()-1);
                code++;
            }
            itype++; //move to next type: trinket
        }
        if (itype==3)
        {
        	type = "T";
            for(int i=1; i<numTrinketTypes+1; i++)
            {
                type += i;
                String[] print = TrinketValues.toString(type);
                System.out.print("Item Entry [" + code + "]");
                for(int j=0; j<3; j++)
                {
                    System.out.println(print[j]);
                }
                type = type.substring(0, type.length()-1); //remove subtype
                code++;
            }
            itype++; 
        }
    }
	
	public static boolean isOpen() { return shopOpen; }
	
	public static void setIsOpen(boolean openShop) { shopOpen = openShop; }

	public static int getState() { return shopState; }
	
	public static void setState(int stateId) { shopState = stateId; }


}
