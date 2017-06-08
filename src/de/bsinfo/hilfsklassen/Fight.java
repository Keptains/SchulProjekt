package de.bsinfo.hilfsklassen;

import java.util.ArrayList;
import java.util.Scanner;

import de.bsinfo.Abstractclasses.Enemy;
import de.bsinfo.Abstractclasses.GameObject;
import de.bsinfo.Abstractclasses.Player;

public class Fight {

	private static Scanner scan = new Scanner(System.in);

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
			// enemyTurn();
			// isDeadPlayer();
		}
	}

	private void playerTurn() {
		if (playerRound == player.size())
			playerRound = 0;
		System.out.println("Was?");
		System.out.println("1 = Angriff");
		switch (getAction(player.get(playerRound))) {
		case 1:
			System.out.println("P war richtig");
			player.get(playerRound).angriff(getTargetEnemy());
			System.out.println("Nach Angriff: "+enemys.get(0));
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			System.out.println("Falsche Eingabe");
			playerTurn();
			break;
		}

	}

	private GameObject getTargetEnemy() {
		if (enemys.size() > 1) {
			System.out.println("Wen?");
			for (int i = 0; i < enemys.size(); i++) {
				System.out.println(i + " = " + enemys.get(i));
			}
			return enemyPick(scan.nextLine());
		} else {
			System.out.println(enemys.get(0));
			return enemys.get(0);
		}
	}

	private GameObject enemyPick(String nextLine) {
		try {
			int x = Integer.parseInt(nextLine);
			if (x >= 0 && x < enemys.size()) {
				return enemys.get(x);
			}
			return getTargetEnemy();
		} catch (Exception e) {
			return getTargetEnemy();
		}
	}

	private int getAction(Player player2) {
		String x = scan.nextLine();
		System.out.println("x=" + x);
		try {
			int p = Integer.parseInt(x);
			System.out.println("p=" + p);
			return p;
		} catch (Exception e) {
			return 99;
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
				System.out.println("Gestorben: " + enemys.get(i));
				enemys.remove(i);
				if (enemys.isEmpty())
					fighting = false;
			}
		}
	}

	// private void enemyTurn() {
	// if (enemyRound == enemys.size())
	// enemyRound = 0;
	// enemys.get(enemyRound).turn(player, enemys);
	// enemyRound++;
	// }
	//
	// private void playerTurn() {
	// if (playerRound == player.size())
	// playerRound = 0;
	// switch (playerTurn()) {
	// case 1:
	// player.get(playerRound).angriff(getTargetEnemy());
	// break;
	// case 2:
	// player.get(playerRound).inv.get(0).get(0).
	// break;
	// case 3:
	// break;
	// }
	// playerRound++;
	// }
	//
	// private GameObject getTargetPlayer() {
	// for (int i = 0; i < player.size(); i++) {
	// System.out.println(1 + i + " = " + player.get(i));
	// }
	// String x = scan2.nextLine();
	// return pickedTargetPlayer(x);
	// }
	//
	// private GameObject pickedTargetPlayer(String x) {
	// int y = -1;
	// try {
	// y = Integer.parseInt(x);
	// --y;
	// if (y > -1 && y < player.size()) {
	// return player.get(y);
	// } else {
	// System.out.println("Ungültige Eingabe");
	// return getTargetPlayer();
	// }
	// } catch (Exception e) {
	// System.out.println("Ungültige Eingabe");
	// return getTargetPlayer();
	// }
	// }
	//
	// private GameObject getTargetEnemy() {
	// for (int i = 0; i < enemys.size(); i++) {
	// System.out.println(1 + i + " = " + enemys.get(i));
	// }
	// Scanner scan1 = new Scanner(System.in);
	// String x = scan1.nextLine();
	// scan1.close();
	// return pickedTargetEnemy(x);
	// }
	//
	// private GameObject pickedTargetEnemy(String x) {
	// int y = -1;
	// try {
	// y = Integer.parseInt(x);
	// --y;
	// if (y > -1 && y < enemys.size()) {
	// return enemys.get(y);
	// } else {
	// System.out.println("Ungültige Eingabe");
	// return getTargetEnemy();
	// }
	// } catch (Exception e) {
	// System.out.println("Ungültige Eingabe");
	// return getTargetEnemy();
	// }
	// }
	//
	// public int playe() {
	// System.out.println();
	// System.out.println("Was willst du tun?");
	// System.out.println();
	// System.out.println("1 > Angriff");
	// System.out.println("2 > Heiltrank");
	// System.out.println("3 > Gift");
	// System.out.println();
	// System.out.print(" > ");
	// String x = scan.next();
	// return getPickAction(x);
	// }
	//
	// private int getPickAction(String x) {
	// try {
	// int p = Integer.parseInt(x);
	// if (p > 3 || p < 1) {
	// System.out.println("Ungültige Eingabe!");
	// return turn();
	// }
	// return p;
	// } catch (Exception e) {
	// System.out.println();
	// System.out.println("Ungültige Eingabe!");
	// return turn();
	// }
	// }
}
