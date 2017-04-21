package utility;

public interface PotionValues {
	//need to figure out how to get these out and automate RP and BP loading into the map instead
	String[] P1 = {"Apple Essence", "An apple a day keeps the evil doctors away.. You don't wanna know what happened to the guy who ran out of them apples.", "15.25"};
	String[] P2 = {"Berry Extract", "The sweetest berries mixed with fresh water and honey. Guaranteed better than raspberry-flavored cough syrup.", "10.50"};
	String[] P3 = {"Ginger Ale", "Revitalizing to the mind and spirit. Was worth its weight in gold back in 13th century England, now an indispensable cheap herb.", "10.50"};
	
	public static String[] toString(String code)
	{
		switch(code)
		{
			case "P1":
				return P1;
			case "P2":
				return P2;
			case "P3":
				return P3;
			default:
				return null;
		}
	}
}
