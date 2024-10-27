package insertionSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//это натуральная сортировка для четных числовых полей
public class SpecialSort<T extends Get & Comparable<T>> implements InsertionSort<T> {

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
			//список для хранения индексов, под которыми находятся элементы с четными числовыми полями
			ArrayList<Integer> idx = new ArrayList<>();
			//добавляю в список все индексы
			for (int i = 0; i < collection.size(); ++i) {
				if (collection.get(i).Gets() % 2 == 0) {
					idx.add(i);
				}
			}
			T first = null;
			//в переменную сохраняю первый объект, удовлетворяющий поиску
			for (T t : collection) {
				if (t.Gets() % 2 == 0) {
					first = t;
					break;
				}
			}
			//установка минимального значение в начало сортировки
			SetMin(collection, first, idx.get(0));
			T temp = null;
			int left, i, j = 1, k = 0;
			for (left = idx.get(j); left < collection.size(); left = idx.get(++j)) {
				temp = collection.get(left);
				k = j - 1;
				for (i = idx.get(k); (collection.get(i).compareTo(Objects.requireNonNull(temp)) > 0); i = idx.get(k)) {
					collection.set(idx.get(k + 1), collection.get(i));
					--k;
				}
				collection.set(idx.get(k + 1), temp);
				if (j >= (idx.size() - 1)) {
					break;
				}
			}
			k = 1;
			for (i = idx.get(k); i < collection.size() && collection.get(i).compareTo(Objects.requireNonNull(first)) < 0; i = idx.get(k)) {
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
			//если числовое поле - четное
			if ((collection.get(i).Gets() % 2 == 0) && (min.compareTo(collection.get(i)) > 0)) {
				min = collection.get(i);
			}
		}
		collection.set(index, min);
	}
}