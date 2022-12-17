package problem4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseWord {
	public static void main(String[] args){
		ReverseWord main = new ReverseWord();
		List<String> words = new ArrayList<>();

		main.printReversWord(words);
	}

	private void saveWords (List<String> words) {
		Scanner sc = new Scanner(System.in);
		int length = Integer.parseInt(sc.next());

		for (int i = 0; i < length; i++) {
			words.add(sc.next());
		}
	}

	private void printReversWord(List<String> words) {
		saveWords(words);

		for (String word : words) {
			StringBuffer sb = new StringBuffer(word);
			System.out.println(sb.reverse());
		}
	}
}
