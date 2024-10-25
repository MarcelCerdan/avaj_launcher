package fr.mthibaul.avajlauncher.aircrafts;

import fr.mthibaul.avajlauncher.towers.*;

public abstract class Flyable {

	protected WeatherTower wetherTower;

	public abstract void updateConditions();
	public abstract int getHeight();
	public abstract long getId();
	public abstract String getName();
	public abstract String getType();

	public void registerTower(WeatherTower p_tower) {
		wetherTower = p_tower;
		p_tower.register(this);
	}


}
