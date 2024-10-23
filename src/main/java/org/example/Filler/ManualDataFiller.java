package org.example.Filler;

import java.util.ArrayList;
import java.util.List;

public class ManualDataFiller <T> implements Filler<T> {
	@Override
	public List<T> fill() {
		// Implement manual data input logic here
		return new ArrayList<>();
	}
}
