package fr.mthibaul.avajlauncher.towers;

import fr.mthibaul.avajlauncher.Coordinates;

public class WeatherProvider {

	private String[][][] weather;

	private WeatherProvider() {

	}

	public String getCurrentWeather(Coordinates p_coordinates) {
		return weather[p_coordinates.getLongitude()][p_coordinates.getLatitude()][p_coordinates.getHeight()];
	}
}
