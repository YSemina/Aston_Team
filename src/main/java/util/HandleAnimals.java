package util;



import entities.Animal;
import search.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandleAnimals {
    public static void HandleAnimals() {


        int n = InputUtils.getInt("Enter number of animals: ");

        List<Animal> animals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s=InputUtils.getString("Enter species, eye color, Has fur? (yes/no)\n");
            String line[] = s.split(",");


            if (!ValidationUtils.isValidAnimalData(s)) {
                System.out.println("Invalid data entered. Please try again.");
                i--;
                continue;
            }
            String species = line[0];
            String eyeColor = line[1];
            boolean fur = line[2].equalsIgnoreCase("yes");

            animals.add(new Animal.AnimalBuilder(species, eyeColor).fur(fur).build());

        }

//        SortStrategy<Animal> sortStrategy = new InsertionSort<>();
//
//        sortStrategy.sort(animals);
        Animal.Sort(animals);

        System.out.println("Sorted Animals:");

        Arrays.asList(animals).forEach(System.out::println);
        String line[] = {};
        for (int i = 0; i < 1; i++) {

String s=InputUtils.getString("Enter species, eye color, Has fur? (yes/no) to search:\n");
            line = s.split(",");
            if (!ValidationUtils.isValidAnimalData(s)) {
                System.out.println("Invalid data entered. Please try again.");
                i--;
            }
        }

        Animal searchKey = new Animal.AnimalBuilder(line[0], line[1]).fur(line[2].equalsIgnoreCase("yes")).build();


        BinarySearch binarySearch = new BinarySearch();

        int index = binarySearch.search(animals, searchKey);

        if (index != -1) {
            System.out.println("Animal found at index: " + index);
            System.out.println(animals.get(index));
        } else {
            System.out.println("Animal not found.");
        }
    }
}
