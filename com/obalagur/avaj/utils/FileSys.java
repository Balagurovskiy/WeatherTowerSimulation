package obalagur.avaj.utils;

import java.io.File;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSys {
	public static boolean exists(String path) {
		File tmpDir = new File(path);
		return tmpDir.exists();
	}
	public static boolean isDir(String path) {
		File tmpDir = new File(path);
		return tmpDir.isDirectory();
	}
	public static boolean isFile(String path) {
		File tmpDir = new File(path);
		return tmpDir.isFile();
	}
	public static boolean sizeIsLessThan(Collection c, int n) {
		return (c.size() < n);
	}
	public static boolean strIsNull(String s) {
		return (s == null);
	}

	public static boolean isDigit(String input) {
		Pattern digitPattern;
		
		digitPattern = Pattern.compile("-?\\d+(\\d*)?");
		Matcher matcher = digitPattern.matcher(input);
		return matcher.matches();
	}
}
