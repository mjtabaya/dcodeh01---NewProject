package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import view.Display;

public class Access {
	
	//Here we force the code to result in an unchecked/runtime exception
	//then have the user re-input a valid number for division else
	//output another exception
	
	final static String[] BP1 = {"Apple Essence", ""};
	final static String[] RP1 = {"Berry Extract", "Juicy berries to revitalize the spirit", "10.50"};
	
	static final Map<String, String[]> potionMap = new HashMap<String, String[]>() 
	{
		private static final long serialVersionUID = 3L;
		{
		   put("RP1", RP1);
		   put("BP1", BP1);
		}
	};

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
			Display.loadScreen(1);
			
			Scanner scanner = new Scanner(System.in);
			scanner.nextInt();
			
			Display.loadScreen(1);
			
			scanner.nextInt();
			
			Display.loadScreen(2);
		
//        String[] currentItem = potionMap.get("BP1");
//        
//        int cartSize = 2;
//        for (int i = 0; i<potionMap.size() ; i++)
//        {
//        	System.out.println();
//        	String itemName = "0" + (i+1) + "- "+ AlignLeftTextInField(currentItem[0], 32);
//        	System.out.format("%32s", itemName);
//        	System.out.format("%32s", "|");
//
//        	if(i==0)
//        		System.out.format("%32s", "Cart");
//        	
//        	
//        	
//        	System.out.println();
//        	currentItem = potionMap.get("RP1");
//        }
//        
//        //end of center body
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//        	System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
//        	System.out.format("%30s%30s%30s%30s%10s", "A - Add Item", "R - Remove Item", "D - Describe Item", "C - Checkout", " : ");
//            String input = scanner.next();
//            if ("q".equals(input)) {
//                System.out.println("Exit!");
//                break;
//            }
//
//            System.out.println("input : " + input);
//            System.out.println("-----------\n");
//        }
//        scanner.close();

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
