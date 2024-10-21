package org.example.entity;
public class Person implements Comparable<Person>{
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
        return this.gender.compareTo(other.gender);
    }
}
