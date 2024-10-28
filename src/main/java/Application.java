


import entities.Animal;
import entities.Barrel;
import entities.Human;
import insertionSort.SpecialSort;
import search.BinarySearch;
import util.Handle;
import util.InputUtils;

import java.io.IOException;
import java.util.Collections;

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
                case 1 -> entity = "animal";
                case 2 -> entity = "barrel";
                case 3 -> entity = "person";
                default -> {
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
                    continue;
                }
            }
            handle.filler(typeOfFill(), entity);

            handle.print();
            if (handle.getEntities().size() == 0) {
                System.out.println("Коллекция пустая, попробуйте еще раз.");
                continue;
            }


            switch (entity) {
                case "animal" -> {
                    System.out.print("Для поиска ");
                    String[] line = typeOfFill(entity);
                    Animal.Sort(handle.getEntities());
                    handle.print();
                    Animal searchKey = new Animal.AnimalBuilder(line[0], line[1]).fur(line[2].equalsIgnoreCase("yes")).build();

                    int index = BinarySearch.search(handle.getEntities(), searchKey);

                    if (index != -1) {
                        System.out.println("Животное найденое в индексе: " + index);
                        System.out.println(handle.getEntities().get(index));
                    } else {
                        System.out.println("Животное не найдено.");
                    }
                    System.out.println("Записать коллекцию в файл?");
                    System.out.println("1. да");
                    int file = InputUtils.getInt("Введите свой вариант: ");
                    if (file == 1) {
                        handle.write();
                    }
                }
                case "barrel" -> {
                    for (int i = 0; i < 1; i++) {
                        System.out.println("1. Сортировка вставками");
                        System.out.println("2. Сортировка только четных значений");
                        System.out.println("3. Пропустить сортировку");
                        int sort = InputUtils.getInt("Введите свой вариант: ");
                        if (sort == 1) {
                            System.out.print("Для поиска ");
                            String[] line = typeOfFill(entity);
                            Barrel.Sort(handle.getEntities());
                            handle.print();
                            Barrel searchKey = new Barrel.BarrelBuilder(line[0], line[1], Integer.parseInt(line[2])).build();

                            int index = BinarySearch.search(handle.getEntities(), searchKey);

                            if (index != -1) {
                                System.out.println("Бочка найденна в индексе: " + index);
                                System.out.println(handle.getEntities().get(index));
                            } else {
                                System.out.println("Бочка не найдена.");
                            }
                        } else if (sort == 2) {
                            Barrel.SetSort(new SpecialSort<>());
                            Barrel.Sort(handle.getEntities());
                            handle.print();
                            i--;
                        } else if (sort == 3) {
                            continue;
                        } else {
                            System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
                            i--;
                        }
                        System.out.println("Записать коллекцию в файл?");
                        System.out.println("1. да");
                        int file = InputUtils.getInt("Введите свой вариант: ");
                        if (file == 1) {
                            handle.write();
                        }

                    }
                }
                case "person" -> {
                    for (int i = 0; i < 1; i++) {
                        System.out.println("1. Сортировка вставками");
                        System.out.println("2. Сортировка только четных значений");
                        System.out.println("3. Пропустить сортировку");
                        int sort = InputUtils.getInt("Введите свой вариант: ");
                        if (sort == 1) {
                            System.out.print("Для поиска ");
                            String[] line = typeOfFill(entity);
                            Human.Sort(handle.getEntities());
                            handle.print();
                            Human searchKey = new Human.HumanBuilder(line[2], line[0], Integer.parseInt(line[1])).build();

                            int index = BinarySearch.search(handle.getEntities(), searchKey);

                            if (index != -1) {
                                System.out.println("Человек найден на интексе: " + index);
                                System.out.println(handle.getEntities().get(index));
                            } else {
                                System.out.println("Человек не найден.");
                            }
                        } else if (sort == 2) {
                            Human.SetSort(new SpecialSort<>());
                            Human.Sort(handle.getEntities());
                            handle.print();
                            i--;
                        } else if (sort == 3) {
                            continue;
                        } else {
                            System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
                            i--;
                        }
                        System.out.println("Записать коллекцию в файл?");
                        System.out.println("1. да");
                        int file = InputUtils.getInt("Введите свой вариант: ");
                        if (file == 1) {
                            handle.write();
                        }
                    }
                }
            }

        }
    }
}
