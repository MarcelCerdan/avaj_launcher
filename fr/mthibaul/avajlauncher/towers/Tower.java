package fr.mthibaul.avajlauncher.towers;
import fr.mthibaul.avajlauncher.aircrafts.Flyable;
import java.util.ArrayList;

public class Tower {

	private ArrayList<Flyable> observers = new ArrayList<>();
	private ArrayList<Flyable> observersToRemove = new ArrayList<>();
	protected WeatherProvider weatherProvider = WeatherProvider.getInstance();

	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable) {
		observersToRemove.add(p_flyable);
		System.out.println("Tower says: " + p_flyable.getFullId() + " unregistered from weather tower.");
	}

	public void removeUnregistered() {
		observers.removeAll(observersToRemove);
		observersToRemove.clear();
	}

	protected void conditionChanged() {
		for (Flyable observer : observers) {
			observer.updateConditions();
		}
	}
}
