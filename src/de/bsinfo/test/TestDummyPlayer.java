package de.bsinfo.test;

import de.bsinfo.Abstractclasses.GameObject;
import de.bsinfo.Abstractclasses.Player;
import de.bsinfo.Item.Equipment;

public class TestDummyPlayer extends Player {

	public TestDummyPlayer(String name, Equipment helmet, Equipment body,
			Equipment boots, Equipment weapon, Equipment amulet) {
		super(name, 20, 30, 12, 10, 160, helmet, body, boots, weapon, amulet);
	}

	@Override
	public void ability1(GameObject obj) {
		
	}

	@Override
	public void ability2(GameObject[] obj) {
		
	}

	@Override
	public void ability3(GameObject obj) {
		
	}

	@Override
	public void ability4(GameObject obj) {
		
	}

}
