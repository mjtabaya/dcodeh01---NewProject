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
		ShopHelper.getShopHelperInstance().addToCart("P1", 3);
		ShopHelper.getShopHelperInstance().addToCart("T2", 1);
		
		//store cart items in local variable for easier use
		List<ArrayList<String>> itemCart = ShopHelper.getCart().getItems();
		
		System.out.println(String.format("%20s", "-----Output---"));
		
		//displaying each arraylist 
		//(that is one arraylist = item rearranged to a <name,count,price>)
		//first .get is for items *unique items* 2nd get is for the above n,c,p
		for (int i = 0; i < itemCart.size() ; i++)
		{
			System.out.println("Item name: " + itemCart.get(i).get(0));
			System.out.println("Item amount: " + itemCart.get(i).get(1));
			System.out.println("Total price: " + itemCart.get(i).get(2));
		}
		
	}

}
