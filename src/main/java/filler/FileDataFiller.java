package filler;

import entities.Animal;
import entities.Barrel;
import entities.Human;
import util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static util.InputUtils.getString;

public class FileDataFiller<Entity> implements Filler<Entity> {
	private static final Logger logger = Logger.getLogger(FileDataFiller.class.getName());

	private static final String RESOURCES = "src/main/resources/";

	@Override
	public List fill(String entity) throws IOException {
		String fileName = null;
		for (int i = 0; i < 1; i++) {
			fileName = getString("Введите имя файла: ");
			if (!Files.exists(Paths.get(RESOURCES + fileName))) {
				System.out.println("Файл не найден.");
				i--;
			}

		}

		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);

		List entities = null;
		switch (entity) {
			case "animal" -> {
				entities = new ArrayList<Animal>();
				for (String s : lines) {
					String[] line = s.split(",");
					if (!ValidationUtils.isValidAnimalData(s)) {
						logger.log(Level.INFO, "Не верные данные для животных: " + s);

						continue;
					}

					entities.add(new Animal.AnimalBuilder(line[0], line[1]).fur(line[2].equalsIgnoreCase("да") || line[2].equalsIgnoreCase("true")).build());

				}

			}
			case "barrel" -> {
				entities = new ArrayList<Barrel>();
				for (String s : lines) {
					String[] line = s.split(",");
					if (!ValidationUtils.isValidBarrelData(s)) {
						logger.log(Level.INFO, "Не верные данные для бочек: " + s);

						continue;

					}
					entities.add(new Barrel.BarrelBuilder(line[0], line[1], Integer.parseInt(line[2])).build());

				}

			}
			case "person" -> {
				entities = new ArrayList<Human>();
				for (String s : lines) {
					String[] line = s.split(",");
					if (!ValidationUtils.isValidPersonData(s)) {
						logger.log(Level.INFO, "Не верные данные для людей: " + s);

						continue;

					}
					entities.add(new Human.HumanBuilder(line[2], line[0], Integer.parseInt(line[1])).build());

				}

			}
		}

		return entities;
	}

}

