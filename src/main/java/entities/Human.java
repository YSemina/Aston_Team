package entities;

import java.util.Scanner;
import java.io.*;
import java.util.Random;

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

class Filler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select how to fill class :");
        System.out.println("1 - Autocomplete (random values)");
        System.out.println("2 - Manual entry");
        System.out.println("3 - Filling from file");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                RandomFill randomFill = new RandomFill();
                randomFill.execute();
                break;
            case 2:
                ManualFill manualFill = new ManualFill();
                manualFill.execute();
                break;
            case 3:
                FFFill fFFill = new FFFill();
                fFFill.execute();
                break;
            default:
                System.out.println("Wrong choice!");
                break;
        }
    }

    static class RandomFill {
        void execute() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of humans: ");
            int repeatCount = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < repeatCount; i++) {                String[] gender = {"Male", "Female"};
                String[] secondName = {"Woods", "Dauda", "Hackett", "Bishop"};
                Random random = new Random();

                Human human = new Human.HumanBuilder()
                        .setGender(gender[random.nextInt(gender.length)])
                        .setAge(random.nextInt(99))
                        .setSecondName(secondName[random.nextInt(secondName.length)])
                        .build();

                System.out.println(human);
            }
        }
    }

    static class ManualFill {
        void execute() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of humans: ");
            int repeatCount = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < repeatCount; i++) {

                Human.HumanBuilder humanBuilder = new Human.HumanBuilder();

                System.out.print("Enter gender: ");
                String gender = scanner.nextLine();
                humanBuilder.setGender(gender);

                System.out.print("Enter Second Name: ");
                String secondName = scanner.nextLine();
                humanBuilder.setSecondName(secondName);

                System.out.print("Enter age:  ");
                int age = Integer.parseInt(scanner.nextLine());
                humanBuilder.setAge(age);

                Human human = humanBuilder.build();

                System.out.println("Created Human: " + human);
            }

            scanner.close();
        }
    }

    static class FFFill {
        void execute() {
            System.out.print("Enter file name: ");
            Scanner scanner = new Scanner(System.in);
            String filename = scanner.nextLine();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    Human human = new Human.HumanBuilder()
                            .setGender(parts[0])
                            .setSecondName(parts[1])
                            .setAge(Integer.parseInt(parts[2]))
                            .build();

                    System.out.println(human);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

