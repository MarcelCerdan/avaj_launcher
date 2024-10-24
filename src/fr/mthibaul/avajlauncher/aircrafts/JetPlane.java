package fr.mthibaul.avajlauncher.aircrafts;

import fr.mthibaul.avajlauncher.Coordinates;

public class JetPlane extends Aircraft {

	public JetPlane(long p_id, String p_name, Coordinates p_Coordinates) {
		super(p_id, p_name, p_Coordinates);
		System.out.println("JetPlane created !");
	}

	public void updateConditions() {
		System.out.println("JetPlane changed !");
	}

}
