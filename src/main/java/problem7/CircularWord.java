package problem7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CircularWord {
	static CircularWord main = new CircularWord();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = main.isCircularByWord(sc.next().toUpperCase());

		System.out.println(main.isRightResult(result));
	}

	private int isCircularByWord(String word) {
		List<Integer> circular = new ArrayList<>();

		circular.add(word.indexOf(word.charAt(0)));
		for (int i = 1; i < word.length(); i++) {
			int index = word.indexOf(word.charAt(i));

			if (circular.contains(index)) {
				circular.remove(circular.indexOf(index));
			} else {
				circular.add(index);
			}
		}

		return circular.size();
	}

	private String isRightResult(int result) {
		String answer = "NO";

		if (result == 0 || result == 1) {
			answer = "YES";
		}

		return answer;
	}
}
