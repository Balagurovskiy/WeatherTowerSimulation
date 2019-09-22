package obalagur.avaj.weather;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import obalagur.avaj.aircraft.AircraftFactory;
import obalagur.avaj.aircraft.Flyable;
import obalagur.avaj.aircraft.types.AircraftTypes;
import obalagur.avaj.aircraft.utils.Coordinates;
import obalagur.avaj.exceptions.AvajException;
import obalagur.avaj.exceptions.ExceptionTypes;
import obalagur.avaj.parsing.Scenario;
import obalagur.avaj.parsing.ScenarioInst;
import obalagur.avaj.utils.Hasher;
import obalagur.avaj.utils.Streamer;

public class Tester {
	
	public static void main(String[] args) {
		AircraftFactory aircraftFactory = new AircraftFactory();
		Flyable flyable;
		try {
			flyable = aircraftFactory.newAircraft(
					"", 
					"qew", 
					2, 
					3, 
					4
				);
			System.out.println(flyable);

		} catch (AvajException e) {
			e.printStackTrace();
		}
		
	}
 
}

