package org.example;

import java.io.*;
import java.util.*;

public class ArrayFiller {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int length = scanner.nextInt();

        int[] array = new int[length];

        System.out.println("Select how to fill the array :");
        System.out.println("1 - Manual entry");
        System.out.println("2 - Autocomplete (random numbers)");
        System.out.println("3 - Filling from file");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                fillArrayManually(array, scanner);
                break;
            case 2:
                fillArrayRandomly(array);
                break;
            case 3:
                fillArrayFromFile(array);
                break;
            default:
                System.out.println("Wrong choice!");
                break;
        }

        System.out.println("Filled array: " + Arrays.toString(array));
    }

    private static void fillArrayManually(int[] array, Scanner scanner) {
        System.out.println("Enter Array Elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
    }

    private static void fillArrayRandomly(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    private static void fillArrayFromFile(int[] array) {
        System.out.print("Введите имя файла: ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null && i < array.length) {
                array[i++] = Integer.parseInt(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка формата в файле: " + e.getMessage());
        }
    }
}
