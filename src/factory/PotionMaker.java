package factory;

import model.Potion;

public interface PotionMaker {

	Potion getPotion(String potionId);
	
}
