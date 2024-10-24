package org.example;

import org.example.entity.Animal;
import org.example.entity.Entity;
import org.example.sorting.InsertionSort;
import org.example.sorting.SortStrategy;
import org.example.util.Handle;
import org.example.util.InputUtils;
import org.example.util.ValidationUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.example.util.InputUtils.typeOfFill;

public class Test {
	public static void main(String[] args) throws IOException {
		Handle handle =new Handle();
		handle.importFile(typeOfFill());
		SortStrategy sortStrategy = new InsertionSort<>();

		sortStrategy.sort(handle.getEntities());

		System.out.println("Sorted Animals:");

		Arrays.asList(handle.getEntities()).forEach(System.out::println);
	}
}
