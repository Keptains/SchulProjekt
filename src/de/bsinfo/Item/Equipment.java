package de.bsinfo.Item;

import de.bsinfo.enums.EquipmentType;

public class Equipment {
	
	String name;
	String beschreibung;
	
	boolean legendary;

	int id;
	int atk;
	int def;
	int agi;
	int fas;
	int life;
	
	EquipmentType type;
	
	public Equipment(String name, String beschreibung, boolean legendary, int atk, int def, int agi, int fas, int life,
			EquipmentType type) {
		super();
		this.name = name;
		this.beschreibung = beschreibung;
		this.legendary = legendary;
		this.atk = atk;
		this.def = def;
		this.agi = agi;
		this.fas = fas;
		this.life = life;
		this.type = type;
	}
	
	public Equipment(String name, boolean legendary, int atk, int def, int agi, int fas, int life,
			EquipmentType type, int id) {
		super();
		this.name = name;
		this.beschreibung = beschreibung;
		this.legendary = legendary;
		this.atk = atk;
		this.def = def;
		this.agi = agi;
		this.fas = fas;
		this.life = life;
		this.type = type;
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "Equipment [name=" + name + ", beschreibung=" + beschreibung /*+ ", legendary=" + legendary + ", atk="
				+ atk + ", def=" + def + ", agi=" + agi + ", fas=" + fas + ", life=" + life + ", type=" + type + "]"*/;
	}

	public boolean isLegendary() {
		return legendary;
	}

	public void setLegendary(boolean legendary) {
		this.legendary = legendary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getAgi() {
		return agi;
	}

	public void setAgi(int agi) {
		this.agi = agi;
	}

	public int getFas() {
		return fas;
	}

	public void setFas(int fas) {
		this.fas = fas;
	}

	public int getlife() {
		return life;
	}

	public void setlife(int life) {
		this.life = life;
	}

	public EquipmentType getType() {
		return type;
	}

	public void setType(EquipmentType type) {
		this.type = type;
	}
	
}

interface Ability{
	
	public void useAbility();
	
}

