package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.Item;
import utility.ShopHelper;
import view.Display;

public class Access {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		boolean running = true;
		/*
		while(running)
		{
			Display.loadScreen(1);
			
		}
		*/
		//System.out.println(String.format("%20s", "-----Input----"));
		ShopHelper.getShopHelperInstance().addToCart("P1", 2);
		ShopHelper.getShopHelperInstance().addToCart("P2", 3);
		ShopHelper.getShopHelperInstance().addToCart("P3", 4);
		ShopHelper.getShopHelperInstance().addToCart("E1", 5);
		ShopHelper.getShopHelperInstance().addToCart("E2", 6);
		ShopHelper.getShopHelperInstance().addToCart("E3", 7);
		ShopHelper.getShopHelperInstance().addToCart("T1", 8);
		ShopHelper.getShopHelperInstance().addToCart("T2", 9);
		ShopHelper.getShopHelperInstance().addToCart("T3", 10);

		//second reorders
		ShopHelper.getShopHelperInstance().addToCart("P1", 2); //should return total 4 of P1
		ShopHelper.getShopHelperInstance().addToCart("P2", 3); //which they do, thus
		ShopHelper.getShopHelperInstance().addToCart("P3", 4); 
		//ordering the same item regardless of the amount works
		
		
		//store cart items in local variable for easier use
		List<ArrayList<String>> itemCart = ShopHelper.getCart().getItems();
		
		System.out.println(String.format("%20s", "-----Output---"));
		
		//displaying each arraylist 
		//(that is one arraylist = item rearranged to a <name,count,price>)
		//first .get is for items *unique items* 2nd get is for the above n,c,p
		for (int i = itemCart.size()-1; i > -1 ; i--) //reverse to print the first item ordered first
		{
			System.out.println("Item name: " + itemCart.get(i).get(0));
			System.out.println("Item amount: " + itemCart.get(i).get(1));
			System.out.println("Total price: " + itemCart.get(i).get(2));
		}
		
	}

}
