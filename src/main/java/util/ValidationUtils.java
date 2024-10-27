package util;


import java.util.Scanner;

public class ValidationUtils {

	public static boolean isValidAnimalData(String s) {
		String[] line = s.split(",");
		String species;
		String eyeColor;
		String fur;
		if (line.length != 3) return false;
		species = line[0];
		eyeColor = line[1];
		fur = line[2];
		if (!(fur.equalsIgnoreCase("да") || fur.equalsIgnoreCase("нет")
				|| fur.equalsIgnoreCase("true") || fur.equalsIgnoreCase("false")))
			return false;
		return !species.isEmpty() && !eyeColor.isEmpty();
	}

	public static boolean isValidBarrelData(String s) {
		String[] line = s.split(",");
		String content;
		String made;
		String volume;

		if (line.length != 3) return false;
		content = line[0];
		made = line[1];
		volume = line[2];
		Scanner scanner = new Scanner(line[2]);
		if ((!scanner.hasNextInt())) return false;
		int v = Integer.parseInt(volume);
		return (v > 0 && v < 1000) && !content.isEmpty() && !made.isEmpty();
	}

	public static boolean isValidPersonData(String s) {
		String[] line = s.split(",");
		String surname;
		String gender;
		String age;
		if (line.length != 3) return false;
		surname = line[0];
		age = line[1];
		gender = line[2];
		Scanner scanner = new Scanner(line[1]);
		if ((!scanner.hasNextInt())) return false;

		int a = Integer.parseInt(age);
		return (a > 0 && a < 100) && (gender.equalsIgnoreCase("м") || gender.equalsIgnoreCase("ж")) && !surname.isEmpty();
	}

}

