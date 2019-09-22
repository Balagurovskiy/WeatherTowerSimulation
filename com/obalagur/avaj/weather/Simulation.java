package obalagur.avaj.weather;

import obalagur.avaj.aircraft.AircraftFactory;
import obalagur.avaj.aircraft.Flyable;
import obalagur.avaj.exceptions.AvajException;
import obalagur.avaj.parsing.Scenario;
import obalagur.avaj.parsing.ScenarioInst;
import obalagur.avaj.utils.Streamer;

public class Simulation {
	// ADD TEST SCENARIO FILES || test.sh with all tests and echoes
		// - empty
		// - random data
		// - inv size
		// - random data hashed
		// - no input, dir
	public static void main(String[] args) {
		
		String pathH = "C:\\Users\\comp\\Desktop\\shared\\avaj\\scenario_md5.txt";
		String path = "C:\\Users\\comp\\Desktop\\shared\\avaj\\tests\\scenario5.txt";

		Scenario scenario = new Scenario();
		WeatherTower weatherTower = new WeatherTower();
		AircraftFactory aircraftFactory = new AircraftFactory();
		
		try {
			
			scenario.setInputFile(path);
			scenario.parse();
		
			for (ScenarioInst si : scenario.getInstances()) {
				Flyable flyable = aircraftFactory.newAircraft(
										si.getType(), 
										si.getName(), 
										si.getLon(), 
										si.getLat(), 
										si.getHei()
									);
				weatherTower.register(flyable);
				flyable.registerTower(weatherTower);
			}
		
		} catch (AvajException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < scenario.getSimulationSize(); i++)
			weatherTower.changeWeather();
		
		Streamer.write("simulation.txt", Streamer.getStorage());
	}
}
