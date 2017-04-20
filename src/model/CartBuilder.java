package model;

import factory.FactoryProducer;

//used to add package deals to the cart
public class CartBuilder {
	
	public Cart healerSet(Cart cart)
	{
		cart.addItem(FactoryProducer.getFactory("potion").getPotion("P1"));
		cart.addItem(FactoryProducer.getFactory("potion").getPotion("P1"));
		cart.addItem(FactoryProducer.getFactory("potion").getPotion("P2"));
		cart.addItem(FactoryProducer.getFactory("trinket").getPotion("T3"));
		return cart;
	}
	
	public Cart bufferSet(Cart cart)
	{
		cart.addItem(FactoryProducer.getFactory("elixir").getPotion("E1"));
		cart.addItem(FactoryProducer.getFactory("elixir").getPotion("E3"));
		cart.addItem(FactoryProducer.getFactory("elixir").getPotion("E3"));
		return cart;
	}
	
	public Cart reviverSet(Cart cart)
	{
		cart.addItem(FactoryProducer.getFactory("elixir").getPotion("E2"));
		cart.addItem(FactoryProducer.getFactory("elixir").getPotion("E2"));
		cart.addItem(FactoryProducer.getFactory("trinket").getPotion("T1"));
		return cart;
	}
}
