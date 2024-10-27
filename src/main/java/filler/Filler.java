package filler;

import java.util.List;

public interface Filler<Entity> {
    public List<Entity> fill(String entity);
}
