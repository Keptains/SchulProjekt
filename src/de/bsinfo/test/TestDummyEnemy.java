package de.bsinfo.test;

import de.bsinfo.Abstractclasses.Enemy;
import de.bsinfo.Abstractclasses.GameObject;

public class TestDummyEnemy extends Enemy{
	
	String name = "TestDummy";

	public TestDummyEnemy() {
		super(20, 20, 20, 20, 200, 150);
	}

	@Override
	public void ability1(GameObject obj) {
		
	}

	@Override
	public void ability2(GameObject[] obj) {
		
	}

	@Override
	public void ability3(GameObject obj) {
		
	}

	@Override
	public void ability4(GameObject obj) {
		
	}

}
