package fr.mthibaul.avajlauncher.aircrafts;

import fr.mthibaul.avajlauncher.Coordinates;
import fr.mthibaul.avajlauncher.towers.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public JetPlane(long p_id, String p_name, Coordinates p_Coordinates) {
		super(p_id, p_name, p_Coordinates);
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
		return ("JetPlane");
	}

}
