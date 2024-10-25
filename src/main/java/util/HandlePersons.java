package util;

import InsertionSort.InsertionSort;
import entities.Human;
import search.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandlePersons {

	public static void HandlePersons() {
		int n = InputUtils.getInt("Enter number of persons: ");

		List<Human> persons = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String line[] = InputUtils.getString("Enter surname, age, gender (M/F)\n").split(",");
			System.out.println(line.length);
			if (line.length != 3 || !ValidationUtils.isValidPersonData(line[0], line[2], Integer.valueOf(line[1]))) {
				System.out.println("Invalid data entered. Please try again.");
				i--;
				continue;
			}

			String secondName = line[0];
			String gender = line[2];
			Integer age = Integer.valueOf(line[1]);


			persons.add(new Human.HumanBuilder(gender, secondName, age).build());
		}

//		InsertionSort<Human> sortStrategy = new InsertionSort<>();

//		sortStrategy.sort(persons);
//		InsertionSort.HumanSort sort = new Human().H
		Human.Sort(persons);
		System.out.println("Sorted Persons:");

		Arrays.asList(persons).forEach(System.out::println);
		String line[] = {};
		// Binary search example:
		for (int i = 0; i < 1; i++) {


			line = InputUtils.getString("Enter surname, age, gender (M/F) to search:\n").split(",");
			if (!ValidationUtils.isValidPersonData(line[0], line[2], Integer.valueOf(line[1]))) {
				System.out.println("Invalid data entered. Please try again.");
				i--;

			}
		}

		Human searchKey = new Human.HumanBuilder(line[2], line[0], Integer.valueOf(line[1])).build();

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
