package fr.mthibaul.avajlauncher.aircrafts;

import fr.mthibaul.avajlauncher.towers.*;

public abstract class Flyable {

	protected WeatherTower wetherTower;

	public abstract void updateConditions();

	public void registerTower(WeatherTower p_tower) {
		System.out.println("Hello");
	}

}
