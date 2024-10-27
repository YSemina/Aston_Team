package InsertionSort;
import entities.*;
import  java.util.*;

public interface InsertionSort <E extends Comparable<E>>{
    default void Sort(List<E> collection){
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
        for(int i=1;i<collection.size();++i){
            if (min.compareTo(collection.get(i))>0){
                min=collection.get(i);
            }
        }
        collection.set(0,min);
    }
}


class Main {
    public static void main(String[] args) {
        List<Barrel> BTest=new ArrayList<>();
        BTest.add(new Barrel.BarrelBuilder("Вода", "Металл", 200).build());
        BTest.add(new Barrel.BarrelBuilder("Пиво", "Металл", 30).build());
        BTest.add(new Barrel.BarrelBuilder("Керосин", "Пластик", 255).build());
        BTest.add(new Barrel.BarrelBuilder("Раствор", "Дерево", 55).build());
        BTest.add(new Barrel.BarrelBuilder("Цемент", "Пластик", 100).build());
        BTest.add(new Barrel.BarrelBuilder("Бензин", "Металл", 1000).build());
        BTest.add(new Barrel.BarrelBuilder("Молоко", "Металл", 25).build());
        Barrel.SetSort(new SpesialSort2<Barrel>());
        Barrel.Sort(BTest);
        System.out.println("\nСортировка по числовому полю для четных значений:\n");
        for(Barrel i:BTest){
            System.out.println(i);
        }

        Barrel.SetSort(new SpesialSort<Barrel>());
        Barrel.Sort(BTest);
        System.out.println("\nНатуральная сортировка для четных числовых полей:\n");
        for(Barrel i:BTest){
            System.out.println(i);
        }

        Barrel.SetSort(new BarrelSort());
        Barrel.Sort(BTest);
        System.out.println("\nНатуральная сортировка:\n");
        for(Barrel i:BTest){
            System.out.println(i);
        }

//        List<Human> test = new ArrayList<>();
//        test.add(new Human.HumanBuilder("Female", "Anya", 28).build());
//        test.add(new Human.HumanBuilder("Female", "Lena", 26).build());
//        test.add(new Human.HumanBuilder("Female", "Olga", 24).build());
//        test.add(new Human.HumanBuilder("Female", "Bella", 32).build());
//        test.add(new Human.HumanBuilder("Female", "Danna",20).build());
//        test.add(new Human.HumanBuilder("Female", "Anya", 27).build());
//        test.add(new Human.HumanBuilder("Female", "Anya", 25).build());
//        test.add(new Human.HumanBuilder("Female", "Anya", 17).build());
//        test.add(new Human.HumanBuilder("Female", "Anya", 15).build());
//        test.add(new Human.HumanBuilder("Female", "Anya", 30).build());
//        Human.Sort(test);
//        System.out.println("\nНатуральная сортировка:\n");
//        for(Human i:test){
//            System.out.println(i);
//        }
//
//        Human.SetSort(new SpesialSort2<Human>());
//        Human.Sort(test);
//        System.out.println("\nСортировка по числовому полю для четных значений:\n");
//        for(Human i:test){
//            System.out.println(i);
//        }
//
//        Human.SetSort(new SpesialSort<Human>());
//        Human.Sort(test);
//        System.out.println("\nНатуральная сортировка для четных числовых полей:\n");
//        for(Human i:test){
//            System.out.println(i);
//        }

        }
    }







