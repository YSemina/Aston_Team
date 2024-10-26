package filler;

import entities.Animal;
import entities.Barrel;
import entities.Human;
import util.InputUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.InputUtils.getString;
import static util.InputUtils.typeOfFill;

public class FileDataFiller<Entity> implements Filler<Entity> {
    private static final String RESOURCES = "src/main/resources/";

    @Override
    public List fill(String entity) throws IOException {
        String fileName=getString("Введите имя файла");
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        Arrays.asList(lines).forEach(System.out::println);

        //  int n = InputUtils.getInt("Количество: ");
        List entities = null;
      /*  switch (entity) {
            case "animal":
                entities = new ArrayList<Animal>();
                for (int i = 0; i < n; i++) {
                    String[] line = typeOfFill(entity);

                    entities.add(new Animal.AnimalBuilder(line[0],line[1]).fur(line[2].equalsIgnoreCase("yes")).build());

                }
                break;
            case "barrel":
                entities = new ArrayList<Barrel>();
                for (int i = 0; i < n; i++) {

                    String[] line = typeOfFill(entity);

                    entities.add(new Barrel.BarrelBuilder(line[0],line[1],Integer.valueOf(line[2])).build());

                }
                break;
            case "person":
                entities = new ArrayList<Human>();
                for (int i = 0; i < n; i++) {

                    String[] line = typeOfFill(entity);

                    entities.add(new Human.HumanBuilder(line[2], line[0], Integer.valueOf(line[1])).build());

                }
                break;

        }*/

        return entities;
    }

}

