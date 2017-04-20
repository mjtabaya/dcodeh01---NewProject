package model.trinket;

import model.Trinket;
import utility.TrinketValues;

public class IceRosetta extends Trinket implements TrinketValues{
	
	public IceRosetta(){
		super(T2[0], T2[1], Double.parseDouble(T3[2]));
	}

	@Override
	public Trinket clone() 
	{
		return new IceRosetta();
	}
}