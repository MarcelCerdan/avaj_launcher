package fr.mthibaul.avajlauncher.aircrafts;

import fr.mthibaul.avajlauncher.towers.*;

public interface Flyable {

	public void updateConditions();
	public void registerTower(WeatherTower p_tower);
	public String getFullId();

}
