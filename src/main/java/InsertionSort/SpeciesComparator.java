package InsertionSort;

import entities.Animal;

import java.util.Comparator;

public class SpeciesComparator implements Comparator<Animal> {
	@Override
	public int compare(Animal a1, Animal a2) {
		return a1.Species().compareTo(a2.Species());
	}
}
