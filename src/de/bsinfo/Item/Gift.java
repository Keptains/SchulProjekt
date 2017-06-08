package de.bsinfo.Item;

import de.bsinfo.Abstractclasses.GameObject;
import de.bsinfo.Abstractclasses.Items;
import de.bsinfo.enums.Status;

public class Gift extends Items {

	public Gift() {
		super("Gift", "Gift", false);
	}
	
	int tickDamage = 25;
	int ticks = 3;
	
	

	public int getTickDamage() {
		return tickDamage;
	}

	public int getTicks() {
		return ticks;
	}

	@Override
	public void useItem(GameObject obj) {
		obj.setStatus(Status.Poison);
		obj.setTickDamge(tickDamage);
		obj.setStatusTime(ticks);
	}

	@Override
	public void multipleUserUse(GameObject[] obj) {
		// TODO Auto-generated method stub

	}

}
