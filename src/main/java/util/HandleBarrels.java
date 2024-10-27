package util;


import entities.Barrel;
import search.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandleBarrels {
	public static void HandleBarrels() {
		int n = InputUtils.getInt("Enter number of barrels: ");

		List<Barrel> barrels = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String s=InputUtils.getString("Enter content, made, volume\n");
			String line[] = s.split(",");


			if (!ValidationUtils.isValidBarrelData(s)) {
				System.out.println("Invalid data entered. Please try again.");
				i--;
				continue;
			}
			String storedMaterial = line[0];
			String fromMaterial = line[1];
			Integer volume = Integer.valueOf(line[2]);

			barrels.add(new Barrel.BarrelBuilder(storedMaterial, fromMaterial, volume).build());

		}

//		SortStrategy<Barrel> sortStrategy = new InsertionSort<>();
//
//		sortStrategy.sort(barrels);
		Barrel.Sort(barrels);

		System.out.println("Sorted Barrels:");

		Arrays.asList(barrels).forEach(System.out::println);
		String line[] = {};
		for (int i = 0; i < 1; i++) {

String s=InputUtils.getString("Enter content, made, volume to search:\n");
			line = s.split(",");
			if (!ValidationUtils.isValidBarrelData(s)) {
				System.out.println("Invalid data entered. Please try again.");
				i--;

			}
		}

		Barrel searchKey = new Barrel.BarrelBuilder(line[0], line[1], Integer.valueOf(line[2])).build();


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
