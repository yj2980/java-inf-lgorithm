package string.problem8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidPalindrome {
	static ValidPalindrome main = new ValidPalindrome();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println(main.solution(sc.nextLine().toUpperCase()));
	}

	private String solution(String sentence) {
		String answer;

		int result = main.isPalindrome(main.excludeNonAlpha(sentence));

		answer = main.isRightResult(result);

		return answer;
	}

	private String excludeNonAlpha(String sentence) {
		StringBuilder answer = new StringBuilder();

		for (char letter : sentence.toCharArray()) {
			if (Character.isUpperCase(letter)) {
				answer.append(letter);
			}
		}

		return answer.toString();
	}

	private int isPalindrome(String word) {
		List<Integer> palindrome = new ArrayList<>();

		palindrome.add(word.indexOf(word.charAt(0)));
		for (int i = 1; i < word.length(); i++) {
			int index = word.indexOf(word.charAt(i));

			if (palindrome.contains(index)) {
				palindrome.remove(palindrome.indexOf(index));
			} else {
				palindrome.add(index);
			}
		}

		return palindrome.size();
	}

	private String isRightResult(int result) {
		String answer = "NO";

		if (result <= 1) {
			answer = "YES";
		}

		return answer;
	}
}
