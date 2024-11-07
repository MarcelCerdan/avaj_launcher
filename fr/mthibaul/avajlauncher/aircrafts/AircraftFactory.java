package fr.mthibaul.avajlauncher.aircrafts;

import fr.mthibaul.avajlauncher.Coordinates;

public class AircraftFactory {

	private int id = 0;
	private static AircraftFactory aircraftFactory;

	private AircraftFactory() {}

	public static AircraftFactory getInstance() {
		if (aircraftFactory == null)
			aircraftFactory = new AircraftFactory();
		return aircraftFactory;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		if (p_type.equalsIgnoreCase("Helicopter"))
			return new Helicopter(++id, p_name, p_coordinates);
		else if (p_type.equalsIgnoreCase("JetPlane"))
			return new JetPlane(++id, p_name, p_coordinates);
		else if (p_type.equalsIgnoreCase("Baloon"))
			return new Baloon(++id, p_name, p_coordinates);
		return null;
	}
}
