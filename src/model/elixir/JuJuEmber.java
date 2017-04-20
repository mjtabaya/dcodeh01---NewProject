package model.elixir;
import model.Potion;
import utility.PotionValues;

public class JuJuEmber extends Potion implements PotionValues{
	
	public JuJuEmber(){
		super(P1[0], P1[1], Double.parseDouble(P1[2]));
	}
}