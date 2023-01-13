package data_structure.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MainByStack {
	static MainByStack main = new MainByStack();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<String> bracket = main.convertStringToList(sc.next());
		main.printResult(main.isCorrect(bracket));

	}

	private List<String> convertStringToList(String s) {
		List<String> bracket = new ArrayList<>();

		for (char c : s.toCharArray()) {
			bracket.add(String.valueOf(c));
		}

		return bracket;
	}

	private boolean isCorrect(List<String> bracket) {
		Stack<String> judge = new Stack<>();

		for (String s : bracket) {
			if (s.equals("(")) {
				judge.push(s);
			}
			if (s.equals(")")) {
				if (judge.isEmpty()) {
					return false;
				}
				judge.pop();
			}
		}

		if (judge.isEmpty()) {
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
