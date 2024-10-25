package fr.mthibaul.avajlauncher;

import java.util.ArrayList;
import java.util.List;

import fr.mthibaul.avajlauncher.aircrafts.*;
import fr.mthibaul.avajlauncher.towers.*;

public class AvajLauncher {
	private static int runNb;
	private static WeatherTower tower = new WeatherTower();

	
	public static void main(String[] args) {
		FileChecker fileChecker = new FileChecker();

		List<String> lines = fileChecker.checkFile(args[0]);
		
		if (lines == null)
			return;
		
		initWeatherTower(lines);
		
		for (int i = 0; i < runNb; i++) {

		}

	}

	private static void initWeatherTower(List<String> lines) {
		ArrayList<Flyable> flyables = initFlyables(lines);

		for (Flyable flyable : flyables) {
			if (flyable.getHeight() > 0)
				flyable.registerTower(tower);
		}
	}

	private static ArrayList<Flyable> initFlyables(List<String> lines) {
		runNb = Integer.parseInt(lines.get(0));
		ArrayList<Flyable> flyables = new ArrayList<>();

		AircraftFactory aircraftFactory = AircraftFactory.getInstance();

		lines.remove(0);
		for (String line : lines) {
			String[] splitedLine = line.split(" ");
			int height = Integer.parseInt(splitedLine[4]);
			if (height > 100)
				height = 100;
			else if (height < 0)
				height = 0;
			Coordinates coordinates = new Coordinates(Integer.parseInt(splitedLine[2]), Integer.parseInt(splitedLine[3]), height);
			flyables.add(aircraftFactory.newAircraft(splitedLine[0], splitedLine[1], coordinates));
		}

		return flyables;
	}


}
