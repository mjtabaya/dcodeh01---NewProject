package factory;

import model.Trinket;

public interface TrinketMaker {

	Trinket getTrinket(String trinketId);
	
}
