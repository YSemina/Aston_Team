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

	public static boolean isValidPersonData(String gender, int age, String lastName) {
		// Implement validation logic
		return age > 0 && !gender.isEmpty() && !lastName.isEmpty();
	}

}

