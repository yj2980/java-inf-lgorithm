package array.problem6;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextLine();

		main.solve(main.convertStringToList(sc.nextLine()));
	}

	private void solve(List<String> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			reverseNumber(numbers.get(i));
		}
	}

	private List<String> convertStringToList(String number) {
		return Arrays.stream(number.split(" "))
				.collect(Collectors.toList());
	}

	private void reverseNumber(String number) {
		String reverse = new StringBuilder(number).reverse().toString();

		if (isPrime(Integer.parseInt(reverse)) == 1) {
			System.out.print(Integer.parseInt(reverse)+ " ");
		}
	}

	private int isPrime(int n) {
		if (n <= 1) {
			return 0;
		}
		if (n % 2 == 0) {
			return n == 2 ? 1 : 0;
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				return 0;
			}
		}

		return 1;
	}
}
