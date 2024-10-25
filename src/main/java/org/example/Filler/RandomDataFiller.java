package org.example.filler;

import org.example.entity.Animal;
import org.example.util.InputUtils;
import org.example.util.ValidationUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class RandomDataFiller <Entity> implements Filler<Entity> {
	@Override
	public List<Entity> fill( String entity) {
		int n = InputUtils.getInt("Enter number of "+entity+"s: ");
		List<Animal> animals = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			final String[] line = UUID.randomUUID().toString().split("-");

//			String line[] = InputUtils.getString("Enter species, eye color, Has fur? (yes/no)\n").split(",");
			Arrays.stream(line).forEach(e-> System.out.print(e+" "));
			System.out.println();
			String species = line[0];
			String eyeColor = line[1];
			boolean hasFur = line[2].equalsIgnoreCase("yes");

			if (!ValidationUtils.isValidAnimalData(species, eyeColor, hasFur)) {
				System.out.println("Invalid data entered. Please try again.");
				i--;
				continue;
			}

			animals.add(new Animal.Builder()
					.species(species)
					.eyeColor(eyeColor)
					.hasFur(hasFur)
					.build());
		}
		return (List<Entity>) animals;
	}
}
