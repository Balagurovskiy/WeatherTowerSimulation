package obalagur.avaj.aircraft.types;

import obalagur.avaj.aircraft.Aircraft;
import obalagur.avaj.aircraft.Flyable;
import obalagur.avaj.aircraft.utils.Coordinates;
import obalagur.avaj.utils.Streamer;
import obalagur.avaj.weather.Weather;
import obalagur.avaj.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{

	private WeatherTower weatherTower;
	
	protected Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String currentWeather = weatherTower.getWeather(coordinates);
		String typeNameId = "Helicopter#" + name + "(" + id + ") : ";
		String towerUnReg = "Tower says : " + typeNameId + " unregistered from weather tower.";

		int lon = coordinates.getLongituge();
		int lat = coordinates.getLatitude();
		int hei = coordinates.getHeight();

		if (currentWeather.equals(Weather.SNOW.toString())) {
			Streamer.addToStorage(typeNameId + "So cold - rotor getting smaller.");
			hei -= 12;
		}
		if (currentWeather.equals(Weather.FOG.toString())) {
			Streamer.addToStorage(typeNameId + "Can not see a thing.");
			lon += 1;
		}
		if (currentWeather.equals(Weather.RAIN.toString())) {
			Streamer.addToStorage(typeNameId + "Damn you rain! You messed up my chopper.");
			lon += 5;
		}
		if (currentWeather.equals(Weather.SUN.toString())) {
			Streamer.addToStorage(typeNameId + "Let's enjoy the good weather and take some pics.");
			lon += 10;
			hei += 2;
		}
		if (hei > 0) {
			if (hei > 100)
				hei = 100;
			coordinates = new Coordinates(lon, lat, hei);
		} else {
			Streamer.addToStorage(typeNameId + "landing.");
			weatherTower.unregister(this);
			Streamer.addToStorage(towerUnReg);	
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		String typeNameId = "Helicopter#" + name + "(" + id + ")";
		String towerReg = "Tower says : " + typeNameId + " registered to weather tower.";
		this.weatherTower = weatherTower;
		Streamer.addToStorage(towerReg);	
		this.weatherTower.register(this);
	}
}
