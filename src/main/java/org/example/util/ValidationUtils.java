package org.example.util;

public class ValidationUtils {

	public static boolean isValidAnimalData(String species, String eyeColor, boolean hasFur) {
		// Implement validation logic
		return !species.isEmpty() && !eyeColor.isEmpty();
	}

	public static boolean isValidBarrelData(Integer volume, String content, String made) {
		// Implement validation logic
		return volume > 0 && !content.isEmpty() && !made.isEmpty();
	}

	public static boolean isValidPersonData( String surname,String gender, int age) {
		// Implement validation logic
		return age > 0 && (gender.equalsIgnoreCase("m")|| gender.equalsIgnoreCase("f")) && !surname.isEmpty();
	}

}

