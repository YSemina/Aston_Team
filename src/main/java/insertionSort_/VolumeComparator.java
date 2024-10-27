package insertionSort_;

import entities.Barrel;

import java.util.Comparator;

public class VolumeComparator implements Comparator<Barrel> {
	@Override
	public int compare(Barrel b1, Barrel b2) {
		return b1.Volume() - b2.Volume();
	}
}
