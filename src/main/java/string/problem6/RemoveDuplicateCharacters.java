package string.problem6;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveDuplicateCharacters {
	static RemoveDuplicateCharacters main = new RemoveDuplicateCharacters();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Character> characters = main.convertStringToList(sc.next());
		main.remove(characters);

		characters.forEach(v -> System.out.print(v));
	}

	private void remove(List<Character> characters) {
		for (int i = 0; i < characters.size(); i++) {
			if (i != characters.indexOf(characters.get(i))) {
				characters.remove(i);
				i--;
			}
		}
	}

	private List<Character> convertStringToList(String word) {

		return word.chars()
				.mapToObj(e -> (char)e)
				.collect(Collectors.toList());
	}
}
