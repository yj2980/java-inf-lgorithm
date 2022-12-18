package problem5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReverseSpecificChar {
	static ReverseSpecificChar main = new ReverseSpecificChar();

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		char[] characters = sc.next().toCharArray();

		List<Character> answer = main
				.reverseSpecificCharacters(characters, main.saveAlphabetsInWord(characters));

		answer.forEach(v -> System.out.print(v));
	}

	private List<Character> reverseSpecificCharacters(char[] characters, List<Character> alphabets) {
		int isNotAlphabetCount = 0;
		List<Character> answer = new ArrayList<>();

		for (int i = 0; i < characters.length; i++) {
			if (isAlphabet(characters[i])) {
				answer.add(alphabets.get(i - isNotAlphabetCount));
			}
			if (!isAlphabet(characters[i])) {
				answer.add(characters[i]);
				isNotAlphabetCount++;
			}
		}

		return answer;
	}

	private List<Character> saveAlphabetsInWord(char[] characters) {
		List<Character> alphabets = new ArrayList<>();

		for (char letter : characters) {
			if (isAlphabet(letter)) {
				alphabets.add(letter);
			}
		}
		Collections.reverse(alphabets);

		return alphabets;
	}

	private boolean isAlphabet(char character) {
		if (Character.isUpperCase(character) || Character.isLowerCase(character)) {
			return true;
		}

		return false;
	}
}
