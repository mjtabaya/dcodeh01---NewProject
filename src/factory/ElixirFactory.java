package factory;
import java.util.HashMap;
import java.util.Map;

import model.Elixir;
import model.Potion;
import model.Trinket;
import model.elixir.*;

public class ElixirFactory implements ElixirMaker, AbstractFactoryForProjectShop
{
	//create a Map to hold a source object for each class
	static final Map<String, Elixir> prototypeMap = new HashMap<>();
	
	static 
	{
		prototypeMap.put("E1", new JujuEmber());
		prototypeMap.put("E2", new PhoenixDown());
		prototypeMap.put("E3", new ZerthulElixir());
	}

	//the source objects in the prototypeMap serve as base for cloning
	//cloning is more efficient than creating and returning a new Object()
	@Override
	public Elixir getElixir(String elixirId) 
	{

		try
		{
			return prototypeMap.get(elixirId).clone();
		}
		catch (NullPointerException npe)
		{
			System.err.println("Prototype: [" + elixirId + "] not found.");
			return null;
		}
	}
	
	//we need to import these too but have them return null

	@Override
	public Potion getPotion(String potionId) {
		return null;
	}

	@Override
	public Trinket getTrinket(String trinketId) {
		return null;
	}
}
