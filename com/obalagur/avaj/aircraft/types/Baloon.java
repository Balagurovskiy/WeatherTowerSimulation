package obalagur.avaj.aircraft.types;

import obalagur.avaj.aircraft.Aircraft;
import obalagur.avaj.aircraft.Flyable;
import obalagur.avaj.aircraft.utils.Coordinates;
import obalagur.avaj.utils.Streamer;
import obalagur.avaj.weather.Weather;
import obalagur.avaj.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable{

	private WeatherTower weatherTower;
	
	protected Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String currentWeather = weatherTower.getWeather(coordinates);
		String typeNameId = "Baloon#" + name + "(" + id + ") : ";
		String towerUnReg = "Tower says : " + typeNameId + " unregistered from weather tower.";

		int lon = coordinates.getLongituge();
		int lat = coordinates.getLatitude();
		int hei = coordinates.getHeight();

		if (currentWeather.equals(Weather.SNOW.toString())) {
			Streamer.addToStorage(typeNameId + "So cold - baloons getting smaller.");
			hei -= 15;
		}
		if (currentWeather.equals(Weather.FOG.toString())) {
			Streamer.addToStorage(typeNameId + "Can not see a thing.");
			hei -= 3;
		}
		if (currentWeather.equals(Weather.RAIN.toString())) {
			Streamer.addToStorage(typeNameId + "Damn you rain! You messed up my baloon.");
			hei -= 5;
		}
		if (currentWeather.equals(Weather.SUN.toString())) {
			Streamer.addToStorage(typeNameId + "Let's enjoy the good weather and take some pics.");
			hei += 4;
			lon += 2;
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
		String typeNameId = "Baloon#" + name + "(" + id + ")";
		String towerReg = "Tower says : " + typeNameId + " registered to weather tower.";
		this.weatherTower = weatherTower;
		Streamer.addToStorage(towerReg);	
		this.weatherTower.register(this);
	}

}
