package org.example.entity;

import com.sun.jdi.IntegerValue;

public class Animal implements Comparable<Animal> {
	private String species;
	private String eyeColor;
	private boolean hasFur;

	public static class Builder {
		private String species;
		private String eyeColor;
		private boolean hasFur;

		public Animal.Builder species(String species) {
			this.species = species;
			return this;
		}

		public Animal.Builder eyeColor(String eyeColor) {
			this.eyeColor = eyeColor;
			return this;
		}

		public Animal.Builder hasFur(boolean hasFur) {
			this.hasFur = hasFur;
			return this;
		}

		public Animal build() {
			return new Animal(this);
		}
	}

	public Animal(Animal.Builder builder) {
		this.species = builder.species;
		this.eyeColor = builder.eyeColor;
		this.hasFur = builder.hasFur;
	}

	@Override
	public int compareTo(Animal other) {
		return this.species.compareTo(other.species);
	}

	@Override
	public String toString() {
		return species+","+eyeColor+","+hasFur;
	}

	@Override
	public int hashCode() {
		return (species.hashCode()+eyeColor.hashCode()+(hasFur?1:0))%8221;
	}

	@Override
	public boolean equals(Object obj) {
		Animal animal = (Animal) obj;
		return animal.species.equals(this.species)&&animal.eyeColor.equals(this.eyeColor)&&animal.hasFur==this.hasFur;
	}
// Геттеры и сеттеры...
}