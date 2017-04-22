package model.trinket;
import model.Trinket;
import utility.TrinketValues;

public class TwentySidedDie extends Trinket implements TrinketValues{
	
	public TwentySidedDie(){
		super(T3[0], T3[1], Double.parseDouble(T3[2]), Integer.parseInt(T3[3]));
	}

	@Override
	public Trinket clone() {
		return new TwentySidedDie();
	}
}