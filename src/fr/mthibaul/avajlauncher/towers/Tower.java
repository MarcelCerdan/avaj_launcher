package fr.mthibaul.avajlauncher.towers;
import java.util.ArrayList;

import fr.mthibaul.avajlauncher.aircrafts.Flyable;

public class Tower {

	private ArrayList<Flyable> observers;

	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable) {
		observers.remove(p_flyable);
	}

	protected void conditionChanged() {
		
	}
}
