



import entities.Animal;
import entities.Barrel;
import entities.Human;
import search.BinarySearch;
import util.Handle;
import util.InputUtils;

import java.io.IOException;
import java.util.Arrays;

import static util.InputUtils.typeOfFill;

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
                Animal searchKey = new Animal.AnimalBuilder(line[0],line[1]).fur(line[2].equalsIgnoreCase("yes")).build();

                BinarySearch binarySearch = new BinarySearch();

                int index = binarySearch.search(handle.getEntities(), searchKey);

                if (index != -1) {
                    System.out.println("Animal found at index: " + index);
                    System.out.println(handle.getEntities().get(index));
                } else {
                    System.out.println("Animal not found.");
                }
            } else if (entity.equals("barrel")) {
                Barrel searchKey = new Barrel.BarrelBuilder(line[0],line[1],Integer.valueOf(line[2])).build();

                BinarySearch binarySearch = new BinarySearch();

                System.out.println(searchKey);

                int index = binarySearch.search(handle.getEntities(), searchKey);

                if (index != -1) {
                    System.out.println("Barrel found at index: " + index);
                    System.out.println(handle.getEntities().get(index));
                } else {
                    System.out.println("Barrel not found.");
                }

            } else if ((entity.equals("person"))) {
                Human searchKey = new Human.HumanBuilder(line[2], line[0], Integer.valueOf(line[1])).build();

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
