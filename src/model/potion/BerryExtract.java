package model.potion;
import model.Potion;
import utility.PotionValues;

public class BerryExtract extends Potion implements PotionValues{
	
	public BerryExtract(){
		super(P2[0], P2[1], Double.parseDouble(P2[2]));
	}

	@Override
	public Potion clone() {
		return new BerryExtract();
	}
	
	
}