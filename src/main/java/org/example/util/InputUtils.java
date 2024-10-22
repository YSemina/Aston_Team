package org.example.util;

import java.util.Scanner;

public class InputUtils {

	private static final Scanner scanner = new Scanner(System.in);

	public static int getInt(String prompt) {
		System.out.print(prompt);
		while (!scanner.hasNextInt()) {
			System.out.println("Invalid input. Please enter an integer.");
			scanner.next();
		}
		return scanner.nextInt();
	}

	public static String getString(String prompt) {
		System.out.print(prompt);
		return scanner.next();
	}

	// Additional methods for reading from file and generating random data can be added here.
}


