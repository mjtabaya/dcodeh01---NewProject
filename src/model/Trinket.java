package model;

public abstract class Trinket implements Item {
	//restores health
	private final String name;
	private final String description;
	private final double price;
	
	public Trinket(String name, String description, double price)
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
	public abstract Trinket clone();
	
	@Override
	public int hashCode() 
	{
	  final int prime = 31;
	  int result = 1;
	  result = prime * result + ((name == null) ? 0 : name.hashCode());
	  return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
	    if (this == obj)
	      return true;
	    if (obj == null)
	      return false;
	    if (getClass() != obj.getClass())
	      return false;
	    Trinket other = (Trinket) obj;
	    if (name == null) 
	    {
	      if (other.name != null)
	        return false;
	    } 
	    else if (!name.equals(other.name))
	      return false;
	    return true;
	}
}
