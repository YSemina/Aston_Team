package org.example;


import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Person;
import org.example.search.BinarySearch;
import org.example.sorting.InsertionSort;
import org.example.sorting.SortStrategy;
import org.example.util.InputUtils;
import org.example.util.ValidationUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		while (true) {
			System.out.println("Choose the type of data to work with:");
			System.out.println("1. Animals");
			System.out.println("2. Barrels");
			System.out.println("3. People");
			System.out.println("4. Exit");

			int choice = InputUtils.getInt("Enter your choice: ");

			if (choice == 4) break;

			switch (choice) {
				case 1:
					handleAnimals();
					break;
				case 2:
					handleBarrels();
					break;
				case 3:
					handlePersons();
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
			}
		}

		System.out.println("Exiting the application.");
	}

	private static void handleAnimals() {

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

			animals.add( new Animal.Builder()
					.species(species)
					.eyeColor(eyeColor)
					.hasFur(hasFur)
					.build());
		}

		SortStrategy<Animal> sortStrategy = new InsertionSort<>();

		sortStrategy.sort(animals);

		System.out.println("Sorted Animals:");

		Arrays.asList(animals).forEach(System.out::println);
		String line[]={};
		for (int i = 0; i < 1; i++) {


		 line = InputUtils.getString("Enter species, eye color, Has fur? (yes/no) to search:\n").split(",");
		if (!ValidationUtils.isValidAnimalData(line[0], line[1], line[2].equalsIgnoreCase("yes"))) {
			System.out.println("Invalid data entered. Please try again.");
			i--;
			continue;
		}}

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

	private static void handleBarrels() {
		int n = InputUtils.getInt("Enter number of barrels: ");

		List<Barrel> barrels = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String line[] = InputUtils.getString("Enter content, made, volume\n").split(",");
			String content = line[0];
			String made = line[1];
			Integer volume = Integer.valueOf( line[2]);

			if (!ValidationUtils.isValidBarrelData(volume, content, made)) {
				System.out.println("Invalid data entered. Please try again.");
				i--;
				continue;
			}

			barrels.add( new Barrel.Builder()
					.content(content)
					.made(made)
					.volume(volume)
					.build());
		}

		SortStrategy<Barrel> sortStrategy = new InsertionSort<>();

		sortStrategy.sort(barrels);

		System.out.println("Sorted Barrels:");

		Arrays.asList(barrels).forEach(System.out::println);
		String line[]={};
		for (int i = 0; i < 1; i++) {


			line = InputUtils.getString("Enter content, made, volume to search:\n").split(",");
			if (!ValidationUtils.isValidBarrelData(Integer.valueOf(line[2]), line[0], line[1])) {
				System.out.println("Invalid data entered. Please try again.");
				i--;
				continue;
			}}

		Barrel searchKey = new Barrel.Builder()
				.content(line[0])
				.made(line[1])
				.volume(Integer.valueOf(line[2]))
				.build();

		BinarySearch binarySearch = new BinarySearch();

		int index = binarySearch.search(barrels, searchKey);

		if (index != -1) {
			System.out.println("Barrel found at index: " + index);
			System.out.println(barrels.get(index));
		} else {
			System.out.println("Barrel not found.");
		}
	}

	private static void handlePersons() {
		int n = InputUtils.getInt("Enter number of persons: ");

		List<Person> persons = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String line[] = InputUtils.getString("Enter surname, age, gender (M/F)\n").split(",");
			System.out.println(line.length);
			if (line.length !=3||!ValidationUtils.isValidPersonData(line[0], line[2], Integer.valueOf(line[1]))) {
				System.out.println("Invalid data entered. Please try again.");
				i--;
				continue;
			}

			String surname = line[0];
			String gender = line[2];
			Integer age = Integer.valueOf(line[1]);



			persons.add( new Person.Builder()
					.surname(surname)
					.gender(gender)
					.age(age)
					.build());
		}

		SortStrategy<Person> sortStrategy = new InsertionSort<>();

		sortStrategy.sort(persons);

		System.out.println("Sorted Persons:");

		Arrays.asList(persons).forEach(System.out::println);
		String line[]={};
		// Binary search example:
		for (int i = 0; i < 1; i++) {


			line = InputUtils.getString("Enter surname, age, gender (M/F) to search:\n").split(",");
			if ( !ValidationUtils.isValidPersonData(line[0], line[2], Integer.valueOf(line[1]))) {
				System.out.println("Invalid data entered. Please try again.");
				i--;
				continue;
			}}

		Person searchKey = new Person.Builder()
				.surname(line[0])
				.gender(line[2])
				.age(Integer.valueOf(line[1]))
				.build();

		BinarySearch binarySearch = new BinarySearch();

		int index = binarySearch.search(persons, searchKey);

		if (index != -1) {
			System.out.println("Person found at index: " + index);
			System.out.println(persons.get(index));
		} else {
			System.out.println("Person not found.");
		}
	}

}
