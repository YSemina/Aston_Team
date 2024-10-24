package org.example.util;

import org.example.Filler.FileDataFiller;
import org.example.Filler.Filler;
import org.example.Filler.ManualDataFiller;
import org.example.Filler.RandomDataFiller;
import org.example.entity.Animal;
import org.example.entity.Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Handle {
	private  List<Entity> entities;// = new ArrayList<>();

	public List<Entity> getEntities() {
		return entities;
	}

	private final Map<String, Filler> stringFillerHashMap = new HashMap<>();

	public Handle() {
		stringFillerHashMap.put("file", new FileDataFiller());
		stringFillerHashMap.put("manual", new ManualDataFiller());
		stringFillerHashMap.put("random", new RandomDataFiller());

	}

	public void importFile(final String filler) throws IOException {

		final Filler importer = stringFillerHashMap.get(filler);

		entities= importer.fill(new Animal.Builder().build());

	}
}
