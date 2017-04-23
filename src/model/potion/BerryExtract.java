package model.potion;
import model.Potion;
import utility.PotionValues;

public class BerryExtract extends Potion implements PotionValues{
	
	public BerryExtract(){
		super(P2[0], P2[1], Double.parseDouble(P2[2]), Integer.parseInt(P2[3]));
	}

	@Override
	public Potion clone() {
		return new BerryExtract();
	}
	
	public boolean equals(Object o)
	{
		if (!(o instanceof Potion)) 
		{
		    return false;
		}
		BerryExtract other = (BerryExtract) o;
		return name().equals(other.name());
	}

	public int hashCode() {
	  return name().hashCode();
	}
	
}