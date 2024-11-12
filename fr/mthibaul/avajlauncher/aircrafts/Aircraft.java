package fr.mthibaul.avajlauncher.aircrafts;

import fr.mthibaul.avajlauncher.Coordinates;
import fr.mthibaul.avajlauncher.exceptions.HeightBelowMinimumException;

public class Aircraft {

	protected long id;
	protected String name;
	protected Coordinates coordinates;

	public String getType(){
		return null;
	}

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		id = p_id;
		name = p_name;
		coordinates = p_coordinates;
	}

	protected void printRegstration() {
		System.out.println("Tower says : " + getFullId() + " registered to weather tower.");
	}

	protected void updateCoord(int longitude, int latitude, int height) throws HeightBelowMinimumException{
		int newLongitude = coordinates.getLongitude() + longitude;
		int newLatitude = coordinates.getLatitude() + latitude;
		int newHeight = coordinates.getHeight() + height;

		if (newHeight > 100)
			newHeight = 100;
		
		if (newHeight <= 0)
			throw new HeightBelowMinimumException();

		coordinates = new Coordinates(newLongitude, newLatitude, newHeight);
	}

	public String getFullId() {
		String fullId = getType() + "#" + getName() + "(" + getId() + ")";
		return fullId;
	}

	public int getHeight() {
		return (coordinates.getHeight());
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

}
