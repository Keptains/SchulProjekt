package de.bsinfo.Abstractclasses;

import java.util.ArrayList;
import java.util.Scanner;

import de.bsinfo.Item.Equipment;
import de.bsinfo.Item.Gift;
import de.bsinfo.Item.Heiltrank;
import de.bsinfo.hilfsklassen.Inventory;

public abstract class Player extends GameObject {

	int gold = 1000;
	int level = 1;
	int exp = 0;

	int atkBase;
	int defBase;
	int agiBase;
	int fasBase;
	int lifeBase;

	Inventory inv = new Inventory();

	Equipment helmet;
	Equipment body;
	Equipment boots;
	Equipment weapon;
	Equipment amulet;

	Scanner scan = new Scanner(System.in);

	public Player(String name, int atk, int def, int agi, int fas, int life, Equipment helmet, Equipment body,
			Equipment boots, Equipment weapon, Equipment amulet) {
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
		fillStartInventory();
		setStats();
	}

	@Override
	public String toString() {
		return "Player [atkBase=" + atkBase + ", defBase=" + defBase + ", agiBase=" + agiBase + ", fasBase=" + fasBase
				+ ", lifeBase=" + lifeBase + ", name=" + name + ", atk=" + atk + ", def=" + def + ", agi=" + agi
				+ ", fas=" + fas + ", life=" + life + "]";
	}

	@SuppressWarnings("unchecked")
	private void fillStartInventory() {
		for (int i = 0; i < 5; i++) {
			inv.get(0).add(new Heiltrank());
			inv.get(1).add(new Gift());
		}
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

	public int turn(ArrayList<Player> player, ArrayList<Enemy> enemys) {
		System.out.println();
		System.out.println("Was willst du tun?");
		System.out.println();
		System.out.println("1 > Angriff");
		System.out.println("2 > Heiltrank");
		System.out.println("3 > Gift");
		System.out.println();
		System.out.print("  > ");
		String x = scan.nextLine();
		return getPickAction(x, player, enemys);
	}

	private int getPickAction(String x, ArrayList<Player> player, ArrayList<Enemy> enemys) {
		try {
			int p = Integer.parseInt(x);
			if(p>3 || p<1){
				System.out.println("Ungültige Eingabe!");
				return turn(player, enemys);
			}
			return p;
		} catch (Exception e) {
			System.out.println();
			System.out.println("Ungültige Eingabe!");
			return turn(player, enemys);
		}
	}

}
