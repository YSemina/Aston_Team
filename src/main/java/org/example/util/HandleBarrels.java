package org.example.util;

import org.example.entity.Barrel;
import org.example.search.BinarySearch;
import org.example.sorting.InsertionSort;
import org.example.sorting.SortStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandleBarrels {
	public static void HandleBarrels() {
		int n = InputUtils.getInt("Enter number of barrels: ");

		List<Barrel> barrels = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String line[] = InputUtils.getString("Enter content, made, volume\n").split(",");
			String content = line[0];
			String made = line[1];
			Integer volume = Integer.valueOf(line[2]);

			if (!ValidationUtils.isValidBarrelData(volume, content, made)) {
				System.out.println("Invalid data entered. Please try again.");
				i--;
				continue;
			}

			barrels.add(new Barrel.Builder()
					.content(content)
					.made(made)
					.volume(volume)
					.build());
		}

		SortStrategy<Barrel> sortStrategy = new InsertionSort<>();

		sortStrategy.sort(barrels);

		System.out.println("Sorted Barrels:");

		Arrays.asList(barrels).forEach(System.out::println);
		String line[] = {};
		for (int i = 0; i < 1; i++) {


			line = InputUtils.getString("Enter content, made, volume to search:\n").split(",");
			if (!ValidationUtils.isValidBarrelData(Integer.valueOf(line[2]), line[0], line[1])) {
				System.out.println("Invalid data entered. Please try again.");
				i--;

			}
		}

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
}
