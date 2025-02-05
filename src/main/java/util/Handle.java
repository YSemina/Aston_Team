package util;


import filler.FileDataFiller;
import filler.Filler;
import filler.ManualDataFiller;
import filler.RandomDataFiller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Handle {
    private List entities;

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

        entities = importer.fill(entity);

    }

    public void write() {
        FileAppender fileAppender = new FileAppender(InputUtils.getString("Введите имя файла: "));
        for (Object e : entities) {
            fileAppender.appendToFile(e.toString());
        }
    }

    public void print() {
        for (Object e : entities) {
            System.out.println(e.toString());
        }
    }


}
