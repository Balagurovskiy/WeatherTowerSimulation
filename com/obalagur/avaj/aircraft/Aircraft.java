package obalagur.avaj.aircraft;

import obalagur.avaj.aircraft.utils.Coordinates;

public class Aircraft {
	protected long 			id;
	protected String		name;
	protected Coordinates	coordinates;
	
	private static long		idCounter = 0;
	
	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		id = nextId();
	}
	
	private long nextId() {
		idCounter++;
		return idCounter;
	}

}
