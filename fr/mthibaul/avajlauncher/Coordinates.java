package fr.mthibaul.avajlauncher;

public class Coordinates {
	private final int longitude, latitude, height;

	public Coordinates(int p_longitude, int p_latitude, int p_height) {
		longitude = p_longitude;
		latitude = p_latitude;
		height = p_height;
	}

	public int getLongitude() {
		return longitude;
	};

	public int getLatitude() {
		return latitude;
	};

	public int getHeight() {
		return height;
	};
}
