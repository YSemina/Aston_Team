package filler;

import java.io.IOException;
import java.util.List;

public interface Filler<Entity> {
    public List<Entity> fill(String entity) throws IOException;
}
