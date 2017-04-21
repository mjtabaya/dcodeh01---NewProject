package model;

import java.util.HashMap;
import java.util.Map;

import utility.PotionValues;

public class Inventory implements PotionValues{
	
	final Map<String, Integer> inventoryMap = new HashMap<String, Integer>() 
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
		   //subtract to inventory by map.put(key, map.get(key) - 1);
		}
	};

}
