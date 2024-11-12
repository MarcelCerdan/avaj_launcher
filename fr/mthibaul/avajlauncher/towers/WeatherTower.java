package fr.mthibaul.avajlauncher.towers;

import fr.mthibaul.avajlauncher.Coordinates;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates p_coordinates) {
		String weather = weatherProvider.getCurrentWeather(p_coordinates);
		return weather;
	}

	public void changeWeather() {
		conditionChanged();
	}
}
