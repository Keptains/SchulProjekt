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
import de.bsinfo.enums.EquipmentType;

public class TestMain {

	static Connection con = null;
	static Statement stmt;
	static ResultSet res;
	
	static ArrayList<Equipment> body = new ArrayList<>();
	static ArrayList<Equipment> helmets = new ArrayList<>();
	static ArrayList<Equipment> weapons = new ArrayList<>();
	static ArrayList<Equipment> boots = new ArrayList<>();
	static ArrayList<Equipment> amulet = new ArrayList<>();
	
	static ArrayList<Player> player = new ArrayList<>();
	static ArrayList<Enemy> enemys = new ArrayList<>();

	public static void main(String[] args) {

		loadItems();
		
		enemys.add(new TestDummyEnemy());
		player.add(new TestDummyPlayer("Hans", helmets.get(0), body.get(0), boots.get(0), weapons.get(0), amulet.get(0)));
		
		System.out.println(enemys.get(0));
		System.out.println(player.get(0));

	}

	private static void loadItems() {
		String[] temp = TestMain.class.getResource("/res/Item.db").toString().split("file:");
		String connectionString = "jdbc:sqlite:" + temp[1];
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(connectionString);
			loadAmulet();
			loadHelmets();
			loadBody();
			loadWeapons();
			loadBoots();

			for (int i = 0; i < helmets.size(); i++) {
				System.out.println(helmets.get(i));
				System.out.println();
				System.out.println(body.get(i));
				System.out.println();
				System.out.println(boots.get(i));
				System.out.println();
				System.out.println(weapons.get(i));
				System.out.println();
				System.out.println(amulet.get(i));
				System.out.println();
			}
		} catch (ClassNotFoundException | SQLException e) {
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