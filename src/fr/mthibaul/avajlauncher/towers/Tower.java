package fr.mthibaul.avajlauncher.towers;
import java.util.ArrayList;

import fr.mthibaul.avajlauncher.aircrafts.Flyable;

public class Tower {

	private ArrayList<Flyable> observers = new ArrayList<>();

	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
		System.out.println("Tower says : " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") registered to weather tower.");
	}

	public void unregister(Flyable p_flyable) {
		observers.remove(p_flyable);
	}

	protected void conditionChanged() {
		
	}
}
