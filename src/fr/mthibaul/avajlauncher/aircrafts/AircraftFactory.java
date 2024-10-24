package fr.mthibaul.avajlauncher.aircrafts;

import fr.mthibaul.avajlauncher.Coordinates;

public class AircraftFactory {

	private static AircraftFactory aircraftFactory;

	private AircraftFactory() {}

	public static AircraftFactory getInstance() {
		if (aircraftFactory == null)
			aircraftFactory = new AircraftFactory();
		return aircraftFactory;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		if (p_type.equalsIgnoreCase("Helicopter"))
			return new Helicopter(0, p_name, p_coordinates);
		else if (p_type.equalsIgnoreCase("JetPlane"))
			return new JetPlane(0, p_name, p_coordinates);
		else if (p_type.equalsIgnoreCase("Baloon"))
			return new Baloon(0, p_name, p_coordinates);
		return null;
	}
}
