package InsertionSort;

import Classes.Human;

import java.util.Comparator;

public class AgeComparator implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.Age()-h2.Age();
    }
}
