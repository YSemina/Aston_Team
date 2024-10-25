package org.example.entity;

import java.util.Comparator;

public class Person implements Comparable<Person> {
	private String gender;
	private String surname;
	private Integer age;

	// Builder Pattern
	public static class Builder {
		private String gender;
		private String surname;
		private Integer age;

		public Person.Builder gender(String gender) {
			this.gender = gender;
			return this;
		}

		public Person.Builder surname(String surname) {
			this.surname = surname;
			return this;
		}

		public Person.Builder age(Integer age) {
			this.age = age;
			return this;
		}

		public Person build() {
			return new Person(this);
		}
	}

	public String getSurname() {
		return surname;
	}

	public Integer getAge() {
		return age;
	}

	private Person(Person.Builder builder) {
		this.gender = builder.gender;
		this.surname = builder.surname;
		this.age = builder.age;
	}

	// Геттеры и compareTo для сортировки
	public String getGender() {
		return gender;
	}

	@Override
	public int compareTo(Person other) {
		return Comparator.comparing(Person::getSurname).thenComparing(Person::getAge).thenComparing(Person::getGender).compare(this, other);
	}

	@Override
	public String toString() {
		return surname + "," + age + "," + gender;
	}

	@Override
	public int hashCode() {
		return (surname.hashCode() + gender.hashCode() + age) % 8221;
	}

	@Override
	public boolean equals(Object obj) {
		Person person = (Person) obj;
		return person.surname.equals(this.surname) && person.gender.equals(this.gender) && person.age == this.age;
	}
}
