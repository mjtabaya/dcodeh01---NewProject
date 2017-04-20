package utility;

import java.util.HashMap;
import java.util.Map;

public interface ElixirValues {
	//need to figure out how to get these out and automate RP and BP loading into the map instead
	final String[] E1 = {"Juju Ember", "Warms the heart, warm enough so you forget it's hot outside. May cause involuntary blushing and uncomfortable bathroom breaks.", "22.30"};
	final String[] E2 = {"Phoenix Down", "The tailfeather of a bird, able to bring one back from the verge of death. Billed by ambitious merchants as having been plucked from the legendary phoenix, the truth of such claims are unsubstantiated. None can deny its power, however, bringing those who have all but drawn their last breath back to their feet.", "10.50"};
	final String[] E3 = {"Ginger Ale", "Revitalizing to the mind and spirit. Was worth its weight in gold back in 13th century England, now an indispensable cheap herb. One of many uses, culinary and medicinal fields benefit much from its humble roots as well.", "10.50"};
	
	static final Map<String, String[]> potionMap = new HashMap<String, String[]>() 
	{
		private static final long serialVersionUID = 3L;
		{
		   put("E1", E1);
		   put("E2", E2);
		   put("E3", E3);
		}
	};
}
