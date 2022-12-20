package problem12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	final int CRYPTOGRAM_SIZE = 7;
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String length = sc.next();
		String cryptogram = sc.next();

		List<String> binaryNumbers = main.convertStringToBinaryNumber(cryptogram);
		System.out.println(main.decrypt(binaryNumbers));

	}

	private String decrypt(List<String> cryptogram) {
		String result = "";

		for (String crypto : cryptogram) {
			result += (char)convertBinaryToDecimal(crypto);
		}

		return result;
	}

	private int createExponent(int iterations) {
		int exponent = 1;

		for (int i = 0; i < iterations; i++) {
			exponent *= 2;
		}

		return exponent;
	}

	private int convertBinaryToDecimal(String binaryNumber) {
		int decimal = 0;

		for (int i = 0; i < binaryNumber.length(); i++) {
			int exponent = createExponent(i);

			decimal += (binaryNumber.charAt(i) - '0') * exponent;
		}

		return decimal;
	}
	private List<String> convertStringToBinaryNumber(String cryptogram) {
		List<String> binaryNumbers = new ArrayList<>();

		for (int i = 0; i < cryptogram.length(); i += CRYPTOGRAM_SIZE) {
			StringBuffer sb = new StringBuffer(createBinaryNumberByCryptogram(cryptogram.substring(i, i + CRYPTOGRAM_SIZE)));
			binaryNumbers.add(sb.reverse().toString());
		}

		return binaryNumbers;
	}

	private String createBinaryNumberByCryptogram(String cryptogram) {
		String binaryNumber = "";

		for (char letter : cryptogram.toCharArray()) {
			if (letter == '#') {
				binaryNumber += 1;
				continue;
			}
			binaryNumber += 0;
		}

		return binaryNumber;
	}
}
