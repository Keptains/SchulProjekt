package de.bsinfo.Abstractclasses;

import java.util.ArrayList;

public abstract class Enemy extends GameObject{
	
	int exp;

	public Enemy(int atk, int def, int agi, int fas, int life, int exp) {
		super(atk, def, agi, fas, life);
		this.exp = exp;
	}

	public void turn(ArrayList<Player> player, ArrayList<Enemy> enemys) {
		
	}

	@Override
	public String toString() {
		return "Enemy [name=" + name + ", life=" + life + "]";
	}

	
	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}

	
}
