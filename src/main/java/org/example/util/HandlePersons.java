package org.example.util;

import org.example.entity.Person;
import org.example.search.BinarySearch;
import org.example.sorting.InsertionSort;
import org.example.sorting.SortStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandlePersons {
	public static void HandlePersons() {
		int n = InputUtils.getInt("Enter number of persons: ");

		List<Person> persons = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String line[] = InputUtils.getString("Enter surname, age, gender (M/F)\n").split(",");
			System.out.println(line.length);
			if (line.length != 3 || !ValidationUtils.isValidPersonData(line[0], line[2], Integer.valueOf(line[1]))) {
				System.out.println("Invalid data entered. Please try again.");
				i--;
				continue;
			}

			String surname = line[0];
			String gender = line[2];
			Integer age = Integer.valueOf(line[1]);


			persons.add(new Person.Builder()
					.surname(surname)
					.gender(gender)
					.age(age)
					.build());
		}

		SortStrategy<Person> sortStrategy = new InsertionSort<>();

		sortStrategy.sort(persons);

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
