package problem3;

import java.util.Scanner;

public class WordInSentence {
	public static void main(String[] args){
		Scanner in= new Scanner(System.in);
		String sentence = in.nextLine();

		System.out.println(new WordInSentence().solution(sentence));
	}

	public String solution(String sentence) {
		String[] words = sentence.split(" ");
		String answer = "";

		for (String word : words) {
			if (answer.length() < word.length()) {
				answer = word;
			}
		}

		return answer;
	}
}
