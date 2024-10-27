package util;

import java.util.Scanner;


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
				System.out.println("Неверный ввод. Пожалуйста, попробуйте еще раз.");
				return typeOfFill();
		}
	}

	public static String[] typeOfFill(String entity) {
		String[] line = null;

		for (int i = 0; i < 1; i++) {
			switch (entity) {
				case "animal" -> {
					String s = InputUtils.getString("Введите вид, цвет глаз, есть ли мех? (да/нет):\n");
					line = s.split(",");
					if (!ValidationUtils.isValidAnimalData(s)) {
						System.out.println("Неверный ввод. Пожалуйста, попробуйте еще раз.");
						i--;
					}

				}
				case "barrel" -> {
					String s = InputUtils.getString("Введите хранимый материал, материал из которого изготовлена, объем:\n");
					line = s.split(",");
					if (!ValidationUtils.isValidBarrelData(s)) {
						System.out.println("Неверный ввод. Пожалуйста, попробуйте еще раз.");
						i--;

					}

				}
				case "person" -> {
					String s = InputUtils.getString("Введите фамилия, возраст, пол (М/Ж):\n");
					line = s.split(",");
					if (!ValidationUtils.isValidPersonData(s)) {
						System.out.println("Неверный ввод. Пожалуйста, попробуйте еще раз.");
						i--;

					}

				}
			}
		}
		return line;
	}

}


