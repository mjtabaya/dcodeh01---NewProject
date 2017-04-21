package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cart {
	//List allows duplication and unordered storage of "Item" objects in a dynamically sized collections framework
	//We'll use getCount for printing and getting price total
	private List<Item> items = new ArrayList<Item>();
	
	public void addItem(Item item) 
	{
		items.add(item);
	}
	
	public float getCost()
	{
		float cost = 0.0f;
		
		for (Item item: items)
		{
			cost += item.price();
		}
		return cost;
	}
	
	@SuppressWarnings("unchecked")
	public List<ArrayList<String>> getItems()
	{
		for(Item i : items)
			if(i!=null)
				System.out.println(i.name());
		//debug:System.out.println(items.get(0).getClass());
		//Set "unique" variable used to get unique instances
		Set<Item> unique = new HashSet<Item>(items);
		
		//debug:System.out.println(items.get(0).name());
		//debug:System.out.println(items.get(0).price());
		
		//List of arrayLists "arrangedCart" used to store <name,count,price> arrays for display
		List<ArrayList<String>> arrangedCart = new ArrayList<ArrayList<String>>();
		
		for (Item key : unique) 
		{
			//store unique item as string
			ArrayList<String> itemCount = new ArrayList<String>();
			if(key!=null)
			{
				itemCount.add(key.name()); //keyname added to first '0' index of first arraylist in list of arraylists
				//store count variable for store then use for total price
				int count = Collections.frequency(items, key);
				itemCount.add(Integer.toString(count)); //count added to index 1
	
				//store total price
				double tprice = key.price()*count;
				itemCount.add(Double.toString(tprice)); //total price to index 2
				arrangedCart.add(itemCount);
			}
		}
		return arrangedCart;
	}
	
	public int getCount(Item item)
	{
		return Collections.frequency(items, item);
	}

}
