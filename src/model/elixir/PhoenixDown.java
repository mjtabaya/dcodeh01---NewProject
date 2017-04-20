package model.elixir;

import model.Potion;
import utility.PotionValues;

public class PhoenixDown extends Potion implements PotionValues{
	
	public PhoenixDown(){
		super(P3[0], P3[1], Double.parseDouble(P3[2]));
	}
}