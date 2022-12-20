package problem11;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.next();
		String answer = main.countDuplication(main.convertStringToStack(word));
		StringBuffer sb = new StringBuffer(answer);

		System.out.println(sb.reverse());
	}

	private Stack<Character> convertStringToStack(String word) {
		Stack<Character> set = new Stack<>();

		for (char letter : word.toCharArray()) {
			set.push(letter);
		}

		return set;
	}

	private String countDuplication(Stack<Character> set) {
		int cnt = 1;
		String result = "";

		char letter = set.pop();
		while(!set.isEmpty()) {
			char pop = set.pop();
			if (letter == pop) {
				cnt++;
				continue;
			}
			result = saveResult(cnt, letter, result);
			letter = pop;
			cnt = 1;
		}
		result = saveResult(cnt, letter, result);

		return result;
	}

	private String saveResult(int cnt, char letter, String result) {
		if (cnt > 1) {
			result += cnt;
		}
		result += letter;

		return result;
	}
}
