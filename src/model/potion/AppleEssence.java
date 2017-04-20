package model.potion;
import model.Potion;

import utility.PotionValues;

public class AppleEssence extends Potion implements PotionValues{
	
	public AppleEssence(){
		super(RP1[0], RP1[1], Double.parseDouble(RP1[2]));
	}
}