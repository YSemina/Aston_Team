package org.example;

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

class humanBuild {
    public static void main(String[] args) {
        Human human = new Human.HumanBuilder("Male", "Bishop", 25)
                .build();
        System.out.println(human);
    }
}

