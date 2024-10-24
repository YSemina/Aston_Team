package entities;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Human {
    private final String gender;
    private final String secondName;
    private final int age;

    public Human(HumanBuilder builder) {
        this.gender = builder.gender;
        this.secondName = builder.secondName;
        this.age = builder.age;
    }

    @Override
    public String toString() {
        return "Human [gender = " + gender + ", age = " + age + ", second name = " + secondName + "]";
    }

    public static class HumanBuilder {
        private String gender;
        private String secondName;
        private int age;


        public HumanBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public HumanBuilder setSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public HumanBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public Human build() {
            return new Human(this);
        }
    }
}


