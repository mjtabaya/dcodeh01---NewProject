package utility;

public interface TrinketValues {
	//need to figure out how to get these out and automate RP and BP loading into the map instead
	String[] T1 = {"Gold Needle", "A curious needle of gold with the power to restore life to those turned to stone. Purified by white mages, the holy essence enters the body through the skin, dissolving the curse of petrification from within. While many speak of the glorious feeling of joints and muscles loosening, it has proven ineffective against common shoulder tightness and back pain.", "8.75", "7"};
	String[] T2 = {"Ice Rosetta", "A fragment of ice with magical glyphs engraved on it, that somewhat resembles a gigantic snowflake. It is said to have been jointly created by a veteran stonesmith and a skilled mage who were experimenting to make the best protective talisman for mages in their homeland, an icy area.", "80.17", "8"};
	String[] T3 = {"Twenty-sided Die", "A die made from materials alien to this world. According to legend, there have been many incidents in which various people have miraculously walked off unharmed after suffering an attack from a monster. Curiously enough, each of them is said to have been carrying this die at the time of the incident.", "30.42", "9"};
	
	public static String[] toString(String code)
	{
		switch(code)
		{
			case "T1":
				return T1;
			case "T2":
				return T2;
			case "T3":
				return T3;
			default:
				return null;
		}
	}
}
