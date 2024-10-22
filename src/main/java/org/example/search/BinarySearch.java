package org.example.search;


import java.util.List;

public class BinarySearch {
	public static <T extends Comparable<T>> int search(List<T> sortedList, T key) {
		int left = 0;
		int right = sortedList.size() - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
//			System.out.println("obj: "+key.toString()+"\t"+ key.hashCode()+":BS:"+sortedList.get(mid).hashCode());
			if (sortedList.get(mid).equals(key)) {
				return mid;
			}
			if (sortedList.get(mid).compareTo(key) < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1; // Элемент не найден
	}
}
