package org.InsertionSort;
import  java.util.*;

public interface InsertionSort <E extends Comparable<E>>{
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
        for(int i=1;i<collection.size();++i){
            if (min.compareTo(collection.get(i))>0){
                min=collection.get(i);
            }
        }
        collection.set(0,min);
        System.out.println("Min: "+ min + "\n");
    }
}

class Test {
    public static void main(String[] args) {

//        List<Human> test = new ArrayList<>();
//        test.add(new Human("w", "Alice", 19));
//        test.add(new Human("w", "Yuliya", 30));
//        test.add(new Human("m", "Bob", 25));
//        test.add(new Human("w", "Marta", 17));
//        test.add(new Human("m", "Petya", 30));
//        test.add(new Human("w", "Lada", 35));
//        test.add(new Human("m", "Andrey", 31));
//        test.add(new Human("w", "Alice", 25));
//        Human.Sort(test);
//        for (Human i : test) {
//            System.out.println(i);
//        }
//
//
//        List<Animal> test2 = new ArrayList<>();
//        test2.add(new Animal("Cat","Blue",true));
//        test2.add(new Animal("Dog","Brown",true));
//        test2.add(new Animal("Parrot","Black",false));
//        test2.add(new Animal("Rabbit","Blue",true));
//        test2.add(new Animal("Monkey","Black",true));
//        test2.add(new Animal("Pig","Black",false));
//        test2.add(new Animal("Hen","Multi-colored",false));
//        test2.add(new Animal("Cat","Abcdefg",true));
//        Animal.Sort(test2);
//        for (Animal i : test2) {
//            System.out.println(i);
//        }
//
//
//        List<Barrel> test3 = new ArrayList<>();
//        test3.add(new Barrel("Песок", "Металл", 500));
//        test3.add(new Barrel("Камни", "Алюминий", 400));
//        test3.add(new Barrel("Вода", "Сталь", 200));
//        test3.add(new Barrel("Раствор", "Пластик", 250));
//        test3.add(new Barrel("Кислота", "то, что не разъедает кислота", 10));
//        test3.add(new Barrel("Пиво", "Алюминий", 30));
//        test3.add(new Barrel("Перегной", "Пластик", 150));
//        test3.add(new Barrel("Вода", "Сталь", 10000));
//        Barrel.Sort(test3);
//        for (Barrel i : test3) {
//            System.out.println(i);
//        }


//        int choice=0,fill=0;
//        //вместо Integer будет способ заполнения
//        Map<Human,Integer> HumanFiller=new HashMap<>();
//        Map<Animal,Integer> AnimalFiller=new HashMap<>();
//        Map<Barrel,Integer> BarrelFiller=new HashMap<>();
//        Scanner in=new Scanner(System.in);
//        do {
//            do {
//                System.out.println("Выберете категорию:\n1 - Человек\n2 - Животное\n3 - Бочка\n0 - Выход\n");
//                choice = in.nextInt();
//                if (choice == 0) break;
//                System.out.println("Выберете способ заполнения:\n1 - Вручную\n2 - Из файла\n3 - Рандомно\n4 - Вернуться назад\n0 - Выход\n");
//                fill = in.nextInt();
//                if (fill == 0) {
//                    choice = fill;
//                    break;
//                }
//                else if(fill==4) break;
//                else {
//                    switch(choice){
//                        case 1:
//
//                    }
//                }
//            }while(true);
//        }while(choice!=0);
    }
}

