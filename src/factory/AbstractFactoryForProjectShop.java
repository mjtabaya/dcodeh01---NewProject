package factory;

import model.Elixir;
import model.Potion;
import model.Trinket;

//This interface is the top of the factory hierarchy to encapsulate a group of individual factories 
//for related objects, making sure we have a factory for each class and that a factory will return it
//In this case, shop objects. Potion, Elixir and Trinket factories expected to implement this interface.
//factories lets us create objects dynamically during runtime without having to code
//"new object()" in controller classes
public interface AbstractFactoryForProjectShop 
{
	Potion getPotion(String potionId);
	Elixir getElixir(String elixirId);
	Trinket getTrinket(String trinketId);
}
//
