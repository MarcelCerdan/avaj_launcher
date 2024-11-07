package fr.mthibaul.avajlauncher;

import fr.mthibaul.avajlauncher.aircrafts.*;
import fr.mthibaul.avajlauncher.towers.*;
import java.util.List;

public class AvajLauncher {
	private static int runNb;
	private static WeatherTower tower = new WeatherTower();

	
	public static void main(String[] args) {
		FileChecker fileChecker = new FileChecker();

		if (args.length != 1) {
			System.out.println("Please input a valid scenario file as argument and nothing else.");
			System.exit(1);
		}

		List<String> lines = fileChecker.checkFile(args[0]);
		
		if (lines == null)
			return;
		
		initFlyables(lines);
		
		for (int i = 0; i < runNb; i++) {

		}

	}

	private static void initWeatherTower(List<String> lines) {

	}

	private static void initFlyables(List<String> lines) {
		runNb = Integer.parseInt(lines.get(0));

		AircraftFactory aircraftFactory = AircraftFactory.getInstance();

		lines.remove(0);
		for (String line : lines) {
			String[] splitedLine = line.split(" ");
			int height = Integer.parseInt(splitedLine[4]);
			if (height > 100)
				height = 100;
			if (height > 0) {
				Coordinates coordinates = new Coordinates(Integer.parseInt(splitedLine[2]), Integer.parseInt(splitedLine[3]), height);
				Flyable flyable = aircraftFactory.newAircraft(splitedLine[0], splitedLine[1], coordinates);
				flyable.registerTower(tower);
			}
		}
	}


}
