package insertionSort;

import entities.Barrel;

import java.util.Comparator;

public class StoredComparator implements Comparator<Barrel> {
	@Override
	public int compare(Barrel b1, Barrel b2) {
		return b1.Stored().compareTo(b2.Stored());
	}
}