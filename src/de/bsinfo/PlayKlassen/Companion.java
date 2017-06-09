package de.bsinfo.PlayKlassen;

import de.bsinfo.Abstractclasses.GameObject;
import de.bsinfo.Abstractclasses.Player;
import de.bsinfo.Item.Equipment;

public class Companion extends Player{

	public Companion(String name, int atk, int def, int agi, int fas, int life, Equipment helmet, Equipment body,
			Equipment boots, Equipment weapon, Equipment amulet) {
		super(name, atk, def, agi, fas, life, helmet, body, boots, weapon, amulet, false);
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
