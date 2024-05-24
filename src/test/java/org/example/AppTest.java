package org.example;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.*;

public class AppTest {

	public static List<BigInteger> readExpectations(String fileName) {
		List<BigInteger> expectations = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String[] line = reader.readLine().split(" ");
			for (String num : line) {
				BigInteger n = new BigInteger(num);
				expectations.add(n);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Ошибка при чтении файла: " + e.getMessage());
		}
		return expectations;
	}

	public String expectations_path = "src/test/resources/tests/expectations.txt";

	List<BigInteger> expectations = readExpectations(expectations_path);

	@Test
	public void testMin() throws IOException {
		String filePath = "src/test/resources/tests/test_min.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String[] nums = reader.readLine().split(" ");
		Assertions.assertEquals(expectations.get(0), App._min(nums));
	}

	@Test
	public void testMax() throws IOException {
		String filePath = "src/test/resources/tests/test_max.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String[] nums = reader.readLine().split(" ");
		Assertions.assertEquals(expectations.get(1), App._max(nums));
	}

	@Test
	public void testSum() throws IOException {
		String filePath = "src/test/resources/tests/test_sum.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String[] nums = reader.readLine().split(" ");
		Assertions.assertEquals(expectations.get(2), App._sum(nums));
	}

	@Test
	public void testMult() throws IOException {
		String filePath = "src/test/resources/tests/test_mult.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String[] nums = reader.readLine().split(" ");
		Assertions.assertEquals(expectations.get(3), App._mult(nums));
	}

	@Test
	public void testEmptyFile() {
		String filename = "src/test/resources/tests/test_empty.txt";
		String expectarion = "Файл пуст или содержит только пробельные символы. Пожалуйста, "
			+ "проверьте файл 'input.txt'";
		// Перенаправляем стандартный вывод в ByteArrayOutputStream
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outContent));
		// Запускаем main
		App.main(new String[]{filename});
		// Восстанавливаем стандартный вывод
		System.setOut(originalOut);
		Assertions.assertEquals(
			expectarion,
			outContent.toString().trim());
	}
	@Test
	public void testFaild() throws InterruptedException {
		Assertions.assertEquals(1, 2);
	}
}
