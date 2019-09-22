package obalagur.avaj.aircraft.utils;

public class Coordinates {
	private int longituge;
	private int latitude;
	private int height;
	
	public Coordinates(int longituge, int latitude, int height) {
		this.longituge = longituge;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongituge() {
		return longituge;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getHeight() {
		return height;
	}
	
	
}
