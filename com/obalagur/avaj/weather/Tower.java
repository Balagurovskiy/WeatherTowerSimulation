package obalagur.avaj.weather;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import obalagur.avaj.aircraft.Flyable;

public class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();
	
	public void register(Flyable flyable) {
		if (observers.contains(flyable) || flyable == null)
			return ;
		observers.add(flyable);
	}
	public void unregister(Flyable flyable) {
		if (observers.contains(flyable))
			observers.remove(flyable);
	}
	protected void conditionsChanged() {
		for (int j = 0; j < observers.size(); j++) {
			Flyable flyable = observers.get(j);
			if (flyable != null)
				flyable.updateConditions();
		}
	}
}
