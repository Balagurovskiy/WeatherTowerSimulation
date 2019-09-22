package obalagur.avaj.weather;

import java.util.Random;

import obalagur.avaj.aircraft.utils.Coordinates;

public class WeatherProvider {
	private static WeatherProvider	weatherProvider;
	private String[] 				weather = {"RAIN","FOG","SUN","SNOW"};
	
	public WeatherProvider() {
	}
	
	public static WeatherProvider getProvider() {
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return weatherProvider;
	}
	
	public String getCurrentWeather(Coordinates coordinates) {
		for (Weather weather : Weather.values()) {
			if (weather.isIn(coordinates))
				return weather.toString();
		}
		Random rand = new Random();
		return weather[rand.nextInt(weather.length)];
	}
}
