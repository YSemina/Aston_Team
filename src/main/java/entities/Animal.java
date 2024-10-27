package entities;

import insertionSort_.*;

import java.util.*;

public class Animal implements Comparable<Animal> {
	private final String species;
	private final String eyeColor;
	private final boolean fur;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Animal animal = (Animal) o;

		if (fur != animal.fur) return false;
		if (!species.equals(animal.species)) return false;
		return eyeColor.equals(animal.eyeColor);
	}

	@Override
	public int hashCode() {
		int result = species.hashCode();
		result = 31 * result + eyeColor.hashCode();
		result = 31 * result + (fur ? 1 : 0);
		return result;
	}

	public Animal(AnimalBuilder builder) {
		this.species = builder.species;
		this.eyeColor = builder.eyeColor;
		this.fur = builder.fur;
	}

	public static InsertionSort<Animal> ASort = new AnimalSort();

	public String Species() {
		return species;
	}

	public String Eye() {
		return eyeColor;
	}

	public boolean Fur() {
		return fur;
	}

	public static void Sort(List<Animal> collection) {
		ASort.Sort(collection);
	}

	@Override
	public int compareTo(Animal animal) {
		return new SpeciesComparator().thenComparing(new EyeComparator()).thenComparing(new FurComparator()).compare(this, animal);
	}

	@Override
	public String toString() {
		return species + "," + eyeColor + "," + fur;
	}

	public static class AnimalBuilder {
		private final String species;
		private final String eyeColor;
		private boolean fur;


		public AnimalBuilder(String species, String eyeColor) {
			this.species = species;
			this.eyeColor = eyeColor;
		}

		public AnimalBuilder fur(boolean fur) {
			this.fur = fur;
			return this;
		}

		public Animal build() {
			return new Animal(this);
		}
	}
}

class animalBuild {
	public static void main(String[] args) {
		Animal animal = new Animal.AnimalBuilder("mammals", "Hazel").fur(false).fur(true)
				.build();
		System.out.println(animal);
	}
}

