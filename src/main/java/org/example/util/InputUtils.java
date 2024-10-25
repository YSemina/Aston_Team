package org.example.util;

import java.util.Scanner;

import static org.example.util.HandleAnimals.HandleAnimals;
import static org.example.util.HandleBarrels.HandleBarrels;
import static org.example.util.HandlePersons.HandlePersons;

public class InputUtils {

	private static final Scanner scanner = new Scanner(System.in);

	public static int getInt(String prompt) {
		System.out.print(prompt);
		while (!scanner.hasNextInt()) {
			System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
			scanner.next();
		}
		return scanner.nextInt();
	}

	public static String getString(String prompt) {
		System.out.print(prompt);
		return scanner.next();
	}

	public static String typeOfFill() {
		System.out.println("Источник ввода данных:");
		System.out.println("1. В ручную");
		System.out.println("2. Случайно");
		System.out.println("3. Из файла");

		int choice = InputUtils.getInt("Введите свой вариант: ");

		switch (choice) {
			case 1:
				return "manual";
			case 2:
				return "random";
			case 3:
				return "file";
			default:
				System.out.println("Invalid choice. Please try again.");
				return typeOfFill();
		}
	}

	// Additional methods for reading from file and generating random data can be added here.
}


