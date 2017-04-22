package model.trinket;
import model.Trinket;
import utility.TrinketValues;

public class GoldNeedle extends Trinket implements TrinketValues{
	
	public GoldNeedle(){
		super(T1[0], T1[1], Double.parseDouble(T1[2]), Integer.parseInt(T1[3]));
	}

	@Override
	public Trinket clone() {
		return new GoldNeedle();
	}
}