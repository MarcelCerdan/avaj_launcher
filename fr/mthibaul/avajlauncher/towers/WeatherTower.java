package fr.mthibaul.avajlauncher.towers;

import fr.mthibaul.avajlauncher.Coordinates;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates p_coordinates) {
		return ("SUN");
	}

	public void changeWeather() {
		System.out.println("Weather changed");
	}
}
