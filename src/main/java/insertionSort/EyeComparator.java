package insertionSort;

import entities.Animal;

import java.util.Comparator;

public class EyeComparator implements Comparator<Animal> {
	@Override
	public int compare(Animal a1, Animal a2) {
		return (a1.Eye()).compareTo(a2.Eye());
	}
}