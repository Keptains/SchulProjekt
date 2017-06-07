package de.bsinfo.Abstractclasses;

public abstract class Items implements ItemUse {

	String name;
	String beschreibung;

	boolean moreUser;

	public Items(String name, String beschreibung, boolean moreUser) {
		super();
		this.name = name;
		this.beschreibung = beschreibung;
		this.moreUser = moreUser;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", beschreibung: " + beschreibung + "]";
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

	public boolean isMoreUser() {
		return moreUser;
	}

	public void setMoreUser(boolean moreUser) {
		this.moreUser = moreUser;
	}

	public void use(GameObject obj) {
		useItem(obj);
	}

	public void use(GameObject[] obj) {
		if (moreUser && obj.length>=1) {
			multipleUserUse(obj);
		} else {
			useItem(obj[0]);
		}
	}

}

interface ItemUse {

	public void useItem(GameObject obj);

	public void multipleUserUse(GameObject[] obj);

}
