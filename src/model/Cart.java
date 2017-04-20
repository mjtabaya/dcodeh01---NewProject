package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	
	public int getCount(Item item)
	{
		return Collections.frequency(items, item);
	}

}
