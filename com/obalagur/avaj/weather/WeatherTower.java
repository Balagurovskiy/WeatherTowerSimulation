package obalagur.avaj.weather;

import obalagur.avaj.aircraft.utils.Coordinates;

public class WeatherTower extends Tower{
	public String getWeather(Coordinates coordinates ) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}
	
	void changeWeather() {
		this.conditionsChanged();
	}
}
