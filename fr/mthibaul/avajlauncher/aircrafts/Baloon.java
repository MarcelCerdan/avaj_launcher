package fr.mthibaul.avajlauncher.aircrafts;

import fr.mthibaul.avajlauncher.Coordinates;

public class Baloon extends Aircraft {
		
	public Baloon(long p_id, String p_name, Coordinates p_Coordinates) {
		super(p_id, p_name, p_Coordinates);
	}

	public void updateConditions() {
		
	}

	public String getType() {
		return ("Baloon");
	}
}
