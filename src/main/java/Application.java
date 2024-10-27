


import entities.Animal;
import entities.Barrel;
import entities.Human;
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

			Collections.singletonList(handle.getEntities()).forEach(System.out::println);
			if (handle.getEntities().size() == 0) {
				System.out.println("Коллекция пустая, попробуйте еще раз.");
				continue;
			}
			System.out.print("Для поиска ");
			String[] line = typeOfFill(entity);


			switch (entity) {
				case "animal" -> {

					Animal.Sort(handle.getEntities());
					Collections.singletonList(handle.getEntities()).forEach(System.out::println);


					Animal searchKey = new Animal.AnimalBuilder(line[0], line[1]).fur(line[2].equalsIgnoreCase("yes")).build();

					int index = BinarySearch.search(handle.getEntities(), searchKey);

					if (index != -1) {
						System.out.println("Животное найденое в индексе: " + index);
						System.out.println(handle.getEntities().get(index));
					} else {
						System.out.println("Животное не найдено.");
					}
				}
				case "barrel" -> {
					Barrel.Sort(handle.getEntities());
					Collections.singletonList(handle.getEntities()).forEach(System.out::println);
					Barrel searchKey = new Barrel.BarrelBuilder(line[0], line[1], Integer.parseInt(line[2])).build();

					System.out.println(searchKey);

					int index = BinarySearch.search(handle.getEntities(), searchKey);

					if (index != -1) {
						System.out.println("Боска найденна в индексе: " + index);
						System.out.println(handle.getEntities().get(index));
					} else {
						System.out.println("Бочка не найдена.");
					}
				}
				case "person" -> {
					Human.Sort(handle.getEntities());
					Collections.singletonList(handle.getEntities()).forEach(System.out::println);
					Human searchKey = new Human.HumanBuilder(line[2], line[0], Integer.parseInt(line[1])).build();

					int index = BinarySearch.search(handle.getEntities(), searchKey);

					if (index != -1) {
						System.out.println("Человек найден на интексе: " + index);
						System.out.println(handle.getEntities().get(index));
					} else {
						System.out.println("Человек не найден.");
					}
				}
			}
		}

	}
}
