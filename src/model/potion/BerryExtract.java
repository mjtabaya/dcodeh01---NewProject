package model.potion;
import model.Potion;
import utility.PotionValues;

public class BerryExtract extends Potion implements PotionValues{
	
	public BerryExtract(){
		super(P1[0], P1[1], Double.parseDouble(P1[2]));
	}
}