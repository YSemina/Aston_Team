package org.example.util;

import org.example.filler.FileDataFiller;
import org.example.filler.Filler;
import org.example.filler.ManualDataFiller;
import org.example.filler.RandomDataFiller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Handle {
	private  List entities;// = new ArrayList<>();

	public List getEntities() {
		return entities;
	}

	private final Map<String, Filler> stringFillerHashMap = new HashMap<>();

	public Handle() {
		stringFillerHashMap.put("file", new FileDataFiller());
		stringFillerHashMap.put("manual", new ManualDataFiller());
		stringFillerHashMap.put("random", new RandomDataFiller());
	}

	public void filler(final String filler, final String entity) throws IOException {

		final Filler importer = stringFillerHashMap.get(filler);

		entities= importer.fill(entity);

	}
}
