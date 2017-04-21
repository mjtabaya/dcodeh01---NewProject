package view;

import utility.ElixirValues;
import utility.PotionValues;
import utility.TrinketValues;

public class Display {
	final static int numPotionTypes = 3;
	final static int numElixirTypes = 3;
	final static int numTrinketTypes = 3;
	
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
	
	public static void loadScreen(int screenCode) {
		
		bufferScreen();
		
		switch(screenCode) {
		case 1:
			mainMenuScreen();
			break;
		case 2:
			itemMenuScreen();
			break;
		default:
			break;
		}
		
	}
	
	private static void bufferScreen() {
		for(int i=0; i < 70 ; i++)
			System.out.println();
	}

	
	private static void mainMenuScreen() {
		for(int i=0; i < 50 ; i++)
		{
			if(i==0||i==48||i==42||i==6)
			{
				for(int x = 0; x < 100; x++)
				{
					System.out.print("=");
				}
				System.out.println();
				
				
			}
			else
			{
				System.out.println(i);
			}
			
		}
			
	}
	
	private static void itemMenuScreen() {
		for(int i=50; i > 0 ; i--)
			System.out.println(i);
	}
	

	
	public static String AlignLeftTextInField(String text, int field)
	{
		int space = field-text.length();
		String alignedText = text;
		for (int i=0; i<space; i++)
			alignedText+=" ";
		return alignedText;
	}
	
	
}
