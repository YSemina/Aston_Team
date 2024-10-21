package org.example;

public class Animal {
    private final String species;
    private final String eyeColor;
    private final int furBulk;

    public Animal(AnimalBuilder builder) {
        this.species = builder.species;
        this.eyeColor = builder.eyeColor;
        this.furBulk = builder.furBulk;
    }

    @Override
    public String toString() {
        return "Animal [species = " + species + ", Bulks of fur = " + furBulk + ", Eye Color = " + eyeColor + "]";
    }

    public static class AnimalBuilder {
        private final String species;
        private final String eyeColor;
        private final int furBulk;


        public AnimalBuilder(String species, String eyeColor, int furBulk) {
            this.species = species;
            this.eyeColor = eyeColor;
            this.furBulk = furBulk;
        }
        public Animal build() {
            return new Animal(this);
        }
    }
}

class animalBuild {
    public static void main(String[] args) {
        Animal animal = new Animal.AnimalBuilder("mammals", "Hazel", 5)
                .build();
        System.out.println(animal);
    }
}
