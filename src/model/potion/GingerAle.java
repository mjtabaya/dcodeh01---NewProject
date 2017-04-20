package model.potion;

import model.Potion;
import utility.PotionValues;

public class GingerAle extends Potion implements PotionValues{
	
	public GingerAle(){
		super(P3[0], P3[1], Double.parseDouble(P3[2]));
	}
}