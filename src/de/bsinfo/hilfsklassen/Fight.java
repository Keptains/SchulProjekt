package de.bsinfo.hilfsklassen;

import java.util.ArrayList;

import de.bsinfo.Abstractclasses.Enemy;
import de.bsinfo.Abstractclasses.Player;

public class Fight {

	boolean fighting = true;
	ArrayList<Enemy> enemys;
	ArrayList<Player> player;
	int playerRound = 0;
	int enemyRound = 0;

	public Fight(ArrayList<Enemy> enemys, ArrayList<Player> player) {
		this.enemys = enemys;
		this.player = player;
		startFight();
	}

	private void startFight() {
		while (fighting) {
			playerTurn();
			isDeadEnemy();
			enemyTurn();
			isDeadPlayer();
		}
	}

	private void isDeadPlayer() {
		for (int i = 0; i < player.size(); i++) {
			if (player.get(i).getlife() <= 0) {
				player.remove(i);
				if (player.isEmpty())
					fighting = false;
			}
		}
	}

	private void isDeadEnemy() {
		for (int i = 0; i < enemys.size(); i++) {
			if (enemys.get(i).getlife() <= 0) {
				enemys.remove(i);
				if (enemys.isEmpty())
					fighting = false;
			}
		}
	}

	private void enemyTurn() {
		if (enemyRound == enemys.size())
			enemyRound = 0;
		enemys.get(enemyRound).turn(player, enemys);
		enemyRound++;
	}

	private void playerTurn() {
		if (playerRound == player.size())
			playerRound = 0;
		getTargetPlayer(player.get(playerRound).turn(player, enemys));
		playerRound++;
	}

	private void getTargetPlayer(int turn) {
		System.out.println("Enemys:");
		System.out.println();
		for (int i = 0; i < enemys.size(); i++) {
			System.out.println(i+1+";E = "+enemys.get(i));
		}
		System.out.println();
		System.out.println("Player:");
		System.out.println();
		for (int i = 0; i < player.size(); i++) {
			System.out.println(i+1+";P = "+player.get(i));
		}
//		String[] x =
		
	}

	private void getTargetEnemy(int turn) {

	}

}
