package org.InsertionSort;
import  java.util.*;

class Human implements Comparable<Human> {
    private final String gender;
    private final String secondName;
    private final int age;
    public static InsertionSort<Human> HSort=new HumanSort();
    public Human(String g,String n,int a){
        gender=g;
        secondName=n;
        age=a;
    }
    public String Gender(){return gender;}
    public String Surname(){return secondName;}
    public int Age(){return age;}
    public static void Sort(List<Human> collection){
        HSort.Sort(collection);
    }
    @Override
    public int compareTo(Human human) {
        return new SurnameComparator().thenComparing(new AgeComparator()).thenComparing(new GenderComparator()).compare(this,human);
    }
    @Override
    public String toString(){
        return secondName+" ["+gender+"] "+age+" years\n";
    }
}

class SurnameComparator implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.Surname().compareTo(h2.Surname());
    }
}

class AgeComparator implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.Age()-h2.Age();
    }
}

class GenderComparator implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2){
        return h1.Gender().compareTo(h2.Gender());
    }
}

class Animal implements Comparable<Animal> {
    private final String species;
    private final String eyeColor;
    private final boolean fur;
    public static InsertionSort<Animal> ASort=new AnimalSort();
    public Animal(String s,String e,boolean f){
        species=s;
        eyeColor=e;
        fur=f;
    }
    public String Species(){return species;}
    public String Eye(){return eyeColor;}
    public boolean Fur(){return fur;}
    public static void Sort(List<Animal> collection){
        ASort.Sort(collection);
    }
    @Override
    public int compareTo(Animal animal) {
        return new SpeciesComparator().thenComparing(new EyeComparator()).thenComparing(new FurComparator()).compare(this,animal);
    }
    @Override
    public String toString(){
        return species+" "+eyeColor+" eyes "+fur+" fur\n";
    }
}

class SpeciesComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        return a1.Species().compareTo(a2.Species());
    }
}

class EyeComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        return (a1.Eye()).compareTo(a2.Eye());
    }
}

class FurComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2){
        if(a1.Fur()==a2.Fur())return 0;
        else if(!a1.Fur())return 1;
        else return -1;
    }
}

class Barrel implements Comparable<Barrel>{
    private final String storedMaterial;
    private final String fromMaterial;
    private final int volume;
    public static InsertionSort<Barrel> BSort=new BarrelSort();
    public Barrel(String s,String f,int v){
        storedMaterial=s;
        fromMaterial=f;
        volume=v;
    }
    public String Stored(){return storedMaterial;}
    public int Volume(){return volume;}
    public String From(){return fromMaterial;}
    public static void Sort(List<Barrel> collection){
        BSort.Sort(collection);
    }
    @Override
    public int compareTo(Barrel barrel) {
        return new StoredComparator().thenComparing(new FromComparator()).thenComparing(new VolumeComparator()).compare(this,barrel);
    }
    @Override
    public String toString(){
        return storedMaterial +"\nМатериал: "+fromMaterial+"\nВмещает: "+volume+" литров\n";
    }
}

class StoredComparator implements Comparator<Barrel> {
    @Override
    public int compare(Barrel b1, Barrel b2) {
        return b1.Stored().compareTo(b2.Stored());
    }
}

class FromComparator implements Comparator<Barrel> {
    @Override
    public int compare(Barrel b1, Barrel b2) {
        return (b1.From()).compareTo(b2.From());
    }
}

class VolumeComparator implements Comparator<Barrel> {
    @Override
    public int compare(Barrel b1, Barrel b2) {
        return b1.Volume() - b2.Volume();
    }
}

interface InsertionSort <E extends Comparable<E>>{
    default void Sort(List<E> collection){
        System.out.println("Размер коллекции "+collection.size()+"\n");
        E first=collection.get(0);
        setMin(collection);
        E temp;
        int left,i;
        for (left = 1; left < collection.size(); ++left) {
            temp=collection.get(left);
            for (i=left-1; collection.get(i).compareTo(temp)>0; --i) {
                collection.set(i+1,collection.get(i));
            }
            collection.set(i+1,temp);
        }
        for(i=1;i<collection.size()&&collection.get(i).compareTo(first)<0;++i){
            collection.set(i-1,collection.get(i));
        }
        collection.set(i-1,first);
    }
    default void setMin(List<E> collection){
        E min=collection.get(0);
        int k;
        for(int i=1;i<collection.size();++i){
            if (min.compareTo(collection.get(i))>0){
                min=collection.get(i);
                k=i;
            }
        }
        collection.set(0,min);
        System.out.println("Min: "+ min + "\n");
    }
}

class HumanSort implements InsertionSort<Human>{}

class AnimalSort implements InsertionSort<Animal>{}

class BarrelSort implements InsertionSort<Barrel>{}

class Test {
    public static void main(String[] args) {

        List<Human> test = new ArrayList<>();
        test.add(new Human("w", "Alice", 19));
        test.add(new Human("w", "Yuliya", 30));
        test.add(new Human("m", "Bob", 25));
        test.add(new Human("w", "Marta", 17));
        test.add(new Human("m", "Petya", 30));
        test.add(new Human("w", "Lada", 35));
        test.add(new Human("m", "Andrey", 31));
        test.add(new Human("w", "Alice", 25));
        Human.Sort(test);
        for (Human i : test) {
            System.out.println(i);
        }


        List<Animal> test2 = new ArrayList<>();
        test2.add(new Animal("Cat","Blue",true));
        test2.add(new Animal("Dog","Brown",true));
        test2.add(new Animal("Parrot","Black",false));
        test2.add(new Animal("Rabbit","Blue",true));
        test2.add(new Animal("Monkey","Black",true));
        test2.add(new Animal("Pig","Black",false));
        test2.add(new Animal("Hen","Multi-colored",false));
        test2.add(new Animal("Cat","Abcdefg",true));
        Animal.Sort(test2);
        for (Animal i : test2) {
            System.out.println(i);
        }


        List<Barrel> test3 = new ArrayList<>();
        test3.add(new Barrel("Песок", "Металл", 500));
        test3.add(new Barrel("Камни", "Алюминий", 400));
        test3.add(new Barrel("Вода", "Сталь", 200));
        test3.add(new Barrel("Раствор", "Пластик", 250));
        test3.add(new Barrel("Кислота", "то, что не разъедает кислота", 10));
        test3.add(new Barrel("Пиво", "Алюминий", 30));
        test3.add(new Barrel("Перегной", "Пластик", 150));
        test3.add(new Barrel("Вода", "Сталь", 10000));
        Barrel.Sort(test3);
        for (Barrel i : test3) {
            System.out.println(i);
        }
    }


}

