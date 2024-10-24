package fr.mthibaul.avajlauncher;

// import java.io.BufferedReader;
import java.io.FileNotFoundException;
// import java.io.FileReader;
import java.io.IOException;

import fr.mthibaul.avajlauncher.aircrafts.*;

public class AvajLauncher {

	public static void main(String[] args) throws IOException {
		try {
			// BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			// String line = reader.readLine();
			// System.out.println(line);
			// reader.close();

			AircraftFactory aircraftFactory = AircraftFactory.getInstance();

			Flyable test = aircraftFactory.newAircraft("JetPlane", "Bob", new Coordinates(0, 0, 0));
		}
		catch (Exception e) {
			System.out.println("Can't open the input file");
		}
	}
}
