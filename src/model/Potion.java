package model;

public abstract class Potion implements Item, Cloneable
{
	//restores health
	private final String name;
	private final String description;
	private final double price;
	private final int code;
	
	public Potion(String name, String description, double price, int code)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.code = code;
	}
	
	@Override
	public String name() {return name;}

	@Override
	public double price() { return price;}
	
	public String description() {return description;}
	
	@Override
	public int code() {return code;}
	
	@Override
	public abstract Potion clone();
	
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
	    Potion other = (Potion) obj;
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
