package model.potion;
import model.Potion;

import utility.PotionValues;

public class AppleEssence extends Potion implements PotionValues{
	
	public AppleEssence(){
		super(P1[0], P1[1], Double.parseDouble(P1[2]));
	}
}