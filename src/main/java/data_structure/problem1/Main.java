package data_structure.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String sentence = sc.next();
		List<String> bracket = main.convertStringToList(sentence);
		main.printResult(main.isCorrect(bracket));
	}

	private List<String> convertStringToList(String sentence) {
		List<String> bracket = new ArrayList<>();

		for (char c : sentence.toCharArray()) {
			bracket.add(String.valueOf(c));
		}

		return bracket;
	}

	private boolean isCorrect(List<String> bracket) {
		int cnt = 0;

		for (String s : bracket) {
			if (cnt < 0) {
				break;
			}
			if (s.equals("(")) {
				cnt++;
			}
			if (s.equals(")")) {
				cnt--;
			}
		}

		if (cnt == 0) {
			return true;
		}

		return false;
	}

	private void printResult(boolean result) {
		String answer = "NO";

		if (result) {
			answer = "YES";
		}

		System.out.println(answer);
	}
}
