package fr.mthibaul.avajlauncher.aircrafts;

import fr.mthibaul.avajlauncher.Coordinates;
import fr.mthibaul.avajlauncher.exceptions.HeightBelowMinimumException;
import fr.mthibaul.avajlauncher.towers.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
		
	public Baloon(long p_id, String p_name, Coordinates p_Coordinates) {
		super(p_id, p_name, p_Coordinates);
	}

    @Override
	public void registerTower(WeatherTower p_tower) {
		this.weatherTower = p_tower;
		weatherTower.register(this);
		printRegstration();
	}

    @Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		try {
			switch (weather) {
				case "SUN" -> {
					updateCoord(2, 0, 4);
					System.out.println(getFullId() + ": Perfect day for a balloon adventure! Unless you’re scared of UV rays...");
					}
				case "RAIN" -> {
					updateCoord(0, 0, -5);
					System.out.println(getFullId() + ": Rain is here! Hope your balloon is waterproof—nobody likes a soggy landing.");
					}
				case "FOG" -> {
					updateCoord(0, 0, -3);
					System.out.println(getFullId() + ": Visibility: practically zero. Time to pretend you’re a ghost ship of the skies!");
					}
				default -> {
					updateCoord(0, 0, -15);
					System.out.println(getFullId() + ": It’s snowing, and your balloon is now a flying snow globe! Watch out for penguins.");
					}
				}	
		}
		catch (HeightBelowMinimumException e) {
			System.out.println(getFullId() + " landing.");
			weatherTower.unregister(this);
		}
	}

	@Override
	public String getType() {
		return ("Baloon");
	}
}
