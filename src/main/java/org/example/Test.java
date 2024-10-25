package org.example;

import org.example.sorting.InsertionSort;
import org.example.sorting.SortStrategy;
import org.example.util.Handle;

import java.io.IOException;
import java.util.Arrays;

import static org.example.util.InputUtils.typeOfFill;

public class Test {
	public static void main(String[] args) throws IOException {
		/*Handle handle =new Handle();
		handle.filler(typeOfFill(), "animal");
		SortStrategy sortStrategy = new InsertionSort<>();

		sortStrategy.sort(handle.getEntities());

		System.out.println("Sorted Animals:");

		Arrays.asList(handle.getEntities()).forEach(System.out::println);*/

		// Пример строки с кириллическими символами, разделенными запятыми
		String input = "рыбий жир,глина,578";

		// Разделяем строку по запятой
		String[] фамилии = input.split(",");

		// Выводим результат
		for (String фамилия : фамилии) {
			System.out.println(фамилия);
		}
	}
}
