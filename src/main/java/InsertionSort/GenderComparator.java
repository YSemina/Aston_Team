package InsertionSort;

import entities.Human;

import java.util.Comparator;

public class GenderComparator implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2){
        return h1.Gender().compareTo(h2.Gender());
    }
}
