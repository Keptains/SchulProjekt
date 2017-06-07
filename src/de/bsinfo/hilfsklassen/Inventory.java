package de.bsinfo.hilfsklassen;

import java.util.ArrayList;

import de.bsinfo.Item.Equipment;
import de.bsinfo.Item.Gift;
import de.bsinfo.Item.Heiltrank;

@SuppressWarnings({ "rawtypes", "serial" })
public class Inventory extends ArrayList<ArrayList>{

//	@SuppressWarnings("rawtypes")
//	ArrayList[] inventory = new ArrayList[4];


	public Inventory() {
		this.add(new ArrayList<Heiltrank>());
		this.add(new ArrayList<Gift>());
		this.add(new ArrayList<Equipment>());
//		this.add();
//		inventory[0] = new ArrayList<Heiltrank>()
//		inventory[1] = new ArrayList<Gift>();
//		inventory[2] = new ArrayList<Equipment>();
	}

}
