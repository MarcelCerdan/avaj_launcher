package fr.mthibaul.avajlauncher.aircrafts;

import fr.mthibaul.avajlauncher.Coordinates;
import fr.mthibaul.avajlauncher.towers.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void registerTower(WeatherTower p_tower) {
		this.weatherTower = p_tower;
		weatherTower.register(this);
		printRegstration();
	}

	public void updateConditions() {
		
	}

	public String getType() {
		return ("Helicopter");
	}

}
