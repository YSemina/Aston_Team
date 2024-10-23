package org.example.util;

import org.example.Filler.FileDataFiller;
import org.example.Filler.Filler;
import org.example.Filler.ManualDataFiller;
import org.example.Filler.RandomDataFiller;
import org.example.entity.Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Handle {
	private final List<List> entities = new ArrayList<List>();
	private final Map<String, Filler> stringFillerHashMap = new HashMap<>();

	public Handle() {
		stringFillerHashMap.put("file", new FileDataFiller());
		stringFillerHashMap.put("manual", new ManualDataFiller());
		stringFillerHashMap.put("random", new RandomDataFiller());

	}

	public void importFile(final String path) throws IOException {
		final File file = new File(path);
		if (!file.exists()) {
			throw new FileNotFoundException(path);
		}

		final int separatorIndex = path.lastIndexOf('.');

		final String extension = path.substring(separatorIndex + 1);
		final Filler importer = stringFillerHashMap.get(extension);
		if (importer == null) {
			throw new IOException("For file: " + path);
		}

		entities.add(importer.fill());

	}
}
