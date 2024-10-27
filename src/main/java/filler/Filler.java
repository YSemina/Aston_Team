package filler;

import java.io.IOException;
import java.util.List;

public interface Filler<Entity> {
	List<Entity> fill(String entity) throws IOException;
}
