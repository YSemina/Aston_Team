package insertionSort;

import java.util.*;

public interface InsertionSort<E extends Comparable<E>> {
	default void Sort(List<E> collection) {
		E first = collection.get(0);
		setMin(collection);
		E temp;
		int left, i;
		for (left = 1; left < collection.size(); ++left) {
			temp = collection.get(left);
			for (i = left - 1; collection.get(i).compareTo(temp) > 0; --i) {
				collection.set(i + 1, collection.get(i));
			}
			collection.set(i + 1, temp);
		}
		for (i = 1; i < collection.size() && collection.get(i).compareTo(first) < 0; ++i) {
			collection.set(i - 1, collection.get(i));
		}
		collection.set(i - 1, first);
	}

	default void setMin(List<E> collection) {
		E min = collection.get(0);
		for (int i = 1; i < collection.size(); ++i) {
			if (min.compareTo(collection.get(i)) > 0) {
				min = collection.get(i);
			}
		}
		collection.set(0, min);
	}
}