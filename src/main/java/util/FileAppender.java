package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public  class FileAppender {
	private static final String RESOURCES = "src/main/resources/";

	private static String fileName;

	public FileAppender(String fileName) {
		this.fileName = RESOURCES + fileName;
	}



	public void appendToFile(String data) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			writer.write(data);
			writer.newLine();
		} catch (IOException e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Enter example format:(xxx,xxx,xxx) or 'exit' for exit: ");
			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("exit")) {
				break;
			}

			System.out.print("Do you want to add this value to the file? (1 - yes, 2 - no):");
			int choice = scanner.nextInt();
			scanner.nextLine();

			if (choice == 1) {
				appendToFile(input);
				System.out.println("Value added to file");
			} else if (choice == 2) {
				System.out.println("No value added");
			} else {
				System.out.println("Invalid input, please try again");
			}
		}
		scanner.close();
	}

	public static void main(String[] args) {
		System.out.print("Enter file name: ");
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.nextLine();
		FileAppender fileAppender = new FileAppender(filename);
		fileAppender.start();
	}
}
