package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class App {

	public static void main(String[] args) {
        String fileName = "src/main/resources/input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();

            if (line == null || line.trim().isEmpty()) {
                System.out.println("Файл пуст или содержит только пробельные символы. "
					+ "Пожалуйста, проверьте файл 'input.txt'");
                return;
            }

            String[] nums = line.split(" ");
            System.out.println("Минимальное число: " + _min(nums));
            System.out.println("Максимальное число: " + _max(nums));
            System.out.println("Сумма чисел: " + _sum(nums));
            System.out.println("Произведение чисел: " + _mult(nums));

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

	public static BigInteger _min(String[] numbers) {
		try {
			BigInteger min = new BigInteger(numbers[0]);
			for (String number : numbers) {
				BigInteger num = new BigInteger(number);
				if (num.compareTo(min) < 0) {
					min = num;
				}
			}
			return min;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Неверный формат числа", e);
		}
	}

	public static BigInteger _max(String[] numbers) {
		try {
			BigInteger max = new BigInteger(numbers[0]);
			for (String number : numbers) {
				BigInteger num = new BigInteger(number);
				if (num.compareTo(max) > 0) {
					max = num;
				}
			}
			return max;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Неверный формат числа", e);
		}
	}

	public static BigInteger _sum(String[] numbers) {
		try {
			BigInteger sum = BigInteger.ZERO;
			for (String number : numbers) {
				sum = sum.add(new BigInteger(number));
			}
			return sum;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Неверный формат числа", e);
		}
	}

	public static BigInteger _mult(String[] numbers) {
		try {
			BigInteger mult = BigInteger.ONE;
			for (String number : numbers) {
				mult = mult.multiply(new BigInteger(number));
			}
			return mult;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Неверный формат числа", e);
		}
	}
}
