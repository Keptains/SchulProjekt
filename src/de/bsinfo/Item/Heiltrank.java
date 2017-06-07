package de.bsinfo.Item;

import de.bsinfo.Abstractclasses.GameObject;
import de.bsinfo.Abstractclasses.Items;

public class Heiltrank extends Items{

	public Heiltrank() {
		super("Heiltrank", "Ein kleiner roter Trank der 75HP heilt", false);
	}

	@Override
	public void useItem(GameObject obj) {
		obj.setLife(obj.getlife()+75);
		if(obj.getlife()>obj.getMaxLife())
			obj.setLife(obj.getMaxLife());
	}

	@Override
	public void multipleUserUse(GameObject[] obj) {
		
	}

}
