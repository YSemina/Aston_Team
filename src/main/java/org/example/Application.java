package org.example;

import org.example.util.Handle;
import org.example.util.InputUtils;

import java.io.IOException;

import static org.example.util.InputUtils.typeOfFill;

public class Application {
    public static void main(String[] args) throws IOException {
        while (true) {
            Handle handle = new Handle();
        System.out.println("Выберите тип данных для работы:");
        System.out.println("1. Животные");
        System.out.println("2. Бочки");
        System.out.println("3. Люди");
        System.out.println("4. Выход");

        int choice = InputUtils.getInt("Введите свой вариант: ");
        String entity;

        if (choice == 4) break;

            switch (choice) {
                case 1:
                    entity = "animal";
                    break;
                case 2:
                    entity = "barrel";
                    break;
                case 3:
                    entity = "person";
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
                    continue;
            }

            handle.filler(typeOfFill(), entity);

        System.out.println(choice);
        }

    }
}
