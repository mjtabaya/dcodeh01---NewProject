package factory;
import java.util.HashMap;
import java.util.Map;

import model.Elixir;
import model.Potion;
import model.Trinket;
import model.trinket.*;

public class TrinketFactory implements TrinketMaker, AbstractFactoryForProjectShop
{
	static final Map<String, Trinket> prototypeMap = new HashMap<>();
	
	static 
	{
		prototypeMap.put("T1", new GoldNeedle());
		prototypeMap.put("T2", new IceRosetta());
		prototypeMap.put("T3", new TwentySidedDie());
	}

	@Override
	public Trinket getTrinket(String trinketId) 
	{

		try
		{
			return (Trinket) prototypeMap.get(trinketId).clone();
		}
		catch (NullPointerException npe)
		{
			System.err.println("Prototype: [" + trinketId + "] not found.");
			return null;
		}
	}
	
	//import then return null since they're not this factory's output

	@Override
	public Potion getPotion(String potionId) {
		return null;
	}

	@Override
	public Elixir getElixir(String elixirId) {
		return null;
	}
}
