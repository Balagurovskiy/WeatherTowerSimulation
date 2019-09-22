package obalagur.avaj.weather;

import obalagur.avaj.aircraft.Flyable;
import obalagur.avaj.aircraft.utils.Coordinates;

public enum Weather {
	SNOW{
		@Override
	    public boolean isIn(Coordinates coordinates) {
			boolean res = false;
			if (coordinates.getHeight() < 25)
				return isInI(coordinates);
			if (coordinates.getHeight() < 50)
				return isInII(coordinates);
			if (coordinates.getHeight() < 75)
				return isInIII(coordinates);
			if (coordinates.getHeight() < 100)
				return isInIV(coordinates);
	        return res;
	    }
	},
	SUN{
		@Override
	    public boolean isIn(Coordinates coordinates) {
			boolean res = false;
			if (coordinates.getHeight() < 25)
				return isInII(coordinates);
			if (coordinates.getHeight() < 50)
				return isInIII(coordinates);
			if (coordinates.getHeight() < 75)
				return isInIV(coordinates);
			if (coordinates.getHeight() < 100)
				return isInI(coordinates);
	        return res;
	    }
	},
	RAIN{
		@Override
	    public boolean isIn(Coordinates coordinates) {
			boolean res = false;
			if (coordinates.getHeight() < 25)
				return isInIII(coordinates);
			if (coordinates.getHeight() < 50)
				return isInIV(coordinates);
			if (coordinates.getHeight() < 75)
				return isInI(coordinates);
			if (coordinates.getHeight() < 100)
				return isInII(coordinates);
	        return res;
	    }
	},
	FOG{
		@Override
	    public boolean isIn(Coordinates coordinates) {
			boolean res = false;
			if (coordinates.getHeight() < 25)
				return isInIV(coordinates);
			if (coordinates.getHeight() < 50)
				return isInI(coordinates);
			if (coordinates.getHeight() < 75)
				return isInII(coordinates);
			if (coordinates.getHeight() < 100)
				return isInIII(coordinates);
	        return res;
	    }
	};

	private static boolean isInI(Coordinates coordinates) {
		boolean res;
		res = coordinates.getLatitude() > 0;
		res = res && coordinates.getLatitude() < 50;
		res = res && coordinates.getLongituge() > 0;
		res = res && coordinates.getLongituge() < 50;
        return res;
	}
	private static boolean isInII(Coordinates coordinates) {
		boolean res;
		res = coordinates.getLatitude() > 50;
		res = res && coordinates.getLatitude() < 100;
		res = res && coordinates.getLongituge() > 0;
		res = res && coordinates.getLongituge() < 50;
        return res;
	}
	private static boolean isInIII(Coordinates coordinates) {
		boolean res;
		res = coordinates.getLatitude() > 0;
		res = res && coordinates.getLatitude() < 50;
		res = res && coordinates.getLongituge() > 50;
		res = res && coordinates.getLongituge() < 100;
        return res;
	}
	private static boolean isInIV(Coordinates coordinates) {
		boolean res;
		res = coordinates.getLatitude() > 50;
		res = res && coordinates.getLatitude() < 100;
		res = res && coordinates.getLongituge() > 50;
		res = res && coordinates.getLongituge() < 100;
        return res;
	}
	public abstract  boolean isIn(Coordinates coordinates);
}
