package factory;

public class FactoryProducer {
	
	//set the abstractfactory as the return type
	public static AbstractFactoryForProjectShop getFactory(String pickedProduct) 
	{
		switch(pickedProduct.toLowerCase())
		{
			case "p":
				return new PotionFactory();
			case "e":
				return new ElixirFactory();
			case "t":
				return new TrinketFactory();
			default:
				return null;
		}
	}
	
	//Main Use:
	//FactoryProducer.getFactory("potion").getPotion("P1");
	//FactoryProducer.getFactory("elixir").getElixir("E1");

}