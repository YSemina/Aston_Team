package entities;

import insertionSort.*;

import java.util.*;

public class Human implements Comparable<Human>, Get {
	private final String gender;
	private final String secondName;
	private final int age;

	@Override
	public int Gets() {
		return age;
	}

	public static void SetSort(InsertionSort<Human> sort) {
		HSort = sort;
	}

	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Human human = (Human) o;

		if (age != human.age) return false;
		if (!gender.equals(human.gender)) return false;
		return secondName.equals(human.secondName);
	}

	@Override
	public int hashCode() {
		int result = gender.hashCode();
		result = 31 * result + secondName.hashCode();
		result = 31 * result + age;
		return result;
	}

	public Human(HumanBuilder builder) {
		this.gender = builder.gender;
		this.secondName = builder.secondName;
		this.age = builder.age;
	}

	public static InsertionSort<Human> HSort = new HumanSort();

	public String Gender() {
		return gender;
	}

	public String Surname() {
		return secondName;
	}

	public int Age() {
		return age;
	}

	public static void Sort(List<Human> collection) {
		HSort.Sort(collection);
	}

	@Override
	public int compareTo(Human human) {
		return new SurnameComparator().thenComparing(new AgeComparator()).thenComparing(new GenderComparator()).compare(this, human);
	}

	@Override
	public String toString() {
		return secondName + "," + age + "," + gender;
	}

	public static class HumanBuilder {
		private final String gender;
		private final String secondName;
		private final int age;


		public HumanBuilder(String gender, String secondName, int age) {
			this.gender = gender;
			this.secondName = secondName;
			this.age = age;
		}

		public Human build() {
			return new Human(this);
		}
	}
}