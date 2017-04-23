package model;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
	private static int maxStock = 10;
	
	private final static Map<String, Integer> inventoryMap = new HashMap<String, Integer>() 
	{
		//don't mind this id
		private static final long serialVersionUID = 3L;
		{
			//set initial inventory amount for items as 10
		   put("P1", maxStock);
		   put("P2", maxStock);
		   put("P3", maxStock);
		   
		   put("E1", maxStock);
		   put("E2", maxStock);
		   put("E3", maxStock);
		   
		   put("T1", maxStock);
		   put("T2", maxStock);
		   put("T3", maxStock);
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
	
	public boolean putBackItem(String code)
	{
		if (!(this.checkStock(code)>maxStock))
		{
			inventoryMap.put(code, inventoryMap.get(code) + 1);
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
	
	public int getMaxStock()
	{
		return maxStock;
	}

}
