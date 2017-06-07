package de.bsinfo.Abstractclasses;

import java.util.ArrayList;

public abstract class Enemy extends GameObject{

	public Enemy(int atk, int def, int agi, int fas, int life) {
		super(atk, def, agi, fas, life);
	}

	public void turn(ArrayList<Player> player, ArrayList<Enemy> enemys) {
		
	}

	@Override
	public String toString() {
		return "Enemy [name=" + name + ", life=" + life + "]";
	}

}
