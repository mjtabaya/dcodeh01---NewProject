package model.elixir;

import model.Elixir;
import utility.ElixirValues;

public class PhoenixDown extends Elixir implements ElixirValues{
	
	public PhoenixDown(){
		super(E2[0], E2[1], Double.parseDouble(E3[2]));
	}

	@Override
	public Elixir clone() {
		return new PhoenixDown();
	}
}