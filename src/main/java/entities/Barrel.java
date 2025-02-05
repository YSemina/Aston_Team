package entities;

import insertionSort.*;

import java.util.*;

public class Barrel implements Comparable<Barrel>, Get {
	private final String storedMaterial;
	private final String fromMaterial;
	private final int volume;

	public static void SetSort(InsertionSort<Barrel> sort) {
		BSort = sort;
	}

	@Override
	public int Gets() {
		return volume;
	}

	public Barrel(BarrelBuilder builder) {
		this.storedMaterial = builder.storedMaterial;
		this.fromMaterial = builder.fromMaterial;
		this.volume = builder.volume;
	}

	public static InsertionSort<Barrel> BSort = new BarrelSort();

	public String Stored() {
		return storedMaterial;
	}

	public int Volume() {
		return volume;
	}

	public String From() {
		return fromMaterial;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Barrel barrel = (Barrel) o;

		if (volume != barrel.volume) return false;
		if (!storedMaterial.equals(barrel.storedMaterial)) return false;
		return fromMaterial.equals(barrel.fromMaterial);
	}

	@Override
	public int hashCode() {
		int result = storedMaterial.hashCode();
		result = 31 * result + fromMaterial.hashCode();
		result = 31 * result + volume;
		return result;
	}

	public static void Sort(List<Barrel> collection) {
		BSort.Sort(collection);
	}

	@Override
	public int compareTo(Barrel barrel) {
		return new StoredComparator().thenComparing(new FromComparator()).thenComparing(new VolumeComparator()).compare(this, barrel);
	}

	@Override
	public String toString() {
		return storedMaterial + "," + fromMaterial + "," + volume;
	}

	public static class BarrelBuilder {
		private final String storedMaterial;
		private final String fromMaterial;
		private final int volume;


		public BarrelBuilder(String storedMaterial, String fromMaterial, int volume) {
			this.storedMaterial = storedMaterial;
			this.fromMaterial = fromMaterial;
			this.volume = volume;
		}

		public Barrel build() {
			return new Barrel(this);
		}
	}
}