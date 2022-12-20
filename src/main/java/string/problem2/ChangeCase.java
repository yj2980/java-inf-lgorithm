package string.problem2;

import java.util.Scanner;

public class ChangeCase {
	public static void main(String[] args){
		Scanner in= new Scanner(System.in);
		String word = in.next();

		System.out.println(new ChangeCase().solution(word));
	}

	private String solution(String word) {
		StringBuilder result = new StringBuilder();

		for (char c : word.toCharArray()) {
			result.append(isLowerOrUpperCase(c));
		}

		return result.toString();
	}

	private static char isLowerOrUpperCase(char separator) {
		if (Character.isUpperCase(separator)) {
			return (char)(separator + 32);
		}

		return (char)(separator - 32);
	}
}
