package sorting.problem5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = main.readNumber();
		boolean result = main.checkDuplication(n);

		main.printResult(result);
	}

	private int readNumber() {
		return Integer.parseInt(sc.next());
	}

	private boolean checkDuplication(int n) {
		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int insertion = readNumber();

			if (numbers.contains(insertion)) {
				return false;
			}
			numbers.add(insertion);
		}

		return true;
	}

	private void printResult(boolean result) {
		String answer = "U";

		if (!result) {
			answer = "D";
		}

		System.out.println(answer);
	}
}
