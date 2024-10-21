package org.InsertionSort;
import  java.util.*;

class Human implements Comparable<Human> {
    private final String gender;
    private final String secondName;
    private final int age;
    public String Gender(){return gender;}
    public String Surname(){return secondName;}
    public int Age(){return age;}
    public Human(String g,String n,int a){
        gender=g;
        secondName=n;
        age=a;
    }
    @Override
    public int compareTo(Human human) {
        return this.Surname().compareToIgnoreCase(human.Surname());
    }
    @Override
    public String toString(){
        return secondName+" ["+gender+"] "+age+" years\n";
    }
}

class Animal implements Comparable<Animal> {
    private final String species;
    private final String eyeColor;
    private final boolean fur;
    public String Species(){return species;}
    public String Eye(){return eyeColor;}
    public boolean Fur(){return fur;}
    public Animal(String s,String e,boolean f){
        species=s;
        eyeColor=e;
        fur=f;
    }
    @Override
    public int compareTo(Animal animal) {
        return this.Species().compareToIgnoreCase(animal.Species());
    }
    @Override
    public String toString(){
        return species+" "+eyeColor+" eyes "+fur+" fur\n";
    }
}

class Barrel implements Comparable<Barrel>{
    private final String storedMaterial;
    private final String fromMaterial;
    private final int volume;
    public String Stored(){return storedMaterial;}
    public String From(){return fromMaterial;}
    public int Volume(){return volume;}
    public Barrel(String s,String f,int v){
        storedMaterial=s;
        fromMaterial=f;
        volume=v;
    }
    @Override
    public int compareTo(Barrel barrel) {
        return this.Stored().compareToIgnoreCase(barrel.Stored());
    }
    @Override
    public String toString(){
        return storedMaterial +"\nМатериал: "+fromMaterial+"\nВмещает: "+volume+" литров\n";
    }
}

interface InsertionSort <E extends Comparable>{
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
//        Human o1 = new Human("w", "Alice", 19);
//        Human o2 = new Human("w", "Yuliya", 30);
//        Human o3 = new Human("m", "Bob", 25);
//        Human o4 = new Human("w", "Marta", 17);
//        Human o5 = new Human("m", "Petya", 30);
//        Human o6 = new Human("w", "Lada", 35);
//        Human o7 = new Human("m", "Andrey", 21);
//        List<Human> test = new ArrayList<>();
//        test.add(o1);
//        test.add(o2);
//        test.add(o3);
//        test.add(o4);
//        test.add(o5);
//        test.add(o6);
//        test.add(o7);
//        InsertionSort sort = new HumanSort();
//        sort.Sort(test);
//        for (Human i : test) {
//            System.out.println(i);
//        }


//        Animal a1=new Animal("Cat","Blue",true);
//        Animal a2=new Animal("Dog","Brown",true);
//        Animal a3=new Animal("Parrot","Black",false);
//        Animal a4=new Animal("Rabbit","Blue",true);
//        Animal a5=new Animal("Monkey","Black",true);
//        Animal a6=new Animal("Pig","Black",false);
//        Animal a7=new Animal("Hen","Multi-colored",false);
//        List<Animal> test2 = new ArrayList<>();
//        test2.add(a1);
//        test2.add(a2);
//        test2.add(a3);
//        test2.add(a4);
//        test2.add(a5);
//        test2.add(a6);
//        test2.add(a7);
//        InsertionSort sort = new AnimalSort();
//        sort.Sort(test2);
//        for (Animal i : test2) {
//            System.out.println(i);
//        }

//        Barrel b1 = new Barrel("Песок", "Металл", 500);
//        Barrel b2 = new Barrel("Камни", "Алюминий", 400);
//        Barrel b3 = new Barrel("Вода", "Сталь", 200);
//        Barrel b4 = new Barrel("Раствор", "Пластик", 250);
//        Barrel b5 = new Barrel("Кислота", "то, что не разъедает кислота", 10);
//        Barrel b6 = new Barrel("Пиво", "Алюминий", 30);
//        Barrel b7 = new Barrel("Перегной", "Пластик", 150);
//        List<Barrel> test3 = new ArrayList<>();
//        test3.add(b1);
//        test3.add(b2);
//        test3.add(b3);
//        test3.add(b4);
//        test3.add(b5);
//        test3.add(b6);
//        test3.add(b7);
//        InsertionSort sort = new BarrelSort();
//        sort.Sort(test3);
//        for (Barrel i : test3) {
//            System.out.println(i);
//
//        }
    }
}

