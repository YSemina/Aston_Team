package org.example;

import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Person;
import org.example.search.BinarySearch;
import org.example.util.Handle;
import org.example.util.InputUtils;
import org.example.util.ValidationUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.util.InputUtils.typeOfFill;

public class Application {
    public static void main(String[] args) throws IOException {
        while (true) {
            Handle handle = new Handle();
            System.out.println("Выберите тип данных для работы:");
            System.out.println("1. Животные");
            System.out.println("2. Бочки");
            System.out.println("3. Люди");
            System.out.println("4. Выход");

            int choice = InputUtils.getInt("Введите свой вариант: ");
            String entity;

            if (choice == 4) break;

            switch (choice) {
                case 1:
                    entity = "animal";
                    break;
                case 2:
                    entity = "barrel";
                    break;
                case 3:
                    entity = "person";
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
                    continue;
            }
//            List<Animal> animals = new ArrayList<Animal>();
            handle.filler(typeOfFill(), entity);
//            handle.filler(typeOfFill(),animals);

            Arrays.asList(handle.getEntities()).forEach(System.out::println);

            String[] line = typeOfFill(entity);
            if (entity.equals("animal")) {
                Animal searchKey = new Animal.Builder()
                        .species(line[0])
                        .eyeColor(line[1])
                        .hasFur(line[2].equalsIgnoreCase("yes"))
                        .build();

                BinarySearch binarySearch = new BinarySearch();

                int index = binarySearch.search(handle.getEntities(), searchKey);

                if (index != -1) {
                    System.out.println("Animal found at index: " + index);
                    System.out.println(handle.getEntities().get(index));
                } else {
                    System.out.println("Animal not found.");
                }
            } else if (entity.equals("barrel")) {
                Barrel searchKey = new Barrel.Builder()
                        .content(line[0])
                        .made(line[1])
                        .volume(Integer.valueOf(line[2]))
                        .build();

                BinarySearch binarySearch = new BinarySearch();

                int index = binarySearch.search(handle.getEntities(), searchKey);

                if (index != -1) {
                    System.out.println("Barrel found at index: " + index);
                    System.out.println(handle.getEntities().get(index));
                } else {
                    System.out.println("Barrel not found.");
                }

            } else if ((entity.equals("person"))) {
                Person searchKey = new Person.Builder()
                        .surname(line[0])
                        .gender(line[2])
                        .age(Integer.valueOf(line[1]))
                        .build();

                BinarySearch binarySearch = new BinarySearch();

                int index = binarySearch.search(handle.getEntities(), searchKey);

                if (index != -1) {
                    System.out.println("Person found at index: " + index);
                    System.out.println(handle.getEntities().get(index));
                } else {
                    System.out.println("Person not found.");
                }

            }
        }

    }
}
