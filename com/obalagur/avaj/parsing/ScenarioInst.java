package obalagur.avaj.parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import obalagur.avaj.aircraft.types.AircraftTypes;
import obalagur.avaj.exceptions.AvajException;
import obalagur.avaj.exceptions.ExceptionTypes;
import obalagur.avaj.utils.FileSys;
import obalagur.avaj.utils.Hasher;



public class ScenarioInst {
	
	private String					src = "";
	
	private static String[]			TYPES;
	private static String[]			DEFAULT_NAMES;
	private static int[]			typeCounts = {1, 1, 1};
	
	private String					type = "";
	private String					name = "";
	private int						count = -1;

	private int						lon = 0;
	private int						lat = 0;
	private int						hei = 0;
	//=====================================
	
	public ScenarioInst(String src) throws AvajException {
		this.src = src;
		
		AircraftTypes[] airTypes = AircraftTypes.values();
		int airTypesSize = airTypes.length;
		TYPES = new String[airTypesSize];
		DEFAULT_NAMES = new String[airTypesSize];
		for (int i = 0; i < airTypesSize; i++) {
			TYPES[i] = airTypes[i].toString();
			if (TYPES[i].length() > 1)
				DEFAULT_NAMES[i] = TYPES[i].substring(0, 1);
		}
		if (Hasher.isHashed(src))
			parseHashedLine();
		else
			parseCasualLine();
	}
	//=====================================

	private boolean noType(String input) {
		for(String t : TYPES)
			if (input.equals(t))
				return false;
		return true;
	}

	//=====================================
	private void parseHashedLine() throws AvajException {
		boolean loop = true;
		int nextType = 0;
		while(nextType <= 2 && loop) {
			this.type = (TYPES[nextType]);
			this.name = (DEFAULT_NAMES[nextType]);
			this.count = (typeCounts[nextType]);
			loop = cracker();
			if (!loop)
				typeCounts[nextType]++;
			nextType++;
		}
		if (loop) 
			throw (new AvajException(ExceptionTypes.NO_HASH));
	}

	private boolean cracker() {
		for (this.lon = 0; this.lon < 101; this.lon++)
			for (this.lat = 0; this.lat < 101; this.lat++)
				for (this.hei = 0; this.hei < 101; this.hei++)
					if (src.toUpperCase().equals(Hasher.getMd5(this.toString()).toUpperCase()))
						return false;
		return true;
	}
	//=====================================
	private void parseCasualLine() throws AvajException {
		if (src == null)
			throw (new AvajException(ExceptionTypes.NULL_INPUT));
		if (src.isEmpty())
			throw (new AvajException(ExceptionTypes.EMPTY_INPUT));
		String[] splitBySpace = src.split(" ");
		if (splitBySpace.length != 5)
			throw (new AvajException(ExceptionTypes.NO_DATA));
		type = splitBySpace[0];
		if (noType(type))
			throw (new AvajException(ExceptionTypes.NO_TYPE));
		name = splitBySpace[1];
		if (name.length() > 50)
			throw (new AvajException(ExceptionTypes.NO_DATA));
		lon = parseToInt(splitBySpace[2]);
		lat = parseToInt(splitBySpace[3]);
		hei = parseToInt(splitBySpace[4]);
	}
	private int parseToInt(String input) throws AvajException {
		if (FileSys.isDigit(input)) {
			if (input.length() > 2)
				return (100);
			int i = Integer.parseInt(input);
			if (i > 100)
				i = 100;
			if (i < 0)
				i = 0;
			return (i);
		}
		throw (new AvajException(ExceptionTypes.NOT_DIGIT));
		//return (-1);
	}
	//=====================================
	@Override
	public String toString() {
		String spc = " ";
		StringBuilder str = new StringBuilder();
		str.append(type);
		str.append(spc);
		str.append(name);
		if (count >= 0)
			str.append(count);
		str.append(spc);
		str.append(lon);
		str.append(spc);
		str.append(lat);
		str.append(spc);
		str.append(hei);
		return (str.toString());
	}
	//=====================================
	public int getLon() {
		return lon;
	}
	public void setLon(int lon) {
		this.lon = lon;
	}
	public int getLat() {
		return lat;
	}
	public void setLat(int lat) {
		this.lat = lat;
	}
	public int getHei() {
		return hei;
	}
	public void setHei(int hei) {
		this.hei = hei;
	}
	//=====================================
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		if (count == -1)
			return name;
		return (name + count);
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
