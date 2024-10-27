package filler;

import java.util.ArrayList;
import java.util.List;

public class FileDataFiller<Entity> implements Filler<Entity> {
    @Override
    public List<Entity> fill(String entity) {
        // Implement file reading and validation logic here
        return new ArrayList<>();
    }

}

