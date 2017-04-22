package model;

import java.util.HashMap;
import java.util.Map;

import utility.PotionValues;

public class Inventory implements PotionValues{
	
	final static Map<String, Integer> inventoryMap = new HashMap<String, Integer>() 
	{
		//don't mind this id
		private static final long serialVersionUID = 3L;
		{
			//set initial inventory amount for items as 10
		   put("P1", 10);
		   put("P2", 10);
		   put("P3", 10);
		   
		   put("E1", 10);
		   put("E2", 10);
		   put("E3", 10);
		   
		   put("T1", 10);
		   put("T2", 10);
		   put("T3", 10);
		   //subtract to inventory by inventoryMap.put(key, inventoryMap.get(key) - 1);
		}
	};
	
	public boolean fetchItem(String code)
	{
		if (this.hasStock(code))
		{
			inventoryMap.put(code, inventoryMap.get(code) - 1);
			return true;
		}
		else
			return false;
	}
	
	public boolean hasStock(String code)
	{
		if (inventoryMap.get(code)>0)
			return true;
		else
			return false;
	}
	
	public int checkStock(String code)
	{
		return inventoryMap.get(code);
	}

}
