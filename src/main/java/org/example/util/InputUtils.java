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

    public static String[] typeOfFill(String entity) {
        String line[] = null;

        for (int i = 0; i < 1; i++) {
            switch (entity) {
                case "animal":
                    line = InputUtils.getString("Для поиска введите вид, цвет глаз, есть ли мех? (да/нет):\n").split(",");
                    if (!ValidationUtils.isValidAnimalData(line[0], line[1], line[2].equalsIgnoreCase("да"))) {
                        System.out.println("Неверный ввод. Пожалуйста, попробуйте еще раз.");
                        i--;
                    }
                    break;
                case "barrel":
                    line = InputUtils.getString("Для поиска введите хранимый материал, материал из которого изготовлена, объем,:\n").split(",");
                    if (!ValidationUtils.isValidBarrelData(Integer.valueOf(line[2]), line[0], line[1])) {
                        System.out.println("Неверный ввод. Пожалуйста, попробуйте еще раз.");
                        i--;

                    }
                    break;
                case "person":
                    line = InputUtils.getString("Для поиска введите фамилия, возраст, пол (М/Ж):\n").split(",");
                    if (!ValidationUtils.isValidPersonData(line[0], line[2], Integer.valueOf(line[1]))) {
                        System.out.println("Неверный ввод. Пожалуйста, попробуйте еще раз.");
                        i--;

                    }
                    break;
            }
        }
        return line;
    }

    // Additional methods for reading from file and generating random data can be added here.
}


