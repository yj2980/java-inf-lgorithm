package problem9;

import java.util.Scanner;

public class ExcludeCharactersExceptNumbers {
	static ExcludeCharactersExceptNumbers main = new ExcludeCharactersExceptNumbers();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println(main.excludeCharacters(sc.next()));
	}

	private int excludeCharacters(String word) {
		String answer = "";

		for (char letter : word.toCharArray()) {
			if (letter >= '0' && letter <= '9') {
				answer += letter;
			}
		}

		return Integer.parseInt(answer);
	}
}
