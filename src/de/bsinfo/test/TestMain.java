package de.bsinfo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.bsinfo.Abstractclasses.Enemy;
import de.bsinfo.Abstractclasses.Player;
import de.bsinfo.Item.Equipment;
import de.bsinfo.PlayKlassen.*;
import de.bsinfo.enums.EquipmentType;
import de.bsinfo.hilfsklassen.Fight;

public class TestMain {

	static Connection con = null;
	static Statement stmt;
	static ResultSet res;

	static ArrayList<Equipment> body = new ArrayList<>();
	static ArrayList<Equipment> helmets = new ArrayList<>();
	static ArrayList<Equipment> weapons = new ArrayList<>();
	static ArrayList<Equipment> boots = new ArrayList<>();
	static ArrayList<Equipment> amulet = new ArrayList<>();

	static ArrayList<Companion> companion = new ArrayList<>();
	static ArrayList<Equipment> compRust = new ArrayList<>();

	static ArrayList<Player> player = new ArrayList<>();
	static ArrayList<Enemy> enemys = new ArrayList<>();

	public static void main(String[] args) {

		loadItems();

		enemys.add(new TestDummyEnemy());
		enemys.add(new TestDummyEnemy());
		player.add(new Thief("Hans", helmets.get(1), body.get(1), boots.get(1), weapons.get(1), amulet.get(1)));
		player.add(companion.get(0));
		System.out.println(player.size());
		
		System.out.println("ATK: "+player.get(1).getAtk());
		System.out.println("ATK Mit: "+player.get(1).getAtkBase());

		Fight fight = new Fight(enemys, player);
		System.out.println(enemys.size());
		enemys.add(new TestDummyEnemy());
		enemys.add(new TestDummyEnemy());
		System.out.println(enemys.size());
		fight = new Fight(enemys, player);
		fight = new Fight(enemys, player);

	}

	private static void loadItems() {
		String[] temp = TestMain.class.getResource("/res/Item.db").toString().split("file:");
		String connectionString = "jdbc:sqlite:" + temp[1];
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(connectionString);
			loadCompanions();
			loadAmulet();
			loadHelmets();
			loadBody();
			loadWeapons();
			loadBoots();
			//
			// for (int i = 0; i < helmets.size(); i++) {
			// System.out.println(helmets.get(i));
			// System.out.println();
			// System.out.println(body.get(i));
			// System.out.println();
			// System.out.println(boots.get(i));
			// System.out.println();
			// System.out.println(weapons.get(i));
			// System.out.println();
			// System.out.println(amulet.get(i));
			// System.out.println();
			// }
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	private static void loadCompRust() {
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery("SELECT * FROM CompRust");
			while (res.next()) {
				compRust.add(new Equipment(res.getString("Name"),
						/* res.getString("Beschreibung"), */ false, res.getInt("ATK"), res.getInt("DEF"),
						res.getInt("AGI"), res.getInt("FAS"), res.getInt("HP"), EquipmentType.Companion,
						res.getInt("ID")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void loadCompanions() {
		loadCompRust();
		try {
//			int id = 0;
			stmt = con.createStatement();
			res = stmt.executeQuery("SELECT * FROM Companions");
			while (res.next()) {
				companion.add(new Companion(res.getString("Name"), res.getInt("ATK"), res.getInt("DEF"),
						res.getInt("AGI"), res.getInt("FAS"), res.getInt("Life"), compRust.get(0),
						compRust.get(1), compRust.get(2), compRust.get(3), compRust.get(4)));
//				id += 5;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void loadAmulet() {
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery("SELECT * FROM Amulet");
			while (res.next()) {
				amulet.add(new Equipment(res.getString("Name"), res.getString("Beschreibung"), false, res.getInt("ATK"),
						res.getInt("DEF"), res.getInt("AGI"), res.getInt("FAHATK"), res.getInt("HP"),
						EquipmentType.Amulet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void loadBoots() {
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery("SELECT * FROM Stiefel");
			while (res.next()) {
				boots.add(new Equipment(res.getString("Name"), res.getString("Beschreibung"), false, res.getInt("ATK"),
						res.getInt("DEF"), res.getInt("AGI"), res.getInt("FAHATK"), res.getInt("HP"),
						EquipmentType.Boots));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void loadWeapons() {
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery("SELECT * FROM Waffen");
			while (res.next()) {
				weapons.add(new Equipment(res.getString("Name"), res.getString("Beschreibung"), false,
						res.getInt("ATK"), res.getInt("DEF"), res.getInt("AGI"), res.getInt("FAHATK"), res.getInt("HP"),
						EquipmentType.Weapon));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void loadHelmets() {
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery("SELECT * FROM Kopf");
			while (res.next()) {
				helmets.add(new Equipment(res.getString("Name"), res.getString("Beschreibung"), false,
						res.getInt("ATK"), res.getInt("DEF"), res.getInt("AGI"), res.getInt("FAHATK"), res.getInt("HP"),
						EquipmentType.Helmet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void loadBody() {
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery("SELECT * FROM Koerper");
			while (res.next()) {
				body.add(new Equipment(res.getString("Name"), res.getString("Beschreibung"), false, res.getInt("ATK"),
						res.getInt("DEF"), res.getInt("AGI"), res.getInt("FAHATK"), res.getInt("HP"),
						EquipmentType.Body));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
