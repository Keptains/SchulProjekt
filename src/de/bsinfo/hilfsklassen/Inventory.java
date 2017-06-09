package de.bsinfo.hilfsklassen;

import java.util.ArrayList;

import de.bsinfo.Item.Equipment;
import de.bsinfo.Item.Gift;
import de.bsinfo.Item.Heiltrank;

public class Inventory {
	
	ArrayList<Heiltrank> healing = new ArrayList<>();
	ArrayList<Gift> gift = new ArrayList<>();
	ArrayList<Equipment> equipment = new ArrayList<>();

	public Inventory() {
		healing.add(new Heiltrank());
		healing.add(new Heiltrank());
		healing.add(new Heiltrank());
		healing.add(new Heiltrank());
		healing.add(new Heiltrank());
		gift.add(new Gift());
//		gift.add(new Gift());
//		gift.add(new Gift());
	}

	public ArrayList<Heiltrank> getHealing() {
		return healing;
	}

	public void setHealing(ArrayList<Heiltrank> healing) {
		this.healing = healing;
	}

	public ArrayList<Gift> getGift() {
		return gift;
	}

	public void setGift(ArrayList<Gift> gift) {
		this.gift = gift;
	}

	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(ArrayList<Equipment> equipment) {
		this.equipment = equipment;
	}
	
	

}
