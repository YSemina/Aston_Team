public class Animal implements Comparable<Animal> {
    private String species;
    private String eyeColor;
    private boolean fur;

    // Builder Pattern
    public static class Builder {
        private String species;
        private String eyeColor;
        private boolean fur;

        public Builder species(String species) {
            this.species = species;
            return this;
        }

        public Builder eyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
            return this;
        }

        public Builder fur(boolean fur) {
            this.fur = fur;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }

    private Animal(Builder builder) {
        this.species = builder.species;
        this.eyeColor = builder.eyeColor;
        this.fur = builder.fur;
    }

    // Геттеры и compareTo для сортировки
    public String getSpecies() {
        return species;
    }

    @Override
    public int compareTo(Animal other) {
        return this.species.compareTo(other.species);
    }
}

