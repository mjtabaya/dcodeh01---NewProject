package utility;

import java.util.HashMap;
import java.util.Map;

public interface PotionValues {
	//need to figure out how to get these out and automate RP and BP loading into the map instead
	final String[] P1 = {"Apple Essence", "An apple a day keeps the evil doctors away.. You don't wanna know what happened to the guy who ran out of them apples.", "15.25"};
	final String[] P2 = {"Berry Extract", "The sweetest berries mixed with fresh water and honey. Guaranteed better than raspberry-flavored cough syrup.", "10.50"};
	final String[] P3 = {"Ginger Ale", "Revitalizing to the mind and spirit. Was worth its weight in gold back in 13th century England, now an indispensable cheap herb.", "10.50"};
	
	static final Map<String, String[]> potionMap = new HashMap<String, String[]>() 
	{
		private static final long serialVersionUID = 3L;
		{
		   put("P1", P1);
		   put("P2", P2);
		   put("P3", P3);
		}
	};
}
