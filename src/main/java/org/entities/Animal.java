package org.entities;

public class Animal {
    private final String species;
    private final String eyeColor;
    private final boolean fur;

    public Animal(AnimalBuilder builder) {
        this.species = builder.species;
        this.eyeColor = builder.eyeColor;
        this.fur = builder.fur;
    }

    @Override
    public String toString() {
        return "Animal [species = " + species + ",  Fur = " +  fur + ", Eye Color = " + eyeColor + "]";
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

//public static InsertionSort<Animal> ASort=new AnimalSort();
//    public String Species(){return species;}
//    public String Eye(){return eyeColor;}
//    public boolean Fur(){return fur;}
//
//public static void Sort(List<Animal> collection){
//    ASort.Sort(collection);
//}
//@Override
//public int compareTo(Animal animal) {
//    return new SpeciesComparator().thenComparing(new EyeComparator()).thenComparing(new FurComparator()).compare(this,animal);
//}