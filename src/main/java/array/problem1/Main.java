package array.problem1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String length = sc.nextLine();
		String number = sc.nextLine();

		main.compareBiggerNumber(main.convertStringToList(number));

	}

	private void compareBiggerNumber(List<String> numbers) {
		System.out.print(numbers.get(0) + " ");

		for (int i = 1; i < numbers.size(); i++) {
			int max = Math.max(convertStringToInteger(numbers.get(i))
					, convertStringToInteger(numbers.get(i - 1)));

			if (max == convertStringToInteger(numbers.get(i))) {
				System.out.print(max + " ");
			}
		}
	}

	private int convertStringToInteger(String number) {
		return Integer.parseInt(number);
	}

	private List<String> convertStringToList(String number) {
		return Arrays.stream(number.split(" "))
				.collect(Collectors.toList());
	}
}
