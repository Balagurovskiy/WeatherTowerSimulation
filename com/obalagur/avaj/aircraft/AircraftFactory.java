package obalagur.avaj.aircraft;

import obalagur.avaj.aircraft.types.AircraftTypes;
import obalagur.avaj.aircraft.utils.Coordinates;
import obalagur.avaj.exceptions.AvajException;
import obalagur.avaj.exceptions.ExceptionTypes;

public class AircraftFactory {
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws AvajException {
		String typeUpper = type.toUpperCase();
		boolean validType = false;
		for (AircraftTypes at : AircraftTypes.values())
			if (type.equals(at.toString())) 
				validType = true;
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		if (validType)
			return AircraftTypes.valueOf(typeUpper).create(name, coordinates);
		else 
			return AircraftTypes.BALOON.create(name, coordinates);
	}
}
