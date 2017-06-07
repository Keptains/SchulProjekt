package de.bsinfo.Item;

import de.bsinfo.Abstractclasses.GameObject;
import de.bsinfo.Abstractclasses.Items;

public class Gift extends Items {

	public Gift() {
		super("Gift", "Gift", false);
	}

	@Override
	public void useItem(GameObject obj) {
		obj.setLife(obj.getlife() - 50);
	}

	@Override
	public void multipleUserUse(GameObject[] obj) {
		// TODO Auto-generated method stub

	}

}
