package utility;

public interface ElixirValues {
	//need to figure out how to get these out and automate RP and BP loading into the map instead
	String[] E1 = {"Juju Ember", "Warms the heart, warm enough so you forget it's hot outside. May cause involuntary blushing and uncomfortable bathroom breaks.", "22.30", "4"};
	String[] E2 = {"Phoenix Down", "The tailfeather of a bird, able to bring one back from the verge of death. Billed by ambitious merchants as having been plucked from the legendary phoenix, the truth of such claims are unsubstantiated. None can deny its power, however, bringing those who have all but drawn their last breath back to their feet.", "42.23", "5"};
	String[] E3 = {"Zerthul Elixir", "A fine mixture made by the moderately and reasonably mad alchemist Zerthul. Villagers under his control claim absolute recovery in all aspects of their lives regardless of the town's decay and eery surroundings. Certainly an effective elixir, share to your friends Zerthul says.", "4.65", "6"};
	
	public static String[] toString(String code)
	{
		switch(code)
		{
			case "E1":
				return E1;
			case "E2":
				return E2;
			case "E3":
				return E3;
			default:
				return null;
		}
	}
	
	/* to be implemented as a single itemMap with potions and trinkets in a separate class that loads values from
	 * a file/DB
	static final Map<String, String[]> ElixirMap = new HashMap<String, String[]>() 
	{
		private static final long serialVersionUID = 3L;
		{
		   put("E1", E1);
		   put("E2", E2);
		   put("E3", E3);
		}
	};
	*/
}
