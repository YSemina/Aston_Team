package InsertionSort;

import entities.Human;

import java.util.Comparator;

public class SurnameComparator implements Comparator<Human> {
	@Override
	public int compare(Human h1, Human h2) {
		return h1.Surname().compareTo(h2.Surname());
	}
}
