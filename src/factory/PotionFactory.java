package factory;
import java.util.HashMap;
import java.util.Map;

import model.Elixir;
import model.Potion;
import model.Trinket;
import model.potion.*;

public class PotionFactory implements PotionMaker, AbstractFactoryForProjectShop
{
	static final Map<String, Potion> prototypeMap = new HashMap<>();
	
	static 
	{
		prototypeMap.put("P1", new AppleEssence());
		prototypeMap.put("P2", new BerryExtract());
		prototypeMap.put("P3", new GingerAle());
	}

	@Override
	public Potion getPotion(String potionId) 
	{

		try
		{
			return (Potion) prototypeMap.get(potionId).clone();
		}
		catch (NullPointerException npe)
		{
			System.err.println("Prototype: [" + potionId + "] not found.");
			return null;
		}
	}

	//we need to import these too but have them return null
	
	@Override
	public Elixir getElixir(String elixirId) {
		return null;
	}

	@Override
	public Trinket getTrinket(String trinketId) {
		return null;
	}
}
