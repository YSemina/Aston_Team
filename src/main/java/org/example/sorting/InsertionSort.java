package org.example.sorting;

import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements SortStrategy<T> {
    public void sort(List<T> items) {
        System.out.println(items.get(0).getClass());
        for (int i = 1; i < items.size(); i++) {
            T key = items.get(i);
            int j = i - 1;
            while (j >= 0 && items.get(j).compareTo(key) > 0) {
                items.set(j + 1, items.get(j));
                j--;
            }
            items.set(j + 1, key);
        }
    }
}
