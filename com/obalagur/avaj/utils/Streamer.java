package obalagur.avaj.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Streamer {
	private static List<String> storage = new ArrayList<String>();
	
	public static void addToStorage(String str) {
		storage.add(str);
	}
	public static List<String> getStorage() {
		return storage;
	}
	public static void clearStorage() {
		storage.clear();
	}
	
	public static List<String> read(String paths) {
		List<String> lines = new ArrayList<String>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(paths));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();				
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public static void write(String fileName, List<String> info) {
	    BufferedWriter writer;
		try {
		    writer = new BufferedWriter(new FileWriter(fileName));
		    for (String i : info)
		    	writer.write(i + "\n");		     
		    writer.close();
	    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
