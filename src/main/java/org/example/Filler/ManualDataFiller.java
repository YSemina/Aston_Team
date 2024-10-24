package org.example.Filler;

import java.util.ArrayList;
import java.util.List;

public class ManualDataFiller <Entity> implements Filler<Entity> {
	@Override
	public List<Entity> fill(Entity entity) {
		// Implement manual data input logic here
		return new ArrayList<>();
	}
}
