package insertionSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

//это сортировка для четных числовых полей по числовому полю
public class SpesialSort2<T extends Get & Comparable<T>> implements InsertionSort<T>, Comparator<T> {
	@Override
	public int compare(T h1, T h2) {
		return h1.Gets() - h2.Gets();
	}

	@Override
	public void Sort(List<T> collection) {

		int count = 0;//счетчик

		for (T i : collection) {
			if (i.Gets() % 2 == 0) {
				++count;
			}
		}
		if (count == 0) {
			System.out.println("Увы, в этом списке нет объектов с четным числовым полем.\nСортировки не будет.\n");
		} else if (count == 1) {
			System.out.println("В этом списке лишь один объект с четным числовым полем.\nВ сортировке нет смысла.\n");
		} else {
			ArrayList<Integer> idx = new ArrayList<>();
			for (int i = 0; i < collection.size(); ++i) {
				if (collection.get(i).Gets() % 2 == 0) {
					idx.add(i);
				}
			}
			T first = null;
			for (T t : collection) {
				if (t.Gets() % 2 == 0) {
					first = t;
					break;
				}
			}
			SetMin(collection, first, idx.get(0));
			T temp;
			int left, i, j = 1, k;
			for (left = idx.get(j); left < collection.size(); left = idx.get(++j)) {
				temp = collection.get(left);
				k = j - 1;
				for (i = idx.get(k); (compare(collection.get(i), temp) > 0); i = idx.get(k)) {
					collection.set(idx.get(k + 1), collection.get(i));
					--k;
				}
				collection.set(idx.get(k + 1), temp);
				if (j >= (idx.size() - 1)) {
					break;
				}
			}
			k = 1;
			for (i = idx.get(k); i < collection.size() && compare(collection.get(i), Objects.requireNonNull(first)) < 0; i = idx.get(k)) {
				collection.set(idx.get(k - 1), collection.get(i));
				++k;
				if (k >= (idx.size())) {
					break;
				}
			}
			collection.set((idx.get(k - 1)), first);
		}
	}

	public void SetMin(List<T> collection, T min, int index) {
		for (int i = index + 1; i < collection.size(); ++i) {
			assert min != null;
			if ((collection.get(i).Gets() % 2 == 0) && (compare(min, collection.get(i)) > 0)) {
				min = collection.get(i);
			}
		}
		collection.set(index, min);
	}
}
