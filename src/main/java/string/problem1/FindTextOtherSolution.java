package string.problem1;

import java.util.Scanner;

public class FindTextOtherSolution {
	public static void main(String[] args){
		String word = readWord();
		char separator = readWord().charAt(0);

		int answer = solution(word.toUpperCase(), Character.toUpperCase(separator));

		System.out.println(answer);
	}

	public static int solution(String word, char separator) {
		int cnt = 0;

		for (char c : word.toCharArray()) {
			if (c == separator) {
				cnt++;
			}
		}

		return cnt;
	}


	private static String readWord() {
		Scanner in = new Scanner(System.in);

		return in.next();
	}

}
