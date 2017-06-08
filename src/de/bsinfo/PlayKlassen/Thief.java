package de.bsinfo.PlayKlassen;

import de.bsinfo.Abstractclasses.GameObject;
import de.bsinfo.Abstractclasses.Player;
import de.bsinfo.Item.Equipment;

public class Thief extends Player{

	public Thief(String name, Equipment helmet, Equipment body, Equipment boots, Equipment weapon, Equipment amulet) {
		super(name, 20, 5, 30, 10, 90, helmet, body, boots, weapon, amulet);
	}
	
	public void angriff(GameObject obj) {
		if ((getAgi()) >= (int) (Math.random() * 100 + 1)) {
			System.out.println("Crit");
			int x = getAtk() - ((obj.getDef() / 10));
			System.out.println("DMG: " + x);
			obj.setLife(obj.getlife() - (getAtk() * 2 - (obj.getDef() / 7)));
		} else {
			int x = (getAtk() - ((obj.getDef() / 3) + (obj.getAgi() / 8)));
			System.out.println("DMG: " + x);
			obj.setLife(obj.getlife() - (getAtk() - ((obj.getDef() / 5) + (obj.getAgi() / 8))));
		}
	}

	@Override
	public void ability1(GameObject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ability2(GameObject[] obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ability3(GameObject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ability4(GameObject obj) {
		// TODO Auto-generated method stub
		
	}
	
	

}
