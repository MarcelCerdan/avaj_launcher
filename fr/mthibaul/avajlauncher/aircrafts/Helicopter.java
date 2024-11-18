package fr.mthibaul.avajlauncher.aircrafts;

import fr.mthibaul.avajlauncher.Coordinates;
import fr.mthibaul.avajlauncher.exceptions.HeightBelowMinimumException;
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

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		try {
			switch (weather) {
				case "SUN" -> {
					updateCoord(10, 0, 2);
					System.out.println(getFullId() + ": Clear skies ahead! Just remember, no sunbathing on the rotor.");
					}
				case "RAIN" -> {
					updateCoord(5, 0, 0);
					System.out.println(getFullId() + ": Flying in the rain? Just don’t mistake the rotors for a ceiling fan.");
					}
				case "FOG" -> {
					updateCoord(1, 0, 0);
					System.out.println(getFullId() + ": Fog level: thick. Fly carefully—your GPS might need a seeing-eye dog.");
					}
				case "SNOW" -> {
					updateCoord(0, 0, -12);
					System.out.println(getFullId() + ": Snow + rotors = instant snowstorm. Who needs a snow globe anyway?");
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
		return ("Helicopter");
	}

}
