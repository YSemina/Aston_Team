package org.example.Filler;

import java.util.ArrayList;
import java.util.List;

public class FileDataFiller<T> implements Filler<T> {
	@Override
	public List<T> fill() {
		// Implement file reading and validation logic here
		return new ArrayList<>();
	}
}

