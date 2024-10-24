package org.example.Filler;

import java.util.ArrayList;
import java.util.List;

public class FileDataFiller<Entity> implements Filler<Entity> {
	@Override
	public List<Entity> fill(Entity entity) {
		// Implement file reading and validation logic here
		return new ArrayList<>();
	}
}

