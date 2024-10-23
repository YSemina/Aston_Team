package org.example.Filler;

import java.util.ArrayList;
import java.util.List;

public class RandomDataFiller <T> implements Filler<T> {
	@Override
	public List<T> fill() {
		// Implement random data generation logic here
		return new ArrayList<>();
	}
}
