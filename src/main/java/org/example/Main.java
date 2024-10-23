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

import static org.example.util.HandleAnimals.HandleAnimals;
import static org.example.util.HandleBarrels.HandleBarrels;
import static org.example.util.HandlePersons.HandlePersons;

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
					HandleAnimals();
					break;
				case 2:
					HandleBarrels();
					break;
				case 3:
					HandlePersons();
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
			}
		}

		System.out.println("Exiting the application.");
	}


}
