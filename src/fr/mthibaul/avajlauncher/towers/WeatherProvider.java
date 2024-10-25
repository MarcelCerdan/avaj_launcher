package fr.mthibaul.avajlauncher.towers;

import fr.mthibaul.avajlauncher.Coordinates;

public class WeatherProvider {

	private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {}

	public String getCurrentWeather(Coordinates p_coordinates) {
		int weatherValue = p_coordinates.getLatitude() + p_coordinates.getLongitude() + p_coordinates.getHeight();

		return weather[weatherValue % 4];
	}
}
