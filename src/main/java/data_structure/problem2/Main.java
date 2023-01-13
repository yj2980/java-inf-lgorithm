package data_structure.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<String> letters = main.convertStringToList(sc.next());
		main.printResult(main.removeBracket(letters));
	}

	private List<String> convertStringToList(String s) {
		List<String> letters = new ArrayList<>();

		for (char c : s.toCharArray()) {
			letters.add(String.valueOf(c));
		}

		return letters;
	}

	private Stack<String> removeBracket(List<String> letters) {
		Stack<String> word = new Stack<>();

		for (String alpha : letters) {
			if (alpha.equals("(")) {
				word.push(alpha);
			}
			if (alpha.equals(")")) {
				word.pop();
				continue;
			}
			if (!word.contains("(")) {
				word.push(alpha);
			}
		}

		return word;
	}

	private void printResult(Stack<String> word) {
		word.forEach(v -> System.out.print(v));
	}
}
