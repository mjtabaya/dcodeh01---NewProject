package utility;

import java.util.HashMap;
import java.util.Map;

public interface PotionValues {
	//need to figure out how to get these out and automate RP and BP loading into the map instead
	final String[] RP1 = {"Apple Essence", "An apple a day keeps the evil doctors away", "15.25"};
	final String[] BP1 = {"Berry Extract", "Juicy berries to revitalize the spirit", "10.50"};
	
	static final Map<String, String[]> potionMap = new HashMap<String, String[]>() 
	{
		private static final long serialVersionUID = 3L;
		{
		   put("RP1", RP1);
		   put("BP1", BP1);
		}
	};
}
