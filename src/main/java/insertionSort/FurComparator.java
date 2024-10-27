package insertionSort;

import entities.Animal;

import java.util.Comparator;

public class FurComparator implements Comparator<Animal> {
	@Override
	public int compare(Animal a1, Animal a2) {
		if (a1.Fur() == a2.Fur()) return 0;
		else if (!a1.Fur()) return 1;
		else return -1;
	}
}
