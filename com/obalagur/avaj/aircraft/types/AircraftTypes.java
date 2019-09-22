package obalagur.avaj.aircraft.types;

import obalagur.avaj.aircraft.Flyable;
import obalagur.avaj.aircraft.utils.Coordinates;

public enum AircraftTypes {
	BALOON{
		 @Override
		public String toString() {
			return "Baloon";
		}
		 @Override
	    public Flyable create(String name, Coordinates coordinates) {
	        return new Baloon(name, coordinates);
	    }
	},
	HELICOPTER{
		 @Override
		public String toString() {
			return "Helicopter";
		}
		 @Override
	    public Flyable create(String name, Coordinates coordinates) {
	        return new Helicopter(name, coordinates);
	    }
	},
	JETPLANE{
		 @Override
		public String toString() {
			return "JetPlane";
		}
		 @Override
	    public Flyable create(String name, Coordinates coordinates) {
	        return new JetPlane(name, coordinates);
	    }
	};
	
	 public abstract Flyable create(String name, Coordinates coordinates);
}
