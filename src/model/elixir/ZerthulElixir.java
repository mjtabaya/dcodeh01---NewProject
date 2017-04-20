package model.elixir;
import model.Elixir;

import utility.ElixirValues;

public class ZerthulElixir extends Elixir implements ElixirValues{
	
	public ZerthulElixir(){
		super(E3[0], E3[1], Double.parseDouble(E3[2]));
	}
	
	@Override
	public Elixir clone() {
		return new ZerthulElixir();
	}
}