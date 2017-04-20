package model;

public abstract class Elixir implements Item 
{
	//restores health
	private final String name;
	private final String description;
	private final double price;
	
	public Elixir(String name, String description, double price)
	{
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	@Override
	public String name() {return name;}

	@Override
	public double price() { return price;}
	
	public String description() {return description;}

	@Override
	public abstract Elixir clone();
}
