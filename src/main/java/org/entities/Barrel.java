package org.entities;

public class Barrel {
    private final String storedMaterial;
    private final String fromMaterial;
    private final int volume;

    public Barrel(BarrelBuilder builder) {
        this.storedMaterial = builder.storedMaterial;
        this.fromMaterial = builder.fromMaterial;
        this.volume = builder.volume;
    }

    @Override
    public String toString() {
        return "Barrel [volume = " + volume + ", Stored Material = " + storedMaterial + ", From Material = " + fromMaterial + "]";
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

class barrelBuild {
    public static void main(String[] args) {
        Barrel barrel = new Barrel.BarrelBuilder("Water", "Wood", 25)
                .build();
        System.out.println(barrel);
    }
}

//public class Barrel implements Comparable<Barrel>
//public static InsertionSort<Barrel> BSort=new BarrelSort();
//    public String Stored(){return storedMaterial;}
//    public int Volume(){return volume;}
//    public String From(){return fromMaterial;}
//    public static void Sort(List<Barrel> collection){
//    BSort.Sort(collection);
//}
//@Override
//public int compareTo(Barrel barrel) {
//    return new StoredComparator().thenComparing(new FromComparator()).thenComparing(new VolumeComparator()).compare(this,barrel);
//}