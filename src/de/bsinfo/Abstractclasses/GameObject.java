package de.bsinfo.Abstractclasses;

import de.bsinfo.enums.Status;
import de.bsinfo.enums.Tactic;

public abstract class GameObject implements Faehigkeiten {

	String name;
	
	
	GameObject obj;
	Tactic tactic = Tactic.one_vs_one;
	Status status = Status.Normal;

	int statusTime = 0;
	int tickDamge;
	
	int maxLife;
	int atk;
	int def;
	int agi;
	int fas;
	int life;

	public GameObject(String name, int atk, int def, int agi, int fas, int life) {
		// super();
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.agi = agi;
		this.fas = fas;
		this.life = life;
	}

	public GameObject(String name, int atk, int def, int agi, int fas, int life, int maxLife) {
		// super();
		this.maxLife = maxLife;
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.agi = agi;
		this.fas = fas;
		this.life = life;
	}

	public int getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(int statusTime) {
		this.statusTime = statusTime;
	}

	public int getLife() {
		return life;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public GameObject(int atk, int def, int agi, int fas, int life) {
		// super();
		this.maxLife = life;
		this.atk = atk;
		this.def = def;
		this.agi = agi;
		this.fas = fas;
		this.life = life;
	}

	public void angriff(GameObject obj) {
		if ((getAgi() / 2) >= (int) (Math.random() * 100 + 1)) {
			System.out.println("Crit");
			int x = getAtk() - ((obj.getDef() / 5));
			System.out.println("DMG: " + x);
			obj.setLife(obj.getlife() - (getAtk() * 2 - (obj.getDef() / 5)));
		} else {
			int x = (getAtk() - ((obj.getDef() / 5) + (obj.getAgi() / 8)));
			System.out.println("DMG: " + x);
			obj.setLife(obj.getlife() - (getAtk() - ((obj.getDef() / 5) + (obj.getAgi() / 8))));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setLife(int life) {
		this.life = life;
	}

	public GameObject getObj() {
		return obj;
	}

	public void setObj(GameObject obj) {
		this.obj = obj;
	}

	public Tactic getTactic() {
		return tactic;
	}

	public void setTactic(Tactic tactic) {
		this.tactic = tactic;
	}

	public int getTickDamge() {
		return tickDamge;
	}

	public void setTickDamge(int tickDamge) {
		this.tickDamge = tickDamge;
	}

	public int getMaxLife() {
		return maxLife;
	}
	
}

interface Faehigkeiten {

	public void ability1(GameObject obj);

	public void ability2(GameObject[] obj);

	public void ability3(GameObject obj);

	public void ability4(GameObject obj);
}
