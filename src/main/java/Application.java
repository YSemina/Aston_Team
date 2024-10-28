


import entities.Animal;
import entities.Barrel;
import entities.Human;
import insertionSort.BarrelSort;
import insertionSort.HumanSort;
import insertionSort.SpecialSort;
import insertionSort.SpecialSort2;
import search.BinarySearch;
import util.Handle;
import util.InputUtils;

import java.io.IOException;
import java.util.Collections;

import static util.InputUtils.typeOfFill;

public class Application {
    public static void main(String[] args) throws IOException {
        while (true) {
            Handle handle = new Handle();
            System.out.println("Выберите тип данных для работы:");
            System.out.println("1. Животные");
            System.out.println("2. Бочки");
            System.out.println("3. Люди");
            System.out.println("4. Выход");

            int choice = InputUtils.getInt("Введите свой вариант: ");
            String entity;

            if (choice == 4) break;

            switch (choice) {
                case 1 -> entity = "animal";
                case 2 -> entity = "barrel";
                case 3 -> entity = "person";
                default -> {
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
                    continue;
                }
            }
            handle.filler(typeOfFill(), entity);

            handle.print();
            if (handle.getEntities().size() == 0) {
                System.out.println("Коллекция пустая, попробуйте еще раз.");
                continue;
            }

            int flag;
            do {
                System.out.println("\n1. Пропустить сортировку");
                System.out.println("2. Отсортировать список");
                if (!entity.equals("animal")) {
                  System.out.println("3. Отсортировать список только c четными значениями");
                }
                int sort = InputUtils.getInt("Введите свой вариант: ");
                if ((sort == 2)&&(entity.equals("animal"))) {
                    Animal.Sort(handle.getEntities());
                }
                else if((sort==2)&&(entity.equals("barrel"))) {
                     Barrel.SetSort(new BarrelSort());
                     Barrel.Sort(handle.getEntities());
                }
                 else if(sort==2) {
                    Human.SetSort(new HumanSort());
                    Human.Sort(handle.getEntities());
                 }
                if((sort==3)&&(!entity.equals("animal"))){
                    System.out.println("1. Отсортировать в натуральном порядке");
                    System.out.println("2. Отсортировать по числовому полю");
                    sort = InputUtils.getInt("Введите свой вариант: ");
                    if(entity.equals("barrel")){
                       if(sort==1){
                           Barrel.SetSort(new SpecialSort<>());
                       }
                        else if(sort==2) {
                           Barrel.SetSort(new SpecialSort2<>());
                        }
                        Barrel.Sort(handle.getEntities());
                    }
                    else {
                        if(sort==1) {
                            Human.SetSort(new SpecialSort<>());
                           }
                           else if(sort==2) {
                             Human.SetSort(new SpecialSort2<>());
                           }
                            Human.Sort(handle.getEntities());
                    }
                }
                 System.out.println("\nПоказать список?\n1. да\n2. нет\n");
                 sort = InputUtils.getInt("Введите свой вариант: ");
                 if (sort == 1) {
                     handle.print();
                 }
                 do {
                    System.out.println("\nНужно найти элемент?\n1. да\n2. нет\n");
                    flag = InputUtils.getInt("Введите свой вариант: ");
                   if (flag == 1) {
                       int index;
                       System.out.println();//для поиска
                       String[] line = typeOfFill(entity);
                          if (entity.equals("animal")) {
                            Animal.Sort(handle.getEntities());
                            handle.print();
                            Animal searchKey = new Animal.AnimalBuilder(line[0], line[1]).fur(line[2].equalsIgnoreCase("да")||line[2].equalsIgnoreCase("есть мех")).build();
                            index = BinarySearch.search(handle.getEntities(), searchKey);
                          }
                          else if (entity.equals("barrel")) {
                            Barrel.SetSort(new BarrelSort());
                            Barrel.Sort(handle.getEntities());
                            Barrel searchKey = new Barrel.BarrelBuilder(line[0], line[1], Integer.parseInt(line[2])).build();
                             index = BinarySearch.search(handle.getEntities(), searchKey);
                          }
                          else {
                             Human.SetSort(new HumanSort());
                             Human.Sort(handle.getEntities());
                             Human searchKey = new Human.HumanBuilder(line[2], line[0], Integer.parseInt(line[1])).build();
                             index = BinarySearch.search(handle.getEntities(), searchKey);
                          }
                           if (index != -1) {
                             System.out.println("Элемент найдет по индексу : " + index);
                             System.out.println(handle.getEntities().get(index));
                           }
                           else {
                              System.out.println("Элемент не найден");
                           }
                   }
                 }while(flag!=2);
                 System.out.println("Записать коллекцию в файл?");
                 System.out.println("1. да\n2. нет");
                 int file = InputUtils.getInt("Введите свой вариант: ");
                 if (file == 1) {
                   handle.write();
                   System.out.println("Файл успешно записан!\n");
                 }
                 System.out.println("Вернуться в меню сортировки?");
                 System.out.println("1. да\n2. нет");
                 flag= InputUtils.getInt("Введите свой вариант: ");
            }while(flag!=2);
        }
    }
}
