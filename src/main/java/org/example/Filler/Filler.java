package org.example.Filler;

import java.util.List;

public interface Filler<Entity> {
	public List<Entity> fill(Entity entity);
}
