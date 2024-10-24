package org.InsertionSort;

import java.util.Comparator;

public class FromComparator implements Comparator<Barrel> {
    @Override
    public int compare(Barrel b1, Barrel b2) {
        return (b1.From()).compareTo(b2.From());
    }
}
