package org.example;

import java.util.Scanner;

public class AnimalF {
    private final String species;
    private final String eyeColor;
    private final boolean fur;

    public AnimalF(AnimalFBuilder builder) {
        this.species = builder.species;
        this.eyeColor = builder.eyeColor;
        this.fur = builder.fur;
    }

    @Override
    public String toString() {
        return "Animal [species = " + species + ",  Fur = " +  fur + ", Eye Color = " + eyeColor + "]";
    }

    public static class AnimalFBuilder {
        private String species;
        private String eyeColor;
        private boolean fur;


        public AnimalFBuilder setSpecies(String species) {
            this.species = species;
            return this;
        }

        public AnimalFBuilder seteyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
            return this;
        }

        public AnimalFBuilder setFur(boolean fur) {
            this.fur = fur;
            return this;
        }

        public AnimalF build() {
            return new AnimalF(this);
        }
    }
}

class AnimalFBuild {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AnimalF.AnimalFBuilder animalFBuilder = new AnimalF.AnimalFBuilder();

        System.out.print("Type species: ");
        String species = scanner.nextLine();
        animalFBuilder.setSpecies(species);

        System.out.print("Type eye color: ");
        String eyeColor = scanner.nextLine();
        animalFBuilder.seteyeColor(eyeColor);

        System.out.print("Type fur true or false: ");
        boolean fur = scanner.hasNextBoolean();
        animalFBuilder.setFur(fur);

        AnimalF animalF = animalFBuilder.build();

        System.out.println("Created Animal: " + animalF);

        scanner.close();
    }
}
