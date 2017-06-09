package de.bsinfo.Abstractclasses;

import de.bsinfo.Item.Equipment;
import de.bsinfo.hilfsklassen.Inventory;

public abstract class Player extends GameObject {

	int gold = 1000;
	int level = 0;
	int exp = 0;
	
	boolean player;

	int[] levels = { 100, 250, 500, 800, 1150 };

	int atkBase;
	int defBase;
	int agiBase;
	int fasBase;
	int lifeBase;

	boolean[] abilitys = { false, false, false, false };

	public Inventory inv = new Inventory();

	Equipment helmet;
	Equipment body;
	Equipment boots;
	Equipment weapon;
	Equipment amulet;

	public Player(String name, int atk, int def, int agi, int fas, int life, Equipment helmet, Equipment body,
			Equipment boots, Equipment weapon, Equipment amulet, boolean player) {
		super(name, atk, def, agi, fas, life);
		this.atkBase = atk;
		this.defBase = def;
		this.agiBase = agi;
		this.fasBase = fas;
		this.lifeBase = life;
		this.helmet = helmet;
		this.body = body;
		this.boots = boots;
		this.weapon = weapon;
		this.amulet = amulet;
		this.player = player;
		setStats();
		System.out.println("Er macht es auch");
	}

	@Override
	public String toString() {
		return "Player [atkBase=" + atkBase + ", defBase=" + defBase + ", agiBase=" + agiBase + ", fasBase=" + fasBase
				+ ", lifeBase=" + lifeBase + ", name=" + name + ", atk=" + atk + ", def=" + def + ", agi=" + agi
				+ ", fas=" + fas + ", life=" + life + "]";
	}

	public int getMaxLife() {
		return getLifeBase() + helmet.getlife() + body.getlife() + boots.getlife() + weapon.getlife()
				+ amulet.getlife();
	}

	public void setStats() {
		setAtk(getAtkBase() + helmet.getAtk() + body.getAtk() + boots.getAtk() + weapon.getAtk() + amulet.getAtk());
		setDef(getDefBase() + helmet.getDef() + body.getDef() + boots.getDef() + weapon.getDef() + amulet.getDef());
		setAgi(getAgiBase() + helmet.getAgi() + body.getAgi() + boots.getAgi() + weapon.getAgi() + amulet.getAgi());
		setFas(getFasBase() + helmet.getFas() + body.getFas() + boots.getFas() + weapon.getFas() + amulet.getFas());
		setLife(getLifeBase() + helmet.getlife() + body.getlife() + boots.getlife() + weapon.getlife()
				+ amulet.getlife());
	}
	
	public boolean getPlayer(){
		return player;
	}

	public int getAtkBase() {
		return atkBase;
	}

	public void setAtkBase(int atkBase) {
		this.atkBase = atkBase;
	}

	public int getDefBase() {
		return defBase;
	}

	public void setDefBase(int defBase) {
		this.defBase = defBase;
	}

	public int getAgiBase() {
		return agiBase;
	}

	public void setAgiBase(int agiBase) {
		this.agiBase = agiBase;
	}

	public int getFasBase() {
		return fasBase;
	}

	public void setFasBase(int fasBase) {
		this.fasBase = fasBase;
	}

	public int getLifeBase() {
		return lifeBase;
	}

	public void setLifeBase(int lifeBase) {
		this.lifeBase = lifeBase;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public boolean getExpLevel() {
		System.out.println("EXP: " + getExp());
		if (getExp() >= levels[getLevel()]) {
			System.out.println("YAY Level up");
			setLevel(getLevel() + 1);
			System.out.println("Neues Level: " + getLevel());
			switch (getLevel()) {
			case 1:
				System.out.println("YAY LOL Erlernt");
				abilitys[0] = true;
				break;

			case 5:
				System.out.println("NAy");
				break;
			}
			return true;
		}
		return false;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public Equipment getHelmet() {
		return helmet;
	}

	public void setHelmet(Equipment helmet) {
		this.helmet = helmet;
	}

	public Equipment getBody() {
		return body;
	}

	public void setBody(Equipment body) {
		this.body = body;
	}

	public Equipment getBoots() {
		return boots;
	}

	public void setBoots(Equipment boots) {
		this.boots = boots;
	}

	public Equipment getWeapon() {
		return weapon;
	}

	public void setWeapon(Equipment weapon) {
		this.weapon = weapon;
	}

	public Equipment getAmulet() {
		return amulet;
	}

	public void setAmulet(Equipment amulet) {
		this.amulet = amulet;
	}

}
