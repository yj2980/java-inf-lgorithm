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

	private int convertBinaryToDecimal(String binaryNumber) {
		String decimal = new StringBuilder(binaryNumber).reverse().toString();

		return Integer.parseInt(decimal, 2);
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
		return cryptogram.replace('#', '1')
				.replace('*', '0');
	}
}
