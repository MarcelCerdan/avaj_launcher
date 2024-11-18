package fr.mthibaul.avajlauncher.aircrafts;

import fr.mthibaul.avajlauncher.Coordinates;
import fr.mthibaul.avajlauncher.exceptions.HeightBelowMinimumException;
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

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		try {
			switch (weather) {
				case "SUN" -> {
					updateCoord(0, 10, 2);
					System.out.println(getFullId() + ": Clear skies ahead. Warning: Excess coolness might blind nearby pilots.");
					}
				case "RAIN" -> {
					updateCoord(0, 5, 0);
					System.out.println(getFullId() + ": Rain is here! Jet engine tip: Don’t suck in too much water, unless you’re secretly a submarine.");
					}
				case "FOG" -> {
					updateCoord(0, 1, 0);
					System.out.println(getFullId() + ": Flying blind, are we? Just channel your inner Jedi for this one.");
					}
				case "SNOW" -> {
					updateCoord(0, 0, -7);
					System.out.println(getFullId() + ": Snow is falling! Your JetPlane is now a high-speed snowflake.");
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
		return ("JetPlane");
	}

}
