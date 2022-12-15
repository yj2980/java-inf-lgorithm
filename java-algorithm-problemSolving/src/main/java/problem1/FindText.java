package problem1;

import java.util.Scanner;

public class FindText {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		String word = in.next();
		String separator = in.next();

		System.out.println(solution(word, separator.charAt(0)));
	}

	public static int solution(String word, char separator) {
		int cnt = 0;
		char separatorCase = isLowerOrUpperCase(separator);

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == separator || word.charAt(i) == separatorCase) {
				cnt++;
			}
		}
		return cnt;
	}

	private static char isLowerOrUpperCase(char separator) {
		char separatorCase = 0;

		if (Character.isUpperCase(separator)) {
			separatorCase = (char)(separator + 32);
		}
		if (Character.isLowerCase(separator)) {
			separatorCase = (char)(separator - 32);
		}

		return separatorCase;
	}
}
