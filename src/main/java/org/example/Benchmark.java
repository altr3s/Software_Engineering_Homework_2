package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Benchmark {

	public static void main(String[] args) {
		String[] array = {"min", "max", "sum", "mult"};
		for (int i = 1; i < 26; i++) {
			String filePath = "src/main/resources/benchmark_tests/test-" + i + ".txt";

			for (int j = 0; j < array.length; j++) {
				String testType = array[j];
				String output = "src/main/resources/benchmark_tests/results-" + testType + ".txt";
				long result = runTest(filePath, testType);
				if (result != -1) {
					try (FileWriter writer = new FileWriter(output, true)) {
						writer.write(i + ") " + result + " ns\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static long runTest(String filePath, String testType) {
		long startTime = System.nanoTime();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line = reader.readLine();
			if (line == null || line.trim().isEmpty()) {
				System.out.println("Файл пуст или содержит только пробельные символы: " + filePath);
				return -1;
			}

			String[] nums = line.split(" ");

			switch (testType) {
				case "min":
					App._min(nums);
					break;
				case "max":
					App._max(nums);
					break;
				case "sum":
					App._sum(nums);
					break;
				case "mult":
					App._mult(nums);
					break;
				default:
					throw new IllegalArgumentException("Неверный тип теста: " + testType);
			}

		} catch (IOException e) {
			System.out.println("Ошибка при чтении файла: " + e.getMessage());
			return -1;
		} catch (IllegalArgumentException e) {
			System.out.println("Ошибка: " + e.getMessage());
			return -1;
		}

		long endTime = System.nanoTime();
		return endTime - startTime;
	}
}
