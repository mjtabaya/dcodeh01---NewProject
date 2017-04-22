package model.elixir;
import model.Elixir;
import utility.ElixirValues;

public class JujuEmber extends Elixir implements ElixirValues{
	
	public JujuEmber(){
		super(E1[0], E1[1], Double.parseDouble(E1[2]), Integer.parseInt(E1[3]));
	}

	@Override
	public Elixir clone() {
		return new JujuEmber();
	}
}