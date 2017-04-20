package model.potion;

import utility.PotionValues;

public class AppleEssence extends RedPotion implements PotionValues{
	
	public AppleEssence(){
		super(RP1[0], RP1[1], Double.parseDouble(RP1[2]));
	}
}