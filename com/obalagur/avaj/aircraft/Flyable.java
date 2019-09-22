package obalagur.avaj.aircraft;

import obalagur.avaj.weather.WeatherTower;

public interface Flyable {
	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);
}
