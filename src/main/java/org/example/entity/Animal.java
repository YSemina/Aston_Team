package org.example.entity;


import java.util.Comparator;

public class Animal implements Comparable<Animal> {
    private String species;
    private String eyeColor;
    private boolean hasFur;

    public String getSpecies() {
        return species;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public boolean isHasFur() {
        return hasFur;
    }

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

    /*@Override
    public int compareTo(Animal other) {
        return (this.species+this.eyeColor+this.hasFur).compareTo(other.species+other.eyeColor+other.hasFur);
    }*/
    @Override
    public int compareTo(Animal other) {
        return Comparator.comparing(Animal::getSpecies)
                .thenComparing(Animal::getEyeColor)
                .thenComparing(Animal::isHasFur)
                .compare(this, other);
    }

    @Override
    public String toString() {
        return species + "," + eyeColor + "," + hasFur;
    }

    @Override
    public int hashCode() {
        return (species.hashCode() + eyeColor.hashCode() + (hasFur ? 1 : 0)) % 8221;
    }

    @Override
    public boolean equals(Object obj) {
        Animal animal = (Animal) obj;
        return animal.species.equals(this.species) && animal.eyeColor.equals(this.eyeColor) && animal.hasFur == this.hasFur;
    }
// Геттеры и сеттеры...
}