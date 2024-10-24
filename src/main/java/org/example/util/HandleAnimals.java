package org.example.util;

import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.search.BinarySearch;
import org.example.sorting.InsertionSort;
import org.example.sorting.SortStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandleAnimals {
	public static void HandleAnimals() {



		int n = InputUtils.getInt("Enter number of animals: ");

		List<Animal> animals = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String line[] = InputUtils.getString("Enter species, eye color, Has fur? (yes/no)\n").split(",");
			String species = line[0];
			String eyeColor = line[1];
			boolean hasFur = line[2].equalsIgnoreCase("yes");

			if (!ValidationUtils.isValidAnimalData(species, eyeColor, hasFur)) {
				System.out.println("Invalid data entered. Please try again.");
				i--;
				continue;
			}

			animals.add(new Animal.Builder()
					.species(species)
					.eyeColor(eyeColor)
					.hasFur(hasFur)
					.build());
		}

		SortStrategy<Animal> sortStrategy = new InsertionSort<>();

		sortStrategy.sort(animals);

		System.out.println("Sorted Animals:");

		Arrays.asList(animals).forEach(System.out::println);
		String line[] = {};
		for (int i = 0; i < 1; i++) {


			line = InputUtils.getString("Enter species, eye color, Has fur? (yes/no) to search:\n").split(",");
			if (!ValidationUtils.isValidAnimalData(line[0], line[1], line[2].equalsIgnoreCase("yes"))) {
				System.out.println("Invalid data entered. Please try again.");
				i--;
			}
		}

		Animal searchKey = new Animal.Builder()
				.species(line[0])
				.eyeColor(line[1])
				.hasFur(line[2].equalsIgnoreCase("yes"))
				.build();

		BinarySearch binarySearch = new BinarySearch();

		int index = binarySearch.search(animals, searchKey);

		if (index != -1) {
			System.out.println("Animal found at index: " + index);
			System.out.println(animals.get(index));
		} else {
			System.out.println("Animal not found.");
		}
	}
}
