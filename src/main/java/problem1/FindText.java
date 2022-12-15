package problem1;

import java.util.Scanner;

public class FindText {
	public static void main(String[] args){
		String word = readWord();
		String separator = readWord();

		int answer = solution(word, separator.charAt(0));

		System.out.println(answer);
	}

	public static int solution(String word, char separator) {
		int cnt = 0;
		char separatorChangeCase = isLowerOrUpperCase(separator);

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == separator || word.charAt(i) == separatorChangeCase) {
				cnt++;
			}
		}

		return cnt;
	}

	private static char isLowerOrUpperCase(char separator) {
		if (Character.isUpperCase(separator)) {
			return (char)(separator + 32);
		}

		return (char)(separator - 32);
	}

	private static String readWord() {
		Scanner in = new Scanner(System.in);

		return in.nextLine();
	}

}
