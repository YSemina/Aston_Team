package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender {
	private static final String RESOURCES = "src/main/resources/";

	private static String fileName;

	public FileAppender(String fileName) {
		FileAppender.fileName = RESOURCES + fileName;
	}


	public void appendToFile(String data) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			writer.write(data);
			writer.newLine();
		} catch (IOException e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}
	}
}
