/***
 * написать приложение, которое будет реализовывать алгоритм сортировки по переданным классам.  Вся архитектура и код
 * стайл должны соответствовать конвенциям языка Java.Программа должна выполняться в цикле. Выход из цикла возможен
 * только путем соответствующего выбора пользователя. Пользователь должен иметь возможность выбирать варианты заполнения
 * исходного массива данных (из файла, рандом, вручную) и его длину. Также у пользователя должна быть возможность найти
 * какой-либо элемент отсортированной коллекции при помощи алгоритма бинарного поиска, которые также необходимо
 * реализовать. Сортировки и бинарный поиск должны быть реализованы с использованием дженериков и быть универсальными
 * под любые классы программы. В программе должен использовать паттерн стратегия. Сортировать необходимо кастомные
 * классы - класс должен иметь реализованный паттерн Builder. Для вводимых данных (в тч из файла) должна производится
 * валидация данных.
 *  Доп. задание: дополнительно к основным сортировкам реализовать эти же алгоритмы сортировки таким
 * образом, что классы будут сортироваться по какому-либо числовому полю таким образом, что классы с четными значениями
 * будут сортироваться в натуральном порядке, а с нечетными оставаться на своих местах.
 *  Доп. доп. задание: Необходимо реализовать функционал для записи отсортированных коллекций/найденных значений в файл
 * в режиме добавления данных.
 * Классы: Животное (Вид, Цвет глаз, Шерсть (булка)), Бочка (Объем, Хранимый материал, Материал из которого изготовлена)
 * , Человек (Пол, Возраст, Фамилия) Сортировка - InsertionSort
 */

package org.example;


import org.example.entity.Animal;
import org.example.search.BinarySearch;
import org.example.sorting.InsertionSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить животное");
            System.out.println("2. Сортировать животных");
            System.out.println("3. Найти животное");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    // Добавление животного вручную (с валидацией)
                    System.out.print("Введите вид: ");
                    String species = scanner.nextLine();
                    System.out.print("Введите цвет глаз: ");
                    String eyeColor = scanner.nextLine();
                    System.out.print("Есть ли шерсть (true/false): ");
                    boolean hasFur = scanner.nextBoolean();
                    animals.add(new Animal.Builder().species(species).eyeColor(eyeColor).hasFur(hasFur).build());
                    for (Animal a : animals) {
                        System.out.println(a);
                    }
                    break;

                case 2:
                    // Сортировка животных
                    InsertionSort<Animal> sorter = new InsertionSort<>();
                    sorter.sort(animals);
                    for (Animal a : animals) {
                        System.out.println(a);
                    }
                    System.out.println("Животные отсортированы.");
                    break;

                case 3:
                    // Поиск животного
                    System.out.print("Введите вид для поиска: ");
                    String searchSpecies = scanner.nextLine();
                    int index = BinarySearch.search(animals, new Animal.Builder().species(searchSpecies).eyeColor(searchSpecies).hasFur(true).build());
                    if (index != -1) {
                        System.out.println("Животное найдено: " + animals.get(index));
                    } else {
                        System.out.println("Животное не найдено.");
                    }
                    break;

                case 0:
                    System.out.println("Выход из программы.");
                    return;

                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }
}